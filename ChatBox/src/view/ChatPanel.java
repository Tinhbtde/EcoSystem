package view;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JTextArea;

import control.Client;
import model.Message;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ChatPanel extends JPanel {

	JTextArea txtDisplay;
	private String sender;
	private String reciever;
	private String senderIP;
	private String recieverIP;
	private int port;
	
	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getReciever() {
		return reciever;
	}

	public void setReciever(String reciever) {
		this.reciever = reciever;
	}

	public String getSenderIP() {
		return senderIP;
	}

	public void setSenderIP(String senderIP) {
		this.senderIP = senderIP;
	}

	public String getRecieverIP() {
		return recieverIP;
	}

	public void setRecieverIP(String recieverIP) {
		this.recieverIP = recieverIP;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	/**
	 * Create the panel.
	 */
	public ChatPanel() {
		setLayout(new GridLayout(2, 1, 0, 0));
		
		txtDisplay = new JTextArea();
		add(txtDisplay);
		
		JPanel panel = new JPanel();
		add(panel);
		panel.setLayout(new GridLayout(1, 2, 0, 0));
		
		JTextArea txtSend = new JTextArea();
		panel.add(txtSend);
		
		JButton btnSend = new JButton("SEND");
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Message mess = new Message();
				mess.setId(2);
				mess.setContent(txtSend.getText());
				mess.setSender(sender);
				mess.setReciever(reciever);
				mess.setSenderIP(senderIP);
				mess.setRecieverIP(recieverIP);
				
				Client.send(recieverIP, port, mess.toJson());
				txtSend.setText("");
			}
		});
		panel.add(btnSend);
		
		
	}

	public synchronized void appendText(String s) {
		this.txtDisplay.append(s);
	}
}
