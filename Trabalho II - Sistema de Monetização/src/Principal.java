import java.util.ArrayList;

import app.Carrinho;
import app.Cliente;
import app.Conta;
import app.Produto;

public class Principal {
    public static void main(String[] args) {
        
        /* Criando cliente, conta, produto e carrinho */
        Conta conta = new Conta(1234, 0.0);
        Cliente cliente = new Cliente("CPF", "Fulano", "algumacoisa@gmail.com", conta);
        
        ArrayList<Produto> listaProdutos = new ArrayList();
        Conta estabelecimento = new Conta(010203, 1000.00);
        Carrinho carrinho = new Carrinho(listaProdutos, 0);

        /* Adicionando alguns pilas na conta do cliente */
        conta.deposito(500.00);

        /* Adicionando alguns produtos */
        Produto produto1 = new Produto(1, "Processador barato", 50.00);
        Produto produto2 = new Produto(2, "Memória de 8° mão", 29.00);
        Produto produto3 = new Produto(3, "Pen Drive pra usar de HD", 39.00);

        /* Cliente adiciona produto sem carrinho */
        carrinho.adicionarProduto(produto1, 5);
        carrinho.adicionarProduto(produto2, 5);
        carrinho.adicionarProduto(produto3, 5);
        
        /* Total da compra */
        carrinho.verTotal();;
        
        /* Cliente remove um produto */
        carrinho.removerProduto(produto1, 2);
        
        /* Total da compra */
        carrinho.verTotal();;

        /* Cliente conclui carrinho e realiza pagamento */
        carrinho.concluirCompra(cliente, estabelecimento);
    }
}