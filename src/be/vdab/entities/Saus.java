package be.vdab.entities;


public class Saus {

	private long nummer;
	private String naam;
	private String[] ingredienten;
	
	public Saus(long nummer,String naam ,String[] ingredienten) {
		setNummer(nummer);
		setNaam(naam);
		setIngredienten(ingredienten);
	}
	
	public long getNummer() {
		return nummer;
	}
	public void setNummer(long nummer) {
		this.nummer = nummer;
	}
	public String getNaam() {
		return naam;
	}
	public void setNaam(String naam) {
		this.naam = naam;
	}
	public String[] getIngredienten() {
		return ingredienten;
	}
	public void setIngredienten(String[] ingredienten) {
		this.ingredienten = ingredienten;
	}
	
	
}
