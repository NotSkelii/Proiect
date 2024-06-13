import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FereastraEvaluator extends JFrame implements ActionListener {

	JButton butonEval;
	Container container;

	public FereastraEvaluator() {
		this.setTitle("Optiuni Evaluator");
		container = getContentPane();
		container.setLayout(null);
		
		butonEval = new JButton("Evalueaza probleme");
		butonEval.setFont(new Font("Arial", Font.BOLD, 15));
		butonEval.setSize(300,150);
		butonEval.setLocation(50,50);
		butonEval.addActionListener(this);
		container.add(butonEval);
		
		
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == butonEval) {
			evalueazaProbleme();
		} 

	}

	private void evalueazaProbleme() {
		try {
			BufferedReader br = new BufferedReader(new FileReader("CereriRep.txt"));
			BufferedWriter bw = new BufferedWriter(new FileWriter("CosturiReparatii.txt", true));
			String line;
			StringBuffer sb = new StringBuffer();

			while ((line = br.readLine()) != null) {
				String[] words = line.split("#");
				for (String word : words) {
					sb.append(word + " ");
				}
				sb.append("\n");
			}
			System.out.println("Lista reparatii:\n" + sb.toString());
			deschideFormular();
			br.close();
			bw.close();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(this, "Eroare");
		}
	}

	private void deschideFormular() {
		var f = new FormularReparatii();
		f.setBounds(700, 90, 400, 350);
		f.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		f.setResizable(false);
		f.setVisible(true);
	}

}
