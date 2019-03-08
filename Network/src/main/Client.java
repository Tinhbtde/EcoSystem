package main;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

final class Client {

	public static void main(String[] args) {
		System.out.println ("Hello! This is Client");
		
		try {
			Socket socket = new Socket("localhost", 2508);
			
			OutputStream os = socket.getOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(os);
			oos.writeObject("Thang map!");
			oos.flush();
			
			InputStream is = socket.getInputStream();
			ObjectInputStream ois = new ObjectInputStream(is);
			String s = (String)ois.readObject();
			System.out.println (s);
		
		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
