package com.sequoia.shorturl;

import com.googlecode.aviator.AviatorEvaluator;
import com.googlecode.aviator.Expression;
import com.googlecode.aviator.runtime.function.AbstractFunction;
import com.googlecode.aviator.runtime.function.FunctionUtils;
import com.googlecode.aviator.runtime.type.AviatorDouble;
import com.googlecode.aviator.runtime.type.AviatorObject;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * google aviator：轻量级Java公式引擎
 * https://blog.csdn.net/liubenlong007/article/details/107043615
 * @Author: jzq
 * @Create: 2021/12/28
 */
public class AviatorTest {

    /**
     * 自定义函数：只要implements AviatorFunction接口, 并注册到AviatorEvaluator即可使用.
     */
    class AddFunction extends AbstractFunction {

        @Override
        public AviatorObject call(Map<String, Object> env, AviatorObject arg1, AviatorObject arg2) {
            Number left = FunctionUtils.getNumberValue(arg1, env);
            Number right = FunctionUtils.getNumberValue(arg2, env);
            return new AviatorDouble(left.doubleValue() + right.doubleValue());
        }

        public String getName() {
            return "add";
        }
    }

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


        length = (Long)AviatorEvaluator.execute("string.length('testdemo')");
        System.out.println("len: "+length);

        // 注册自定义函数
        AviatorEvaluator.addFunction(new AddFunction());
        System.out.println(AviatorEvaluator.execute("add(1, 2)"));           // 3.0
        System.out.println(AviatorEvaluator.execute("add(add(1, 2), 100)")); // 103.0

        // 移除自定义函数
        //AviatorEvaluator.removeFunction("add");



    }


}
