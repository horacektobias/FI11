package PizzaNeu;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Optional;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class Controller 
{
	
	// Änderung
	private PizzaGUI gui;
	private DefaultComboBoxModel<Pizza> listeTest = new DefaultComboBoxModel<>();
	private DefaultComboBoxModel<Groesse> listeGroesse = new DefaultComboBoxModel<>();
	private DefaultListModel<Bestellung> bestellung = new DefaultListModel<>();
	private ActionListener hinzu;
	private ActionListener entfernen;
	private ActionListener drucken;
	private double gesamtpreis = 0;
	
	

	
	public Controller()
	{
		gui = new PizzaGUI();
		gui.getComboBoxGroesse().setModel(listeGroesse);
		gui.getComboBoxPizza().setModel(listeTest);
		gui.getList().setModel(bestellung);
		LeseDatei();
		
		/*
		listeTest.addElement(new Pizza("Pizza Schinken",11.00));
		listeTest.addElement(new Pizza("Pizza Salami",11.10));
		listeTest.addElement(new Pizza("Pizza Margherita",9.10));
		*/
		listeGroesse.addElement(new Groesse("klein", 26,-1));
		listeGroesse.addElement(new Groesse("groß",32,1.80));
		listeGroesse.addElement(new Groesse("Familie",48,4.30));
		
		hinzu = new ActionListener() 
		{

			@Override
			public void actionPerformed(ActionEvent e) 
			{
				machwas((Pizza)gui.getComboBoxPizza().getSelectedItem(),(Groesse)gui.getComboBoxGroesse().getSelectedItem());		
			}
			
		};
		gui.getBtnHinzu().addActionListener(hinzu);
		
		entfernen = new ActionListener() 
		{

			@Override
			public void actionPerformed(ActionEvent e) 
			{
				entfernen(gui.getList().getSelectedValue());		
			}
			
		};
		gui.getBtnEntfernen().addActionListener(entfernen);
		
		drucken = new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				SchreibeDatei();
			}
		};
		gui.getBtnDrucken().addActionListener(drucken);
		
	}
	public void LeseDatei()
	{
		try
		{
			String zeile = null;
			BufferedReader in = new BufferedReader(new FileReader("Pizzaliste.txt"));	
			try
			{
				while ((zeile = in.readLine()) != null)
				{
					String[] values = zeile.split(";");
					Pizza p = new Pizza(values[0],Double.parseDouble(values[1]));
					listeTest.addElement(p);
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
			BufferedWriter out = new BufferedWriter(new FileWriter("Rechnung.txt",false));
			try
			{
				out.write("Ihre Rechnung:\n\n");
				for(int i=0;i<bestellung.size();i++)
				{
					out.write(bestellung.getElementAt(i).toString()+"\n");
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
	
	public void machwas(Pizza p, Groesse g)
	{	
		try
		{
			Bestellung pizza = new Bestellung(p.getName(),p.getPreis(),g.getName(),g.getGroesse(),g.getZusatz());
			bestellung.addElement(pizza);
			gesamtpreis = gesamtpreis + pizza.getGesamtpreis();
			double roundOff = Math.round(gesamtpreis * 100.00) / 100.00;
			gui.getTextPreis().setText(roundOff + "€");
		}
		catch(NumberFormatException nfe)
		{
			
		}
	}
	public void entfernen(Object w)
	{
		try 
		{
			Bestellung p = (Bestellung) w;
			bestellung.removeElement(p);
			gesamtpreis = gesamtpreis - p.getGesamtpreis();
			double roundOff = Math.round(gesamtpreis * 100.00) / 100.00;
			gui.getTextPreis().setText(roundOff + "€");
		}
		catch(Exception e)
		{
			
		}
	}
	
}
