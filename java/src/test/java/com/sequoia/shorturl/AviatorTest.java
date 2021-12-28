package com.sequoia.shorturl;

import com.googlecode.aviator.AviatorEvaluator;
import com.googlecode.aviator.Expression;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author: jzq
 * @Create: 2021/12/28
 */
public class AviatorTest {

    @Test
    public void test() {
        Long result = (Long) AviatorEvaluator.execute("1+2+3+4");
        System.out.println("caculate result: " + result);

        String name = "唐简";
        Map<String,Object> env = new HashMap<>();
        env.put("name", name);
        String strResult = (String) AviatorEvaluator.execute(" 'Hello ' + name ", env);
        System.out.println(strResult);

        // 使用内置函数
        String str = "小哥哥带你使用Aviator";
        //Map<String,Object> env = new HashMap<>();
        env.put("str",str);
        Long length = (Long)AviatorEvaluator.execute("string.length(str)", env);
        System.out.println("length: "+length);

        // compile 用法
        String expression = "a-(b-c)>100";
        Expression compiledExp = AviatorEvaluator.compile(expression);
        // 缓存本次编译的结果
        //Expression compiledExp = AviatorEvaluator.compile(expression,true);
        // 使缓存失效
        //AviatorEvaluator.invalidateCache(String expression);


        //Map<String, Object> env = new HashMap<>();
        env.put("a", 100.3);
        env.put("b", 45);
        env.put("c", -199.100);
        Boolean boolResult = (Boolean) compiledExp.execute(env);
        System.out.println(boolResult);



    }


}
