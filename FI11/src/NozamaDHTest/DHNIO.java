package NozamaDHTest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import javax.swing.DefaultListModel;

public class DHNIO extends DateiHandler
{

	public DHNIO()
	{

	}
	@Override
	public DefaultListModel<Artikel> lesen(String datei) throws IOException
	{
		try
		{
			in = Files.newBufferedReader(Paths.get(datei));
		} 
		catch (FileNotFoundException e1)
		{
			e1.printStackTrace();
		}
		DefaultListModel<Artikel> al = new DefaultListModel<>();		
		al = super.lesenDatei();
		System.out.println(al.getElementAt(1));
		return al;
	}
	@Override
	public void schreiben(String datei, DefaultListModel<Artikel> waren)
	{
		try
		{
			BufferedWriter out = Files.newBufferedWriter(Paths.get(datei), StandardCharsets.UTF_8);
			try
			{	
				out.write("Ihre Rechnung:\n\n");
				for(int i=0;i<waren.size();i++)
				{
					out.write(waren.getElementAt(i).toString()+"\n");
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
