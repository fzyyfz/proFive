package org.java.nio.d20180417.channel;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * ������׽���ͨ��(ServerSocketChannel): һ���������ļ����׽��ֵĿ�ѡͨ����ͨ�����ø����open��������,�´����ķ������׽���ͨ���Ǵ򿪵ģ�����δ�󶨼����˿�
 * 
 *  ����������׽���ͨ��: 
 *  ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
 *  
 *  ���÷���:
 *  bind: �󶨷�����׽���ͨ�������˿�
 *  accept: ���տͻ����׽���ͨ������
 *  configurebloking: ���÷�����ģʽ ,false: ��������true: ����
 *  register: ��ͨ��ע�ᵽע��ѡ����
 * 
 * @author VIC
 *
 */
public class ServerSocketChannelDemo {
	
	public static void main(String[] args) throws Exception {
		// 1. ����������׽���ͨ��
		ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
		// 2. �󶨷�����׽��ּ����˿�
		serverSocketChannel.bind(new InetSocketAddress(8099));
		System.err.println("����������ɹ�,���ڵȴ�����");
		// 3. �ȴ���ȡ�ͻ���ͨ������
		SocketChannel socketChannel = serverSocketChannel.accept();
		// 4. ����ͻ����׽���ͨ��
		ByteBuffer readBuffer = ByteBuffer.allocate(1024);
		socketChannel.read(readBuffer);
		// �л�������Ϊ��ģʽ
		readBuffer.flip();
		System.out.println(socketChannel.getRemoteAddress() + " say: " + new String(readBuffer.array()));
		// 5. �رշ�����׽���ͨ��
		serverSocketChannel.close();
	}

}
