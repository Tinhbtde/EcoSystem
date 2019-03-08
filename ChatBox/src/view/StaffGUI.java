package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.Border;

import control.Client;
import model.Message;

import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.TextArea;

import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StaffGUI {

	private JFrame frame;
	private JTextField txtStaff;
	private JTextField txtServerIP;
	private JTextField txtPort;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StaffGUI window = new StaffGUI();
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
	public StaffGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 547, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel lblStaff = new JLabel("Staff");
		panel.add(lblStaff);
		
		txtStaff = new JTextField();
		txtStaff.setText("Hoa");
		panel.add(txtStaff);
		txtStaff.setColumns(4);
		
		JLabel lblManagerIp = new JLabel("Manager IP");
		panel.add(lblManagerIp);
		
		txtServerIP = new JTextField();
		txtServerIP.setText("localhost");
		panel.add(txtServerIP);
		txtServerIP.setColumns(10);
		
		JLabel lblPort = new JLabel("Port");
		panel.add(lblPort);
		
		txtPort = new JTextField();
		txtPort.setText("2508");
		panel.add(txtPort);
		txtPort.setColumns(4);
		
		JButton btnConnect = new JButton("Connect");
		btnConnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ChatPanel chat = new ChatPanel();
				frame.getContentPane().add(chat, BorderLayout.CENTER);
				frame.revalidate();
				
				Message mess = new Message();
				mess.setSender(txtStaff.getText());
				mess.setReciever("server");
				mess.setSenderIP("localhost");
				mess.setRecieverIP(txtServerIP.getText());
				mess.setContent("connect");
				mess.setId(1);
				
				int port = Integer.parseInt(txtPort.getText());
				Client.send(txtServerIP.getText(), port, mess.toJson());
			}
		});
		panel.add(btnConnect);
		
	}

}
