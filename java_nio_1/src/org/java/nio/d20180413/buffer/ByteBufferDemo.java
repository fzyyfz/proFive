package org.java.nio.d20180413.buffer;

import java.nio.Buffer;
import java.nio.ByteBuffer;

/**
 * Java NIO 缓冲区(Buffer): 该类是抽象类,它定义NIO中缓存区的核心属性和方法,是存储数据的地方,输入数据将数据从缓冲读取，输出数据将数据从缓冲区写出
 * 
 *  缓冲区分类
 *  非直接缓冲区: 建立在JVM中的缓冲区,使用allocate()方法创建
 *  直接缓冲区 :  建立在OS中的缓冲区,能提高效率,使用allocateDirect()方法建立直接缓冲区
 * 
 *  缓冲区实现类:
 *  ByteBuffer: 字节缓冲区
 *  CharBuffer: 字符缓冲区
 *  DoubleBuffer: 双精度浮点缓冲区
 *  FloatBuffer: 单精度浮点缓冲区
 *  ShortBuffer: 短整型缓冲区
 *  LongBuffer: 长整型缓冲区
 *  IntBuffer: 整型缓冲区
 *  以上缓冲区都是通过allocate()方法创建,默认写模式
 *  
 *  缓冲区模式(默认写模式):
 *  读模式: 使用flip方法切换模式
 *  写模式: 使用flip方法切换模式
 *  
 *  缓冲区实现类核心属性:
 *  capacity: 表示缓冲区大小
 *  limit: 表示缓冲区数据可用大小
 *  position: 表示当前缓冲区读数据的起始位置,默认为0。或写数据的起始位置.
 *  mark: 表示读取数据的标记位置
 *  
 *  使用方法:
 *  get: 读取单个字节
 *  put: 写入单个字节
 *  flip: 切换读写模式
 *  allocate: 分配一个新的非直接缓冲区
 *  allocateDirect: 分配一个新的直接缓冲区
 *  rewind: 重复读取数据
 *  mark: 记录当前位置标记
 *  reset: 恢复记录的标记位置
 *  
 *  使用缓冲区步骤:
 *  1. 建立缓冲区
 *  2. 读写数据
 *  3. 切换读写模式
 *  
 *  常见异常：
 *  java.nio.BufferOverflowException： 缓冲区溢出,即数据大小超出缓冲区大小
 *  BufferUnderflowException - 如果此缓冲区中的剩余字节少于 length
 *  
 * @author VIC
 *
 */
public class ByteBufferDemo {
	
	public static void main(String[] args) {
		
		// 使用缓冲区步骤
//		simpleUsed();
		// 创建直接缓冲区
		ByteBuffer directBuffer = createDirectBuffer(2048);
		// 输出缓冲区初始信息
		printBufferInto(directBuffer);
		// 操作缓冲区
		useBuffer(directBuffer);
	}

	/**
	 * 使用缓冲区
	 * @param buffer
	 */
	private static void useBuffer(ByteBuffer buffer) {
		
		// 使用put写入数据到缓冲区
		buffer.put("abcdefg".getBytes());
		printBufferInto(buffer);
		buffer.put("h".getBytes());
		printBufferInto(buffer);
		
		// 使用filp切换缓冲区模式(读)
		// limit在写模式下: 值=缓冲区大小
		// limit在读模式下: 值=实际数据大小
		buffer.flip();
		
		// 使用get方法从缓冲区中读取一个字节
		char a =  (char)buffer.get();
		System.out.println("a: " + a);
		char b =  (char)buffer.get();
		System.out.println("b: " + b);
		char c =  (char)buffer.get();
		System.out.println("c: " + c);
		// 标记当前读取数据的位置
		buffer.mark();
		char d =  (char)buffer.get();
		System.out.println("d: " + d);
		char e =  (char)buffer.get();
		System.out.println("e: " + e);
		// 回复标志位
		buffer.reset();
		char dd =  (char)buffer.get();
		System.out.println("dd: " + dd);
		char ee =  (char)buffer.get();
		System.out.println("ee: " + ee);
		
		printBufferInto(buffer);
		
		// 清空缓冲区数据
		System.out.println("清空缓冲区数据");
		buffer.clear();
		printBufferInto(buffer);
		
		// 循环每次读取一个字节
//		int count = buffer.limit();
//		while (count > 0) {
//			char tmp = (char)buffer.get();
//			System.out.println("tmp: " + tmp);
//			count--;
//		}
//		printBufferInto(buffer);
		
		
	}

	/**
	 * 输出缓冲区信息
	 * @param buffer
	 */
	private static void printBufferInto(Buffer buffer) {
		
		System.out.println();
		System.out.println("直接缓冲区: " + buffer.isDirect());
		System.out.println("大小: " + buffer.capacity());
		System.out.println("数据长度: " + buffer.limit());
		System.out.println("当前位置: " + buffer.position());
		
	}

	/**
	 * 创建直接缓冲区
	 * @return
	 */
	private static ByteBuffer createDirectBuffer(int capacity) {
		// 使用allocateDirect方法创建直接缓冲区
		return ByteBuffer.allocateDirect(capacity);
	}

	/**
	* 使用缓冲区步骤:
	*  1. 建立缓冲区
	*  2. 读写数据
	*  3. 切换读写模式
	 */
	private static void simpleUsed() {
		
		// 建立非直接缓冲区(默认写模式)
		ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
		// 写数据到缓冲区
		byteBuffer.put("hello buffer".getBytes());
		// 切换到读模式
		byteBuffer.flip();
		// 从缓冲区读取数据
		byte[] dst = new byte[byteBuffer.limit()];
		byteBuffer.get(dst);
		System.out.println("读取数据: " + new String(dst));
	}

}
