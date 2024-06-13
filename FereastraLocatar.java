import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FereastraLocatar extends JFrame implements ActionListener {

	JButton butonIndex, butonAchitare, butonSolicitaFact, butonSolicitaRep;
	JPanel panel;
	String nume;

	FereastraLocatar(String currentName) {
		this.setTitle("Optiuni Locatar");
		this.nume = currentName;

		butonIndex = new JButton("Adauga Index");
		butonSolicitaFact = new JButton("Solicita Factura");
		butonAchitare = new JButton("Achita factura");
		butonSolicitaRep = new JButton("Solicita reparatii");

		butonIndex.addActionListener(this);
		butonSolicitaFact.addActionListener(this);
		butonAchitare.addActionListener(this);
		butonSolicitaRep.addActionListener(this);

		butonIndex.setFont(new Font("Arial", Font.BOLD, 15));
		butonSolicitaFact.setFont(new Font("Arial", Font.BOLD, 15));
		butonAchitare.setFont(new Font("Arial", Font.BOLD, 15));
		butonSolicitaRep.setFont(new Font("Arial", Font.BOLD, 15));

		panel = new JPanel(new GridLayout(4, 0));
		panel.add(butonIndex);
		panel.add(butonSolicitaFact);
		panel.add(butonAchitare);
		panel.add(butonSolicitaRep);

		this.add(panel);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == butonIndex) {
			deschideAdaugaIndex();
		} else if (e.getSource() == butonSolicitaFact) {
			afiseazaFactura();
		} else if (e.getSource() == butonAchitare) {
			achitaFactura();
		} else if (e.getSource() == butonSolicitaRep) {
			deschideSolicitaRep();
		}

	}

	private void deschideSolicitaRep() {
		var SR = new SolicitaReparatii();
		SR.setBounds(700, 90, 400, 450);
		SR.setDefaultCloseOperation(HIDE_ON_CLOSE);
		SR.setResizable(false);
		SR.setVisible(true);

	}

	private void achitaFactura() {

		try {
			var bw = new BufferedWriter(new FileWriter("Facturi.txt", true));
			bw.write(nume + "#");
			bw.write("Achitat#");
			bw.write("\n");
			bw.close();
			JOptionPane.showMessageDialog(this, "Achitare reusita");

		} catch (IOException e) {
			JOptionPane.showMessageDialog(this, "Achitare esuata");
		}
	}

	private void afiseazaFactura() {
		try {
			BufferedReader br = new BufferedReader(new FileReader("Costuri.txt"));
			String line;
			while((line = br.readLine()) != null) {
				String[] words = line.split("#");
				if(words[0].contains(this.nume)) {
					JOptionPane.showMessageDialog(this, "Aveti de achitat " + words[1] + "RON");
				}
			}
			
			br.close();
		}catch(IOException e) {
			JOptionPane.showMessageDialog(this, "Eroare");
		}
	}

	private void deschideAdaugaIndex() {
		var adaugaIndex = new AdaugaIndex();
		adaugaIndex.setBounds(700, 90, 400, 300);
		adaugaIndex.setDefaultCloseOperation(HIDE_ON_CLOSE);
		adaugaIndex.setResizable(false);
		adaugaIndex.setVisible(true);

	}

}
