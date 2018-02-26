package com.mcajamarca.conway;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Before;
import org.junit.Test;


public class ConwayTest {
	
	@Before
	public void init (){
		Path plano = Paths.get("src/com/mcajamarca/juegoconway/conway.txt");
	}
}
