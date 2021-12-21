package com.sequoia.shorturl.tcp;

import java.io.OutputStream;
import java.net.Socket;

/**
 * @Description:
 * @Author: usr1999
 * @Create: 2021/9/2
 */
public class SocketClient {

    public static void main(String[] args) throws Exception {
        // 要连接的服务端IP地址和端口
        String host = "127.0.0.1";
        int port = 55533;
        // 与服务端建立连接
        Socket socket = new Socket(host, port);
        // 建立连接后获得输出流
        OutputStream outputStream = socket.getOutputStream();
        String message = "这是一个整包!!!";
        for (int i = 0; i < 100; i++) {
            //Thread.sleep(1);
            outputStream.write(message.getBytes("UTF-8"));
        }
        Thread.sleep(20000);
        outputStream.close();
        socket.close();
    }

}
