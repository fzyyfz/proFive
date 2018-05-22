package org.java.nio.d20180417.channel;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * 文件通道(FileChannel): 该 通道可以读写文件，是阻塞模式
 * 
 * 获取文件通道: 使用FileCHannel类的open静态方法获取文件通道
 * FileChannel.open(Path,Option)
 * 
 * Paths: 表示文件通道操作的文件路径对象
 * Paths.get(): 通过该方法获取文件或构建路径对象
 * 
 * Paths.get("content.txt");
 * Paths.get("data","content.txt");
 * 
 * Option: 表示文件通道操作文件的属性设置
 * StandardOpenOption.READ: 表示通道只能读取文件内容
 * StandardOpenOption.WRITER: 表示通道可以写入文件内容
 * StandardOpenOption.APPEND: 表示支持内容追加
 * StandardOpenOption.CREATE: 表示创建文件(如果文件存在则抛错)
 * StandardOpenOption.CREATE_NEW: 表示创建新文件
 * StandardOpenOption.DELETE_ON_CLOSE: 在关闭时删除文件
 * 
 * @author VIC
 *
 */
public class FileChannelDemo {
	
	public static void main(String[] args) throws Exception {
		reader();
//		writer();
	}

	private static void reader() throws Exception {
		// 1. 使用open方法获取通道
		FileChannel fileChannel = FileChannel.open(Paths.get("content.txt"), StandardOpenOption.READ);
		// 2. 从通道中读取数据到缓冲区
		ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
		fileChannel.read(byteBuffer);
		System.out.println(new String(byteBuffer.array()));
		// 3. 关闭通道
		fileChannel.close();
	}

	private static void writer() throws IOException {
		// 1. 使用open方法获取通道
		FileChannel fileChannel = FileChannel.open(Paths.get("content.txt"), StandardOpenOption.READ,StandardOpenOption.WRITE);
		// 2. 创建缓冲区并填充数据
		ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
		byteBuffer.put("使用NIO操作文件".getBytes());
		// 3. 通过通道将缓冲区中数据写出
		byteBuffer.flip();
		fileChannel.write(byteBuffer);
		// 4.  关闭通道
		fileChannel.close();
	}

}
