import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Ramka extends JFrame implements ActionListener {

	public JPanel dolnyPanel = new JPanel();
	
	public JTextField promien = new JTextField();
	public JLabel promien_podpis = new JLabel("Promieñ podstawy");
	
	public JTextField bok = new JTextField();
	public JLabel bok_podpis = new JLabel("Bok przekroju osiowego");
	
	public JTextField pole_powierzchni_bocznej = new JTextField();
	public JLabel pole_powierzchni_bocznej_podpis = new JLabel("Pole powierzchni bocznej");
	
	public JTextField pole_powierzchni_calkowitej = new JTextField();
	public JLabel pole_powierzchni_calkowitej_podpis = new JLabel("Pole powierzchni ca³kowitej");
	
	public JTextField objetosc = new JTextField();
	public JLabel objetosc_podpis = new JLabel("Objêtoœæ");
	
	public JButton dane = new JButton("Podaj dane!");
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(dane.equals(e.getSource())) {
			podajDane();
		}
		
	}

	private void podajDane() {
		try {
		
		String wysokoscStozka = JOptionPane.showInputDialog(null, "Podaj wysokoœæ sto¿ka!", "Wysokoœæ sto¿ka", JOptionPane.OK_CANCEL_OPTION);
		String podstawaStozka = JOptionPane.showInputDialog(null, "Podaj pole podstawy sto¿ka!", "Pole sto¿ka", JOptionPane.OK_CANCEL_OPTION);
		
		double podanaWysokosc = Double.parseDouble(wysokoscStozka);
		double podanaPodstawa = Double.parseDouble(podstawaStozka);
		
		double promienPodany = Math.sqrt(podanaPodstawa/Math.PI);
		promien.setText(String.valueOf(promienPodany));
		
		double bokPrzekroju = Math.sqrt(Math.pow(promienPodany, 2) + Math.pow(podanaWysokosc, 2));
		bok.setText(String.valueOf(bokPrzekroju));
		
		double poleBoczne = Math.PI*bokPrzekroju*promienPodany;
		pole_powierzchni_bocznej.setText(String.valueOf(poleBoczne));
		
		double poleCalkowite = poleBoczne+podanaPodstawa;
		pole_powierzchni_calkowitej.setText(String.valueOf(poleCalkowite));
		
		double podanaObjetosc = (podanaPodstawa * podanaWysokosc)/3;
		objetosc.setText(String.valueOf(podanaObjetosc));
		} catch (Exception e1) {
			JOptionPane.showConfirmDialog(null, "Wprowadz poprawn¹ wartoœæ!", "MESSAGE", JOptionPane.CANCEL_OPTION);
			
		}
	}

	public void initUI() {
		this.setLayout(new BorderLayout());
		this.setTitle("Kalkulator wymiarów sto¿ka");
		this.setSize(440, 230);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		dolnyPanel.setLayout(new GridLayout(5, 1));
		this.add(dolnyPanel, BorderLayout.SOUTH);
		
		this.add(dane);
		dane.addActionListener(this);
		
		dolnyPanel.add(promien_podpis);
		dolnyPanel.add(promien);
		promien.setColumns(20);
		
		dolnyPanel.add(bok_podpis);
		dolnyPanel.add(bok);
		promien.setColumns(20);
		
		dolnyPanel.add(pole_powierzchni_bocznej_podpis);
		dolnyPanel.add(pole_powierzchni_bocznej);
		promien.setColumns(20);
		
		dolnyPanel.add(pole_powierzchni_calkowitej_podpis);
		dolnyPanel.add(pole_powierzchni_calkowitej);
		promien.setColumns(20);
		
		dolnyPanel.add(objetosc_podpis);
		dolnyPanel.add(objetosc);
		promien.setColumns(20);
		
		promien.setEditable(false);
		bok.setEditable(false);
		pole_powierzchni_bocznej.setEditable(false);
		pole_powierzchni_calkowitej.setEditable(false);
		objetosc.setEditable(false);
		
		
	}

}
