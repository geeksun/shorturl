package com.sequoia.shorturl;

import com.sequoia.shorturl.domain.Cart;
import com.sequoia.shorturl.domain.rule.CartTotalRule;
import org.jeasy.rules.annotation.Rule;
import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rules;
import org.jeasy.rules.api.RulesEngine;
import org.jeasy.rules.core.DefaultRulesEngine;

/**
 * @Description:
 * @Author: jzq
 * @Create: 2021/12/28
 */
public class CartTotalRuleTest {

    public static void main(String args) {
        Cart cart = new Cart();
        cart.setProducts(null);
        cart.setTotalAmount(180);

        // define facts
        Facts facts = new Facts();
        facts.put("cart", cart);

        // define rules
        Rule cartTotalRUle = (Rule) new CartTotalRule();
        Rules rules = new Rules();
        rules.register(cartTotalRUle);

        // fire rules on known facts
        RulesEngine rulesEngine = new DefaultRulesEngine();
        rulesEngine.fire(rules, facts);

        System.out.println(rulesEngine);


    }


}
