package com.test.testing.Service;

import com.test.testing.Dao.*;
import com.test.testing.Model.Cart;
import com.test.testing.Model.Cart_Order;
import com.test.testing.Model.Input.PaymentInput;
import com.test.testing.Model.Order;
import com.test.testing.Model.Payment;
import com.test.testing.Model.UpdateInput.Cart_OrderUpdate;
import com.test.testing.Model.UpdateInput.OrderUpdate;
import com.test.testing.Model.UpdateInput.PaymentUpdate;
import com.test.testing.Util.StaticVariable;
import com.test.testing.response.Response;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PaymentBL implements  PaymentBLI{
    @Autowired
    SellerDAOI sellerDAO;
    @Autowired
    ProductDAOI productDAO;
    @Autowired
    Cart_OrderDAOI cartOrderDAO;
    @Autowired
    ProductDropDownDAOI productDropDownDAO;
    @Autowired
    PaymentDAOI paymentDAO;
    @Autowired
    OrderBLI orderBL;
    @Autowired
    CartBLI cartBL;
    private boolean updateCartOrderStatus (List<Cart_Order> cartOrders, StaticVariable.orderStat status){
        if (cartOrderDAO.updateCartOrdersStatus(cartOrders,status)){
            return true;
        }
        else {
            return false;
        }
    }
    public Response createPayment(PaymentInput input){
        Payment payment = input.toPayment();
        if (paymentDAO.createPayment(payment)){
            List<Cart_Order> cartOrders = orderBL.getCartOrdersbyOrderId(input.getOrderId());
            if (updateCartOrderStatus(cartOrders, StaticVariable.orderStat.Awaiting_Payment)){
                return new Response(true);
            }
            else {
                paymentDAO.deletePayment(payment);
                return new Response(false, "Error occurred while updating order");
            }
        }
        else {
            return new Response(false, "Error occurred while creating payment");
        }
    }
    public Response makePayment(PaymentUpdate update){
        Payment payment = paymentDAO.getPaymentbyId(update.getPaymentId());
        if (payment == null){
            return new Response(false, "Payment not found");
        }
        else {
            if (paymentDAO.updatePayment(update.toPayment(payment))){
                List<Cart_Order> cartOrders = orderBL.getCartOrdersbyOrderId(payment.getOrderId());
                if (updateCartOrderStatus(cartOrders, StaticVariable.orderStat.Awaiting_Acceptance)){
                    return new Response(true);
                }
                else {
                    return new Response(false, "Error occurred while updating cart order");
                }
            }
            else {
                return new Response(false, "Error occurred while updating payment");
            }

        }
    }

}
