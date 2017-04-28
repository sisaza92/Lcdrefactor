/**
 * 
 */
package co.psl.practicas;

import java.util.HashMap;

import co.psl.practicas.exceptions.LcdException;


/**
 * @author Cristian Camilo Isaza
 * @email sisaza92@gmail.com
 * 
 * Esta clase es la representación de una pantalla
 * LCD 7 segmentos de un solo digito.
 *
 */
public class DigitoLcd {

	private final char CARACTER_INICIALIZADOR = ' ';
	private final HashMap<Integer, String> SEGMENTOS_POR_DIGITO = new HashMap<Integer, String>() {
		private static final long serialVersionUID = -6118510173609000069L;
				{
                    put(0, "012456");
                    put(1, "25");
                    put(2, "02346");
                    put(3, "02356");
                    put(4, "1235");
                    put(5, "01356");
                    put(6, "013456");
                    put(7, "025");
                    put(8, "0123456");
                    put(9, "012356");
                }
            };
	
	private int size;
	private char[][] lcd;
	private HashMap<Integer, char[][]> lcdsEncendidos;
	
	/**
	 * Método constructor de la clase DigitoLcd.
	 * @param size Tamaño de cada segmento que será dibujado en el LCD.
	 */
	public DigitoLcd(int size) {
		this.size = size;
		lcdsEncendidos = new HashMap<Integer, char[][]>();
		lcd = new char[2*size+3][size+2];
		inicializarMatriz();
	}
	
	/**
	 * Inicializa la matriz digitoLcd con el caracter CARACTER_INICIALIZADOR.
	 */
	private void inicializarMatriz() {
		int totalFilas = 2*size+3;
		int totalColumnas = 2+size;
		for (int i = 0; i < totalFilas; i++) {
			for (int j = 0; j < totalColumnas; j++) {
				lcd[i][j]=CARACTER_INICIALIZADOR;				
			}
		}
	}

	/**
	 * Verifica si el digito ingresado ya se habia encendido previamente 
	 * para evitar encenderlo de nuevo,de lo contrario lo enciende.
	 * @param digito numero que se desea encender en el lcd.
	 * @return matriz que representa el digito encendido.
	 * @throws LcdException Toma la excepcion si se presenta y la lanza de nuevo.
	 */
	public char[][] encenderLcd(int digito) throws LcdException{
		if(lcdsEncendidos.containsKey(digito)){
			return lcdsEncendidos.get(digito);
		}else{
			encenderSegmentos(digito);
			return lcd;
		}		
	}
	/**
	 * Toma un digito entre 0 y 9 para verificar que segmentos
	 * le pertenecen sobre el LCD, los enciende y luego guarda el LCD
	 * para no volver a encender cada segmento de nuevo.
	 * @param digito Número que se desea mostrar en el LCD.
	 * @throws LcdException Toma la excepcion si se presenta y la lanza de nuevo. 
	 */
	private void encenderSegmentos(int digito) throws LcdException {		
		char[] segmentos = SEGMENTOS_POR_DIGITO.get(digito).toCharArray();
		for (char segmento : segmentos) {
			int idSeg = Integer.parseInt(segmento+"");
			Segmento seg = new Segmento(idSeg, size);
			lcd = seg.encenderSegmentoSobreLCD(lcd);
		}
		lcdsEncendidos.put(digito, lcd);
	}

}
