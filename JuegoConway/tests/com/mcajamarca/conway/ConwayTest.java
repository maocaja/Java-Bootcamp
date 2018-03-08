package com.mcajamarca.conway;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.mcajamarca.juegoconway.Tablero;


public class ConwayTest {
	
	@Test
	public void todasLasCélulasMuertasLaSiguienteGeneracionSiguenTodasMuertas(){
		char [][] tableroInicial = {{'.','.','.'},{'.','.','.'},{'.','.','.'}};
		Tablero tablero = new Tablero(tableroInicial);
		assertThat(tablero.tableroFuturo().toString(),equalTo(tablero.toString()));
	}
	
	@Test
	public void unaCéulaVivaEnLaMitadSiguienteGeneraciónMuere(){
		char [][] tableroInicial = {{'.','.','.'},{'.','*','.'},{'.','.','.'}};
		char [][] tableroVacío   = {{'.','.','.'},{'.','.','.'},{'.','.','.'}};
		Tablero tablero = new Tablero(tableroInicial);
		assertThat(tablero.tableroFuturo().toString(),equalTo(new Tablero(tableroVacío).toString()));
	}
	
	@Test
	public void unCudradoDeCélulasVivasEnElCentroEsElMismoEnLaSiguienteGeneración(){
		char [][] tableroInicial = {{'.','.','.','.'},{'.','*','*','.'},{'.','*','*','.'},{'.','.','.','.'}};
		Tablero tablero = new Tablero(tableroInicial);
		assertThat(tablero.tableroFuturo().toString(),equalTo(tablero.toString()));
	}
	
	@Test
	public void todasLasCélulasVivasEnLaSiguienteGeneraciónPintaUnaCruzDeCélulasMuertasEnElCentro(){
		char [][] tableroInicial = {{'*','*','*'},{'*','*','*'},{'*','*','*'}};
		char [][] tableroEsperado   = {{'*','.','*'},{'.','.','.'},{'*','.','*'}};
		Tablero tablero = new Tablero(tableroInicial);
		assertThat(tablero.tableroFuturo().toString(),equalTo(new Tablero(tableroEsperado).toString()));
	}
}
