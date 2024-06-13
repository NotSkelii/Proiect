import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AlegeriAngajat extends JFrame implements ActionListener {

	JButton buton_login, buton_signup;
	JPanel panel;

	AlegeriAngajat() {
		this.setTitle("Pagina login/sign-up locatar");

		buton_login = new JButton("Log in");
		buton_signup = new JButton("Inregistrare");

		buton_login.setFont(new Font("Arial", Font.PLAIN, 15));
		buton_signup.setFont(new Font("Arial", Font.PLAIN, 15));

		buton_login.addActionListener(this);
		buton_signup.addActionListener(this);

		panel = new JPanel(new GridLayout(2, 0));
		panel.add(buton_login);
		panel.add(buton_signup);

		this.add(panel);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == buton_login) {
			deschideLoginAngajat();
			dispose();
		} else if (e.getSource() == buton_signup) {
			deschideSignUpAngajat();
			dispose();
		}

	}

	private void deschideSignUpAngajat() {
		var aa = new SignUpAngajat();
		aa.setBounds(700, 90, 400, 500);
		aa.setDefaultCloseOperation(HIDE_ON_CLOSE);
		aa.setResizable(false);
		aa.setVisible(true);

	}

	private void deschideLoginAngajat() {
		var loginAng = new LoginAngajat();
		loginAng.setBounds(300, 90, 400, 300);
		loginAng.setDefaultCloseOperation(HIDE_ON_CLOSE);
		loginAng.setResizable(false);
		loginAng.setVisible(true);

	}

}
