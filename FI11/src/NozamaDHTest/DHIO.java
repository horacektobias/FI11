package NozamaDHTest;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class DHIO extends DateiHandler
{
	public DHIO()
	{

	}

	@Override
	public ArrayList<String> lesen(String datei)
	{
		try
		{
			in = new BufferedReader(new FileReader(datei));
		} 
		catch (FileNotFoundException e1)
		{
			e1.printStackTrace();
		}
		
		ArrayList<String> al = null;
		
		try
		{
			al = super.lesenDatei();
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return al;
		
		

		
	}

	@Override
	public void schreiben(String datei)
	{
		// TODO Auto-generated method stub
		
	}
	
}
