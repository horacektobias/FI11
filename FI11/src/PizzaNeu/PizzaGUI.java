package PizzaNeu;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JScrollBar;

public class PizzaGUI extends JFrame {

	private JPanel contentPane;
	private JLabel lblPizza;
	private JLabel lblExtras;
	private JTextField textExtras;
	private JLabel lblGroesse;
	private JComboBox comboBoxPizza;
	private JComboBox comboBoxGroesse;
	private JButton btnHinzu;
	private JButton btnEntfernen;
	private JLabel lblPreis;
	public JTextField textPreis;
	private JButton btnDrucken;
	private JButton btnNewButton;
	private JTextField textAnzahl;
	private Controller controller;
	private Pizza pizza;
	private JScrollPane scrollPane;
	private JList list;
	/**
	 * Launch the application.
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PizzaGUI frame = new PizzaGUI();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	 * Create the frame.
	 */
	public PizzaGUI() 
	{	
		initialize();			
	}
	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 528, 387);
		contentPane = new JPanel();
		contentPane.setVisible(true);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblPizza());
		contentPane.add(getLblExtras());
		contentPane.add(getTextExtras());
		contentPane.add(getLblGroesse());
		contentPane.add(getComboBoxPizza());
		contentPane.add(getComboBoxGroesse());
		contentPane.add(getBtnHinzu());
		contentPane.add(getBtnEntfernen());
		contentPane.add(getLblPreis());
		contentPane.add(getTextPreis());
		contentPane.add(getBtnDrucken());
		contentPane.add(getBtnNewButton());
		contentPane.add(getTextAnzahl());
		contentPane.add(getScrollPane());
		this.setVisible(true);
	}
	private JLabel getLblPizza() {
		if (lblPizza == null) {
			lblPizza = new JLabel("Pizza:");
			lblPizza.setBounds(27, 24, 46, 14);
		}
		return lblPizza;
	}
	protected JLabel getLblExtras() {
		if (lblExtras == null) {
			lblExtras = new JLabel("Extras:");
			lblExtras.setBounds(27, 49, 46, 14);
		}
		return lblExtras;
	}
	protected JTextField getTextExtras() {
		if (textExtras == null) {
			textExtras = new JTextField();
			textExtras.setBounds(118, 46, 194, 20);
			textExtras.setColumns(10);
		}
		return textExtras;
	}
	private JLabel getLblGroesse() {
		if (lblGroesse == null) {
			lblGroesse = new JLabel("Gr\u00F6\u00DFe:");
			lblGroesse.setBounds(322, 24, 46, 14);
		}
		return lblGroesse;
	}
		
	protected JComboBox getComboBoxPizza() {
		if (comboBoxPizza == null) {
			comboBoxPizza = new JComboBox();
			comboBoxPizza.setBounds(118, 20, 194, 22);
			
			
		}
		
		return comboBoxPizza;
	}
	protected JComboBox getComboBoxGroesse() {
		if (comboBoxGroesse == null) {
			comboBoxGroesse = new JComboBox();
			comboBoxGroesse.setBounds(394, 20, 89, 22);
			
		}
		return comboBoxGroesse;
	}
	protected JButton getBtnHinzu() {
		if (btnHinzu == null) 
		{
			btnHinzu = new JButton("Hinzuf\u00FCgen");
			btnHinzu.setBounds(394, 84, 89, 23);
		}
		return btnHinzu;
	}
	protected JButton getBtnEntfernen() {
		if (btnEntfernen == null) {
			btnEntfernen = new JButton("Entfernen");
			btnEntfernen.setBounds(394, 118, 89, 23);
		}
		return btnEntfernen;
	}
	private JLabel getLblPreis() {
		if (lblPreis == null) {
			lblPreis = new JLabel("Gesamtpreis:");
			lblPreis.setBounds(28, 292, 80, 14);
		}
		return lblPreis;
	}
	public void setTextPreis(JTextField textPreis) 
	{
		this.textPreis = textPreis;
	}
	protected JTextField getTextPreis() {
		if (textPreis == null) {
			textPreis = new JTextField();
			textPreis.setBounds(118, 289, 136, 20);
			textPreis.setColumns(10);
		}
		return textPreis;
	}
	public JButton getBtnDrucken() {
		if (btnDrucken == null) {
			btnDrucken = new JButton("Drucken");
			btnDrucken.setBounds(267, 288, 101, 23);
		}
		return btnDrucken;
	}
	public JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("Hardcopy");
			btnNewButton.setBounds(374, 288, 109, 23);
		}
		return btnNewButton;
	}
	public JTextField getTextAnzahl() {
		if (textAnzahl == null) {
			textAnzahl = new JTextField();
			textAnzahl.setBounds(394, 46, 89, 20);
			textAnzahl.setColumns(10);
		}
		return textAnzahl;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(27, 84, 354, 179);
			scrollPane.setViewportView(getList());
			scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		}
		return scrollPane;
	}
	protected JList getList() {
		if (list == null) {
			list = new JList();
			list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		}
		return list;
	}
}
