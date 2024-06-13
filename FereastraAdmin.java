import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FereastraAdmin extends JFrame implements ActionListener{
	
	JButton buton_modif, buton_sterge, buton_add;
	JPanel panel;
	
	FereastraAdmin(){
		this.setTitle("Optiuni Administrator");
		
		buton_add = new JButton("Introdu utilizator");
		buton_modif = new JButton("Modifica date utlizator"); //TO-DO (delete and rewrite)
		buton_sterge = new JButton("Sterge date utilizator"); // TO-DO
		
		buton_add.addActionListener(this);
		buton_modif.addActionListener(this);
		buton_sterge.addActionListener(this);
		
		buton_add.setFont(new Font("Arial", Font.BOLD, 15));
		buton_modif.setFont(new Font("Arial", Font.BOLD, 15));
		buton_sterge.setFont(new Font("Arial", Font.BOLD, 15));
		
		
		panel = new JPanel(new GridLayout(3,0));
		panel.add(buton_add);
		panel.add(buton_modif);
		panel.add(buton_sterge);
		
		this.add(panel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == buton_add) {
			deschideFereastraAdd();
		}
		else if(e.getSource() == buton_modif) {
			deschideFereastraModifica();
		}
		else {
			deschideFereastraSterge();
		}
		
	}
	
	public void deschideFereastraAdd() {
		var addUser = new FereastraAdd();
		  addUser.setBounds(700, 90, 400, 100);
		  addUser.setDefaultCloseOperation(HIDE_ON_CLOSE);
		  addUser.setResizable(false);
		  addUser.setVisible(true);
	}
	
	public void deschideFereastraModifica() {
		var modifUser = new Fereastra_Modif();
		modifUser.setBounds(700, 90, 400, 100);
		modifUser.setDefaultCloseOperation(HIDE_ON_CLOSE);
		modifUser.setResizable(false);
		modifUser.setVisible(true);
	}
	
	public void deschideFereastraSterge() {
		var delUser = new Fereastra_Sterge();
		delUser.setBounds(700, 90, 400, 100);
		delUser.setDefaultCloseOperation(HIDE_ON_CLOSE);
		delUser.setResizable(false);
		delUser.setVisible(true);
	}

}
