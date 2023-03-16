package com.test.testing.Service;

import com.test.testing.Model.Cart_Order;
import com.test.testing.Model.Input.ApproveRejectOrderInput;
import com.test.testing.Model.Input.OrderInput;
import com.test.testing.Model.Output.OrderOutput;
import com.test.testing.Model.UpdateInput.OrderUpdate;
import com.test.testing.response.Response;

import java.util.List;

public interface OrderBLI {
    Response createOrder(OrderInput input);
    Response updateOrder(OrderUpdate input);
    List<Cart_Order> getCartOrdersbyOrderId (String orderId);
    Response getAllOrderByCustomerId (String customerId);
    OrderOutput getFullOrderByOrderId (String orderId);
    List<OrderOutput> getAllOrderBySellerId (String sellerId);
    Response ApproveRejectOrder (ApproveRejectOrderInput input);
}
