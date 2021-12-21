package com.sequoia.shorturl.classloader;

/**
 * @Description:
 * @Author: usr1999
 * @Create: 2021/9/3
 */
public class LoadInfo {
    /** 自定义的类加载器 */
    private MyClasslLoader myClasslLoader;

    /** 记录要加载的类的时间戳-->加载的时间 */
    private long loadTime;

    /** 需要被热加载的类 */
    private BaseApi manager;

    public LoadInfo(MyClasslLoader myClasslLoader, long loadTime) {
        this.myClasslLoader = myClasslLoader;
        this.loadTime = loadTime;
    }

    public MyClasslLoader getMyClasslLoader() {
        return myClasslLoader;
    }

    public void setMyClasslLoader(MyClasslLoader myClasslLoader) {
        this.myClasslLoader = myClasslLoader;
    }

    public long getLoadTime() {
        return loadTime;
    }

    public void setLoadTime(long loadTime) {
        this.loadTime = loadTime;
    }

    public BaseApi getManager() {
        return manager;
    }

    public void setManager(BaseApi manager) {
        this.manager = manager;
    }
}
