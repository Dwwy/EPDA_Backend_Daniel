package com.test.testing.Model.Input;

import com.test.testing.Model.Cart_Order;
import com.test.testing.Util.StaticVariable;
import lombok.Data;

@Data
public class ApproveRejectOrderInput {
    private String sellerId;
    private String cartOrderId;
    private StaticVariable.orderStat status;

}
