package Nozama;

public class Artikel
{
	private String artikelnr;
	private String bezeichnung;
	private double preis;
	
	public Artikel(String artikelnr, String bezeichnung, double preis)
	{
		this.artikelnr = artikelnr;
		this.bezeichnung = bezeichnung;
		this.preis = preis;
	}

	public String getArtikelnr()
	{
		return artikelnr;
	}

	public void setArtikelnr(String artikelnr)
	{
		this.artikelnr = artikelnr;
	}

	public String getBezeichnung()
	{
		return bezeichnung;
	}

	public void setBezeichnung(String bezeichnung)
	{
		this.bezeichnung = bezeichnung;
	}

	public double getPreis()
	{
		return preis;
	}

	public void setPreis(double preis)
	{
		this.preis = preis;
	}
	public String toString()
	{
		return bezeichnung + " " + preis;
	}
	
}
