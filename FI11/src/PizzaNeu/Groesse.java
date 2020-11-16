package PizzaNeu;

public class Groesse 
{
	private String name;
	private int groesse;
	private double zusatz;
	
	
	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}

		
	public int getGroesse() 
	{
		return groesse;
	}

	public void setGroesse(int groesse) 
	{
		this.groesse = groesse;
	}

	public double getZusatz() 
	{
		return zusatz;
	}

	public void setZusatz(double zusatz) 
	{
		this.zusatz = zusatz;
	}

	public Groesse(String name, int groesse, double zusatz) 
	{
		this.name = name;
		this.groesse = groesse;
		this.zusatz = zusatz;
	}
	
	public String toString()
	{
		return name;
	}

	
}
