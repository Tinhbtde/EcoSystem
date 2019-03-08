package model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Message {

	private String sender;
	private String reciever;
	private String senderIP;
	private String recieverIP;
	private String content;
	private int id;
	
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Message(String sender, String reciever, String senderIP, String recieverIP, String content, int id) {
		super();
		this.sender = sender;
		this.reciever = reciever;
		this.senderIP = senderIP;
		this.recieverIP = recieverIP;
		this.content = content;
		this.id = id;
	}

	public static void main(String[] args) {

		Message mess = new Message();
		mess.sender = "Tinh";
		mess.reciever = "SE1302";
		mess.senderIP = "130006";
		mess.recieverIP = "130218";
		mess.content = "Hello";
		mess.id = 1;
		
		Gson gson = new GsonBuilder().create();
	    String s = gson.toJson(mess);
	    System.out.println (s);
	    
	    Message p = gson.fromJson(s, Message.class);
	    System.out.println (p.sender);
	}

	public String toJson () {
		Gson gson = new GsonBuilder().create();
	    String s = gson.toJson(this);
	    return s;
	}
	public Message(String s) {
		Gson gson = new GsonBuilder().create();
		Message p = gson.fromJson(s, Message.class);
		this.sender = p.sender;
		this.reciever = p.reciever;
		this.senderIP = p.senderIP;
		this.recieverIP = p.reciever;
		this.content = p.content;
		this.id = p.id;
	}
	public Message() {
		super();
	}

}
