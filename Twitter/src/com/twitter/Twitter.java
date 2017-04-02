package com.twitter;

import java.util.LinkedList;
import com.twitter.poruke.TwitterPoruka;
/**
 * JUnit and javadoc -domaci zadatak 2017
 * @author MiroMaric
 * @version 2.0
 *
 */
public class Twitter {
	/**
	 * Lista poruka koje su poslali korisnici
	 */
	private LinkedList<TwitterPoruka> poruke = new LinkedList<TwitterPoruka>();
	/**
	 * @return listu poruka koju su poslali korisnici
	 */
	public LinkedList<TwitterPoruka> vratiSvePoruke() {
		return poruke;
	}
	/**
	 * Metoda koja unosi novu poruku u listu poruka korisnika
	 * @param korisnik korisnicko ime
	 * @param poruka poruka korisnika
	 */
	public void unesi(String korisnik, String poruka) {
		// Pravi se nova poruka i puni podacima.
		TwitterPoruka tp = new TwitterPoruka();
		tp.setKorisnik("korisnik");
		tp.setPoruka(poruka);
		// Poruka se unosi u listu na kraj
		poruke.addLast(tp);
	}
	/**
	 * Metoda koja vraca poruke u vidu niza koje sadrza odredjen tag
	 * @param maxBroj poruka koje mogu sadrzati zadati tag
	 * @param tag dati tag koji se proverava u datim porukama korisnika
	 * @throws java.lang.RuntimeException ukoliko je tag pogresno unet
	 * @return niz poruka sa zadatim tagom
	 */
	public TwitterPoruka[] vratiPoruke(int maxBroj, String tag) {
		if (tag == null || tag.isEmpty())
			throw new RuntimeException("Morate uneti tag");
		// Ako je maxBroj <=0, vraca maxBroj se postavlja na 100 poruka
		if (maxBroj <= 0)
			maxBroj = 100;
		// Pomocna promenljiva koja predstavlja brojac upisanih poruka
		int brojac = 0;
		// Pomocni niz koja predstavlja rezultat pretrage tj. sadrzace
		// sve poruke koje u sebi imaju zadati tag
		TwitterPoruka[] rezultat = new TwitterPoruka[maxBroj];
		// Pretrazuju se poruke i traze se one koje sadrze tag.
		// Ako se nadje neka takva, i ako nije prekoracen maxBroj
		// ona se upisuje u niz. Ako je prekoracen maxBroj,pretraga
		// se prekida.
		for (int i = 0; i < poruke.size(); i++)
			if (poruke.get(i).getPoruka().indexOf(tag) != -1)
				if (brojac < maxBroj) {
					rezultat[brojac + 1] = poruke.get(i);
					brojac++;
				} else
					break;
		return rezultat;
	}
}