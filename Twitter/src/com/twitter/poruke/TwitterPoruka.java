package com.twitter.poruke;
/**
 * *JUnit and javadoc -domaci zadatak 2017*
 * @author MiroMaric
 * @version 1.0
 */
public class TwitterPoruka {
	/**
	 * Korisnicko ime
	 */
	private String korisnik;
	/**
	 * Poruka korisnika
	 */
	private String poruka;

	/**
	 * @return orisnicko ime
	 */
	public String getKorisnik() {
		return korisnik;
	}
	/**
	 * 
	 * @param korisnik -korisnicko ime
	 * @throws java.lang.RuntimeException -kada je ime korisnika pogresno uneto
	 */
	public void setKorisnik(String korisnik) {
		if (korisnik == null || korisnik.isEmpty()) //!korsnik.isEmpty()-korisnik.isEmpty() Bug otklonjen! 2.4.2017
			throw new RuntimeException("Ime korisnika mora biti uneto");
		this.korisnik = korisnik;
	}

	/**
	 * @return poruka korisnika
	 */
	public String getPoruka() {
		return poruka; //"poruka"-poruka Bug otklonjen! 2.4.2017
	}

	/**
	 * @param poruka -poruka korisnika
	 * @throws java.lang.RuntimeException -kada je poruka pogresno uneta
	 */
	public void setPoruka(String poruka) {
		if (poruka == null || poruka.equals(new String("")) || poruka.length() > 140)
			//suvisana kljuc "this",== - equals() Bug otklonjen! 2.4.2017
			throw new RuntimeException("Poruka mora biti uneta i mora imati najvise 140 znakova");
		this.poruka = poruka;
	}

	public String toString() {
		return "KORISNIK:" + korisnik + " PORUKA:" + poruka;
	}
}