package com.sequoia.shorturl;

import com.sequoia.shorturl.domain.User;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author: jzq
 * @Create: 2021/12/27
 */
public class GroovyTest {

    /*
     *
     * @params condition  从数据库中读出来的条件表达式
     */
    private static Boolean validateCondition() {

        String script = "def validateCondition(args){return args.用户性别 == \"女性\" && (args.连续登录天数>10 || args.订单金额 > 200);}";

        try {
            // 实际使用上，ScriptEngineManager 可以定义为单例
            ScriptEngineManager engineManager = new ScriptEngineManager();
            ScriptEngine engine = engineManager.getEngineByName("demo");
            Map<String, Object> data = new HashMap<>();
            data.put("用户性别", "女性");
            data.put("连续登录天数", 11);
            data.put("订单金额", 220);
            engine.eval(script);
            Object o = ((Invocable) engine).invokeFunction("validateCondition", data);
            System.out.println("Return obj: " + o);
        } catch (Exception e){
            e.printStackTrace();
        }

        return true;
    }

    public static void main(String[] args) {
        validateCondition();
    }


}
