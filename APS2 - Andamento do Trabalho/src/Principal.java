import java.util.ArrayList;

public class Principal {

	public static void main(String[] args) {
		Conta estabelecimento = new Conta(010203, 1000.00);

        /* Criando cliente e conta */
        Conta conta = new Conta(1234, 0.0);
        Cliente cliente = new Cliente("43132154", "Fulano", "algumacoisa@gmail.com", conta);
        
        /* Adicionando alguns pilas na conta do cliente e mudando e-mail*/
        cliente.getConta().deposito(500.00);
        cliente.setEmail("cliente.não.tem.email@gmail.com");
        
        /* Buscando dados do cliente */
        System.out.println("CPF: " + cliente.getCpf() + " | Nome: " + cliente.getNome() + " | E-mail: " + cliente.getEmail() + " | Saldo: R$" + cliente.getConta().getSaldo());
        System.out.println();
        
        /* Criando alguns produtos */
        Produto produto1 = new Produto(1, "Produto 1", 50.00);
        Produto produto2 = new Produto(2, "Produto 2", 29.00);

        /* Buscando dados de produtos */
        System.out.println("Produtos: ");
        System.out.println("Código: " + produto1.getCodigo() + " | Nome: " + produto1.getNome() + " | Valor: R$"+ produto1.getPreco());
        System.out.println("Código: " + produto2.getCodigo() + " | Nome: " + produto2.getNome() + " | Valor: R$"+ produto2.getPreco());
        System.out.println();
        
        /* Alterando alguns dados */
        produto1.setCodigo(5);
        produto1.setNome("Produto 5");
        produto1.setPreco(499.99);
            
        /* Buscando dados dos produtos agora atualizados*/
        System.out.println("Produtos atualizados:");
        System.out.println("Código: " + produto1.getCodigo() + " | Nome: " + produto1.getNome() + " | Valor: R$"+ produto1.getPreco());
        System.out.println("Código: " + produto2.getCodigo() + " | Nome: " + produto2.getNome() + " | Valor: R$"+ produto2.getPreco());
        
        
	}

}
