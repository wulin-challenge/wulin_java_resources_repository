package package2;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

public class Client2 {

	public static void main(String args[]) throws Exception{
		boolean flag = false;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		DataOutputStream dos = new DataOutputStream(baos);
		dos.writeBoolean(flag);//这里最终是输到字节数组流对应的容器的
		
		byte[] buf = baos.toByteArray();//将字节数组流对应的容器中的内容输出到缓冲数组buf中
		
		//连接对应的主机和端口号,并为发送准备内容,即缓冲数组buf
		DatagramPacket dp = new DatagramPacket(buf, buf.length, 
											   new InetSocketAddress("127.0.0.1", 6666)
											   );
		DatagramSocket ds = new DatagramSocket(9999);//创建一个属于自己的客户端
		ds.send(dp);//真正向客户端发送
		ds.close();
		
	}
}
