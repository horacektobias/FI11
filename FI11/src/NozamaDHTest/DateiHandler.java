package NozamaDHTest;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public abstract class DateiHandler 
{
	String datei;
	ArrayList<String> listListe;
	protected BufferedReader in;
	
	public abstract ArrayList<String> lesen(String datei);
	public abstract void schreiben(String datei);
	
	
	public DateiHandler()
	{
		
	}
	
	public ArrayList<String> lesenDatei() throws IOException
	{	
		
		String zeile = null;
		while((zeile = in.readLine()) != null)
		{
			String[] values = zeile.split(";");
		}
		
		return listListe; 
	
			
			
	}
	
	
}
