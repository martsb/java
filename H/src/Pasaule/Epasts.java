package Pasaule;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Epasts implements ActionListener{
	static JFrame jframe = new JFrame();
	static JPanel firstScreen = new JPanel();
	static JPanel secondScreen = new JPanel();
	static JButton loginButton = new JButton("Login");
	static JButton cancelButton = new JButton("Cancel");
	static JButton newAccountButton = new JButton("Create an account");
	static JButton incomingEmailsButton = new JButton("Incoming Emails");
	static JButton sentEmailsButton = new JButton("Sent Emails");
	static JButton logoutButton = new JButton("Logout");
	static JButton sendButton = new JButton("Write an Email");
	static JButton sendEmailButton = new JButton("Send");
	static JButton cancelEmailButton = new JButton("Cancel");
	static JTextField loginField = new JTextField();
	static JTextField passwordField = new JTextField();
	static JTextField receiverField = new JTextField();
	static JTextField topicField = new JTextField();
	static JTextField textField = new JTextField();
	static JLabel loginText = new JLabel("Username");
	static JLabel passwordText = new JLabel("Password");
	static JLabel infoText = new JLabel("Login in your inbox!");
	static JLabel receiverText = new JLabel("Receiver");
	static JLabel topicText = new JLabel("Topic:");
	static JLabel textText = new JLabel("Text:");
	static Container c1 = new Container();
	static ArrayList<String> usernameList = new ArrayList<>();
	static ArrayList<String> passwordList = new ArrayList<>();
	static ArrayList<Object> loginThings = new ArrayList<>();
	static ArrayList<Object> emailThings = new ArrayList<>();
	static ArrayList<JButton> buttons = new ArrayList<>();
	static ArrayList<ArrayList<String>> emailsList = new ArrayList<>();

	static boolean isLoginScreenOpen = true;
	static int minUsernameLenght = 3;
	static int minPasswordLenght = 3;
	static int displayedEmailCount = 8;
	
	public static void main(String[] args) {
		new Epasts();
	}
	
	Epasts() {
		createjframe();
		start();
	}
	void createSendEmailButton() {
		sendEmailButton.setBounds(90, 400, 200, 50);
		sendEmailButton.setVisible(false);
		sendEmailButton.setOpaque(true);
		sendEmailButton.setFocusable(false);
		sendEmailButton.addActionListener(this);
		c1.add(sendEmailButton);
	}
	void createCancelButton() {
		cancelEmailButton.setBounds(310, 400, 200, 50);
		cancelEmailButton.setVisible(false);
		cancelEmailButton.setOpaque(true);
		cancelEmailButton.setFocusable(false);
		cancelEmailButton.addActionListener(this);
		c1.add(cancelEmailButton);
	}
	
	void createnewAccountButton() {
		newAccountButton.setBounds(200, 400, 200, 50);
		newAccountButton.setVisible(true);
		newAccountButton.setOpaque(true);
		newAccountButton.setFocusable(false);
		newAccountButton.addActionListener(this);
		loginThings.add(newAccountButton);
		c1.add(newAccountButton);
	}
	void createloginButton() {
		loginButton.setBounds(200, 300, 200, 50);
		loginButton.setVisible(true);
		loginButton.setOpaque(true);
		loginButton.setFocusable(false);
		loginButton.addActionListener(this);
		loginThings.add(loginButton);
		c1.add(loginButton);
	}
	void createcancelButton() {
		cancelButton.setBounds(200, 400, 200, 50);
		cancelButton.setVisible(true);
		cancelButton.setOpaque(true);
		cancelButton.setFocusable(false);
		cancelButton.addActionListener(this);
		loginThings.add(cancelButton);
		c1.add(cancelButton);
	}
	void createSendButton() {
		sendButton.setBounds(200, 100, 200, 50);
		sendButton.setVisible(false);
		sendButton.setOpaque(true);
		sendButton.setFocusable(false);
		sendButton.addActionListener(this);
		emailThings.add(sendButton);
		c1.add(sendButton);
	}
	void createincomingEmailsButton() {
		incomingEmailsButton.setBounds(200, 200, 200, 50);
		incomingEmailsButton.setVisible(false);
		incomingEmailsButton.setOpaque(true);
		incomingEmailsButton.setFocusable(false);
		incomingEmailsButton.addActionListener(this);
		emailThings.add(incomingEmailsButton);
		c1.add(incomingEmailsButton);
	}
	void createSendEmailsButton() {
		sentEmailsButton.setBounds(200, 300, 200, 50);
		sentEmailsButton.setVisible(false);
		sentEmailsButton.setOpaque(true);
		sentEmailsButton.setFocusable(false);
		sentEmailsButton.addActionListener(this);
		emailThings.add(sentEmailsButton);
		c1.add(sentEmailsButton);
	}
	void createlogoutButton() {
		logoutButton.setBounds(200, 400, 200, 50);
		logoutButton.setVisible(false);
		logoutButton.setOpaque(true);
		logoutButton.setFocusable(false);
		logoutButton.addActionListener(this);
		emailThings.add(loginButton);
		c1.add(logoutButton);
	}
	void createpasswordField() {
		passwordField.setBounds(200, 200, 200, 50);
		passwordField.setVisible(true);
		passwordField.setOpaque(true);
		passwordField.addActionListener(this);
		loginThings.add(passwordField);
		c1.add(passwordField);
	}
	void createloginField() {
		loginField.setBounds(200, 100, 200, 50);
		loginField.setVisible(true);
		loginField.setOpaque(true);
		loginField.addActionListener(this);
		loginThings.add(loginField);
		c1.add(loginField);
	}
	void createpasswordText() {
		passwordText.setBounds(200, 150, 200, 50);
		passwordText.setVisible(true);
		passwordText.setOpaque(true);
		loginThings.add(passwordText);
		c1.add(passwordText);
	}
	void createloginText() {
		loginText.setBounds(200, 50, 200, 50);
		loginText.setVisible(true);
		loginText.setOpaque(true);
		loginThings.add(loginText);
		c1.add(loginText);
	}
	void createjframe() {
		jframe.setBounds(600, 200, 600, 600);
		jframe.setVisible(true);
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.setLayout(null);
		jframe.setResizable(false);
		c1 = jframe.getContentPane();
	}
	void createInfoText() {
		infoText.setBounds(200, 20, 300, 50);
		infoText.setVisible(true);
		infoText.setOpaque(true);
		c1.add(infoText);
	}
	void openAccountScreen() {
		loginButton.setText("Create new account");
		infoText.setText("Creating an account...");
		loginText.setText("New Username");
		passwordText.setText("New Password");
		createcancelButton();
		c1.remove(newAccountButton);
		c1.repaint();
		isLoginScreenOpen = false;
	}
	void reopenLoginScreen() {
		loginButton.setText("Login");
		loginText.setText("Username");
		passwordText.setText("Password");
		c1.remove(cancelButton);
		c1.add(newAccountButton);
		c1.repaint();
		isLoginScreenOpen = true;
	}
	void tryLogin() {
		boolean found = false;
		for (int i = 0; i < usernameList.size(); i++) {
			if (usernameList.get(i).equals(loginField.getText()) && passwordList.get(i).equals(passwordField.getText())) {
				openEmail();
				found = true;
				break;
			}
		}
		if(found == false) {
			infoText.setText("Wrong Username or Password!");
			c1.repaint();
		}
	}
	void createAccount() {
		usernameList.add(loginField.getText());
		passwordList.add(passwordField.getText());
		infoText.setText("Account created!");
		c1.repaint();
		reopenLoginScreen();
	}
	void openEmail() {
		System.out.println("ew");
		loginButton.setVisible(false);
		loginText.setVisible(false);
		loginField.setVisible(false);
		passwordText.setVisible(false);
		passwordField.setVisible(false);
		loginButton.setVisible(false);
		newAccountButton.setVisible(false);
		sendButton.setVisible(true);
		incomingEmailsButton.setVisible(true);
		sentEmailsButton.setVisible(true);
		logoutButton.setVisible(true);
		c1.add(infoText);
		infoText.setText("Login Succesfull!");
		c1.repaint();
	}
	void creatingAccountCheck() {
		if (loginField.getText().length() < minUsernameLenght) {
			infoText.setText("Username must be atleast " + minUsernameLenght + " characters long!");
			return;
		}  
		if (passwordField.getText().length() < minPasswordLenght) {
			infoText.setText("Password must be atleast " + minPasswordLenght + " characters long!");
			return;
		}
		for (int i = 0; i < usernameList.size(); i++) {
			if (usernameList.get(i).matches(loginField.getText())) {
				infoText.setText("Username already exists!");
				return;
			}
		}
		createAccount();
	}
	void openLoginScreen() {
		loginButton.setVisible(true);
		loginText.setVisible(true);
		loginField.setVisible(true);
		passwordText.setVisible(true);
		passwordField.setVisible(true);
		loginButton.setVisible(true);
		newAccountButton.setVisible(true);
		sendButton.setVisible(false);
		incomingEmailsButton.setVisible(false);
		sentEmailsButton.setVisible(false);
		logoutButton.setVisible(false);
		loginField.setText("");
		passwordField.setText("");
		infoText.setText("Login in your inbox!");
		c1.repaint();
	}
	void start() {
		createloginField();
		createloginText();
		createpasswordText();
		createpasswordField();
		createloginButton();
		createnewAccountButton();
		createInfoText();
		createSendButton();
		createincomingEmailsButton();
		createSendEmailsButton();
		createlogoutButton();
		createSendEmailButton();
		createCancelButton();
		infoText.setText("Login in your inbox!");
		c1.repaint();
	}
	void buttonMaker(int x, int y, String text) {
		buttons.add(new JButton(text));
		buttons.get(buttons.size()-1).setBounds(x, y, 400, 50);
		buttons.get(buttons.size()-1).setVisible(false);
		buttons.get(buttons.size()-1).setOpaque(true);
		buttons.get(buttons.size()-1).setFocusable(false);
		buttons.get(buttons.size()-1).addActionListener(this);
		c1.add(buttons.get(buttons.size()-1));
	}
	void switchScreen(int num) {
		switch(num) {
		case 1: ;
		break;
		case 2: ;
		break;
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == newAccountButton) {
			openAccountScreen();
		}
		if (e.getSource() == cancelButton) {
			reopenLoginScreen();
			infoText.setText("Login in your inbox!");
		}
		
		if (e.getSource() == loginField || 
			e.getSource() == passwordField ||
			e.getSource() == loginButton) {
				if (isLoginScreenOpen) tryLogin();
				else creatingAccountCheck();
		}
		if (e.getSource() == logoutButton) {
			openLoginScreen();
		}
		if (e.getSource() == sendButton) {
			sendButton.setVisible(false);
			incomingEmailsButton.setVisible(false);
			sentEmailsButton.setVisible(false);
			logoutButton.setVisible(false);
			sendEmailButton.setVisible(true);
			cancelEmailButton.setVisible(true);
			
			c1.repaint();
		}
		if (e.getSource() == cancelEmailButton) {
			sendButton.setVisible(true);
			incomingEmailsButton.setVisible(true);
			sentEmailsButton.setVisible(true);	
			logoutButton.setVisible(true);
			sendEmailButton.setVisible(false);
			cancelEmailButton.setVisible(false);
			
			c1.repaint();
		}
		if (e.getSource() == sentEmailsButton) {
			sendButton.setVisible(false);
			incomingEmailsButton.setVisible(false);
			sentEmailsButton.setVisible(false);
			logoutButton.setVisible(false);
			for (int i = 0; i < displayedEmailCount; i++) {
				if (i + 1 == displayedEmailCount) buttonMaker(100, i * 50 + 80, "Go back");
				else 							  buttonMaker(100, i * 50 + 80, "Email: " + (i + 1));
				buttons.get(i).setName("e" + i);
				buttons.get(i).setVisible(true);
				System.out.println(buttons.get(i).getName());
			}
		}
		if (buttons.size() >= displayedEmailCount && e.getSource() == buttons.get(displayedEmailCount-1)) {
			sendButton.setVisible(true);
			incomingEmailsButton.setVisible(true);
			sentEmailsButton.setVisible(true);	
			logoutButton.setVisible(true);
			for (JButton b : buttons) {
				b.setVisible(false);
			}
		}

	}

}
