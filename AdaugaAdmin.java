import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class AdaugaAdmin extends JFrame implements ActionListener {
	
	JTextField username,email;
	JPasswordField parola;
	JLabel label_user, label_parola, label_email;
	JButton buton_signup;
	Container container;
	FileWriter fw;

	AdaugaAdmin(){
		this.setTitle("Adauga Admin");
		
		container = getContentPane();
		container.setLayout(null);
		
		label_user = new JLabel("Username: ");
		label_user.setFont(new Font("Arial", Font.PLAIN, 15));
		label_user.setSize(100, 20);
		label_user.setLocation(50, 50);
		container.add(label_user);
		
		username = new JTextField();
		username.setFont(new Font("Arial", Font.PLAIN, 15));
		username.setSize(190, 20);
		username.setLocation(150, 50);
		container.add(username);
		
		label_parola = new JLabel("Parola: ");
		label_parola.setFont(new Font("Arial", Font.PLAIN, 15));
		label_parola.setSize(100, 20);
		label_parola.setLocation(50,100);
		container.add(label_parola);
		
		parola = new JPasswordField();
		parola.setFont(new Font("Arial", Font.PLAIN, 15));
		parola.setSize(190, 20);
		parola.setLocation(150,100);
		container.add(parola);
		
		label_email = new JLabel("Email: ");
		label_email.setFont(new Font("Arial", Font.PLAIN, 15));
		label_email.setSize(100, 20);
		label_email.setLocation(50,150);
		container.add(label_email);
		
		email = new JTextField();
		email.setFont(new Font("Arial", Font.PLAIN, 15));
		email.setSize(190, 20);
		email.setLocation(150,150);
		container.add(email);
		
		buton_signup= new JButton("Login");
		buton_signup.setFont(new Font("Arial", Font.PLAIN, 15));
		buton_signup.setSize(100, 20);
		buton_signup.setLocation(150, 200);
		buton_signup.addActionListener(this);
		container.add(buton_signup);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == buton_signup) {
			String userText = username.getText();
			String passText = new String(parola.getPassword());
			String emailText = email.getText();
			
			 if (passText.length() >= 5 && userText.length() != 0 && emailText.length() != 0) {
				 InscrieDate(userText, passText, emailText);
				 dispose();
			 }
			 else if(passText.length() < 5) {
				 JOptionPane.showMessageDialog(this, "Parola trebuie sa contina minim 5 caractere!");
			 }
			 else if(userText.length() == 0) {
				 JOptionPane.showMessageDialog(this, "Username-ul nu poate fi vid");
			 }
			 else if(emailText.length() == 0) {
				 JOptionPane.showMessageDialog(this, "E-mail-ul nu poate fi vid");
			 }
	 }
	}
	
	public void InscrieDate(String user, String password, String email) {
		try{
			fw = new FileWriter("DateAdmin.txt", true);
			fw.write(user + "#");
			fw.write(password + "#");
			fw.write(email);
			fw.write("\n");
			fw.close();
		}
		catch(IOException e){
			System.out.println("Sign Up esuat, incercati din nou!");
			deseneazaSignUpAdmin();
			e.printStackTrace();
		}
	}
	
	public void deschideFereastraAdmin() {
		var FA = new FereastraAdmin();
		FA.setBounds(300, 90, 400, 300);
		FA.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		FA.setResizable(false);
		FA.setVisible(true);
	}
	private void deseneazaSignUpAdmin() {
		var aa = new AdaugaAdmin();
		aa.setBounds(900, 150, 400, 300);
		aa.setDefaultCloseOperation(HIDE_ON_CLOSE);
	    aa.setResizable(false);
		aa.setVisible(true);
	}
}
