import java.awt.event.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.*;
import javax.swing.*;

public class AlegePersoanaSters extends JFrame implements ActionListener {

	JLabel label, label2;
	JComboBox<String> persoane;
	JComboBox<String> tipPersoana;
	ArrayList<String> lista;
	JPanel panel;
	JButton buton;
	StringBuffer numeLocatari, numeAngajati;
	String curent;

	AlegePersoanaSters(StringBuffer numeL, StringBuffer numeA) {
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

		buton = new JButton("Sterge");
		buton.setFont(new Font("Arial", Font.BOLD, 15));
		buton.addActionListener(this);

		this.add(panel);
		this.add(buton, BorderLayout.SOUTH);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (tipPersoana != null) {
			var selected = (String) (tipPersoana.getSelectedItem());
			this.curent = (String) (persoane.getSelectedItem());

			if (e.getSource() == buton && selected == "Locatar") {
				stergeDateLocatar();
				dispose();
			} else if (e.getSource() == buton && selected == "Angajat") {
				stergeDateAngajat();
				dispose();
			}
		}
	}

	private void stergeDateLocatar() {

		var sb = new StringBuffer();
		String[] cuvinteNume = curent.split("\\s+");

		for (String word : cuvinteNume) {
			sb.append(word).append("#");
		}
		sb.deleteCharAt(sb.length() - 1);

		var sb1 = new StringBuilder();

		BufferedReader br = null;
		BufferedWriter bw = null;
		try {
			br = new BufferedReader(new FileReader("DateLocatar.txt"));
			String line;
			while ((line = br.readLine()) != null) {
				if (!line.equals(sb.toString())) {
					sb1.append(line).append("\n");
				}
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			bw = new BufferedWriter(new FileWriter("DateLocatar.txt"));
			bw.write(sb1.toString());
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		JOptionPane.showMessageDialog(null, "Locatar sters cu succes");
	}

	private void stergeDateAngajat() {

		var sb = new StringBuffer();
		String[] cuvinteNume = curent.split("\\s+");

		for (String word : cuvinteNume) {
			sb.append(word).append("#");
		}
		sb.deleteCharAt(sb.length() - 1);

		var sb1 = new StringBuilder();

		BufferedReader br = null;
		BufferedWriter bw = null;
		try {
			br = new BufferedReader(new FileReader("DateAngajat.txt"));
			String line;
			while ((line = br.readLine()) != null) {
				if (!line.equals(sb.toString())) {
					sb1.append(line).append("\n");
				}
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			bw = new BufferedWriter(new FileWriter("DateAngajat.txt"));
			bw.write(sb1.toString());
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		JOptionPane.showMessageDialog(null, "Angajat sters cu succes");
	}

}
