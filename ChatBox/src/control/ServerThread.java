package control;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import model.Message;
import view.ManagerGUI;

public class ServerThread extends Thread {
	private int port;
	ServerSocket serverSocket;
	ManagerGUI managerGUI;
	
	public ManagerGUI getManagerGUI() {
		return managerGUI;
	}
	public void setManagerGUI(ManagerGUI managerGUI) {
		this.managerGUI = managerGUI;
	}
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
				
				Message mess = new Message(s);
				if(mess.getId() == 1) {
					managerGUI.addStaff(mess);
				}
				else if(mess.getId() == 2) {
					managerGUI.processStaff2Manager(mess);
				}
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
