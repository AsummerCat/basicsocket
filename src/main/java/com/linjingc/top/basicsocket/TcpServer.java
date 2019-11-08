package com.linjingc.top.basicsocket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务端
 */
public class TcpServer {
	public static void main(String[] args)throws Exception {
		ServerSocket server = new ServerSocket(9091);
		try {
			Socket client = server.accept();
			System.out.println("socket服务启动中");

			try{
				BufferedReader input = new BufferedReader(new InputStreamReader(client.getInputStream()));
				boolean flag = true;
				int count = 1;
				while (flag) {
					System.out.println("客户端要开始发骚了，这是第" + count + "次！");
					count++;
					String line = input.readLine();
					if (line.equals("exit")) {
						flag = false;
						System.out.println("客户端不想玩了！");
					} else {
						System.out.println("客户端说:"+ line);
					}
				}
			}catch (Exception e){
				e.printStackTrace();
			}finally {
				client.close();
			}
		}catch (Exception e){
 e.printStackTrace();
		}finally {
			server.close();
		}

	}
}
