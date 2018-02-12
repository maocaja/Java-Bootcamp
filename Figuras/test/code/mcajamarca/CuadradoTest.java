package code.mcajamarca;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import com.mcajamarca.figuras.Cuadrado;
import com.mcajamarca.figuras.Impresora;

public class CuadradoTest {
	
	public StringBuilder cuadradoTresPorTres = new StringBuilder();	
	public StringBuilder cuadradoCuatroPorCuatro = new StringBuilder();
	public StringBuilder cuadradoDiezPorDiez = new StringBuilder();
	
	
	
	@Before
	public void init (){
		cuadradoTresPorTres.append("***").append(Impresora.SALTO_DE_LINEA)
						   .append("***").append(Impresora.SALTO_DE_LINEA)
						   .append("***");
	
		
		cuadradoCuatroPorCuatro.append("****").append(Impresora.SALTO_DE_LINEA)
							   .append("****").append(Impresora.SALTO_DE_LINEA)
							   .append("****").append(Impresora.SALTO_DE_LINEA)
							   .append("****");
		
		cuadradoCuatroPorCuatro.append("**********").append(Impresora.SALTO_DE_LINEA)
							   .append("**********").append(Impresora.SALTO_DE_LINEA)
							   .append("**********").append(Impresora.SALTO_DE_LINEA)
							   .append("**********").append(Impresora.SALTO_DE_LINEA)
							   .append("**********").append(Impresora.SALTO_DE_LINEA)
							   .append("**********").append(Impresora.SALTO_DE_LINEA)
							   .append("**********").append(Impresora.SALTO_DE_LINEA)
							   .append("**********").append(Impresora.SALTO_DE_LINEA)
							   .append("**********").append(Impresora.SALTO_DE_LINEA)
							   .append("**********");
	}
	
	@Test
	public void cuadradoTamaño1EsTresPorTres(){
		assertThat(new Cuadrado(1).getCuadrado(), equalTo(cuadradoTresPorTres));
	}
	
	@Test
	public void cuadradoPorDefectoEs3Por3(){
		assertThat(new Cuadrado().getCuadrado(), equalTo(cuadradoTresPorTres));
		
	}
	
	@Test
	public void cuadradoCuatroPorCuatro(){
		assertThat(new Cuadrado(4).getCuadrado(), equalTo(cuadradoCuatroPorCuatro));
		
	}
	
}
