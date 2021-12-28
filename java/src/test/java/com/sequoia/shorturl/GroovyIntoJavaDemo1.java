package com.sequoia.shorturl;

import groovy.lang.GroovyClassLoader;
import groovy.lang.GroovyObject;
import groovy.lang.GroovyShell;
import groovy.lang.Script;
import groovy.util.GroovyScriptEngine;
import groovy.util.ResourceException;
import groovy.util.ScriptException;
import java.io.File;
import java.io.IOException;

/**
 * @Description:
 * Java集成groovy之GroovyShell、GroovyScriptEngine、GroovyClassLoader
 * https://www.cnblogs.com/jsersudo/p/10178407.html
 * @Author: jzq
 * @Create: 2021/12/27
 * Created by Jxy on 2018/12/24 11:28
 * 测试GroovyShell、GroovyClassLoader、GroovyScriptEngine 性能
 */
public class GroovyIntoJavaDemo1 {

    // 测试次数
    private static final int num = 10000;

    public static void main(String[] args) throws IOException, ResourceException, ScriptException {

        /**
         * GroovyClassLoader
         */
        long start = System.currentTimeMillis();
        GroovyClassLoader loader =  new GroovyClassLoader();
        Class aClass = loader.parseClass(new File("src/test/java/com/sequoia/shorturl/CycleDemo.groovy"));
        try {
            GroovyObject instance = (GroovyObject) aClass.newInstance();
            instance.invokeMethod("cycle", num);

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        long end = System.currentTimeMillis()-start;

        /**
         * GroovyShell
         */
        long start1 = System.currentTimeMillis();

        new GroovyShell().parse( new File("src/test/java/com/sequoia/shorturl/CycleDemo.groovy" ) )
                .invokeMethod("cycle", num);

        long end1 = System.currentTimeMillis()-start1;

        /**
         * GroovyScriptEngine
         */
        long start2 = System.currentTimeMillis();

        Class script = new GroovyScriptEngine("src/test/java/com/sequoia/shorturl/").loadScriptByName("CycleDemo.groovy");
        try {
            Script instance =(Script) script.newInstance();
            instance.invokeMethod ("cycle", new Object[]{num});
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        long end2 = System.currentTimeMillis()-start2;

        // 时间最多
        System.out.println(" GroovyClassLoader时间："+ end );
        // 和GroovyScriptEngine时间差不多
        System.out.println(" GroovyShell时间："+ end1 );
        // 时间最少
        System.out.println(" GroovyScriptEngine时间："+ end2 );

    }

}

