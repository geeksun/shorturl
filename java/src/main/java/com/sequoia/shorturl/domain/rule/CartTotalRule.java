package com.sequoia.shorturl.domain.rule;

import com.sequoia.shorturl.domain.Cart;
import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Fact;
import org.jeasy.rules.annotation.Rule;

/**
 * @Description: easy-rules demo
 * @Author: jzq
 * @Create: 2021/12/28
 */

@Rule(name = "cart total rule", description = "Give 10% off when shopping cart is greater than $200" )
public class CartTotalRule {

    @Condition
    public boolean cartTotal(@Fact("cart") Cart cart) {
        return cart.isGreaterThanTwoHundered();
    }

    @Action
    public void giveDiscount(@Fact("cart") Cart cart) {
        cart.setTotalDiscount(200);
    }

}
