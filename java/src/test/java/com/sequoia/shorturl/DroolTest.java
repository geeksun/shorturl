package com.sequoia.shorturl;

import com.sequoia.shorturl.domain.Product;
import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

/**
 * @Description:
 * drools规则引擎可视化：https://blog.csdn.net/weixin_39959369/article/details/111215791
 * @Author: jzq
 * @Create: 2021/12/27
 */
public class DroolTest {

    @Test
    public void droolsTest() {
        KieServices ks = KieServices.Factory.get();
        KieContainer kieContainer = ks.getKieClasspathContainer();
        KieSession kSession = kieContainer.newKieSession("ksession-rule");
        Product product = new Product();
        product.setType(Product.GOLD);
        kSession.insert(product);
        int count = kSession.fireAllRules();
        System.out.println("命中了" + count + "条规则");
        System.out.println("商品" + product.getType() + "的商品折扣为" + product.getDiscount() + "%");
    }



}
