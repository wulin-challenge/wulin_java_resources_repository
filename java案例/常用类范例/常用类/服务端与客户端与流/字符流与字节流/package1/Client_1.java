package package1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class Client_1 {
	public static void main(String[] args) throws Exception {
		Socket socket=new Socket("localhost" ,6686);
		BufferedReader br1=new BufferedReader(new InputStreamReader(System.in));
		//当在用键盘输入时就相当于是字节流
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		//对应得输入流就应有对应的输出流
		/*int buf;
		while((buf=br.read())!=-1){
			System.out.println(buf);
		}*/
		String string=br1.readLine();
		bw.write(string);
		bw.flush();
		
		/*Socket socket=new Socket("localhost",6666);
		DataOutputStream dos=new DataOutputStream(socket.getOutputStream());
		dos.writeUTF("你啊ho");
		dos.close();*/
	}
}


/*BuferedReader br=new BufferedReader(new INputStreamRader(client.getImputStream()));
 * BuferedReader br=new BufferedReader(new INputStreamRader(new InputstreamReader(System.in));
 * BufferedWriter bw =new BufferedWriter(new OUtputStreamWriter(client.getOutputStream())
 * String msg=br.readLine();
 * while()msg!=msg{
 * 	String keyMsg=br1.reaLine();
 * bw.write();
 * 
 * }
 * */


