package com.test.testing.Service;

import com.test.testing.Model.Cart_Order;
import com.test.testing.Model.Input.CartInput;
import com.test.testing.Model.UpdateInput.CartUpdate;
import com.test.testing.Model.UpdateInput.Cart_OrderUpdate;
import com.test.testing.response.Response;

public interface CartBLI {
    Response createCart(CartInput input);
    Response createCartOrder(Cart_Order input);
    Response updateCart(CartUpdate input);
    Response updateCartOrder(Cart_OrderUpdate input);
}
