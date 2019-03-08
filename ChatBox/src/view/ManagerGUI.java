package view;

import java.awt.EventQueue;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JTextField;

import control.ServerThread;

public class ManagerGUI {

	private JFrame frame;
	private JTextField txtPort;
	JTabbedPane tabbedPane;
	private int port = 2508;

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
	
	public synchronized void addStaff(String name) {
		if(!chatPanels.containsKey(name)) {
			ChatPanel chat = new ChatPanel();
			tabbedPane.add(name, chat);
			chatPanels.put(name, chat);
		}
	}

}
