package code.mcajamarca;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import com.mcajamarca.figuras.Impresora;
import com.mcajamarca.figuras.Rombo;

public class RomboTest {
	
	public StringBuilder romboPorDefecto = new StringBuilder();	
	public StringBuilder romboTamañoCinco = new StringBuilder();
	public StringBuilder romboTamañoSiete = new StringBuilder();
	
	
	
	@Before
	public void init (){
		romboPorDefecto.append("  *  ").append(Impresora.SALTO_DE_LINEA)
					   .append(" *** ").append(Impresora.SALTO_DE_LINEA)
					   .append("*****").append(Impresora.SALTO_DE_LINEA)
					   .append(" *** ").append(Impresora.SALTO_DE_LINEA)
					   .append("  *  ");
		
		
		
		romboTamañoCinco.append("    *    ").append(Impresora.SALTO_DE_LINEA)
						.append("   ***   ").append(Impresora.SALTO_DE_LINEA)
					    .append("  *****  ").append(Impresora.SALTO_DE_LINEA)
						.append(" ******* ").append(Impresora.SALTO_DE_LINEA)
						.append("*********").append(Impresora.SALTO_DE_LINEA)
						.append(" ******* ").append(Impresora.SALTO_DE_LINEA)
						.append("  *****  ").append(Impresora.SALTO_DE_LINEA)
						.append("   ***   ").append(Impresora.SALTO_DE_LINEA)
						.append("    *    ");
		
		romboTamañoSiete.append("      *      ").append(Impresora.SALTO_DE_LINEA)
		   				.append("     ***     ").append(Impresora.SALTO_DE_LINEA)
		   				.append("    *****    ").append(Impresora.SALTO_DE_LINEA)
		   				.append("   *******   ").append(Impresora.SALTO_DE_LINEA)
		   				.append("  *********  ").append(Impresora.SALTO_DE_LINEA)
		   				.append(" *********** ").append(Impresora.SALTO_DE_LINEA)
		   				.append("*************").append(Impresora.SALTO_DE_LINEA)
		   				.append(" *********** ").append(Impresora.SALTO_DE_LINEA)
		   				.append("  *********  ").append(Impresora.SALTO_DE_LINEA)
		   				.append("   *******   ").append(Impresora.SALTO_DE_LINEA)
		   				.append("    *****    ").append(Impresora.SALTO_DE_LINEA)
		   				.append("     ***     ").append(Impresora.SALTO_DE_LINEA)
		   				.append("      *      ");
		   				
	}
	
	@Test
	public void romboDeTamañoUnoEsRomboPorDefecto(){
		assertThat(new Rombo(1).getRombo(), equalTo(romboPorDefecto));
	}
	
	@Test
	public void romboTamñoTresEsIgualRomboPorDefecto(){
		assertThat(new Rombo(3).getRombo(), equalTo(romboPorDefecto));
	}

}
