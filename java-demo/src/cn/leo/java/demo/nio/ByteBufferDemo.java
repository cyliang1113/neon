package cn.leo.java.demo.nio;

import java.nio.ByteBuffer;

public class ByteBufferDemo {
	public static void main(String[] args) {
		ByteBuffer buffer = ByteBuffer.allocate(10);

		buffer.clear(); // ��position��Ϊ0����limit��Ϊcapacity

		byte a = 1;
		byte b = 2;
		byte c = 3;

		buffer.put(a);
		buffer.put(b);
		buffer.put(c);
		
		System.out.println("capacity: " + buffer.capacity());
		System.out.println("limit: " + buffer.limit());
		System.out.println("position: " + buffer.position());
		
		buffer.flip();

		System.out.println("capacity: " + buffer.capacity());
		System.out.println("limit: " + buffer.limit());
		System.out.println("position: " + buffer.position());
		
		for (int i = buffer.position(); i < buffer.limit(); i++) {
			System.out.println(buffer.get(i));
		}
		
		
		
	}
}
