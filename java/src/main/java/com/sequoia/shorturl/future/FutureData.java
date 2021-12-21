package com.sequoia.shorturl.future;

/**
 * Future 模式是多线程开发中的一种常见设计模式，它的核心思想是异步调用。
 *
 * FutureData：Future 数据构造快，但是是一个虚拟的数据，需要装配 RealData。
 * FutureData 相当于 RealData 的代理（契约）。
 * java23种设计模式-Future模式:
 * https://blog.csdn.net/weixin_37967166/article/details/97234202
 */
public class FutureData implements Data {

    public RealData realData = null;
    public boolean isReady = false;

    public synchronized void setRealData(RealData realData){
        if (isReady){
            return;
        }
        this.realData = realData;
        isReady = true;
        this.notifyAll();    //realData已经被注入 通知getResult启动
    }


    @Override
    public synchronized String getResult() {
        while (!isReady){
            try {
                System.out.println("Future.data wait start at " + System.currentTimeMillis());
                this.wait();     //等待realData被注入
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Future.data wait end at " + System.currentTimeMillis());
        return realData.result;
    }

}

