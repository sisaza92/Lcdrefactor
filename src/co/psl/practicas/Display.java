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
 * Esta clase es la representa un Display de una o varias pantallas
 * LCD 7 segmentos de un solo digito.
 *
 */
public class Display {
	
	private final char ESPACIO = ' ';
	private final char SALTO_DE_LINEA = '\n';

	private HashMap<Integer, char[][]> digitosLcd;
	private int size;
	private String numeros;
	private String espacioEntreDigitos;
	
	/**
	 * Método constructor de la clase Display. 
	 * @param size Entero con el Tamaño de cada segmento 
	 * que será dibujado en cada uno de los LCD. 
	 * @param numeros String con cada uno de los números que se
	 * quiere mostrar en el LCD. 
	 * @param nroEspacioEntreDigitos Entero con el numero de espacios que se
	 * desea usar como separación entre cada LCD. 
	 * @throws LcdException Toma la excepcion si se presenta y la lanza de nuevo.
	 */
	public Display(int size,String numeros,int nroEspacioEntreDigitos) throws LcdException {
		this.size = size;
		this.numeros = numeros;
		digitosLcd = new HashMap<Integer, char[][]>();
		this.espacioEntreDigitos = crearSeparacion(nroEspacioEntreDigitos);
		incluirDigitos();
	}

	/**
	 * Crea un string con la cantidad de espacios especificada por nroEspacioEntreDigitos.
	 * @param nroEspacioEntreDigitos cantidad de espacios que se desean concatenar.
	 * @return String con la cantidad de espacios especificada por nroEspacioEntreDigitos.
	 */
	private String crearSeparacion(int nroEspacioEntreDigitos) {
		String espacioEntreDigitos = "";
		for (int i = 0; i < nroEspacioEntreDigitos; i++) {
			espacioEntreDigitos += ESPACIO;
		}
		return espacioEntreDigitos;
	}
	
	/**
	 * Incluye las representaciones de los digitos que se van a mostrar en pantalla.
	 * @throws LcdException
	 */
	private void incluirDigitos() throws LcdException{
		for (int i = 0; i < numeros.length(); i++) {
			int numero = Integer.parseInt(numeros.charAt(i)+"");
			DigitoLcd lcd = new DigitoLcd(size);
			
			if(!digitosLcd.containsKey(numero)){
				digitosLcd.put(numero, lcd.encenderLcd(numero));
			}	
		}
	}
	
	/**
	 * Imprime los digitos del display en la pantalla.
	 */
	public void encender(){
		int nrofilas = 2*size+3;
		for (int fila = 0; fila < nrofilas; fila++) {
			for (int i = 0; i < numeros.length(); i++) {
				int numero = Integer.parseInt(numeros.charAt(i)+"");
				char[][] digitoLcd = digitosLcd.get(numero);
				int nroColumnas = 2+size;
				for (int columna = 0; columna < nroColumnas; columna++) {
					String caracter = digitoLcd[fila][columna]+"";
					System.out.print(caracter);
				}
				System.out.print(espacioEntreDigitos);
			}
			System.out.print(SALTO_DE_LINEA);
		}
	}
	
}
