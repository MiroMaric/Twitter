package com.twitter;

import static org.junit.Assert.*;


import java.util.LinkedList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.twitter.poruke.TwitterPoruka;


public class TwitterTest {
	Twitter t;

	@Before
	public void setUp() throws Exception {
		t = new Twitter();
	}

	@After
	public void tearDown() throws Exception {
		t = null;
	}

	@Test
	public void testVratiSvePoruke() {
		t.unesi("MiroMaric", "Poruka1");
		TwitterPoruka tp1 = new TwitterPoruka();
		tp1.setKorisnik("MiroMaric");
		tp1.setPoruka("Poruka1");
		
		t.unesi("MiroMaric", "Poruka2");
		TwitterPoruka tp2 = new TwitterPoruka();
		tp2.setKorisnik("MiroMaric");
		tp2.setPoruka("Poruka2");
		
		t.unesi("MiroMaric", "Poruka3");
		TwitterPoruka tp3 = new TwitterPoruka();
		tp3.setKorisnik("MiroMaric");
		tp3.setPoruka("Poruka3");
		
		TwitterPoruka[] nizPoruka = new TwitterPoruka[3];
		nizPoruka[0] = tp1;
		nizPoruka[1] = tp2;
		nizPoruka[2] = tp3;
		
		LinkedList<TwitterPoruka> lista = t.vratiSvePoruke();
		TwitterPoruka[] nizPorukaTwitter = new TwitterPoruka[3];
		lista.toArray(nizPorukaTwitter);
		assertArrayEquals(nizPoruka, nizPorukaTwitter);
	}

	@Test
	public void testUnesi() {
		t.unesi("MiroMaric", "Dzava");
		assertEquals("KORISNIK:MiroMaric PORUKA:Dzava", t.vratiSvePoruke().getLast().toString());
	}
	
	@Test (expected=java.lang.RuntimeException.class)
	public void testUnesiNull() {
		t.unesi(null, "Dzava"); // i/ili mozemo staviti da je poruka==null
	}
	
	@Test (expected=java.lang.RuntimeException.class)
	public void testUnesiEmpty() {
		t.unesi("MiroMaric", ""); // i/ili mozemo staviti da je korisnik==""
	}

	
	@Test (expected=java.lang.RuntimeException.class)
	public void testVratiPorukeNull() {
		t.vratiPoruke(100, null);
	}
	
	@Test (expected=java.lang.RuntimeException.class)
	public void testVratiPorukeEmpty() {
		t.vratiPoruke(100, "");
	}
	
	@Test
	public void testVratiPoruke() {
		t.unesi("MiroMaric", "Beli-'Ljubi cika ruku'");
		TwitterPoruka tp1 = new TwitterPoruka();
		tp1.setKorisnik("MiroMaric");
		tp1.setPoruka("Beli-'Ljubi cika ruku'");
		
		t.unesi("MiroMaric", "Ovo je poruka");
				
		t.unesi("MiroMaric", "Ovo je isto poruka");
		
		t.unesi("MiroMaric", "Beli!");
		TwitterPoruka tp2 = new TwitterPoruka();
		tp2.setKorisnik("MiroMaric");
		tp2.setPoruka("Beli!");
		
		TwitterPoruka[] nizPorukaPom = new TwitterPoruka[10];
		nizPorukaPom[0] = tp1;
		nizPorukaPom[1] = tp2;
		
		TwitterPoruka[] nizPoruka = t.vratiPoruke(10, "Beli");
		assertArrayEquals(nizPorukaPom, nizPoruka);
	}
	
	@Test
	public void testVratiPorukeMaxBroj() {
		t.unesi("MiroMaric", "Beli-'Ljubi cika ruku'");
		TwitterPoruka tp1 = new TwitterPoruka();
		tp1.setKorisnik("MiroMaric");
		tp1.setPoruka("Beli-'Ljubi cika ruku'");
		
		t.unesi("MiroMaric", "Ovo je poruka");
				
		t.unesi("MiroMaric", "Ovo je isto poruka");
		
		t.unesi("MiroMaric", "Beli!");
		TwitterPoruka tp2 = new TwitterPoruka();
		tp2.setKorisnik("MiroMaric");
		tp2.setPoruka("Beli!");
		
		TwitterPoruka[] nizPorukaPom = new TwitterPoruka[100];
		nizPorukaPom[0] = tp1;
		nizPorukaPom[1] = tp2;
		
		TwitterPoruka[] nizPoruka = t.vratiPoruke(-2258, "Beli");
		assertArrayEquals(nizPorukaPom, nizPoruka);
	}
	
	

}
