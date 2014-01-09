package be.vdab.entities;

import java.io.Serializable;

public class SauzenRaden implements Serializable{

	private boolean won;
	private boolean lost;
	private int pogingen;
	private StringBuilder sausPuntjes;
	private String saus;
	private static final long serialVersionUID = 1L;
	private static final int MAX_BEURTEN = 10;
	
	public SauzenRaden(String saus) {
		this.saus=saus;
		sausPuntjes = new StringBuilder();
		setWon(false);
		setLost(false);
		setPogingen(0);
		int aantalPuntjes= saus.length();
		for(int i= 0; i < aantalPuntjes; i++){
			sausPuntjes.append(".");
		}
		
	}
	public void checkLetter(Character letter){
		
		int positieLetter = getSaus().indexOf(letter);
		if (positieLetter == -1){
			 pogingen ++;
			 if (pogingen == MAX_BEURTEN){
				 lost=true;
			 }
		}
		else{
			do{
				sausPuntjes.setCharAt(positieLetter, letter);
			    positieLetter = saus.indexOf(letter, positieLetter + 1);
			    
			   
			}while(positieLetter != -1);
		   if (sausPuntjes.indexOf(".") == -1){
				  setWon(true);
				  
			}
		}
	}
			
	
	

	public StringBuilder getSausPuntjes() {
		return sausPuntjes;
	}
	
	public boolean isWon() {
		return won;
	}

	public boolean isLost() {
		return lost;
	}

	public int getPogingen() {
		return pogingen;
	}

	public String getSaus() {
		return saus;
	}

	public static int getMaxBeurten() {
		return MAX_BEURTEN;
	}

	public void setWon(boolean won) {
		this.won = won;
	}

	public void setLost(boolean lost) {
		this.lost = lost;
	}

	public void setPogingen(int pogingen) {
		this.pogingen = pogingen;
	}

	public void setSaus(String saus) {
		this.saus = saus;
	}
	
	
	
}
