package Nozama;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JTextField;

public class GuiNozama
{

	private JFrame frame;
	private JLabel lblWarenkorb;
	private JList listArtikel;
	private JButton btnWarenHinzu;
	private JButton btnWarenWeg;
	private JList listArtikel_1;
	private JTextField textKundenname;
	private JLabel lblNewLabel;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					GuiNozama window = new GuiNozama();
					window.frame.setVisible(true);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GuiNozama()
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{
		frame = new JFrame();
		frame.setBounds(100, 100, 481, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getLblWarenkorb());
		frame.getContentPane().add(getListArtikel());
		frame.getContentPane().add(getBtnWarenHinzu());
		frame.getContentPane().add(getBtnWarenWeg());
		frame.getContentPane().add(getListArtikel_1());
		frame.getContentPane().add(getTextKundenname());
		frame.getContentPane().add(getLblNewLabel());
		frame.getContentPane().add(getBtnNewButton());
	}
	private JLabel getLblWarenkorb() {
		if (lblWarenkorb == null) {
			lblWarenkorb = new JLabel("Warenkorb");
			lblWarenkorb.setBounds(288, 47, 98, 14);
		}
		return lblWarenkorb;
	}
	private JList getListArtikel() {
		if (listArtikel == null) {
			listArtikel = new JList();
			listArtikel.setBounds(39, 79, 138, 131);
		}
		return listArtikel;
	}
	private JButton getBtnWarenHinzu() {
		if (btnWarenHinzu == null) {
			btnWarenHinzu = new JButton(">");
			btnWarenHinzu.setBounds(187, 98, 89, 23);
		}
		return btnWarenHinzu;
	}
	private JButton getBtnWarenWeg() {
		if (btnWarenWeg == null) {
			btnWarenWeg = new JButton("<");
			btnWarenWeg.setBounds(187, 148, 89, 23);
		}
		return btnWarenWeg;
	}
	private JList getListArtikel_1() {
		if (listArtikel_1 == null) {
			listArtikel_1 = new JList();
			listArtikel_1.setBounds(286, 79, 138, 131);
		}
		return listArtikel_1;
	}
	private JTextField getTextKundenname() {
		if (textKundenname == null) {
			textKundenname = new JTextField();
			textKundenname.setBounds(120, 221, 156, 20);
			textKundenname.setColumns(10);
		}
		return textKundenname;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Kundenname:");
			lblNewLabel.setBounds(49, 224, 72, 14);
		}
		return lblNewLabel;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("Bestellung abschicken");
			btnNewButton.setBounds(286, 221, 138, 23);
		}
		return btnNewButton;
	}
}
