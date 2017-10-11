package package1.socket;

import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Socket_1 {
	public static void main(String[] args) throws Exception {
		ServerSocket server = new ServerSocket(6686);
		while (true) {
			Socket socket = server.accept();
			DataInputStream dis = new DataInputStream(socket.getInputStream());
			String msg = dis.readUTF();
			
			while(msg != null){
				System.out.println(msg);
				msg = dis.readUTF();
			}
			dis.close();
		}
	}

}
