package Vigeniere;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class Frame extends JFrame implements ActionListener, FocusListener {

	private static final long serialVersionUID = 1L;
	
	JTextArea input = new JTextArea("Input");
	JTextArea key = new JTextArea("Key");
	JTextArea output = new JTextArea("Output");
	
	JButton encryptButton = new JButton("Encrypt");
	JButton decryptButton = new JButton("Decrypt");
	
	Frame() {
		
		encryptButton.addActionListener(this);
		decryptButton.addActionListener(this);
		
		input.addFocusListener(this);
		key.addFocusListener(this);
		output.addFocusListener(this);
		
		add(input);
		add(key);
		add(output);
		
		add(encryptButton);
		add(decryptButton);
		
		
		setLayout(new FlowLayout());
		setSize(300, 200);
		setLocation(500, 300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String inputText = input.getText();
		String keyText = key.getText();
		
		if (e.getSource() == encryptButton) {
			output.setText(Algorithms.encrypt(inputText, keyText));
		} else if (e.getSource() == decryptButton) {
			output.setText(Algorithms.decrypt(inputText, keyText));
		}		
	}

	@Override
	public void focusGained(FocusEvent e) {
		
		if ((e.getSource() == input) && (input.getText().equals("Input"))) {
			input.setText("");
		} else if ((e.getSource() == key) && (key.getText().equals("Key"))) {
			key.setText("");
		} else if ((e.getSource() == output) && (output.getText().equals("Output"))) {
			output.setText("");
		}
	}

	@Override
	public void focusLost(FocusEvent e) {
		
		if ((e.getSource() == input) && (input.getText().equals(""))) {
			input.setText("Input");
		} else if ((e.getSource() == key) && (key.getText().equals(""))) {
			key.setText("Key");
		} else if ((e.getSource() == output) && (output.getText().equals(""))) {
			output.setText("Output");
		}
	}
}
