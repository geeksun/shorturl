package com.sequoia.shorturl.classloader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

/**
 * @Description: 自定义 Java类加载器来实现 Java 类的热加载
 * @Author: usr1999
 * @Create: 2021/9/3
 */
public class MyClasslLoader extends ClassLoader {

    /** 要加载的 Java 类的 classpath 路径 */
    private String classpath;

    public MyClasslLoader(String classpath) {
        // 指定父加载器
        super(ClassLoader.getSystemClassLoader());
        this.classpath = classpath;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] data = this.loadClassData(name);
        return this.defineClass(name, data, 0, data.length);
    }

    /**
     * 加载 class 文件中的内容
     *
     * @param name
     * @return
     */
    private byte[] loadClassData(String name) {
        try {
            // 传进来是带包名的
            name = name.replace(".", "//");
            FileInputStream inputStream = new FileInputStream(new File(classpath + name + ".class"));
            // 定义字节数组输出流
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            int b = 0;
            while ((b = inputStream.read()) != -1) {
                baos.write(b);
            }
            inputStream.close();
            return baos.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
