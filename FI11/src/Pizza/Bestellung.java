package Pizza;

public class Bestellung 
{
	private String pizzaname;
	private double preis;
	private String groessename;
	private int groesse;
	private double zusatz;
	private double gesamtpreis;
	
	
	public Bestellung(String pizzaname, double preis, String groessename, int groesse, double zusatz) 
	{
		this.pizzaname = pizzaname;
		this.preis = preis;
		this.groessename = groessename;
		this.groesse = groesse;
		this.zusatz = zusatz;
		gesamtpreis = preisrechnen(preis,zusatz);
	}
	
	
	public String getPizzaname() 
	{
		return pizzaname;
	}

	public void setPizzaname(String pizzaname) 
	{
		this.pizzaname = pizzaname;
	}

	public double getPreis()
	{
		return preis;
	}

	public void setPreis(double preis) 
	{
		this.preis = preis;
	}

	public String getGroessename() 
	{
		return groessename;
	}

	public void setGroessename(String groessename) 
	{
		this.groessename = groessename;
	}

	public int getGroesse() {
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

	public double getGesamtpreis() 
	{
		return gesamtpreis;
	}

	public void setGesamtpreis(double gesamtpreis)
	{
		this.gesamtpreis = gesamtpreis;
	}
	
	
	
	public double preisrechnen(double preis,double zusatz)
	{	
		return preis + zusatz;
	}
	
	public String toString()
	{
		return pizzaname + ", " + groessename;
	}
	
}
