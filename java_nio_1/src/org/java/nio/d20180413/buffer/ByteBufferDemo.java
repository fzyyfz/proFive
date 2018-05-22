package org.java.nio.d20180413.buffer;

import java.nio.Buffer;
import java.nio.ByteBuffer;

/**
 * Java NIO ������(Buffer): �����ǳ�����,������NIO�л������ĺ������Ժͷ���,�Ǵ洢���ݵĵط�,�������ݽ����ݴӻ����ȡ��������ݽ����ݴӻ�����д��
 * 
 *  ����������
 *  ��ֱ�ӻ�����: ������JVM�еĻ�����,ʹ��allocate()��������
 *  ֱ�ӻ����� :  ������OS�еĻ�����,�����Ч��,ʹ��allocateDirect()��������ֱ�ӻ�����
 * 
 *  ������ʵ����:
 *  ByteBuffer: �ֽڻ�����
 *  CharBuffer: �ַ�������
 *  DoubleBuffer: ˫���ȸ��㻺����
 *  FloatBuffer: �����ȸ��㻺����
 *  ShortBuffer: �����ͻ�����
 *  LongBuffer: �����ͻ�����
 *  IntBuffer: ���ͻ�����
 *  ���ϻ���������ͨ��allocate()��������,Ĭ��дģʽ
 *  
 *  ������ģʽ(Ĭ��дģʽ):
 *  ��ģʽ: ʹ��flip�����л�ģʽ
 *  дģʽ: ʹ��flip�����л�ģʽ
 *  
 *  ������ʵ�����������:
 *  capacity: ��ʾ��������С
 *  limit: ��ʾ���������ݿ��ô�С
 *  position: ��ʾ��ǰ�����������ݵ���ʼλ��,Ĭ��Ϊ0����д���ݵ���ʼλ��.
 *  mark: ��ʾ��ȡ���ݵı��λ��
 *  
 *  ʹ�÷���:
 *  get: ��ȡ�����ֽ�
 *  put: д�뵥���ֽ�
 *  flip: �л���дģʽ
 *  allocate: ����һ���µķ�ֱ�ӻ�����
 *  allocateDirect: ����һ���µ�ֱ�ӻ�����
 *  rewind: �ظ���ȡ����
 *  mark: ��¼��ǰλ�ñ��
 *  reset: �ָ���¼�ı��λ��
 *  
 *  ʹ�û���������:
 *  1. ����������
 *  2. ��д����
 *  3. �л���дģʽ
 *  
 *  �����쳣��
 *  java.nio.BufferOverflowException�� ���������,�����ݴ�С������������С
 *  BufferUnderflowException - ����˻������е�ʣ���ֽ����� length
 *  
 * @author VIC
 *
 */
public class ByteBufferDemo {
	
	public static void main(String[] args) {
		
		// ʹ�û���������
//		simpleUsed();
		// ����ֱ�ӻ�����
		ByteBuffer directBuffer = createDirectBuffer(2048);
		// �����������ʼ��Ϣ
		printBufferInto(directBuffer);
		// ����������
		useBuffer(directBuffer);
	}

	/**
	 * ʹ�û�����
	 * @param buffer
	 */
	private static void useBuffer(ByteBuffer buffer) {
		
		// ʹ��putд�����ݵ�������
		buffer.put("abcdefg".getBytes());
		printBufferInto(buffer);
		buffer.put("h".getBytes());
		printBufferInto(buffer);
		
		// ʹ��filp�л�������ģʽ(��)
		// limit��дģʽ��: ֵ=��������С
		// limit�ڶ�ģʽ��: ֵ=ʵ�����ݴ�С
		buffer.flip();
		
		// ʹ��get�����ӻ������ж�ȡһ���ֽ�
		char a =  (char)buffer.get();
		System.out.println("a: " + a);
		char b =  (char)buffer.get();
		System.out.println("b: " + b);
		char c =  (char)buffer.get();
		System.out.println("c: " + c);
		// ��ǵ�ǰ��ȡ���ݵ�λ��
		buffer.mark();
		char d =  (char)buffer.get();
		System.out.println("d: " + d);
		char e =  (char)buffer.get();
		System.out.println("e: " + e);
		// �ظ���־λ
		buffer.reset();
		char dd =  (char)buffer.get();
		System.out.println("dd: " + dd);
		char ee =  (char)buffer.get();
		System.out.println("ee: " + ee);
		
		printBufferInto(buffer);
		
		// ��ջ���������
		System.out.println("��ջ���������");
		buffer.clear();
		printBufferInto(buffer);
		
		// ѭ��ÿ�ζ�ȡһ���ֽ�
//		int count = buffer.limit();
//		while (count > 0) {
//			char tmp = (char)buffer.get();
//			System.out.println("tmp: " + tmp);
//			count--;
//		}
//		printBufferInto(buffer);
		
		
	}

	/**
	 * �����������Ϣ
	 * @param buffer
	 */
	private static void printBufferInto(Buffer buffer) {
		
		System.out.println();
		System.out.println("ֱ�ӻ�����: " + buffer.isDirect());
		System.out.println("��С: " + buffer.capacity());
		System.out.println("���ݳ���: " + buffer.limit());
		System.out.println("��ǰλ��: " + buffer.position());
		
	}

	/**
	 * ����ֱ�ӻ�����
	 * @return
	 */
	private static ByteBuffer createDirectBuffer(int capacity) {
		// ʹ��allocateDirect��������ֱ�ӻ�����
		return ByteBuffer.allocateDirect(capacity);
	}

	/**
	* ʹ�û���������:
	*  1. ����������
	*  2. ��д����
	*  3. �л���дģʽ
	 */
	private static void simpleUsed() {
		
		// ������ֱ�ӻ�����(Ĭ��дģʽ)
		ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
		// д���ݵ�������
		byteBuffer.put("hello buffer".getBytes());
		// �л�����ģʽ
		byteBuffer.flip();
		// �ӻ�������ȡ����
		byte[] dst = new byte[byteBuffer.limit()];
		byteBuffer.get(dst);
		System.out.println("��ȡ����: " + new String(dst));
	}

}
