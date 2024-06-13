import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FereastraCasier extends JFrame implements ActionListener {

	JButton butonFacturi, butonRestantieri;
	JPanel panel;
	String[] names;

	public FereastraCasier() {
		this.setTitle("Optiuni Evaluator");

		butonFacturi = new JButton("Incaseaza facturi");
		butonRestantieri = new JButton("Stabileste restantieri");

		butonFacturi.addActionListener(this);
		butonRestantieri.addActionListener(this);

		butonFacturi.setFont(new Font("Arial", Font.BOLD, 15));
		butonRestantieri.setFont(new Font("Arial", Font.BOLD, 15));

		panel = new JPanel(new GridLayout(2, 0));

		panel.add(butonFacturi);
		panel.add(butonRestantieri);

		this.add(panel);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == butonFacturi) {
			stabilesteFacturiAchitate();
		} else if (e.getSource() == butonRestantieri) {
			stabilesteRestantieri();
		}

	}

	private void stabilesteRestantieri() {
		StringBuffer numeFacturi = new StringBuffer();
		try {
			BufferedReader br = new BufferedReader(new FileReader("Facturi.txt"));
			String line;
			while((line = br.readLine()) != null) {
				String[] words = line.split("#");
				numeFacturi.append(words[0]).append(" ");
			}
			br.close();
		}catch(IOException e) {
			JOptionPane.showMessageDialog(this, "Eroare");
		}
		String[] numeFacturiArray = numeFacturi.toString().split("\\+s");
		int numeFacturiLength = numeFacturiArray.length;
		
		StringBuffer sb = new StringBuffer();
		for(int i = 0 ; i < numeFacturiLength ; ++i) {
			try {
				BufferedReader br = new BufferedReader(new FileReader("DateLocatar.txt"));
				String line;
				while((line = br.readLine()) != null) {
					String[] words = line.split("#");
					if(!numeFacturi.toString().contains(words[3])) {
						sb.append(words[3]);
					}
				}
				JOptionPane.showMessageDialog(this, "Restantierii lunii sunt:\n" + sb.toString());
				br.close();
			}catch(IOException e) {
				JOptionPane.showMessageDialog(this, "Eroare");
			}
		}
	}

	private void stabilesteFacturiAchitate() {
		StringBuffer sb = new StringBuffer();
		try {
			BufferedReader br = new BufferedReader(new FileReader("Facturi.txt"));
			String line;
			while((line = br.readLine()) != null) {
				String[] words = line.split("#");
				String nume = words[0];
				sb.append(nume).append("\n");
			}
			JOptionPane.showMessageDialog(this, "Au achitat facturile:\n" + sb.toString());
			br.close();
		}catch(IOException e) {
			JOptionPane.showMessageDialog(this, "Eroare");
		}
	}

}
