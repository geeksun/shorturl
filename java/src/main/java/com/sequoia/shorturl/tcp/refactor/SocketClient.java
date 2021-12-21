package com.sequoia.shorturl.tcp.refactor;

import java.io.OutputStream;
import java.net.Socket;

/**
 * @Description: a. 客户端。每次发送一个字符串前，都将字符串转为字节数组，
 * 在原数据字节数组前再加上一个四个字节的代表该数据的长度，然后将组合的字节数组发送出去；
 * @Author: usr1999
 * @Create: 2021/9/3
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

        String message = "这是一句代码!!!";
        byte[] contentBytes = message.getBytes("UTF-8");
        System.out.println("contentBytes.length = " + contentBytes.length);

        int contentLength = contentBytes.length;
        byte[] lengthBytes = Utils.int2Bytes(contentLength);
        byte[] resultBytes = new byte[4 + contentLength];
        System.arraycopy(lengthBytes, 0, resultBytes, 0, lengthBytes.length);
        System.arraycopy(contentBytes, 0, resultBytes, 4, contentBytes.length);

        for (int i = 0; i < 10; i++) {
            outputStream.write(resultBytes);
        }
        Thread.sleep(20000);
        outputStream.close();
        socket.close();
    }

}


