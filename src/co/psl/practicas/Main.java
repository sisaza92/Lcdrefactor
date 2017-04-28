package co.psl.practicas;

import java.util.Scanner;

import co.psl.practicas.Display;
import co.psl.practicas.exceptions.LcdException;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Scanner lector = new Scanner(System.in);
			System.out.println("Ingrese el numero de Espacios entre Impresiones");
			String espacios = lector.nextLine();
			int nroEspacios = Integer.parseInt(espacios);
			
			System.out.print("Entrada: ");
			String linea = lector.nextLine();
			lector.close();
			String[] comandos = linea.split(" ");
			for (int i = 0; i < comandos.length; i++) {
				String strComando = comandos[i].trim();
				//System.err.println(strComando);
				if(!"0,0".equalsIgnoreCase(strComando)){
					String[] comando = strComando.split(",");
					int size = Integer.parseInt(comando[0]);
					String numeros = comando[1];
					
					Display display = new Display(size,numeros,nroEspacios);
					display.encender();					
					
				}else{
					break;
				}
				
				
				
			}
			
		} catch (LcdException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
