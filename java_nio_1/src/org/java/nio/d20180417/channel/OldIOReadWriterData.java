package org.java.nio.d20180417.channel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.Reader;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * ʹ��NIO��ȡ����(��IO�����л�ȡͨ��)
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
		// 1. ��ȡ�ļ�ͨ��
		FileChannel fileChannel = new FileInputStream("content.txt").getChannel();
		
		// 2. ��ͨ���ж�ȡ���ݵ�������
		ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
		fileChannel.read(byteBuffer);
		System.out.println(new String(byteBuffer.array()));
		
		// 3. �ر�ͨ��
		fileChannel.close();
	}

	public static void writer() throws Exception{
		
		// 1. ��ȡ�ļ�ͨ��
		FileChannel fileChannel = new FileOutputStream("content.txt").getChannel();
		
		// 2. ��������������������
		ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
		byteBuffer.put("ʹ�ô�ͳIO��ȡ�ļ�ͨ���������ļ�����".getBytes());
		
		// 3. ͨ��ͨ��д������������
		byteBuffer.flip();
		fileChannel.write(byteBuffer);
		
		// 4. �ر�ͨ��
		fileChannel.close();
	}

}
