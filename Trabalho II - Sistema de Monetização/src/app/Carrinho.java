package app;
import java.util.ArrayList;

public class Carrinho {
	ArrayList<Produto> listaProdutos;
    double valor;

    public Carrinho(ArrayList<Produto> listaProdutos, double valor) {
        this.listaProdutos = listaProdutos;
        this.valor = valor;
    }
    
    public void verTotal() {
    	System.out.println("O total do carrinho é: R$" + getValor());
    	System.out.println();
    }
        
    public void adicionarProduto(Produto produto, int quantidade) {
        for(int i = 0; i > quantidade; i++) {
        	listaProdutos.add(produto);
        }
        valor = valor + produto.getPreco() * quantidade;
        System.out.println(quantidade + " " + produto.getNome() + " adicionado com sucesso!");
    }
    
    public void removerProduto(Produto produto, int quantidade) {
    	for(int i = 0; i > quantidade; i++) {
    		if(listaProdutos.get(i) == produto) {
    			listaProdutos.remove(listaProdutos.get(i));
    		}
    	}
    	valor = valor - produto.getPreco() * quantidade;
    	System.out.println(quantidade + " " + produto.getNome() + " removido com sucesso!");
    	System.out.println();
    }
    
    public void concluirCompra(Cliente cliente, Conta estabelecimento) {
        if (cliente.getConta().getSaldo() > valor) {
        	cliente.getConta().transferencia(estabelecimento, valor);
        	System.out.println("Compra concluida com sucesso!");
        	System.out.println();
        } else {
        	System.out.println("A compra não pode ser concluida!");
        	System.out.println();
        }
    	
    }
    
    /* Getters */
    public ArrayList<Produto> getListaProdutos() {
        return listaProdutos;
    }

    public double getValor() {
        return valor;
    }

    /* Setters */
    public void setListaProdutos(ArrayList<Produto> listaProdutos) {
        this.listaProdutos = listaProdutos;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    
    
    
}