package code.mcajamarca;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import com.mcajamarca.figuras.Impresora;
import com.mcajamarca.figuras.Piramide;

public class PiramideTest {
	
public final String El_PARAMETRO_NO_ES_UN_NÚMERO = "El parámetro no es un número";
	
	public StringBuilder piramidePorDefecto = new StringBuilder();	
	public StringBuilder piramideTamañoCinco = new StringBuilder();
	public StringBuilder piramideTamañoSiete = new StringBuilder();
	
	
	
	@Before
	public void init (){
		piramidePorDefecto.append("  *  ").append(Impresora.SALTO_DE_LINEA)
						  .append(" *** ").append(Impresora.SALTO_DE_LINEA)
						  .append("*****");
		
		
		piramideTamañoCinco.append("    *    ").append(Impresora.SALTO_DE_LINEA)
						   .append("   ***   ").append(Impresora.SALTO_DE_LINEA)
						   .append("  *****  ").append(Impresora.SALTO_DE_LINEA)
						   .append(" ******* ").append(Impresora.SALTO_DE_LINEA)
						   .append("*********");
		
		piramideTamañoSiete.append("      *      ").append(Impresora.SALTO_DE_LINEA)
		   				   .append("     ***     ").append(Impresora.SALTO_DE_LINEA)
		   				   .append("    *****    ").append(Impresora.SALTO_DE_LINEA)
		   				   .append("   *******   ").append(Impresora.SALTO_DE_LINEA)
		   				   .append("  *********  ").append(Impresora.SALTO_DE_LINEA)
		   				   .append(" *********** ").append(Impresora.SALTO_DE_LINEA)
		   				   .append("*************");
	}
	
	@Test
	public void piramidePorDefectoEsTresPorTres(){
		assertThat(new Piramide(1).getPiramide(), equalTo(piramidePorDefecto));
	}
	
	@Test
	public void piramideConTamñoUnoEsIgualTresPorTres(){
		assertThat(new Piramide(1).getPiramide(), equalTo(piramidePorDefecto));
	}

}
