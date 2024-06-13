import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class AdaugaIndex extends JFrame implements ActionListener {
	
	JLabel labelApaRece, labelApaCalda, labelNume;
	JTextField textApaRece, textApaCalda, numePers;
	JButton buton;
	Container container;
	
	public AdaugaIndex() {
		this.setName("Adauga Index");
		
		container = getContentPane();
		container.setLayout(null);
		
		labelApaRece = new JLabel("Apa rece: ");
		labelApaRece.setFont(new Font("Arial", Font.PLAIN, 15));
		labelApaRece.setSize(100, 20);
		labelApaRece.setLocation(50, 50);
		container.add(labelApaRece);
		
		textApaRece = new JTextField();
		textApaRece.setFont(new Font("Arial", Font.PLAIN, 15));
		textApaRece.setSize(190, 20);
		textApaRece.setLocation(150, 50);
		container.add(textApaRece);
		
		labelApaCalda = new JLabel("Apa calda: ");
		labelApaCalda.setFont(new Font("Arial", Font.PLAIN, 15));
		labelApaCalda.setSize(100, 20);
		labelApaCalda.setLocation(50,100);
		container.add(labelApaCalda);
		
		textApaCalda = new JTextField();
		textApaCalda.setFont(new Font("Arial", Font.PLAIN, 15));
		textApaCalda.setSize(190, 20);
		textApaCalda.setLocation(150,100);
		container.add(textApaCalda);
		
		labelNume = new JLabel("Nume: ");
		labelNume.setFont(new Font("Arial", Font.PLAIN, 15));
		labelNume.setSize(100, 20);
		labelNume.setLocation(50,150);
		container.add(labelNume);
		
		numePers = new JTextField();
		numePers.setFont(new Font("Arial", Font.PLAIN, 15));
		numePers.setSize(190, 20);
		numePers.setLocation(150,150);
		container.add(numePers);
		
		buton = new JButton("Adauga");
		buton.setFont(new Font("Arial", Font.PLAIN, 15));
		buton.setSize(100, 20);
		buton.setLocation(150,200);
		buton.addActionListener(this);
		container.add(buton);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	
		if(e.getSource() == buton) {
			adaugaIndex();
			dispose();
		}
	}

	private void adaugaIndex() {
		String indexApaCalda =textApaCalda.getText();
		String indexApaRece = textApaRece.getText();
		String nume = numePers.getText();
		
		
		
		try {
			var fw = new FileWriter("Indexuri.txt", true);
			fw.write(nume + "#");
			fw.write("Apa calda#"+ indexApaCalda + "#");
			fw.write("Apa rece#" + indexApaRece + "#");
			fw.write('\n');
			fw.close();
			JOptionPane.showMessageDialog(this, "Index adaugat cu succes");
		} catch(IOException e) {
			e.printStackTrace();
		}
		
	}

}
