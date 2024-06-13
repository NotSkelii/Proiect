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

public class SignUpLocatar extends JFrame implements ActionListener {
	
	JTextField username, email, nume, cnp, prenume, localitate, judet, strada, nrAp, bloc, scara, nrPers;
	JPasswordField parola;
	JLabel label_user, label_parola, label_email, label_nume, label_cnp, label_prenume, label_localitate, 
	label_judet, label_strada, label_nrAp, label_bloc, label_scara, label_nrPers;
	JButton buton_signup;
	Container container;
	FileWriter fw;

	SignUpLocatar(){
		this.setTitle("Sign-up Locatar");
		
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
		parola.setLocation(150, 100);
		container.add(parola);
		
		label_cnp = new JLabel("CNP: ");
		label_cnp.setFont(new Font("Arial", Font.PLAIN, 15));
		label_cnp.setSize(100, 20);
		label_cnp.setLocation(50, 150);
		container.add(label_cnp);
		
		cnp = new JTextField();
		cnp.setFont(new Font("Arial", Font.PLAIN, 15));
		cnp.setSize(190, 20);
		cnp.setLocation(150, 150);
		container.add(cnp);
		
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
		
		label_prenume = new JLabel("Prenume: ");
		label_prenume.setFont(new Font("Arial", Font.PLAIN, 15));
		label_prenume.setSize(100, 20);
		label_prenume.setLocation(50, 250);
		container.add(label_prenume);
		
		prenume = new JTextField();
		prenume.setFont(new Font("Arial", Font.PLAIN, 15));
		prenume.setSize(190, 20);
		prenume.setLocation(150, 250);
		container.add(prenume);
		
		label_email = new JLabel("Email: ");
		label_email.setFont(new Font("Arial", Font.PLAIN, 15));
		label_email.setSize(100, 20);
		label_email.setLocation(50, 300);
		container.add(label_email);
		
		email = new JTextField();
		email.setFont(new Font("Arial", Font.PLAIN, 15));
		email.setSize(190, 20);
		email.setLocation(150, 300);
		container.add(email);
		
		label_localitate = new JLabel("Localitate: ");
		label_localitate.setFont(new Font("Arial", Font.PLAIN, 15));
		label_localitate.setSize(100, 20);
		label_localitate.setLocation(50, 350);
		container.add(label_localitate);
		
		localitate = new JTextField();
		localitate.setFont(new Font("Arial", Font.PLAIN, 15));
		localitate.setSize(190, 20);
		localitate.setLocation(150, 350);
		container.add(localitate);
		
		label_judet = new JLabel("Judet: ");
		label_judet.setFont(new Font("Arial", Font.PLAIN, 15));
		label_judet.setSize(100, 20);
		label_judet.setLocation(390, 50);
		container.add(label_judet);
		
		judet = new JTextField();
		judet.setFont(new Font("Arial", Font.PLAIN, 15));
		judet.setSize(190, 20);
		judet.setLocation(490, 50);
		container.add(judet);
		
		label_strada= new JLabel("Strada: ");
		label_strada.setFont(new Font("Arial", Font.PLAIN, 15));
		label_strada.setSize(100, 20);
		label_strada.setLocation(390, 100);
		container.add(label_strada);
		
		strada = new JTextField();
		strada.setFont(new Font("Arial", Font.PLAIN, 15));
		strada.setSize(190, 20);
		strada.setLocation(490, 100);
		container.add(strada);
		
		label_nrAp = new JLabel("Nr. apart.: ");
		label_nrAp.setFont(new Font("Arial", Font.PLAIN, 15));
		label_nrAp.setSize(100, 20);
		label_nrAp.setLocation(390,150);
		container.add(label_nrAp);
		
		nrAp = new JTextField();
		nrAp.setFont(new Font("Arial", Font.PLAIN, 15));
		nrAp.setSize(190, 20);
		nrAp.setLocation(490,150);
		container.add(nrAp);
		
		label_bloc = new JLabel("Bloc: ");
		label_bloc.setFont(new Font("Arial", Font.PLAIN, 15));
		label_bloc.setSize(100, 20);
		label_bloc.setLocation(390, 200);
		container.add(label_bloc);
		
		bloc = new JTextField();
		bloc.setFont(new Font("Arial", Font.PLAIN, 15));
		bloc.setSize(190, 20);
		bloc.setLocation(490, 200);
		container.add(bloc);
		
		label_scara = new JLabel("Scara: ");
		label_scara.setFont(new Font("Arial", Font.PLAIN, 15));
		label_scara.setSize(100, 20);
		label_scara.setLocation(390, 250);
		container.add(label_scara);
		
		scara = new JTextField();
		scara.setFont(new Font("Arial", Font.PLAIN, 15));
		scara.setSize(190, 20);
		scara.setLocation(490, 250);
		container.add(scara);
		
		label_nrPers = new JLabel("Nr. pers.: ");
		label_nrPers.setFont(new Font("Arial", Font.PLAIN, 15));
		label_nrPers.setSize(100, 20);
		label_nrPers.setLocation(390, 300);
		container.add(label_nrPers);
		
		nrPers = new JTextField();
		nrPers.setFont(new Font("Arial", Font.PLAIN, 15));
		nrPers.setSize(190, 20);
		nrPers.setLocation(490, 300);
		container.add(nrPers);
		
		buton_signup= new JButton("Sign-Up");
		buton_signup.setFont(new Font("Arial", Font.PLAIN, 15));
		buton_signup.setSize(120, 30);
		buton_signup.setLocation(490, 350);
		buton_signup.addActionListener(this);
		container.add(buton_signup);
	}

	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == buton_signup) {
			String userText = username.getText();
			String passText = new String(parola.getPassword());
			String cnpText = cnp.getText();
			String numeText = nume.getText();
			String prenumeText = prenume.getText();
			String emailText = email.getText();
			String locText = localitate.getText();
			String judText = judet.getText();
			String stradaText = strada.getText();
			String nrApText = nrAp.getText();
			String blocText = bloc.getText();
			String scaraText = scara.getText();
			String nrPersText = nrPers.getText();
			
			//System.out.println(chosenCategory);
			
			 if (passText.length() >= 5 && userText.length() != 0 && cnpText.length() != 0 &&
					 numeText.length() != 0 && prenumeText.length() != 0 && emailText.length() != 0 &&
					 locText.length() != 0 && judText.length() != 0 && stradaText.length() != 0 &&
					 nrApText.length() != 0 && blocText.length() != 0 && scaraText.length() != 0 &&
					 nrPersText.length() != 0) {
				 InscrieDate(userText, passText, cnpText, numeText, prenumeText, emailText, locText, judText,
						 stradaText, nrApText, blocText, scaraText, nrPersText);
				 deschideLoginLocatar();
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
			 else if(locText.length() == 0) {
				 JOptionPane.showMessageDialog(this, "Localitatea nu poate fi vida");
			 }
			 else if(judText.length() == 0) {
				 JOptionPane.showMessageDialog(this, "Judetul nu poate fi vid");
			 }
			 else if(stradaText.length() == 0) {
				 JOptionPane.showMessageDialog(this, "Strada nu poate fi vida");
			 }
			 else if(nrApText.length() == 0) {
				 JOptionPane.showMessageDialog(this, "Numarul apartamentului nu poate fi vid");
			 }
			 else if(blocText.length() == 0) {
				 JOptionPane.showMessageDialog(this, "Blocul nu poate fi vid");
			 }
			 else if(scaraText.length() == 0) {
				 JOptionPane.showMessageDialog(this, "Scara nu poate fi vida");
			 }
			 else if(nrPersText.length() == 0) {
				 JOptionPane.showMessageDialog(this, "Numarul de persoane nu poate fi vid");
			 }
			 
	 }
	}
	
	public void InscrieDate(String user, String password, String cnp, String nume, String prenume,
			String email, String loc, String jud, String strada, String nrAp, 
			String bloc, String scara, String nrPers) {
		try{
			fw = new FileWriter("DateLocatar.txt", true);
			fw.write(user + "#");
			fw.write(password + "#");
			fw.write(cnp + "#");
			fw.write(nume + "#");
			fw.write(prenume + "#");
			fw.write(email + "#");
			fw.write(loc + "#");
			fw.write(jud + "#");
			fw.write(strada + "#");
			fw.write(nrAp + "#");
			fw.write(bloc + "#");
			fw.write(scara + "#");
			fw.write(nrPers);
			fw.write("\n");
			fw.close();
		}
		catch(IOException e){
			System.out.println("Sign Up esuat, incercati din nou!");
			deseneazaSignUpLocatar();
			e.printStackTrace();
		}
		
		
		// System.out.println(date);
		// System.out.println(date.size());
	}
	 
	
	public void deseneazaSignUpLocatar() {
		var aa = new SignUpLocatar();
		aa.setBounds(700, 90, 400, 500);
		aa.setDefaultCloseOperation(HIDE_ON_CLOSE);
	    aa.setResizable(false);
		aa.setVisible(true);
	}
	
	public void deschideLoginLocatar() {
		 var loginAdmin = new LoginLocatar();
		  loginAdmin.setBounds(300, 90, 400, 300);
		  loginAdmin.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		  loginAdmin.setResizable(false);
		  loginAdmin.setVisible(true);
	}
}
