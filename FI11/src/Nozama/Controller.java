package Nozama;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


import javax.swing.DefaultListModel;

import PizzaNeu.Bestellung;
import PizzaNeu.Groesse;
import PizzaNeu.Pizza;

public class Controller
{
	private GuiNozama gui; 
	private DefaultListModel<Artikel> artikelListe = new DefaultListModel<>();
	private DefaultListModel<Artikel> warenListe = new DefaultListModel<>();
	private double gesamtpreis = 0;
	
	public Controller()
	{
		gui = new GuiNozama();
		gui.getListArtikel().setModel(artikelListe);
		gui.getListArtikel_1().setModel(warenListe);
		ActionListener hinzu;
		ActionListener wegnehmen;
		ActionListener drucken;
		LeseDatei();
		
		hinzu = new ActionListener() 
		{

			@Override
			public void actionPerformed(ActionEvent e) 
			{
				warenListe.addElement((Artikel)gui.getListArtikel().getSelectedValue());
				Artikel a = (Artikel)gui.getListArtikel().getSelectedValue();
				artikelListe.removeElement((Artikel)gui.getListArtikel().getSelectedValue());
				gesamtpreis = gesamtpreis + a.getPreis();
			}
			
		};
		gui.getBtnWarenHinzu().addActionListener(hinzu);
		
		wegnehmen = new ActionListener() 
		{

			@Override
			public void actionPerformed(ActionEvent e) 
			{
				artikelListe.addElement((Artikel)gui.getListArtikel_1().getSelectedValue());
				Artikel a = (Artikel)gui.getListArtikel().getSelectedValue();
				warenListe.removeElement((Artikel)gui.getListArtikel_1().getSelectedValue());		
				gesamtpreis = gesamtpreis - a.getPreis();
			}
			
		};
		gui.getBtnWarenWeg().addActionListener(wegnehmen);
		
		drucken = new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				SchreibeDatei();
			}
		};
		gui.getBtnBestellung().addActionListener(drucken);
	}

	
	
	public void LeseDatei()
	{
		try
		{
			String zeile = null;
			BufferedReader in = Files.newBufferedReader(Paths.get("ArtikelListe.txt"));	
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
	
	public void SchreibeDatei()
	{
		try
		{
			BufferedWriter out = Files.newBufferedWriter(Paths.get("RechnungWarenkorb.txt"));
			try
			{
				out.write("Ihre Rechnung:\n\n");
				out.write("Herr " + gui.getTextKundenname().getText() + "\n\n");
				for(int i=0;i<warenListe.size();i++)
				{
					out.write(warenListe.getElementAt(i).toString()+"\n");
				}
				out.write("\n");
				out.write("Ihr Gesamtpreis"+" "+String.format("%.2f", gesamtpreis)+"€");
			}
			catch(IOException ex)
			{
				
			}
			finally
			{
				out.close();
			}
		}
		catch(Exception e)
		{
			
		}
	}
}
