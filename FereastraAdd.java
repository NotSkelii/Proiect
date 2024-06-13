import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.*;

public class FereastraAdd extends JFrame implements ActionListener{
	
	JButton buton;
	JComboBox<String> optiuni;
	JPanel panel;
	JLabel label;
	
	FereastraAdd() {
		this.setTitle("Adauga utilizator");
		
		panel = new JPanel();
		panel.setLayout(new GridLayout(1, 2, 10, 10));
		
		label = new JLabel("Tip utilizator");
		label.setFont(new Font("Arial", Font.PLAIN, 15));
		
		panel.add(label);
		
		optiuni = new JComboBox<String>(new String[] {"Admin", "Locatar", "Angajat"});
		optiuni.setFont(new Font("Arial", Font.PLAIN, 15));
		optiuni.addActionListener(this);
		
		panel.add(optiuni);
		
		this.add(panel,BorderLayout.CENTER);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String s = (String)optiuni.getSelectedItem();
		
		if(s == "Admin") {
			deseneazaSignUpAdmin();
			dispose();
		}
		else if(s =="Locatar"){
			deseneazaSignUpLocatar();
			dispose();
		}
		else {
			deseneazaSignUpAngajat();
			dispose();
		}
	}
	
	private void deseneazaSignUpAdmin() {
		var aa = new AdaugaAdmin();
		aa.setBounds(700, 90, 400, 300);
		aa.setDefaultCloseOperation(HIDE_ON_CLOSE);
	    aa.setResizable(false);
		aa.setVisible(true);
	}

	private void deseneazaSignUpAngajat() {
		var aa = new AdaugaAngajat();
		aa.setBounds(700, 90, 400, 500);
		aa.setDefaultCloseOperation(HIDE_ON_CLOSE);
	    aa.setResizable(false);
		aa.setVisible(true);		
	}

	private void deseneazaSignUpLocatar() {
		var aa = new AdaugaLocatar();
		aa.setBounds(700, 90, 800, 450);
		aa.setDefaultCloseOperation(HIDE_ON_CLOSE);
	    aa.setResizable(false);
		aa.setVisible(true);		
	}

}
