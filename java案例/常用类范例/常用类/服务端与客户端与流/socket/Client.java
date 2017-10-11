package package1.socket;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client {
	public static void main(String[] args) throws Exception {
		DataOutputStream dop=null;
		BufferedReader br=null;
		Socket socket=new Socket("localhost" ,6686);
		int i=0;
		while(i<6){
		 dop=new DataOutputStream(socket.getOutputStream());
		 br=new BufferedReader(new InputStreamReader(System.in));
			String string=br.readLine();
			dop.writeUTF(string);
			i++;
		}
		br.close();
		dop.close();
	}
}
