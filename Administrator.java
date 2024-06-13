import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Administrator extends JFrame implements ActionListener{
	
	JButton buton_login, buton_signup;
	JPanel panel;
	
	Administrator(){
		this.setTitle("Pagina login/sign-up administrator");
		
		buton_login = new JButton("Log in");
		buton_signup = new JButton("Inregistrare");
		
		buton_login.setFont(new Font("Arial", Font.PLAIN, 15));
		buton_signup.setFont(new Font("Arial", Font.PLAIN, 15));
		
		buton_login.addActionListener(this);
		buton_signup.addActionListener(this);
		
		panel = new JPanel(new GridLayout(2,0));
		panel.add(buton_login);
		panel.add(buton_signup);
		
		this.add(panel);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == buton_login) {
			deschideLoginAdmin();
			dispose();
		}
		else if(e.getSource() == buton_signup) {
			deschideSignUpAdmin();
			dispose();
		}
	}
	
	public void deschideLoginAdmin() {
		LoginAdmin loginAdmin = new LoginAdmin();
		  loginAdmin.setBounds(300, 90, 400, 300);
		  loginAdmin.setDefaultCloseOperation(HIDE_ON_CLOSE);
		  loginAdmin.setResizable(false);
		  loginAdmin.setVisible(true);
	}
	public void deschideSignUpAdmin() {
		var signUpAdmin = new SignUpAdmin();
		  signUpAdmin.setBounds(300,90,400,300);
		  signUpAdmin.setDefaultCloseOperation(HIDE_ON_CLOSE);
		  signUpAdmin.setResizable(false);
		  signUpAdmin.setVisible(true);
	}
	
}