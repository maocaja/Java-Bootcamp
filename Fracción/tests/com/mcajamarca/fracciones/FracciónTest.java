package com.mcajamarca.fracciones;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;
import org.junit.Test;

import com.mcajamarca.fracción.Fracción;

public class FracciónTest {
	
	@Test
	public void elNumeradorDeCincoQuintosEs1() {
		Fracción cincoQuintos = new Fracción(5, 5);
		assertThat("Fracción actual es " + cincoQuintos,
										   cincoQuintos.getNumerador(), is(1));
	}
	
	@Test
	public void elNumeradorDeUnMedioEs1() {
		Fracción unMedio = new Fracción(1, 2);
		assertThat("Fracción actual es " + unMedio,
										   unMedio.getNumerador(), is(1));
	}
	
	@Test
	public void diezQuintoEsEquivalenteADos() {
		assertThat(new Fracción(10, 5), equalTo(new Fracción(2, 1)));
	}
	
	@Test
	public void unoMenosUnMedioEsUnMedio() {
		Fracción uno = new Fracción(1, 1);
		Fracción unMedio = new Fracción(1, 2);
		assertThat(uno.menos(unMedio), equalTo(unMedio));
	}
	
	@Test
	public void cincoMasCincoEsDiez() {
		Fracción cinco = new Fracción(5, 1);
		Fracción diez = new Fracción(10, 1);
		assertThat(cinco.más(cinco), equalTo(diez));
	}
	
	@Test
	public void unMedioPorUnMediooEsUnCuarto() {
		Fracción unMedio = new Fracción(1, 2);
		Fracción unCuarto = new Fracción(1, 4);
		assertThat(unMedio.por(unMedio), equalTo(unCuarto));
	}
	
	@Test
	public void unMedioDivididoUnMedioEsUno() {
		Fracción unMedio = new Fracción(1, 2);
		Fracción uno = new Fracción(1, 1);
		assertThat(unMedio.dividido(unMedio), equalTo(uno));
	}
}
