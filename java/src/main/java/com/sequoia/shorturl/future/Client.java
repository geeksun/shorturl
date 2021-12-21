package com.sequoia.shorturl.future;

/**
 * Client：返回Data对象，立即返回FutureData，并开启ClientThread线程装配RealData。
 */
public class Client {

    public  Data request(final String queryStr){
        final FutureData future = new FutureData();
        new Thread(){
            @Override
            public void run(){
                System.out.println("run start at " + System.currentTimeMillis());
                RealData realData = new RealData(queryStr);
                System.out.println("run end at " + System.currentTimeMillis());
                future.setRealData(realData);
            }
        }.start();
        // 立即返回futureData
        return future;
    }

    public static void main(String[] args) {
        Client client = new Client();
        //返回的futureData
        Data data = client.request("name");
        System.out.println("请求完成");
        try{
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("main end");
        System.out.println("Current time is " + System.currentTimeMillis());
        System.out.println("真实数据"+data.getResult());
    }

}

