package PizzaNeu;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Optional;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;

public class Controller 
{
	private PizzaGUI gui;
	private DefaultComboBoxModel<Pizza> listeTest = new DefaultComboBoxModel<>();
	private DefaultComboBoxModel<Groesse> listeGroesse = new DefaultComboBoxModel<>();
	private DefaultListModel<Bestellung> bestellung = new DefaultListModel<>();
	private ActionListener hinzu;
	private ActionListener entfernen;
	private double gesamtpreis = 0;
	

	
	public Controller()
	{
		gui = new PizzaGUI();
		gui.getComboBoxGroesse().setModel(listeGroesse);
		gui.getComboBoxPizza().setModel(listeTest);
		gui.getList().setModel(bestellung);
		
		listeTest.addElement(new Pizza("Pizza Schinken",11.00));
		listeTest.addElement(new Pizza("Pizza Salami",11.10));
		listeTest.addElement(new Pizza("Pizza Margherita",9.10));
		listeGroesse.addElement(new Groesse("klein", 26,-1));
		listeGroesse.addElement(new Groesse("groﬂ",32,1.80));
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
	}
	public void LeseDatei()
	{
		try
		{
			String zeile = null;
			Bufferedreader in = new BufferedReader(new)
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
			gui.getTextPreis().setText(roundOff + "Ä");
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
			gui.getTextPreis().setText(roundOff + "Ä");
		}
		catch(Exception e)
		{
			
		}
	}
	
}
