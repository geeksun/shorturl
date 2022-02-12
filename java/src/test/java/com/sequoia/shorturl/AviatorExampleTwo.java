package com.sequoia.shorturl;

import com.googlecode.aviator.AviatorEvaluator;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 基于Aviator的规则引擎
 * https://blog.csdn.net/weixin_48029654/article/details/118870862
 * @Author: jzq
 * @Create: 2022/1/2
 */
public class AviatorExampleTwo {

    //规则可以保存在数据库中，mysql或者redis等等
    Map<Integer, String> ruleMap = new HashMap<>();

    public AviatorExampleTwo() {
        //秒数计算公式
        ruleMap.put(1, "hour * 3600 + minute * 60 + second");
        //正方体体积计算公式
        ruleMap.put(2, "height * width * length");
        //判断一个人是不是资深顾客
        ruleMap.put(3, "age >= 18 && sumConsume > 2000 && vip");
        //资深顾客要求修改
        ruleMap.put(4, "age > 10 && sumConsume >= 8000 && vip && avgYearConsume >= 1000");
        //判断一个人的年龄是不是大于等于18岁
        ruleMap.put(5, "age  >= 18 ? 'yes' : 'no'");
    }

    public static void main(String[] args) {
        AviatorExampleTwo aviatorExample = new AviatorExampleTwo();
        //选择规则, 传入规则所需要的参数
        System.out.println("公式1：" + aviatorExample.getResult(1, 1, 1, 1));
        System.out.println("公式2：" + aviatorExample.getResult(2, 3, 3, 3));
        System.out.println("公式3：" + aviatorExample.getResult(3, 20, 3000, false));
        System.out.println("公式4：" + aviatorExample.getResult(4, 23, 8000, true, 2000));
        System.out.println("公式5：" + aviatorExample.getResult(5, 12));
    }

    public Object getResult(int ruleId, Object... args) {
        String rule = ruleMap.get(ruleId);
        return AviatorEvaluator.exec(rule, args);
    }


}

//公式1：3661
//公式2：27
//公式3：false
//公式4：true
//公式5：no


