package package2;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Server_2 {
	public static void main(String[] args) throws Exception {
		//准备一个缓冲字节数组容器
		byte buf[] = new byte[1024];
		DatagramPacket dp = new DatagramPacket(buf, buf.length);//用于发送的
		DatagramSocket ds = new DatagramSocket(6666);//用于接收
		while(true){
			ds.receive(dp);//真正接收从客户端发送过来的东西
			//创建一个字节数组流,即管道,同时创建一个大小为buf的缓冲字节数组容器,同时将字节数组流与缓冲字节数组容器接上
			ByteArrayInputStream bais = new ByteArrayInputStream(buf);
			//由于DataInputStream流是一个处理流,在操作上比较方便,但它需要包装一个字节流对象
			DataInputStream dis = new DataInputStream(bais);
			//dis.readBoolean() 从对应的dos.writeBoolean(flag);中,即管道中读取数据
			System.out.println(dis.readBoolean());
		}
	}
}
