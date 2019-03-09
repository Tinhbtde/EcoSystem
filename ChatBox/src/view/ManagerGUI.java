package view;

import java.awt.EventQueue;
import java.net.InetAddress;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JTextField;

import control.ServerThread;
import model.Message;

public class ManagerGUI {

	private JFrame frame;
	private JTextField txtPort;
	JTabbedPane tabbedPane;
	private int port = 2508;
	private String myIP;

	private HashMap<String, ChatPanel> chatPanels;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManagerGUI window = new ManagerGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ManagerGUI() {
		try {
			InetAddress inetAddress = InetAddress.getLocalHost();
			myIP = inetAddress.getHostAddress();
		} catch (Exception e) {
			e.printStackTrace();
		}
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Mng. Server is running at the port");
		panel.add(lblNewLabel);
		
		txtPort = new JTextField();
		txtPort.setText("2508");
		panel.add(txtPort);
		txtPort.setColumns(10);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frame.getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		txtPort.setText(port + ""); 
		ServerThread serverThread = new ServerThread(port);
		serverThread.setManagerGUI(this);
		serverThread.start();
		
		chatPanels = new HashMap<String, ChatPanel>();
	}
	
	public synchronized void addStaff(Message mess) {
		if(!chatPanels.containsKey(mess.getSender())) {
			ChatPanel chat = new ChatPanel();
			chat.setPort(port);
			chat.setRecieverIP(mess.getSenderIP());
			chat.setSenderIP(myIP);
			chat.setSender("server");
			chat.setReciever(mess.getSender());
			tabbedPane.add(mess.getSender(), chat);
			chatPanels.put(mess.getSender(), chat);
		}
	}

	public synchronized void processStaff2Manager(Message mess) {
		if(chatPanels.containsKey(mess.getSender())) {
			ChatPanel chat = chatPanels.get(mess.getSender());
			String s = mess.getSender() + " : " + mess.getContent() + "\n";
			chat.appendText(s);
		}
	}
}
