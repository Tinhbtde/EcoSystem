package control;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
	public static String send (String url, int port, String content) {
		try {
			Socket socket = new Socket(url, port);
			
			OutputStream os = socket.getOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(os);
			oos.writeObject(content);
			oos.flush();
			
			InputStream is = socket.getInputStream();
			ObjectInputStream ois = new ObjectInputStream(is);
			String s = (String)ois.readObject();
			System.out.println (s);
			socket.close();
			return s;
		
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
}
