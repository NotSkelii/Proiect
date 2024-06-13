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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class SignUpAngajat extends JFrame implements ActionListener {
	
	JTextField username, email, nume, cnp, prenume;
	JPasswordField parola;
	JLabel label_user, label_parola, label_email, label_nume, label_cnp, label_prenume, label_categorie;
	JButton buton_signup;
	JComboBox<String> categorie;
	Container container;
	FileWriter fw;

	SignUpAngajat(){
		this.setTitle("Sing-up Angajat");
		
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
		
		label_nume = new JLabel("Nume: ");
		label_nume.setFont(new Font("Arial", Font.PLAIN, 15));
		label_nume.setSize(100, 20);
		label_nume.setLocation(50, 200);
		container.add(label_nume);
		
		nume = new JTextField();
		nume.setFont(new Font("Arial", Font.PLAIN, 15));
		nume.setSize(190, 20);
		nume.setLocation(150, 200);
		container.add(nume);
		
		label_cnp = new JLabel("CNP: ");
		label_cnp.setFont(new Font("Arial", Font.PLAIN, 15));
		label_cnp.setSize(100, 20);
		label_cnp.setLocation(50, 250);
		container.add(label_cnp);
		
		cnp = new JTextField();
		cnp.setFont(new Font("Arial", Font.PLAIN, 15));
		cnp.setSize(190, 20);
		cnp.setLocation(150,250);
		container.add(cnp);
		
		label_prenume = new JLabel("Prenume: ");
		label_prenume.setFont(new Font("Arial", Font.PLAIN, 15));
		label_prenume.setSize(100, 20);
		label_prenume.setLocation(50,300);
		container.add(label_prenume);
		
		prenume = new JTextField();
		prenume.setFont(new Font("Arial", Font.PLAIN, 15));
		prenume.setSize(190, 20);
		prenume.setLocation(150,300);
		container.add(prenume);
		
		label_categorie = new JLabel("Categorie: ");
		label_categorie.setFont(new Font("Arial", Font.PLAIN, 15));
		label_categorie.setSize(100, 20);
		label_categorie.setLocation(50,350);
		container.add(label_categorie);
		
		categorie = new JComboBox<String>(new String[] {"Casier", "Cititor", "Evaluator"});
		categorie.setFont(new Font("Arial", Font.PLAIN, 15));
		categorie.setSize(190,20);
		categorie.setLocation(150, 350);
		container.add(categorie);
		
		buton_signup= new JButton("Sign-Up");
		buton_signup.setFont(new Font("Arial", Font.PLAIN, 15));
		buton_signup.setSize(120, 30);
		buton_signup.setLocation(150, 400);
		buton_signup.addActionListener(this);
		container.add(buton_signup);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == buton_signup) {
			String userText = username.getText();
			String passText = new String(parola.getPassword());
			String emailText = email.getText();
			String numeText = nume.getText();
			String cnpText = cnp.getText();
			String prenumeText = prenume.getText();
			String chosenCategory = (String)(categorie.getSelectedItem());
			//System.out.println(chosenCategory);
			
			 if (passText.length() >= 5 && userText.length() != 0 && emailText.length() != 0 &&
					 numeText.length() != 0 && cnpText.length() != 0 && prenumeText.length() != 0) {
				 InscrieDate(userText, passText, emailText, numeText, cnpText, prenumeText, chosenCategory);
				 deseneazaLoginAngajat();
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
			 else if(numeText.length() == 0) {
				 JOptionPane.showMessageDialog(this, "Numele nu poate fi vid");
			 }
			 else if(cnpText.length() == 0) {
				 JOptionPane.showMessageDialog(this, "CNP-ul nu poate fi vid");
			 }
			 else if(prenumeText.length() == 0) {
				 JOptionPane.showMessageDialog(this, "Prenumele nu poate fi vid");
			 }
			 
	 }
	}
	
	public void InscrieDate(String user, String password, String email, String nume, String cnp, String prenume, String categorie) {
		try{
			fw = new FileWriter("DateAngajat.txt", true);
			fw.write(user + "#");
			fw.write(password + "#");
			fw.write(email + "#");
			fw.write(nume + "#");
			fw.write(cnp + "#");
			fw.write(prenume + "#");
			fw.write(categorie);
			fw.write("\n");
			fw.close();
		}
		catch(IOException e){
			System.out.println("Sign Up esuat, incercati din nou!");
			deseneazaSignUpAngajat();
			e.printStackTrace();
		}
		
		
		// System.out.println(date);
		// System.out.println(date.size());
	}
	
	private void deseneazaSignUpAngajat() {
		var aa = new SignUpAngajat();
		aa.setBounds(700, 90, 400, 500);
		aa.setDefaultCloseOperation(HIDE_ON_CLOSE);
	    aa.setResizable(false);
		aa.setVisible(true);
	}
	
	private void deseneazaLoginAngajat() {
		LoginAngajat loginAdmin = new LoginAngajat();
		  loginAdmin.setBounds(300, 90, 400, 300);
		  loginAdmin.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		  loginAdmin.setResizable(false);
		  loginAdmin.setVisible(true);
	}
}
