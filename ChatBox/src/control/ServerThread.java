package control;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerThread extends Thread {
	private int port;
	ServerSocket serverSocket;
	public ServerThread(int port) {
		super();
		this.port = port;
		
		try {
			serverSocket = new ServerSocket(port);
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		
		try {
			while (true) {
				Socket socket = serverSocket.accept();
				
				InputStream is = socket.getInputStream();
				ObjectInputStream ois = new ObjectInputStream(is);
				String s = (String)ois.readObject();
				System.out.println (s);
				
				OutputStream os = socket.getOutputStream();
				ObjectOutputStream oos = new ObjectOutputStream(os);
				oos.writeObject("OK!");
				os.flush();
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
