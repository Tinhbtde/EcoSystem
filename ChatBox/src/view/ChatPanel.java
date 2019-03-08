package view;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class ChatPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public ChatPanel() {
		setLayout(new GridLayout(2, 1, 0, 0));
		
		JTextArea txtDisplay = new JTextArea();
		add(txtDisplay);
		
		JPanel panel = new JPanel();
		add(panel);
		panel.setLayout(new GridLayout(1, 2, 0, 0));
		
		JTextArea txtSend = new JTextArea();
		panel.add(txtSend);
		
		JButton btnSend = new JButton("SEND");
		panel.add(btnSend);
		
		
	}

}
