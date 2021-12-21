package com.sequoia.shorturl.classloader;

/**
 * @Description:
 * @Author: usr1999
 * @Create: 2021/9/4
 */
public class MsgHandle  implements Runnable {
    @Override
    public void run() {
        while (true) {
            BaseApi manager = ManagerFactory.getManager(ManagerFactory.MY_MANAGER);
            manager.update();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
