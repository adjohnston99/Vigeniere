package Vigeniere;

import java.awt.Font;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

import javafx.application.Application;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class Frame extends Application implements EventHandler<ActionEvent>, ChangeListener<Boolean> {
	
	public static void main(String[] args) {
		launch(args);
	}
	
	GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
	int screenWidth = gd.getDisplayMode().getWidth();
	int screenHeight = gd.getDisplayMode().getHeight();
	
	double frameWidth = screenWidth*15/100;
	double frameHeight = screenHeight*25/100;
	
	double framePosX = screenWidth*25/100;
	double framePosY = screenHeight*30/100;
	
	double defaultFontSize = screenHeight*50/100; 
	Font defaultFont = new Font("SansSerif", Font.BOLD, (int) defaultFontSize);
	
//	Frame() {
//		
//		System.out.println(screenWidth + ", " + screenHeight);
//		System.out.println(frameWidth + ", " + frameHeight);
//		System.out.println(framePosX + ", " + framePosY);
//		
//		encryptButton.addActionListener(this);
//		decryptButton.addActionListener(this);
//		
//		input.addFocusListener(this);
//		key.addFocusListener(this);
//		output.addFocusListener(this);
//		
//		input.setPreferredSize(new Dimension(screenWidth*5/100, screenHeight*5/100));
//		
//		add(input);
//		add(key);
//		add(output);		
//		
//		setLayout(new FlowLayout());
//		setSize((int) frameWidth, (int) frameHeight);
//		setLocation((int) framePosX, (int) framePosY);
//		setDefaultCloseOperation(EXIT_ON_CLOSE);
//		setVisible(true);
//	}

	FlowPane componentLayout = new FlowPane();
	
	TextField input;
	TextField key;
	TextField output;
	
	Button encryptButton;
	Button decryptButton;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		primaryStage.setTitle("Vigeniere");
		
		input = new TextField("Input");
		key = new TextField("Key");
		output = new TextField("Output");
		
		encryptButton = new Button("Encrypt");
		decryptButton = new Button("Decrypt");
		
		input.focusedProperty().addListener(this);
		key.focusedProperty().addListener(this);
		output.focusedProperty().addListener(this);
		
		encryptButton.addEventHandler(ActionEvent.ACTION, this);
		decryptButton.addEventHandler(ActionEvent.ACTION, this);
		
		componentLayout.getChildren().add(input);
		componentLayout.getChildren().add(key);
		componentLayout.getChildren().add(output);
		
		componentLayout.getChildren().add(encryptButton);
		componentLayout.getChildren().add(decryptButton);
		
		Scene appScene = new Scene(componentLayout, frameWidth, frameHeight);
		
		primaryStage.setScene(appScene);
		primaryStage.show();
	}
	
	public void handle(ActionEvent event) {
	
		String inputText = input.getText();
		String keyText = key.getText();
		
		if (event.getSource() == encryptButton) {
			output.setText(Algorithms.encrypt(inputText, keyText));
		} else if (event.getSource() == decryptButton) {
			output.setText(Algorithms.decrypt(inputText, keyText));
		}
		
		event.consume();
	}

//	public void focusGained(FocusEvent event) {
//		
//		if ((event.getSource() == input) && (input.getText().equals("Input"))) {
//			input.setText("");
//		} else if ((event.getSource() == key) && (key.getText().equals("Key"))) {
//			key.setText("");
//		} else if ((event.getSource() == output) && (output.getText().equals("Output"))) {
//			output.setText("");
//		}
//	}
//
//	public void focusLost(FocusEvent event) {
//		
//		if ((event.getSource() == input) && (input.getText().equals(""))) {
//			input.setText("Input");
//		} else if ((event.getSource() == key) && (key.getText().equals(""))) {
//			key.setText("Key");
//		} else if ((event.getSource() == output) && (output.getText().equals(""))) {
//			output.setText("Output");
//		}
//	}
	
	@Override
	public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
	
		System.out.println("Focus changed");
		System.out.println(observable.getClass());
	}
}