package com.twitter.poruke;
/**
 * Ova klasa sadrzi informacije o korisnickom imenu, poruci korisnika kao i toString,equals i get,set metode
 * za navedene atribute.
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
	 * Metoda vraca korisnicko ime
	 * @return orisnicko ime
	 */
	public String getKorisnik() {
		return korisnik;
	}
	/**
	 * Metoda postavlja korisnicko ime
	 * @param korisnik korisnicko ime
	 * @throws java.lang.RuntimeException kada je ime korisnika null ili je prazan String
	 */
	public void setKorisnik(String korisnik) {
		if (korisnik == null || korisnik.isEmpty()) //!korsnik.isEmpty()-korisnik.isEmpty() Bug otklonjen! 2.4.2017
			throw new RuntimeException("Ime korisnika mora biti uneto");
		this.korisnik = korisnik;
	}

	/**
	 * Metoda vraca poruku korisnika
	 * @return poruka korisnika
	 */
	public String getPoruka() {
		return poruka; //"poruka"-poruka Bug otklonjen! 2.4.2017
	}

	/**
	 * Metoda postavlja poruku korisnika
	 * @param poruka poruka korisnika
	 * @throws java.lang.RuntimeException kada je poruka null, prazan Strng ili je duza od 140 karaktera
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
	@Override
	//Morali smo dodati metodu zbog testiranja
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TwitterPoruka other = (TwitterPoruka) obj;
		if (korisnik == null) {
			if (other.korisnik != null)
				return false;
		} else if (!korisnik.equals(other.korisnik))
			return false;
		if (poruka == null) {
			if (other.poruka != null)
				return false;
		} else if (!poruka.equals(other.poruka))
			return false;
		return true;
	}
	
}