import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		
		// Criacao dos continentes
		Continente america = new Continente(null, 0, 0);		
		
		// Adicionar nome ao continente
		america.setNome("Am�rica");
		
		// Paises
		Pais brasil = new Pais("Brasil", 207.7);
		Pais estadosUnidos = new Pais("Estados Unidos", 352.7);
		Pais canada = new Pais("Canad�", 36.29);
		Pais mexico = new Pais("M�xico", 127.5);
		Pais argentina = new Pais("Argentina", 43.85);
		Pais guatemala = new Pais("Guatemala", 16.58);
		
		// Adicionar paises ao continente
		america.adicionarPais(brasil);
		america.adicionarPais(estadosUnidos);
		america.adicionarPais(canada);
		america.adicionarPais(mexico);
		america.adicionarPais(argentina);
		america.adicionarPais(guatemala);/*
		america.adicionarPais("Haiti");
		america.adicionarPais("Jamaica");
		america.adicionarPais("Peru");
		america.adicionarPais("Paraguai");
		america.adicionarPais("Uruguai");
		*/
		
		//Retornar nome do pa�s
		System.out.println(america.getNome());
		
		// Retornar total de pa�ses
		System.out.println("Total de Pa�ses: " + america.getTotalPaises());
		
		// Retornar popula��o total
		System.out.println("Popula��o total: " + america.getTotalPopulacao() + " milh�es");
		
		// Retornar pais com maior e menor populacao
		america.compararPaises();
	}

}
