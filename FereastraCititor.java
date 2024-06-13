import javax.swing.*;
import java.util.Random;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FereastraCititor extends JFrame implements ActionListener {

	JButton butonContor, butonLista;
	JPanel panel;

	public FereastraCititor() {
		this.setTitle("Optiuni Cititor");

		butonContor = new JButton("Introdu date contor");
		butonLista = new JButton("Printeaza cheltuieli");

		butonContor.addActionListener(this);
		butonLista.addActionListener(this);

		butonContor.setFont(new Font("Arial", Font.BOLD, 15));
		butonLista.setFont(new Font("Arial", Font.BOLD, 15));

		panel = new JPanel(new GridLayout(2, 0));

		panel.add(butonContor);
		panel.add(butonLista);

		this.add(panel);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == butonContor) {
			calculeazaCosturi();
		} else if (e.getSource() == butonLista) {
			printeazaLista();
		}

	}

	private void printeazaLista() {
		StringBuffer sb = new StringBuffer();
		try {
			BufferedReader br = new BufferedReader(new FileReader("Costuri.txt"));
			String line;
			while ((line = br.readLine()) != null) {
				String[] words = line.split("#");
				sb.append(words[0]).append(": ");
				sb.append(words[1]).append(words[2]);
				sb.append("\n");
			}
			br.close();
			JOptionPane.showMessageDialog(this, sb.toString());
		} catch (IOException e) {
			JOptionPane.showMessageDialog(this, "Eroare");
		}

	}

	private void calculeazaCosturi() {

		try {
			BufferedReader br = new BufferedReader(new FileReader("Indexuri.txt"));
			BufferedWriter bw = new BufferedWriter(new FileWriter("Costuri.txt"));
			String line;
			while ((line = br.readLine()) != null) {
				String[] words = line.split("#");
				bw.write(words[0] + "#");
				int apaCalda = Integer.parseInt(words[2]);
				int apaRece = Integer.parseInt(words[4]);
				int cheltuieli = new Random().nextInt(120) + 10;
				int cheltuileiTotale = apaCalda + apaRece + cheltuieli;
				bw.write(cheltuileiTotale + "#");
				bw.write("RON#");
				bw.write("\n");
			}
			bw.close();
			br.close();
			JOptionPane.showMessageDialog(this, "Facturi calculate cu succes");
		} catch (IOException e) {
			JOptionPane.showMessageDialog(this, "Eroare");
		}
	}

}
