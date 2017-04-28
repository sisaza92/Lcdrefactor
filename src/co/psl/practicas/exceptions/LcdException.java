package co.psl.practicas.exceptions;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class LcdException extends Exception {

	private static final long serialVersionUID = -3905567986648395680L;
	
	private final Logger LOG = LogManager.getLogger(this.getClass().getName());

	public LcdException(String mensaje) {
		super(mensaje);
		LOG.error("Error: " + mensaje);
	}
	
	
}
