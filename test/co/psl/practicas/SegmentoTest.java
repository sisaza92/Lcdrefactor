/**
 * 
 */
package co.psl.practicas;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import co.psl.practicas.exceptions.LcdException;

/**
 * @author USUARIO
 *
 */
public class SegmentoTest {
	
	int idSegmento=0;
	int size=2;
	char[][] lcdActual;		
	Segmento seg;
	
	private char[][] inicializarlcd(int size) {
		char [][] lcd = new char[2*size+3][2+size];
		for (int i = 0; i < lcd.length; i++) {
			for (int j = 0; j < lcd[0].length; j++) {
				lcd[i][j]=' ';
			}
		}
		return lcd;
	}

	/**
	 * Test method for {@link co.psl.practicas.Segmento#Segmento(int, int)(char[][])}.
	 */
	@Test
	public void testSegmentoSize() {
		try {
			seg = new Segmento(0, 0);
			fail("Se esperaba una excepcion de tamaño invalido.");
		} catch (LcdException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.err.println(e.getMessage());
		}
		
	}
	/**
	 * Test method for {@link co.psl.practicas.Segmento#Segmento(int, int)(char[][])}.
	 */
	@Test
	public void testSegmentoId() {
		try {
			seg = new Segmento(7, 1);
			fail("Se esperaba una excepcion de id de Segmento invalido.");
		} catch (LcdException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.err.println(e.getMessage());
		}
		
	}
	
	/**
	 * Test method for {@link co.psl.practicas.Segmento#encenderSegmentoSobreLCD(char[][])}.
	 * @throws LcdException 
	 */
	@Test
	public void testEncender() throws LcdException {
		
		char[][] lcdExpected_0_2 =inicializarlcd(2);
		lcdExpected_0_2[0][1]='-';
		lcdExpected_0_2[0][2]='-';
		
		char[][] lcdExpected_1_2 = inicializarlcd(2);
		lcdExpected_1_2[1][0]='|';
		lcdExpected_1_2[2][0]='|';
		
		char[][] lcdExpected_2_3 ={		{' ',' ',' ',' ',' '},
											{' ',' ',' ',' ','|'},
											{' ',' ',' ',' ','|'},
											{' ',' ',' ',' ','|'},
											{' ',' ',' ',' ',' '},
											{' ',' ',' ',' ',' '},
											{' ',' ',' ',' ',' '},
											{' ',' ',' ',' ',' '},
											{' ',' ',' ',' ',' '},};

		
		char[][] lcdExpected_3_4 ={		{' ',' ',' ',' ',' ',' '},
											{' ',' ',' ',' ',' ',' '},
											{' ',' ',' ',' ',' ',' '},
											{' ',' ',' ',' ',' ',' '},
											{' ',' ',' ',' ',' ',' '},
											{' ','-','-','-','-',' '},
											{' ',' ',' ',' ',' ',' '},
											{' ',' ',' ',' ',' ',' '},
											{' ',' ',' ',' ',' ',' '},
											{' ',' ',' ',' ',' ',' '},
											{' ',' ',' ',' ',' ',' '},};
		
		seg = new Segmento(idSegmento, size);
		lcdActual = seg.encenderSegmentoSobreLCD(inicializarlcd(size));
		assertArrayEquals("Fallo la prueba para el segmento 0 con tamaño 2",lcdExpected_0_2, lcdActual);
		
		idSegmento=1;
		size = 2;
		seg = new Segmento(idSegmento, size);
		lcdActual = seg.encenderSegmentoSobreLCD(inicializarlcd(size));
		assertArrayEquals("Fallo la prueba para el segmento 1 con tamaño 2",lcdExpected_1_2, lcdActual);
		
		idSegmento=2;
		size = 3;
		seg = new Segmento(idSegmento, size);
		lcdActual = seg.encenderSegmentoSobreLCD(inicializarlcd(size));
		assertArrayEquals("Fallo la prueba para el segmento 2 con tamaño 3",lcdExpected_2_3, lcdActual);
		
		idSegmento=3;
		size = 4;
		seg = new Segmento(idSegmento, size);
		lcdActual = seg.encenderSegmentoSobreLCD(inicializarlcd(size));
		assertArrayEquals("Fallo la prueba para el segmento 3 con tamaño 4",lcdExpected_3_4, lcdActual);
	}

}
