package com.sequoia.shorturl;

import com.sequoia.shorturl.domain.Cart;
import com.sequoia.shorturl.domain.rule.CartTotalRule;
import com.sequoia.shorturl.domain.rule.OperationRules;
import com.sequoia.shorturl.domain.rule.WeatherRule;
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
public class EasyRuleTest {

    public static void main(String args) {
        //定义相应的facts 一组事实并表示一个事实名称空间。事实在事实对象中具有唯一的名称。
        Facts facts = new Facts();
        //看相关的源码，是一个set集合保存fact，这里是需要全局唯一的name
        facts.put("operation", false);
        //此类封装了一组规则并表示规则名称空间。 规则在规则名称空间中必须具有唯一的名称。
        //规则将基于Comparable.compareTo（Object）方法相互比较，因此Rule的实现应正确
        //实现compareTo以确保单个命名空间中的唯一规则名称。
        Rules rules = new Rules();
        //register方法注册一个或多个新规则
        rules.register(new OperationRules());
        //申明一个规则引擎
        RulesEngine rulesEngine = new DefaultRulesEngine();
        rulesEngine.fire(rules, facts);

        System.out.println("rulesEngine: " + rulesEngine.toString());

    }


    public static void main(String[] args) {
        // define facts
        Facts facts = new Facts();
        facts.put("rain", true);

        // define rules
        WeatherRule weatherRule = new WeatherRule();
        Rules rules = new Rules();
        rules.register(weatherRule);

        // fire rules on known facts
        RulesEngine rulesEngine = new DefaultRulesEngine();
        rulesEngine.fire(rules, facts);
        System.out.println("rulesEngine: " + rulesEngine);


/*        Cart cart = new Cart();
        cart.setProducts(null);
        cart.setTotalAmount(180);

        // Define facts
        Facts facts = new Facts();
        facts.put("cart", cart);

        // Define rules
        Rule cartTotalRUle = (Rule) new CartTotalRule();
        Rules rules = new Rules();
        rules.register(cartTotalRUle);

        // fire rules on known facts
        RulesEngine rulesEngine = new DefaultRulesEngine();
        rulesEngine.fire(rules, facts);*/

        System.out.println(rulesEngine);


    }


}
