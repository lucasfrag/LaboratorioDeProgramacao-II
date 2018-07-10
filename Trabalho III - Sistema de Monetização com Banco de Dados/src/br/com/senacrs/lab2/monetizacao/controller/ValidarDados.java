package br.com.senacrs.lab2.monetizacao.controller;

public class ValidarDados {

	public static void verificaString(String string) {
		System.out.println("Validando dados informados...");
		if (isString(string) != true) {
			System.out.println("O valor informado não é aceito. Operação abortada!");
			return;
		}
	}
	
	public static void verificaInteger(Object object) {
		System.out.println("Validando dados informados...");
		if (isInteger(object) != true) {
			System.out.println("O valor informado não é aceito. Operação abortada!");
			return;
		}
	}
	
	public static void verificaLong(Object object) {
		System.out.println("Validando dados informados...");
		if (isLong(object) != true) {
			System.out.println("O valor informado não é aceito. Operação abortada!");
			return;
		}
		
	}
	
	public static void verificaDouble(Object object) {
		if (isDouble(object) != true) {
			System.out.println("O valor informado não é aceito. Operação abortada!");
			return;
		}
	}
	
	
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
	
	public static boolean isLong(Object object) {
		if (object instanceof Long) {
			return true;
		} else {
			String string = object.toString();
			
			try {
				Long.parseLong(string);
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
	
	public static boolean isString(String string) {
	    char[] c = string.toCharArray();
	    boolean d = true;
	    for ( int i = 0; i < c.length; i++ ) {
	        if ( !Character.isDigit( c[ i ] ) ) {
	            d = false;
	            break;
	        }
	    }
	    return d;
	}
}
