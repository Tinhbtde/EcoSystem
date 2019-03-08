package main;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.print.attribute.standard.Severity;

public class Server {

	public static void main(String[] args) {
		System.out.println ("Hello! This is Server");
		
		try {
			ServerSocket serverSocket = new ServerSocket(2508);
			while (true) {
				Socket socket = serverSocket.accept();
				System.out.println("Connected!");
				
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
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
