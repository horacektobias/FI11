package NozamaDHTest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class DHNIO extends DateiHandler
{

	public DHNIO(String datei)
	{
		super(datei);
		listListe = new ArrayList<>();
	}
	
	
	@Override
	public void schreiben(String datei)
	{
		try
		{
			BufferedWriter out = Files.newBufferedWriter(Paths.get(datei), StandardCharsets.UTF_8);
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
