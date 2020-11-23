package Nozama;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;

import javax.swing.DefaultListModel;

import PizzaNeu.Bestellung;
import PizzaNeu.Groesse;
import PizzaNeu.Pizza;

public class Controller
{
	private GuiNozama gui; 
	private DefaultListModel<Artikel> artikelListe = new DefaultListModel<>();
	private DefaultListModel<Artikel> warenListe = new DefaultListModel<>();
	
	public Controller()
	{
		gui = new GuiNozama();
		gui.getListArtikel().setModel(artikelListe);
		gui.getListArtikel_1().setModel(warenListe);
		ActionListener hinzu;
		ActionListener wegnehmen;
		LeseDatei();
		
		hinzu = new ActionListener() 
		{

			@Override
			public void actionPerformed(ActionEvent e) 
			{
				warenListe.addElement((Artikel)gui.getListArtikel().getSelectedValue());
				artikelListe.removeElement((Artikel)gui.getListArtikel().getSelectedValue());
			}
			
		};
		gui.getBtnWarenHinzu().addActionListener(hinzu);
		
		wegnehmen = new ActionListener() 
		{

			@Override
			public void actionPerformed(ActionEvent e) 
			{
				artikelListe.addElement((Artikel)gui.getListArtikel_1().getSelectedValue());
				warenListe.removeElement((Artikel)gui.getListArtikel_1().getSelectedValue());
			}
			
		};
		gui.getBtnWarenWeg().addActionListener(wegnehmen);
	}

	
	
	public void LeseDatei()
	{
		try
		{
			String zeile = null;
			BufferedReader in = new BufferedReader(new FileReader("ArtikelListe.txt"));	
			try
			{
				while ((zeile = in.readLine()) != null)
				{
					String[] values = zeile.split(";");
					Artikel art = new Artikel(values[0],values[1],Double.parseDouble(values[2]));
					artikelListe.addElement(art);
				}
			}
			catch(Exception IO)
			{
				
			}
			finally 
			{
				in.close();
			}
			
		}
		catch(Exception e)
		{
			
		}
		
	}
}
