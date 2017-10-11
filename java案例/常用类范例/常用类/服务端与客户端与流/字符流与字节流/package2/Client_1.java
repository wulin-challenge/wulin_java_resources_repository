package package1;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client_1 {
	public static void main(String[] args) throws Exception {
		Socket socket=new Socket("localhost" ,6686);
		//dis.
		//当在用键盘输入时就相当于是字节流
		 BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		 DataOutputStream dos=new DataOutputStream(socket.getOutputStream());
		 DataInputStream dis=new DataInputStream(socket.getInputStream());
		 for(int i=0;i<8;i++){
			 String string=br.readLine();
			 dos.writeUTF(string);//当你向输出流管道中注入内容后,线程应该停在这儿
			 string=dis.readUTF();
			 System.out.println(string);
		 }
		 dos.close();
		 br.close();
	}
}

