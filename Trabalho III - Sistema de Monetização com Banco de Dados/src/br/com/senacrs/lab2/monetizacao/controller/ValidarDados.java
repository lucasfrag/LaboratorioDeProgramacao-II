package br.com.senacrs.lab2.monetizacao.controller;

public class ValidarDados {

	/* Validações */
	public static boolean isInteger(Object object) {
		if (object instanceof Integer) {
			return true;
		} else {
			String string = object.toString();
			
			try {
				Integer.parseInt(string);
			} catch(Exception e) {
				return false;
			}	
		}
		
	    return true;
	}
	
	public static boolean isDouble(Object object) {
		if (object instanceof Double) {
			return true;
		} else {
			String string = object.toString();
			
			try {
				Double.parseDouble(string);
			} catch(Exception e) {
				return false;
			}	
		}
		
	    return true;
	}
	
}
