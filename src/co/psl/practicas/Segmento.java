/**
 * 
 */
package co.psl.practicas;

import co.psl.practicas.exceptions.LcdException;

/**
 * @author Cristian Camilo Isaza
 * @email sisaza92@gmail.com
 * 
 * Esta clase es la representación de un segmento
 * perteneciente un lcd de un digito.
 *
 */
public class Segmento {
	
	private final char CARACTER_HORIZONTAL = '-';
	private final char CARACTER_VERTICAL = '|';
	private final int MIN_ID = 0;
	private final int MAX_ID = 6;
	private final int MAX_SIZE = 10;
	private final int MIN_SIZE = 1;
	private final String MSG_MAL_TAMANO = "Tamaño fuera del Rango";
	private final String MSG_MAL_ID = "Id de segmento Inválido";
	
	private int id;
	private int size;
	private int idxFila;
	private int idxColumna;
	private boolean horizontal = false;
	
	/**
	 * Método Constructor de la clase Segmento.
	 * 
	 * @param id Identificador del segmento que será dibujado, Debe ser un entero entre MIN_ID y MAX_ID.
	 * @param size Tamaño del segmento que será dibujado. Debe ser un entero enntre MIN_SIZE y MAX_SIZE.
	 * @throws LcdException Permite lanzar una excepcion con un mensaje y hacer
	 * un log cuando una de las validaciónes no sea satisfactoria.
	 */
	public Segmento(int id, int size) throws LcdException {
		
		esIdValido(id);
		esSizeValido(size);
		
		this.id = id;
		this.size = size;
		inicializarSegmento();
	}
	
	/**
	 * Método que valida que el tamaño esté dentro del rango especificado.
	 * 
	 * @param size Entero que indica el tamaño del Segmento que será dibujado.
	 * Debe ser un entero entre MIN_SIZE y MAX_SIZE.
	 * @return true siempre que size este dentro del rango especificado entre MIN_SIZE Y MAX_SIZE.
	 * @throws LcdException Permite lanzar una excepcion con el mensaje MSG_MAL_ID y hacer
	 * un log cuando size no esta entre MIN_SIZE Y MAX_SIZE.
	 * 
	 */
	private boolean esSizeValido(int size) throws LcdException {
		if (size < MIN_SIZE || size > MAX_SIZE) {
			throw new LcdException(MSG_MAL_TAMANO);
		}
		return true;
	}

	/**
	 * Método que valida que el id esté dentro del rango especificado.
	 * 
	 * @param id Entero que indica el identificador del Segmento que será dibujado.
	 * Debe ser un entero entre MIN_ID y MAX_ID.
	 * @return true siempre que size este dentro del rango especificado entre MIN_ID y MAX_ID.
	 * @throws LcdException Permite lanzar una excepcion con el mensaje MSG_MAL_ID y hacer
	 * un log cuando size no esta entre MIN_ID y MAX_ID.
	 * 
	 */
	private boolean esIdValido(int id) throws LcdException {
		if (id>MAX_ID || id<MIN_ID) {
			throw new LcdException(MSG_MAL_ID);
		}
		return true;
	}
	
	/**
	 * Permite posicionar el inicio de cada segmento en la matriz digitoLcd, asignando
	 * sus indices según el id del segmento, además de indicar si el
	 * segmento está orientado horizontalmente.
	 */
	private void inicializarSegmento() {
		switch(id){
		case 0:
			idxFila=0;
			idxColumna=1;
			horizontal=true;
			break;
		case 1:
			idxFila=1;
			idxColumna=0;
			break;
		case 2:
			idxFila=1;
			idxColumna=size+1;
			break;
		case 3:
			idxFila=size+1;
			idxColumna=1;
			horizontal=true;
			break;
		case 4:
			idxFila=size+2;
			idxColumna=0;
			break;
		case 5:
			idxFila=size+2;
			idxColumna=size+1;
			break;
		case 6:
			idxFila=2*size+2;
			idxColumna=1;
			horizontal=true;
			break;
		}
	}


	/**
	 * Permite dibujar el segmento en la matriz digitoLcd, asignando el 
	 * caracter CARACTER_HORIZONTAL si el segmento es horizontal un total 
	 * de size casillas en columna en la matriz o asignando el caracter 
	 * CARACTER_VERTICAL un total de size casillas en fila en la matriz.
	 * @param digitoLcd representación matricial de la pantalla LCD
	 *  de un digito en la cual se dibujará el segmento.
	 * @return matriz con digitoLcd con el segmento encendido.
	 */
	public char[][] encenderSegmentoSobreLCD(char[][] digitoLcd){		
		int i = 0;
		while(i<size){
			if (horizontal) {
				digitoLcd[idxFila][idxColumna] = CARACTER_HORIZONTAL;
				i++;
				idxColumna++;
			}else{
				digitoLcd[idxFila][idxColumna] = CARACTER_VERTICAL;
				i++;
				idxFila++;
			}
		}
		return digitoLcd;
	}
	

}
