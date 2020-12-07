package NozamaDHTest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import javax.swing.DefaultListModel;

public class DHIO extends DateiHandler
{
	public DHIO()
	{

	}

	@Override
	public DefaultListModel<Artikel> lesen(String datei)
	{
		try
		{
			in = new BufferedReader(new FileReader(datei));
		} 
		catch (FileNotFoundException e1)
		{
			e1.printStackTrace();
		}
		
		DefaultListModel<Artikel> al = new DefaultListModel<>();
		al = super.lesenDatei();
		return al;
	}

	@Override
	public void schreiben(String datei, DefaultListModel<Artikel> waren)
	{
		try
		{
			BufferedWriter out = new BufferedWriter (new FileWriter(datei));
			try
			{	
				for(int i=0;i<listListe.size();i++)
				{
					out.write("Test");
				}
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
