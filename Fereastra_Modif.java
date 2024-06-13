import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Fereastra_Modif extends JFrame implements ActionListener {

	JLabel cautaPersoana;
	JTextField numePersoana;
	JButton buton;
	JPanel panel;
	StringBuffer numeLocatari, numeAngajati;

	public Fereastra_Modif() {
		this.setTitle("Modificare date");
		this.numeLocatari = new StringBuffer();
		this.numeAngajati = new StringBuffer();

		cautaPersoana = new JLabel("Introduceti numele");
		cautaPersoana.setFont(new Font("Arial", Font.BOLD, 15));

		numePersoana = new JTextField(10);
		numePersoana.setFont(new Font("Arial", Font.BOLD, 15));

		panel = new JPanel();
		panel.add(cautaPersoana);
		panel.add(numePersoana);

		buton = new JButton("Cauta");
		buton.setFont(new Font("Arial", Font.BOLD, 15));
		buton.addActionListener(this);

		this.add(panel, BorderLayout.NORTH);
		this.add(buton, BorderLayout.SOUTH);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == buton) {
			cautaNumeLocatar();
			cautaNumeAngajat();
			deschideAlegePersoana(numeLocatari, numeAngajati);
		}

	}

	public void cautaNumeLocatar() {
		String nume = numePersoana.getText();
		String line;

		try {
			var br = new BufferedReader(new FileReader("DateLocatar.txt"));
			while ((line = br.readLine()) != null) {
				String[] words = line.split("#");
				if (words[3].contains(nume)) {
					for (String word : words) {
						numeLocatari.append(word + " ");
					}
					System.out.println("Locatar: ");
					for (int i = 0; i < words.length; i++) {
						System.out.print(words[i] + " ");
					}
					System.out.println();
					numeLocatari.append("\n");
				}
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void cautaNumeAngajat() {
		String nume = numePersoana.getText();
		String line;

		try {
			var br = new BufferedReader(new FileReader("DateAngajat.txt"));
			while ((line = br.readLine()) != null) {
				String[] words = line.split("#");
				if (words[3].contains(nume)) {
					for (String word : words) {
						numeAngajati.append(word + " ");
					}
					System.out.print("Angajat: ");
					for (int i = 0; i < words.length; i++) {
						System.out.print(words[i] + " ");
					}
					System.out.println();
					numeAngajati.append("\n");
				}
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void deschideAlegePersoana(StringBuffer numeL, StringBuffer numeA) {
		var alegePers = new AlegePersoanaModif(numeL, numeA);
		alegePers.setBounds(700, 190, 1000, 300);
		alegePers.setDefaultCloseOperation(HIDE_ON_CLOSE);
		alegePers.setResizable(false);
		alegePers.setVisible(true);

	}

}
