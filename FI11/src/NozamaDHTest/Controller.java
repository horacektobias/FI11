package NozamaDHTest;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;


import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;

import PizzaNeu.Bestellung;
import PizzaNeu.Groesse;
import PizzaNeu.Pizza;

public class Controller
{
	private GuiNozama gui; 
	private DateiHandler dh = new DHNIO();
	private DefaultListModel<Artikel> artikelListe = new DefaultListModel<>();
	private DefaultListModel<Artikel> warenListe = new DefaultListModel<>();
	private double gesamtpreis = 0;
	private String filePfad;
	private String fileLesen = LadeDaten();
	
	public Controller()
	{
		gui = new GuiNozama();
		gui.getListArtikel().setModel(artikelListe);
		gui.getListArtikel_1().setModel(warenListe);
		ActionListener hinzu;
		ActionListener wegnehmen;
		ActionListener drucken;
		
		try
		{
			artikelListe = dh.lesen(fileLesen);
			System.out.println(artikelListe.getElementAt(1));
		} catch (IOException e1)
		{
			e1.printStackTrace();
		}
		
		hinzu = new ActionListener() 
		{

			@Override
			public void actionPerformed(ActionEvent e) 
			{
				/*
				warenListe.addElement((Artikel)gui.getListArtikel().getSelectedValue());
				Artikel a = (Artikel)gui.getListArtikel().getSelectedValue();
				artikelListe.removeElement((Artikel)gui.getListArtikel().getSelectedValue());
				gesamtpreis = gesamtpreis + a.getPreis();
				*/
				Wechsel();
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
				filePfad = ZeigeDaten();
				dh.schreiben(filePfad,warenListe);
			}
		};
		gui.getBtnBestellung().addActionListener(drucken);
	}

	
	/*
	public void LeseDatei()
	{
		try
		{
			String zeile = null;
			BufferedReader in = Files.newBufferedReader(Paths.get(fileLesen));	
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
	
	public void SchreibeDatei(String pfad)
	{
		try
		{
			BufferedWriter out = Files.newBufferedWriter(Paths.get(pfad), StandardCharsets.UTF_8);
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
	*/
	public void Wechsel()
	{
		warenListe.addElement((Artikel)gui.getListArtikel().getSelectedValue());
		Artikel a = (Artikel)gui.getListArtikel().getSelectedValue();
		artikelListe.removeElement((Artikel)gui.getListArtikel().getSelectedValue());
		gesamtpreis = gesamtpreis + a.getPreis();
	}
	public double getGesamtpreis()
	{
		return gesamtpreis;
	}


	public void setGesamtpreis(double gesamtpreis)
	{
		this.gesamtpreis = gesamtpreis;
	}


	public String ZeigeDaten()
	{
		String test;
		
		JFileChooser chooser = new JFileChooser();
		chooser.showOpenDialog(null);
		test = chooser.getSelectedFile().toString();
		
		return test;
	}
	public String LadeDaten()
	{
		String test;
		
		JFileChooser chooser = new JFileChooser();
		chooser.showOpenDialog(null);
		test = chooser.getSelectedFile().getAbsolutePath().toString();
		
		return test;
	}
	
}
