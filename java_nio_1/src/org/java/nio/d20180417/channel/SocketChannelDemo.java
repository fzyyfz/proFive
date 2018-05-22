package org.java.nio.d20180417.channel;


import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * 套接字通道(SocketChannel): 该类面向流的套接字通道,通过调用这个类的一个open方法创建通道,默认创建的通道是打开的但未连接,支持非阻塞模式。
 * 
 * 创建套接字通道: SocketChannel.open();
 * 
 * 常用方法:
 * open： 获取套接字通道
 * read: 从通道中读取数据
 * writer: 将数据写入通道
 * 
 * @author VIC
 *
 */
public class SocketChannelDemo {
	
	public static void main(String[] args) throws Exception {
		
		// 1. 获取通道(使用open方法打开到远程服务器的通道)
		SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1",8099));
		System.out.println("客户端启动成功");
		// 2. 通过通道写出数据
		ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
		String content = "hello server.";
		byteBuffer.put(content.getBytes());
		// 切换缓冲区为读模式
		byteBuffer.flip();
		// 写出数据
		socketChannel.write(byteBuffer);
		// 关闭输出状态
		socketChannel.shutdownOutput();
		System.out.println("客户端发送数据完成.");
		// 3. 关闭通道
		socketChannel.close();
	}

}
