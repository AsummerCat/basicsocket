package com.linjingc.top.basicsocket;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class TcpClient {
    public static void main(String[] args) throws Exception {
        Socket client = new Socket("127.0.0.1", 9091);
        System.out.println("socket客户端启动");

        try {
            PrintWriter output =
                    new PrintWriter(client.getOutputStream(), true);
            Scanner cin = new Scanner(System.in);
            String words;
 
            while (cin.hasNext()) {
                words = cin.nextLine();
 
                output.println(words);
 
                System.out.println("写出了数据:"  + words);
            }
 
            cin.close();
        } finally {
            client.close();
        }
    }
}