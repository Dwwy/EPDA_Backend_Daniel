package com.test.testing.Service;

import com.test.testing.Dao.*;
import com.test.testing.Model.*;
import com.test.testing.Model.Input.ApproveRejectOrderInput;
import com.test.testing.Model.Input.CartInput;
import com.test.testing.Model.Input.OrderInput;
import com.test.testing.Model.Input.WalletHistoryInput;
import com.test.testing.Model.Output.Cart_OrderOutput;
import com.test.testing.Model.Output.OrderOutput;
import com.test.testing.Model.Output.ProductOutput;
import com.test.testing.Model.UpdateInput.OrderUpdate;
import com.test.testing.Util.StaticVariable;
import com.test.testing.response.Response;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class OrderBL implements OrderBLI{
    @Autowired
    SellerDAOI sellerDAO;
    @Autowired
    ProductDAOI productDAO;
    @Autowired
    ProductDropDownDAOI productDropDownDAO;
    @Autowired
    OrderDAOI orderDAO;
    @Autowired
    Cart_OrderDAOI cartOrderDAO;
    @Autowired
    CartDAOI cartDAO;
    @Autowired
    CartBLI cartBL;
    @Autowired
    PaymentDAOI paymentDAO;
    @Autowired
    ProductBLI productBL;
    @Autowired
    WalletHistoryDAOI walletHistoryDAO;
    public Double calculateFreight (OrderInput input){
        List<Cart> carts = input.getCartId().stream().map(x-> cartDAO.getCartbyId(x)).collect(Collectors.toList());
        List<String> seller = carts.stream().map(x-> productDAO.getProductbyId(x.getId())).map(x-> x.getSellerId()).collect(Collectors.toSet())
                .stream().collect(Collectors.toList());
        Double size = Double.valueOf(seller.size());
        return  size * StaticVariable.freightCost;

    }
    public Response createOrder(OrderInput input){
        Order order = input.toOrder(calculateFreight(input));
        if (orderDAO.createOrder(order)){
            List<Cart_Order> cartOrders = input.toCartOrder(order.getId(),cartDAO).stream()
                    .map(x -> x.toCart_Order())
                    .collect(Collectors.toList());
            List<Response> responses = new ArrayList<>();
            cartOrders.forEach(x->{
                responses.add(cartBL.createCartOrder(x));
            });
            if (responses.stream().anyMatch(x-> !x.isStatus())){
                orderDAO.deleteOrder(order);
                cartOrders.forEach(x-> {
                    cartOrderDAO.deleteCart_Order(x);
                });
                return new Response(false, "Error occurred while creating cart order items");
            }
            else {
                return new Response(true);
            }
        }
        else {
            return new Response(false, "Error occurred while creating order");
        }
    }
    public Response updateOrder(OrderUpdate input){
        Order order = orderDAO.getOrderbyId(input.getOrderId());
        if (order == null){
            return new Response(false, "Order not found");
        }
        else {
            orderDAO.updateOrder(input.toOrder(order));
            return new Response(true);
        }
    }
    public List<Cart_Order> getCartOrdersbyOrderId (String orderId){
        return cartOrderDAO.getAllCartOrderbyOrderId(orderId);
    }
    public Response getAllOrderByCustomerId (String customerId){
        List<Order> orderList = orderDAO.getAllOrderbyCustomerId(customerId);
        List<OrderOutput> outputList = new ArrayList<>();
        orderList.forEach(x-> {
            outputList.add(getFullOrderByOrderId(x.getId()));
        });
        return new Response(outputList);
    }
    public OrderOutput getFullOrderByOrderId (String orderId){
        Order order = orderDAO.getOrderbyId(orderId);
        List<Cart_OrderOutput> items = getCartOrdersbyOrderId(orderId).stream().map(x-> {
            Cart cart = cartDAO.getCartbyId(x.getCartId());
            return new Cart_OrderOutput(x, productDAO.getProductbyId(cart.getId()));
        }).collect(Collectors.toList());
        Payment payment = paymentDAO.getPaymentbyOrderId(orderId);
        return new OrderOutput(order,payment,items);
    }
    public List<OrderOutput> getAllOrderBySellerId (String sellerId) {
        List<ProductOutput> products = productBL.getProductBySellerId(sellerId);
        List<Cart> carts = new ArrayList<>();
        products.forEach(x->{
            carts.addAll(cartDAO.getAllCartbyProductId(x.getId()));
        });
        List<Cart_Order> cartOrders = new ArrayList<>();
        carts.forEach(x->{
            cartOrderDAO.getAllCartOrderbyCartId(x.getId());
        });
        List<OrderOutput> output = new ArrayList<>();
        cartOrders.forEach(x->{
            output.add(getFullOrderByOrderId(x.getOrderId()));
        });
        return output;
    }
    public Response ApproveRejectOrder (ApproveRejectOrderInput input){
        Cart_Order cartOrder = cartOrderDAO.getCart_OrderbyId(input.getCartOrderId());
        cartOrder.setStatus(input.getStatus());
        cartOrder.setLastUpdated(LocalDateTime.now());
        if (cartOrder.getStatus() == StaticVariable.orderStat.Awaiting_Shipment){
            cartOrder.setAcceptedDate(LocalDateTime.now());
            cartOrder.setEstimatedDeliveryDate(LocalDateTime.now().plusDays(7));
            WalletHistory walletHistory = new WalletHistoryInput(cartOrder.getPrice(),input.getSellerId()).toWalletHistory();

            if (walletHistoryDAO.createWalletHistory(walletHistory)){
                Seller seller = sellerDAO.getSellerbyId(input.getSellerId());
                seller.setWalletBalance(seller.getWalletBalance()+cartOrder.getPrice());
                sellerDAO.updateSeller(seller);
                cartOrderDAO.updateCart_Order(cartOrder);
                return new Response(true);
            }
            else {
                return new Response(false, "Error occurred while creating wallet history");
            }

        }
        else {
            cartOrderDAO.updateCart_Order(cartOrder);
            return  new Response(true);
        }
    }
}
