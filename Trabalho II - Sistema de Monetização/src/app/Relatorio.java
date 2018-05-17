package app;

import java.util.ArrayList;

public class Relatorio {
	ArrayList<Produto> produtosVendidos = new ArrayList();
	ArrayList<Cliente> clienteQueComprou = new ArrayList();
	
	public void addVenda(Produto produto, Cliente cliente) {
		produtosVendidos.add(produto);
		clienteQueComprou.add(cliente);
	}
	
	public void produtoMaisVendido() {
		
	}
	
	public Cliente clienteQueMaisComprou() {
		int temp = -1;
		int[] count = new int[clienteQueComprou.size()];
		for(int i=0;i<clienteQueComprou.size();i++) {
			for(int j=0;j<clienteQueComprou.size();j++) {
				if(clienteQueComprou.get(i).getCpf() == clienteQueComprou.get(j).getCpf() ) {
					count[i]++;
				}
			}
		}
		temp = verificaQualMaiorValorVetor(count);
		if(temp < 0) {
			return null;
		}
		System.out.println(clienteQueComprou.get(temp).getNome());
		return clienteQueComprou.get(temp);
	}
	
	private int verificaQualMaiorValorVetor(int[] count) {
		int temp = 0;
		int index = -1;
		for(int i=0;i<count.length;i++) {
			if(count[i] > temp) {
				temp = count[i];
				index = i;
			}
		}
		if(temp == 0) {
			System.out.println("Nenhum cliente comprou.");
		}
		return index;
	}
	
	public Cliente clienteRealizaMonetizacao(Cliente cliente) {
		if(clienteQueComprou.contains(cliente)) {
			System.out.print(cliente.getNome() + "ja eh cliente.");
			return cliente;
		} else {
			System.out.println("Cliente não esta na lista.");
			return null;
		}
}
}
