package org.java.nio.d20180417.channel;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * 服务端套接字通道(ServerSocketChannel): 一种面向流的监听套接字的可选通道，通过调用该类的open方法创建,新创建的服务器套接字通道是打开的，但尚未绑定监听端口
 * 
 *  创建服务端套接字通道: 
 *  ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
 *  
 *  常用方法:
 *  bind: 绑定服务端套接字通道监听端口
 *  accept: 接收客户端套接字通道请求
 *  configurebloking: 设置非阻塞模式 ,false: 非阻塞，true: 阻塞
 *  register: 将通道注册到注册选择器
 * 
 * @author VIC
 *
 */
public class ServerSocketChannelDemo {
	
	public static void main(String[] args) throws Exception {
		// 1. 创建服务端套接字通道
		ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
		// 2. 绑定服务端套接字监听端口
		serverSocketChannel.bind(new InetSocketAddress(8099));
		System.err.println("服务端启动成功,正在等待连接");
		// 3. 等待获取客户端通道连接
		SocketChannel socketChannel = serverSocketChannel.accept();
		// 4. 处理客户端套接字通道
		ByteBuffer readBuffer = ByteBuffer.allocate(1024);
		socketChannel.read(readBuffer);
		// 切换缓冲区为读模式
		readBuffer.flip();
		System.out.println(socketChannel.getRemoteAddress() + " say: " + new String(readBuffer.array()));
		// 5. 关闭服务端套接字通道
		serverSocketChannel.close();
	}

}
