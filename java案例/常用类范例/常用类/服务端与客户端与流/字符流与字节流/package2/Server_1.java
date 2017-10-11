package package1;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;


public class Server_1 {
	public static void main(String[] args) throws Exception {
		ServerSocket serverSocket=new ServerSocket(6686);
		while(true){
			//不管是字节流还是字符流,都没有办法得到String类型;
			Socket socket=serverSocket.accept(); //socket是客户端的意思
			DataInputStream dis=new DataInputStream(socket.getInputStream());
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			DataOutputStream dos=new DataOutputStream(socket.getOutputStream());
			int i=2;
			while(i<8){
				String string=dis.readUTF();
				System.out.println(string);//当一次输出完后,线程将停留在这里,下一次请求来了后,线程将从这里开始执行
				string=br.readLine();
				dos.writeUTF(string);
			}
			dis.close();
		}//在这种判断语句为true的死循环下,线程不可能跳出去,所以该"}"后面不能写任何语句
	}
}
