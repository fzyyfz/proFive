package org.java.nio.d20180417.channel;


import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * �׽���ͨ��(SocketChannel): �������������׽���ͨ��,ͨ������������һ��open��������ͨ��,Ĭ�ϴ�����ͨ���Ǵ򿪵ĵ�δ����,֧�ַ�����ģʽ��
 * 
 * �����׽���ͨ��: SocketChannel.open();
 * 
 * ���÷���:
 * open�� ��ȡ�׽���ͨ��
 * read: ��ͨ���ж�ȡ����
 * writer: ������д��ͨ��
 * 
 * @author VIC
 *
 */
public class SocketChannelDemo {
	
	public static void main(String[] args) throws Exception {
		
		// 1. ��ȡͨ��(ʹ��open�����򿪵�Զ�̷�������ͨ��)
		SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1",8099));
		System.out.println("�ͻ��������ɹ�");
		// 2. ͨ��ͨ��д������
		ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
		String content = "hello server.";
		byteBuffer.put(content.getBytes());
		// �л�������Ϊ��ģʽ
		byteBuffer.flip();
		// д������
		socketChannel.write(byteBuffer);
		// �ر����״̬
		socketChannel.shutdownOutput();
		System.out.println("�ͻ��˷����������.");
		// 3. �ر�ͨ��
		socketChannel.close();
	}

}
