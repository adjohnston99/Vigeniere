package Vigeniere;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
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
	
	GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
	int screenWidth = gd.getDisplayMode().getWidth();
	int screenHeight = gd.getDisplayMode().getHeight();
	
	double frameWidth = screenWidth*15/100;
	double frameHeight = screenHeight*25/100;
	
	double framePosX = screenWidth*25/100;
	double framePosY = screenHeight*30/100;
	double defaultFontSize = screenHeight*50/100; 
	Font defaultFont = new Font("SansSerif", Font.BOLD, (int) defaultFontSize);
	
	Frame() {
		
		System.out.println(screenWidth + ", " + screenHeight);
		System.out.println(frameWidth + ", " + frameHeight);
		System.out.println(framePosX + ", " + framePosY);
		
		encryptButton.addActionListener(this);
		decryptButton.addActionListener(this);
		
		input.addFocusListener(this);
		key.addFocusListener(this);
		output.addFocusListener(this);
		
		input.setPreferredSize(new Dimension(screenWidth*5/100, screenHeight*5/100));
		
		add(input);
		add(key);
		add(output);
		
		add(encryptButton);
		add(decryptButton);
		
		
		setLayout(new FlowLayout());
		setSize((int) frameWidth, (int) frameHeight);
		setLocation((int) framePosX, (int) framePosY);
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
