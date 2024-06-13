import java.awt.event.*;
import java.util.ArrayList;
import java.awt.*;
import javax.swing.*;

public class AlegePersoanaModif extends JFrame implements ActionListener {

	JLabel label, label2;
	JComboBox<String> persoane;
	JComboBox<String> tipPersoana;
	JPanel panel;
	JButton buton;
	StringBuffer numeLocatari, numeAngajati;

	AlegePersoanaModif(StringBuffer numeL, StringBuffer numeA) {
		this.setTitle("Alege persoana");
		this.numeLocatari = numeL;
		this.numeAngajati = numeA;

		label = new JLabel("Alegeti persoana din lista");
		label.setFont(new Font("Arial", Font.BOLD, 15));

		String[] numeLocatariArray = numeLocatari.toString().split("\\n");
		String[] numeAngajatiArray = numeAngajati.toString().split("\\n");

		persoane = new JComboBox<String>();
		persoane.setFont(new Font("Arial", Font.BOLD, 15));
		persoane.addActionListener(this);

		if (numeLocatariArray != null) {
			for (String nume : numeLocatariArray) {
				persoane.addItem(nume);
			}
		}
		if (numeAngajatiArray != null) {
			for (String nume : numeAngajatiArray) {
				persoane.addItem(nume);
			}
		}

		label2 = new JLabel("Tipul persoanei ");
		label2.setFont(new Font("Arial", Font.BOLD, 15));

		tipPersoana = new JComboBox<String>();
		tipPersoana.addItem("Locatar");
		tipPersoana.addItem("Angajat");
		tipPersoana.setFont(new Font("Arial", Font.BOLD, 15));
		tipPersoana.addActionListener(this);

		panel = new JPanel(new GridLayout(2, 2));
		panel.add(label);
		panel.add(persoane);
		panel.add(label2);
		panel.add(tipPersoana);

		buton = new JButton("Modifica");
		buton.setFont(new Font("Arial", Font.BOLD, 15));
		buton.addActionListener(this);

		this.add(panel);
		this.add(buton, BorderLayout.SOUTH);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (tipPersoana != null) {
			var selected = (String) (tipPersoana.getSelectedItem());
			var curent = (String) (persoane.getSelectedItem());

			if (e.getSource() == buton && selected == "Locatar") {
				deschideModificareDateLocatar(curent);
			} else if (e.getSource() == buton && selected == "Angajat") {
				deschideModificareDateAngajat(curent);
			}
		}
	}

	private void deschideModificareDateLocatar(String curent) {
		var aa = new ModificareDateLocatar(curent);
		aa.setBounds(700, 490, 800, 450);
		aa.setDefaultCloseOperation(HIDE_ON_CLOSE);
		aa.setResizable(false);
		aa.setVisible(true);

	}

	private void deschideModificareDateAngajat(String curent) {
		var aa = new ModificaDateAngajat(curent);
		aa.setBounds(700, 490, 400, 500);
		aa.setDefaultCloseOperation(HIDE_ON_CLOSE);
		aa.setResizable(false);
		aa.setVisible(true);

	}

}
