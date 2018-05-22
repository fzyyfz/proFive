package org.java.nio.d20180417.channel;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * �ļ�ͨ��(FileChannel): �� ͨ�����Զ�д�ļ���������ģʽ
 * 
 * ��ȡ�ļ�ͨ��: ʹ��FileCHannel���open��̬������ȡ�ļ�ͨ��
 * FileChannel.open(Path,Option)
 * 
 * Paths: ��ʾ�ļ�ͨ���������ļ�·������
 * Paths.get(): ͨ���÷�����ȡ�ļ��򹹽�·������
 * 
 * Paths.get("content.txt");
 * Paths.get("data","content.txt");
 * 
 * Option: ��ʾ�ļ�ͨ�������ļ�����������
 * StandardOpenOption.READ: ��ʾͨ��ֻ�ܶ�ȡ�ļ�����
 * StandardOpenOption.WRITER: ��ʾͨ������д���ļ�����
 * StandardOpenOption.APPEND: ��ʾ֧������׷��
 * StandardOpenOption.CREATE: ��ʾ�����ļ�(����ļ��������״�)
 * StandardOpenOption.CREATE_NEW: ��ʾ�������ļ�
 * StandardOpenOption.DELETE_ON_CLOSE: �ڹر�ʱɾ���ļ�
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
		// 1. ʹ��open������ȡͨ��
		FileChannel fileChannel = FileChannel.open(Paths.get("content.txt"), StandardOpenOption.READ);
		// 2. ��ͨ���ж�ȡ���ݵ�������
		ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
		fileChannel.read(byteBuffer);
		System.out.println(new String(byteBuffer.array()));
		// 3. �ر�ͨ��
		fileChannel.close();
	}

	private static void writer() throws IOException {
		// 1. ʹ��open������ȡͨ��
		FileChannel fileChannel = FileChannel.open(Paths.get("content.txt"), StandardOpenOption.READ,StandardOpenOption.WRITE);
		// 2. �������������������
		ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
		byteBuffer.put("ʹ��NIO�����ļ�".getBytes());
		// 3. ͨ��ͨ����������������д��
		byteBuffer.flip();
		fileChannel.write(byteBuffer);
		// 4.  �ر�ͨ��
		fileChannel.close();
	}

}
