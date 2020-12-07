package NozamaDHTest;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.DefaultListModel;

public abstract class DateiHandler 
{
	String datei;
	DefaultListModel<Artikel> listListe = new DefaultListModel<>();
	protected BufferedReader in;
	
	public abstract DefaultListModel<Artikel> lesen(String datei) throws IOException;
	public abstract void schreiben(String datei, DefaultListModel<Artikel> waren);
	
	
	public DateiHandler()
	{
		
	}
	
	public DefaultListModel<Artikel> lesenDatei()
	{	
		String zeile = null;
		try
		{
			while((zeile = in.readLine()) != null)
			{
				String[] values = zeile.split(";");
				Artikel art = new Artikel(values[0],values[1],Double.parseDouble(values[2]));
				System.out.println(art);
				listListe.addElement(art);
			}
		} catch (NumberFormatException e)
		{
			e.printStackTrace();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		return listListe; 		
	}	
}
