package org.java.nio.d20180417.channel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.Reader;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 使用NIO读取数据(在IO对象中获取通道)
 * 
 * @author VIC
 *
 */
public class OldIOReadWriterData {
	
	public static void main(String[] args) throws Exception {
		reader();
//		writer();
	}
	
	private static void reader() throws Exception {
		// 1. 获取文件通道
		FileChannel fileChannel = new FileInputStream("content.txt").getChannel();
		
		// 2. 从通道中读取数据到缓冲区
		ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
		fileChannel.read(byteBuffer);
		System.out.println(new String(byteBuffer.array()));
		
		// 3. 关闭通道
		fileChannel.close();
	}

	public static void writer() throws Exception{
		
		// 1. 获取文件通道
		FileChannel fileChannel = new FileOutputStream("content.txt").getChannel();
		
		// 2. 创建缓冲区并放入数据
		ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
		byteBuffer.put("使用传统IO获取文件通道来操作文件内容".getBytes());
		
		// 3. 通过通道写出缓冲区数据
		byteBuffer.flip();
		fileChannel.write(byteBuffer);
		
		// 4. 关闭通道
		fileChannel.close();
	}

}
