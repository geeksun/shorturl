package com.sequoia.shorturl.tcp;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Description: Socket 服务端代码，服务监听55533端口，没有指定IP地址默认就是localhost，即本机IP环回地址 127.0.0.1，接着就等待客户端连接。
 * @Author: usr1999
 * @Create: 2021/9/2
 */
public class SocketServer {

    public static void main(String[] args) throws Exception {
        // 监听指定的端口
        int port = 55533;
        ServerSocket server = new ServerSocket(port);

        // server将一直等待连接的到来
        System.out.println("Server 将一直等待连接的到来");
        Socket socket = server.accept();
        // 建立好连接后，从socket中获取输入流，并建立缓冲区进行读取
        InputStream inputStream = socket.getInputStream();
        byte[] bytes = new byte[1024 * 1024];
        int len;
        while ((len = inputStream.read(bytes)) != -1) {
            //注意指定编码格式，发送方和接收方一定要统一，建议使用UTF-8
            String content = new String(bytes, 0, len,"UTF-8");
            System.out.println("len = " + len + ", content: " + content);
        }
        inputStream.close();
        socket.close();
        server.close();
    }

}
