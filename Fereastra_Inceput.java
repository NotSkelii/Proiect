import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Fereastra_Inceput extends JFrame implements ActionListener {
	
	JButton buton_admin, buton_locatar, buton_angajat;
	JPanel panel_titlu,panel_butoane;
	JLabel label;
	
	Fereastra_Inceput(){
		super("Fereastra de inceput");
		
		label = new JLabel("Selectati persoana");
		label.setFont(new Font("Arial", Font.BOLD, 15));
		
		panel_titlu = new JPanel();
		panel_titlu.add(label);
		
		buton_admin = new JButton("Administrator");
		buton_locatar = new JButton("Locatar");
		buton_angajat = new JButton("Angajat");
		
		buton_admin.setFocusable(false);
		buton_locatar.setFocusable(false);
		buton_angajat.setFocusable(false);
		
		buton_admin.addActionListener(this);
		buton_locatar.addActionListener(this);
		buton_angajat.addActionListener(this);
		
		buton_admin.setFont(new Font("Arial", Font.PLAIN, 15));
		buton_locatar.setFont(new Font("Arial", Font.PLAIN, 15));
		buton_angajat.setFont(new Font("Arial", Font.PLAIN, 15));
		
		panel_butoane = new JPanel();
		panel_butoane.add(buton_admin);
		panel_butoane.add(buton_locatar);
		panel_butoane.add(buton_angajat);
		
		this.add(panel_titlu, BorderLayout.NORTH);
		this.add(panel_butoane, BorderLayout.CENTER);
	}	

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == buton_admin) {
			deschideAlegeriAdmin();
		}
		else if(e.getSource() == buton_locatar) {
			deschideAlegeriLocatar();
		}
		else if(e.getSource() == buton_angajat) {
			deschideAlegeriAngajat();
		}
	}
	
	public void deschideAlegeriAngajat() {
		var f = new AlegeriAngajat();
		  f.setBounds(800, 400, 300, 150);
		  f.setResizable(false);
		  f.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		  f.setVisible(true);
	}

	public void deschideAlegeriLocatar() {
		var f = new AlegeriLocatar();
		  f.setBounds(800, 400, 300, 150);
		  f.setResizable(false);
		  f.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		  f.setVisible(true);
	}

	public void deschideAlegeriAdmin() {
		var f = new Administrator();
		  f.setBounds(800, 400, 300, 150);
		  f.setResizable(false);
		  f.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		  f.setVisible(true);
	}
	
	
}
