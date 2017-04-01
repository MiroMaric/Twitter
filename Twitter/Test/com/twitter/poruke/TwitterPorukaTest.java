package com.twitter.poruke;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TwitterPorukaTest {
	TwitterPoruka tp;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		tp = new TwitterPoruka();
	}

	@After
	public void tearDown() throws Exception {
		tp = null;
	}
	
	@Test
	public void testSetKorisnik() {
		tp.setKorisnik("MiroMaric");
		assertEquals("MiroMaric", tp.getKorisnik());
	}
	
	@Test (expected=java.lang.RuntimeException.class)
	public void testSetKorisnikNull() {
		tp.setKorisnik(null);
	}
	
	@Test (expected=java.lang.RuntimeException.class)
	public void testSetKorisnikEmptyString() {
		tp.setKorisnik("");
	}

	@Test
	public void testSetPoruka() {
		tp.setPoruka("Samo jako!");
		assertEquals("Samo jako!", tp.getPoruka());
	}
	
	@Test (expected=java.lang.RuntimeException.class)
	public void testSetPorukaNull() {
		tp.setPoruka(null);
	}
	
	@Test (expected=java.lang.RuntimeException.class)
	public void testSetPorukaEmptyString() {
		tp.setPoruka("");
	}
	
	@Test (expected=java.lang.RuntimeException.class)
	public void testSetPorukaLenght() {
		String poruka = "Da li sada stvarno da kucam 140 karaktera? Ave Beli!Ave Beli!Ave Beli!"
				+ "Ave Beli!Ave Beli!Ave Beli!Ave Beli!Ave Beli!Ave Beli!Ave Beli!Ave Beli!"
				+ "Ave Beli!Ave Beli!Ave Beli!Ave Beli!Ave Beli!Ave Beli!Ave Beli!Ave Beli!"
				+ "Ave Beli!Ave Beli!Ave Beli!Ave Beli!Ave Beli!Ave Beli!Ave Beli!Ave Beli!";
		tp.setPoruka(poruka);
	}
	
	@Test
	public void testToString() {
		tp.setKorisnik("MiroMaric");
		tp.setPoruka("Dzava");
		assertEquals("KORISNIK:MiroMaric PORUKA:Dzava",tp.toString());
	}

}
