package com.sequoia.shorturl

/**
 * Groovy demo
 * Groovy简介与使用 https://blog.csdn.net/jiangqian6481/article/details/83717442
 * 在 Groovy 中 “一切都是对象 "
 */
class GroovyDemo {

    def methodA(String name) {
        println("A: " + name)
        return this
    }
    def methodB(String name) {
        println("B: " + name)
        return this
    }
    def methodC() {
        println("C")
        return this
    }
    def methodD(String name) {
        println("D: " + name)
        return this
    }





    public static void main(String[] args) {
        String x = "abc";

        // java: if (object != null) {
        //          object.getFieldA();
        //       }
        // groovy: object?.getFieldA()
        int len = x?.length();
        print("hello groovy" + len)

        GroovyDemo demo = new GroovyDemo();

        demo.methodA("xiaoming")
        methodB("zhangsan")
        methodC()
        methodD("lisi")

        // 不带参数的链中需要用括号
        //methodA "xiaoming" methodB "zhangsan" methodC() methodD "lisi"
    }


}
