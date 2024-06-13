import javax.swing.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.awt.*;

public class FormularReparatii extends JFrame implements ActionListener {

	JLabel labelNume, labelTip, labelCI, labelCT;
	JTextField textNume, textTip, textCI, textCT;
	JButton buton;
	Container container;
	int costI, costF;

	public FormularReparatii() {
		this.setTitle("Formular Reparatii");

		container = getContentPane();
		container.setLayout(null);

		labelNume = new JLabel("Nume: ");
		labelNume.setFont(new Font("Arial", Font.PLAIN, 15));
		labelNume.setSize(100, 20);
		labelNume.setLocation(50, 50);
		container.add(labelNume);

		textNume = new JTextField();
		textNume.setFont(new Font("Arial", Font.PLAIN, 15));
		textNume.setSize(190, 20);
		textNume.setLocation(150, 50);
		container.add(textNume);

		labelTip = new JLabel("Tip problema: ");
		labelTip.setFont(new Font("Arial", Font.PLAIN, 15));
		labelTip.setSize(100, 20);
		labelTip.setLocation(50, 100);
		container.add(labelTip);

		textTip = new JTextField();
		textTip.setFont(new Font("Arial", Font.PLAIN, 15));
		textTip.setSize(190, 20);
		textTip.setLocation(150, 100);
		container.add(textTip);

		labelCI = new JLabel("Cost initial: ");
		labelCI.setFont(new Font("Arial", Font.PLAIN, 15));
		labelCI.setSize(100, 20);
		labelCI.setLocation(50, 150);
		container.add(labelCI);

		textCI = new JTextField();
		textCI.setFont(new Font("Arial", Font.PLAIN, 15));
		textCI.setSize(190, 20);
		textCI.setLocation(150, 150);
		container.add(textCI);

		labelCT = new JLabel("Cost total: ");
		labelCT.setFont(new Font("Arial", Font.PLAIN, 15));
		labelCT.setSize(100, 20);
		labelCT.setLocation(50, 200);
		container.add(labelCT);

		textCT = new JTextField();
		textCT.setFont(new Font("Arial", Font.PLAIN, 15));
		textCT.setSize(190, 20);
		textCT.setLocation(150, 200);
		container.add(textCT);

		buton = new JButton("Confirma");
		buton.setFont(new Font("Arial", Font.PLAIN, 15));
		buton.setSize(100, 20);
		buton.setLocation(150, 250);
		buton.addActionListener(this);
		container.add(buton);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == buton) {
			genereazaRaport();
		}
	}

	private void genereazaRaport() {
		int costInitial = Integer.parseInt(textCI.getText());
		int costTotal = Integer.parseInt(textCT.getText());

		setCostInitial(costInitial);
		setCostFinal(costTotal);

		int rez = JOptionPane.showConfirmDialog(this,
				"Costul initial de reparatii este: " + costInitial + "\nCostul total de reparatii este: " + costTotal,
				"Confirm", JOptionPane.OK_OPTION);
		System.out.println(
				"Costul initial de reparatii este: " + costInitial + "\nCostul total de reparatii este: " + costTotal);

		if (rez == JOptionPane.OK_OPTION) {
			deschideDistribuiri();
			dispose();
		}

	}

	private void deschideDistribuiri() {
		int nrPersScA = 0, nrPersScB = 0, nrPersScC = 0;
		int nrTotalPers = 0;
		int pretTotal = getCostTotal();
		int pretScara = 0;

		try {
			BufferedReader br = new BufferedReader(new FileReader("CereriRep.txt"));
			String line;
			while ((line = br.readLine()) != null) {
				String[] words = line.split("#");
				if (words[5].contains("A")) {
					nrPersScA++;
				} else if (words[5].contains("B")) {
					nrPersScB++;
				} else if (words[5].contains("C")) {
					nrPersScC++;
				}
			}
			nrTotalPers = nrPersScA + nrPersScB + nrPersScC;
			// System.out.println(nrTotalPers);
			pretScara = (int) (pretTotal / nrTotalPers);

			if (nrPersScA != 0 && nrPersScB != 0 && nrPersScC != 0) {
				JOptionPane.showMessageDialog(this, "Fiecare scara are de plata " + pretScara + "RON");
			} else if (nrPersScA != 0 && nrPersScB != 0 && nrPersScC == 0) {
				JOptionPane.showMessageDialog(this, "Scarile A si B au de plata " + pretScara + "RON");
			} else if (nrPersScA != 0 && nrPersScB == 0 && nrPersScC != 0) {
				JOptionPane.showMessageDialog(this, "Scarile A si C au de plata  " + pretScara + "RON");
			} else if (nrPersScA == 0 && nrPersScB != 0 && nrPersScC != 0) {
				JOptionPane.showMessageDialog(this, "Scarile B si C au de plata " + pretScara + "RON");
			} else if (nrPersScA != 0 && nrPersScB == 0 && nrPersScC == 0) {
				JOptionPane.showMessageDialog(this, "Scara A are de plata " + pretScara + "RON");
			} else if (nrPersScA == 0 && nrPersScB != 0 && nrPersScC == 0) {
				JOptionPane.showMessageDialog(this, "Scara B are de plata " + pretScara + "RON");
			} else if (nrPersScA == 0 && nrPersScB == 0 && nrPersScC != 0) {
				JOptionPane.showMessageDialog(this, "Scara C are de plata " + pretScara + "RON");
			}

			br.close();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(this, "Eroare");
		}

	}

	private void setCostFinal(int costTotal) {
		this.costF = costTotal;
	}

	private void setCostInitial(int costInitial) {
		this.costI = costInitial;
	}

	private int getCostTotal() {
		return this.costF;
	}

}
