package it.gimelli.jsoup.dati_atletica;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import org.junit.Test;

import junit.framework.Assert;

public class PrestazioneTest {

	@Test
	public void test() {
		

		
		Prestazione p1= new Prestazione();
		p1.setTimeFromString("01:01");
		Assert.assertEquals(61, p1.getTempo().toSecondOfDay());
		
		p1.setTimeFromString("02:02.100");
		Assert.assertEquals(122, p1.getTempo().toSecondOfDay());
		
		p1.setTimeFromString("01.100");
		System.out.println(p1.getMisura());
		Assert.assertEquals(new BigDecimal("01.100"), p1.getMisura());
		
		p1.setTimeFromString("01:01.10");
		Assert.assertEquals(61, p1.getTempo().toSecondOfDay());
		
		
	}

}
