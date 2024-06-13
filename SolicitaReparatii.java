import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.IOException;

public class SolicitaReparatii extends JFrame implements ActionListener {

	JLabel labelTip, labelData, labelNume, labelPrenume, labelBloc, labelScara;
	JTextField textDate, textNume, textPrenume, textBloc, textScara;
	JComboBox<String> textTip;
	JButton buton;
	Container container;

	public SolicitaReparatii() {
		this.setTitle("Cerere reparatii");

		container = getContentPane();
		container.setLayout(null);

		labelTip = new JLabel("Tip problema: ");
		labelTip.setFont(new Font("Arial", Font.PLAIN, 15));
		labelTip.setSize(100, 20);
		labelTip.setLocation(50, 50);
		container.add(labelTip);

		textTip = new JComboBox<String>(new String[] { "Acoperis", "Tevi", "Inundatie" });
		textTip.setFont(new Font("Arial", Font.PLAIN, 15));
		textTip.setSize(190, 20);
		textTip.setLocation(150, 50);
		container.add(textTip);

		labelData = new JLabel("Data sesizarii: ");
		labelData.setFont(new Font("Arial", Font.PLAIN, 15));
		labelData.setSize(100, 20);
		labelData.setLocation(50, 100);
		container.add(labelData);

		textDate = new JTextField();
		textDate.setFont(new Font("Arial", Font.PLAIN, 15));
		textDate.setSize(190, 20);
		textDate.setLocation(150, 100);
		container.add(textDate);

		labelNume = new JLabel("Nume: ");
		labelNume.setFont(new Font("Arial", Font.PLAIN, 15));
		labelNume.setSize(100, 20);
		labelNume.setLocation(50, 150);
		container.add(labelNume);

		textNume = new JTextField();
		textNume.setFont(new Font("Arial", Font.PLAIN, 15));
		textNume.setSize(190, 20);
		textNume.setLocation(150, 150);
		container.add(textNume);

		labelPrenume = new JLabel("Prenume: ");
		labelPrenume.setFont(new Font("Arial", Font.PLAIN, 15));
		labelPrenume.setSize(100, 20);
		labelPrenume.setLocation(50, 200);
		container.add(labelPrenume);

		textPrenume = new JTextField();
		textPrenume.setFont(new Font("Arial", Font.PLAIN, 15));
		textPrenume.setSize(190, 20);
		textPrenume.setLocation(150, 200);
		container.add(textPrenume);

		labelBloc = new JLabel("Bloc: ");
		labelBloc.setFont(new Font("Arial", Font.PLAIN, 15));
		labelBloc.setSize(100, 20);
		labelBloc.setLocation(50, 250);
		container.add(labelBloc);

		textBloc = new JTextField();
		textBloc.setFont(new Font("Arial", Font.PLAIN, 15));
		textBloc.setSize(190, 20);
		textBloc.setLocation(150, 250);
		container.add(textBloc);

		labelScara = new JLabel("Scara: ");
		labelScara.setFont(new Font("Arial", Font.PLAIN, 15));
		labelScara.setSize(100, 20);
		labelScara.setLocation(50, 300);
		container.add(labelScara);

		textScara = new JTextField();
		textScara.setFont(new Font("Arial", Font.PLAIN, 15));
		textScara.setSize(190, 20);
		textScara.setLocation(150, 300);
		container.add(textScara);

		buton = new JButton("Trimite");
		buton.setFont(new Font("Arial", Font.PLAIN, 15));
		buton.setSize(120, 30);
		buton.setLocation(130, 350);
		buton.addActionListener(this);
		container.add(buton);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == buton) {
			adaugaCerere();
			dispose();
		}

	}

	private void adaugaCerere() {
		String tip = (String) textTip.getSelectedItem();
		String data = textDate.getText();
		String nume = textNume.getText();
		String pren = textPrenume.getText();
		String bloc = textBloc.getText();
		String scara = textScara.getText();

		try {
			if (tip != null) {
				var fw = new FileWriter("CereriRep.txt", true);
				fw.write(tip + "#");
				fw.write(data + "#");
				fw.write(nume + "#");
				fw.write(pren + "#");
				fw.write(bloc + "#");
				fw.write(scara);
				fw.write("\n");
				fw.close();
				JOptionPane.showMessageDialog(this, "Cerere adaugata cu succes");
			}

		} catch (IOException e) {
			JOptionPane.showMessageDialog(this, "Adaugare esuata");
		}

	}

}
