import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AlegeriLocatar extends JFrame implements ActionListener{
	
	JButton buton_login, buton_signup;
	JPanel panel;
	
	AlegeriLocatar(){
		this.setTitle("Pagina login/sign-up locatar");
		
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
			deschideLoginLocatar();
			dispose();
		}
		else if(e.getSource() == buton_signup) {
			deschideSignUpLocatar();
			dispose();
		}
	}
	
	public void deschideLoginLocatar() {
		var loginLoc = new LoginLocatar();
		loginLoc.setBounds(300, 90, 400, 300);
		loginLoc.setDefaultCloseOperation(HIDE_ON_CLOSE);
		loginLoc.setResizable(false);
		loginLoc.setVisible(true);
	}
	public void deschideSignUpLocatar() {
		var aa = new SignUpLocatar();
		aa.setBounds(700, 90, 800, 450);
		aa.setDefaultCloseOperation(HIDE_ON_CLOSE);
	    aa.setResizable(false);
		aa.setVisible(true);		
	}
	
}