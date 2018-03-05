package com.mcajamarca.picasyfijas;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;


public class PicasYFijasTest {
	
	@Test
	public void fijasDelMismoNúmeroSonCuatro() {
		String número = "1234";
		MenteMaestra menteMaestra = new MenteMaestra(número);
		assertThat(menteMaestra.fijas(número),is(4));
	}
	
	@Test
	public void picasDelMismoNúmeroEsCero() {
		String número = "1234";
		MenteMaestra menteMaestra = new MenteMaestra(número);
		Intento intento = new Intento(número);
		assertThat(menteMaestra.picas(intento.toString()),is(0));
	}
	
	@Test
	public void fijasDeUnNúmeroQueEmpiezaPorElMismoDigitoEsUno() {
		MenteMaestra menteMaestra = new MenteMaestra("1234");
		Intento intento = new Intento("1672");
		assertThat(menteMaestra.fijas(intento.toString()),is(1));
	}
	
	@Test
	public void picasDeUnNúmeroQueEmpiezaPorElMismoDígitoYContineOtroDigitoEnOtraPocisiónEsUno() {
		MenteMaestra menteMaestra = new MenteMaestra("1234");
		Intento intento = new Intento("1672");
		assertThat(menteMaestra.picas(intento.toString()),is(1));
	}
	
	@Test
	public void fijasDeUnNúmeroQueContieneDosDígitosEnLaMismaPocisionEsDos() {
		MenteMaestra menteMaestra = new MenteMaestra("1234");
		Intento intento = new Intento("8254");
		assertThat(menteMaestra.fijas(intento.toString()),is(2));
	}

	
}
