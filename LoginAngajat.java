import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginAngajat extends JFrame implements ActionListener{

	JTextField username;
	JPasswordField parola;
	JLabel label_user, label_parola;
	JButton buton_login;
	Container container;
	BufferedReader br;

	
	LoginAngajat(){
		this.setTitle("Login Angajat");
		
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
		
		buton_login = new JButton("Login");
		buton_login.setFont(new Font("Arial", Font.PLAIN, 15));
		buton_login.setSize(100, 20);
		buton_login.setLocation(150,150);
		buton_login.addActionListener(this);
		container.add(buton_login);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == buton_login) {
			verificaDate();
			}
			
			
			//TO-DO
			//la apasarea butonului de Login, trebuie afisat un mesaj de eroare daca datele nu corecte(ex:
			//Contul nu exista/Datele introduse sunt incorecte si sa primeasca optiunea de sign-up
			//In caz contrar, daca datele sunt corecte, este redirectionat pe pagina cu optiuni de admin
		}

	public void verificaDate() {
		boolean ok = false;
		   
			String userText = username.getText();
			String passText = new String(parola.getPassword());
			String userStocat = " ";
			String passStocat = " ";
			String profesie = " ";
			try {
				br = new BufferedReader(new FileReader("DateAngajat.txt"));
				String line;
				while(br.ready() && ok == false) {
					line = br.readLine();
					String[] part = line.split("#");
					userStocat = part[0];
					passStocat = part[1];
					profesie = part[6];
					 if (userText.equals(userStocat) && passText.equals(passStocat)) {
						 ok = true;
						 break;
					 }
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			int optiune1 = 0;
			int optiune2 = 0;
			if(ok == false) {
			  optiune1 = JOptionPane.showConfirmDialog(null, "Login esuat. Incercati din nou?", "Fail Login", JOptionPane.YES_NO_OPTION);
			  if(optiune1 == JOptionPane.YES_OPTION) {
				  deschideLoginAngajat();
				  dispose();
				}
				else {
					optiune2 = JOptionPane.showConfirmDialog(null, "Doriti sa va inregistrati?", "Try sign-up", JOptionPane.YES_NO_OPTION);
					if(optiune2 == JOptionPane.YES_OPTION) {
						deschideSignUpAngajat();
						dispose();
					}
					else {
						System.exit(0);
					}
				}
			
			}
			else {
				verificaAngajat(profesie);
				dispose();
			}
				
	}

	private void verificaAngajat(String profesie) {
		
		if(profesie.equals("Casier")) {
			deschideFereastraCasier();
		} else if(profesie.equals("Evaluator")) {
			deschideFereastraEvaluator();
		} else if(profesie.equals("Cititor")) {
			deschideFereastraCititor();
		}
	}


	public void deschideLoginAngajat() {
		LoginAngajat loginAdmin = new LoginAngajat();
		  loginAdmin.setBounds(300, 90, 400, 300);
		  loginAdmin.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		  loginAdmin.setResizable(false);
		  loginAdmin.setVisible(true);
	}
	
	public void deschideSignUpAngajat() {
		var signUpAdmin = new SignUpAngajat();
		  signUpAdmin.setBounds(700, 90, 800, 450);
		  signUpAdmin.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		  signUpAdmin.setResizable(false);
		  signUpAdmin.setVisible(true);
	}
	
	public void deschideFereastraEvaluator() {
		var FA = new FereastraEvaluator();
		FA.setBounds(300, 90, 400, 300);
		FA.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		FA.setResizable(false);
		FA.setVisible(true);
	}
	
	public void deschideFereastraCasier() {
		var FA = new FereastraCasier();
		FA.setBounds(300, 90, 400, 300);
		FA.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		FA.setResizable(false);
		FA.setVisible(true);
	}
	
	public void deschideFereastraCititor() {
		var FA = new FereastraCititor();
		FA.setBounds(300, 90, 400, 300);
		FA.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		FA.setResizable(false);
		FA.setVisible(true);
	}
	
	
}
