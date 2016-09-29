package com.verysu.test;

import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int port;
		ServerSocket serverSocket;

		try {
			port = Integer.parseInt(args[0]);
		} catch (Exception e) {
			System.out.println("port = 8080 (默认)");
			port = 8080;
		}

		try {

			// 建立端口监听
			serverSocket = new ServerSocket(port);
			System.out.println("服务器正在监听端口： " + serverSocket.getLocalPort());
			while (true) {
				try {
					// 等待客户的TCP连接请求
					final Socket socket = serverSocket.accept();
					System.out.println("建立一个客户端的新的TCP连接，该客户的地址为：" + socket.getInetAddress() + ":" + socket.getPort());
					service(socket);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/* 处理HTTP请求 */
	public static void service(Socket socket) throws Exception {
	}
}
