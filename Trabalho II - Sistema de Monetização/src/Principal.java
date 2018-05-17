import java.util.ArrayList;
import java.util.Scanner;

import app.Cliente;
import app.Conta;
import app.Produto;
import app.Relatorio;
import app.Usuario;

public class Principal {
	
	private static ArrayList<Cliente> listaClientes = new ArrayList<>();
	private static Produto[] produto = new Produto[20];
	private static Relatorio controleVendas = new Relatorio();
	private	static Conta estabelecimento = new Conta(010203, 1000.00);
	
	public static void main(String[] args) {
		menuCadastrarUser();
		
		//Inicia o programa.
		trocarUser();

	}
	
	private static void menuCadastrarUser() {
		Scanner a = new Scanner(System.in);
		System.out.println("1 - Cadastrar Cliente: ");
		System.out.println("2 - Cadastrar Produto: ");
		System.out.println("3 - Programa Principal: ");
		int e = a.nextInt();
		if(e >3 || e < 1) {
			System.out.println("Valor incorreto");
			menuCadastrarUser();
		}
		switch(e) {
		case 1:
			instanciaUsuario();
			break;
		case 2:
			instanciarProduto();
			break;
		case 3:
			trocarUser();
			break;
		}
		
	}
	private static void instanciarProduto() {
		int codigo;
		String nome;
		double preco;
		Scanner a = new Scanner(System.in);
		System.out.println("Código: ");
		codigo = a.nextInt();
		System.out.println("Nome: ");
		nome = a.next();
		System.out.println("Preço: ");
		preco = a.nextDouble();
		if(isInteger(codigo) && isDouble(preco) && !nome.isEmpty()) {
			cadastraProduto(codigo,nome,preco);
		}else {
			System.out.println("Dados inválidos");
			menuCadastrarUser();
		}
	}
	private static void cadastraProduto(int codigo, String nome, double preco) {
		Produto prod = new Produto(codigo,nome,preco);
		for(int i=0;i<produto.length;i++) {
			if(produto[i] == null) {
				if(verificaProdutoCadastrado(codigo)) {
					produto[i] = new Produto(codigo,nome,preco);
					System.out.println("Cadastrado com sucesso");
					menuCadastrarUser();
				} else {
					System.out.println("Produto não cadastrado");
					menuCadastrarUser();
				}
			}
		}
	}
	
	private static Boolean verificaProdutoCadastrado(int codigo) {
		for(int i=0;i<produto.length;i++) {
			if(produto[i] != null) {
				if(produto[i].getCodigo() == codigo) {
					return false;
				}
			}
		}
		return true;
	}
	
	private static void instanciaUsuario() {
		long cpf;
		String nome, email;
		int conta;
		
		Scanner a = new Scanner(System.in);
		System.out.println("CPF: ");
		cpf = a.nextInt();
		System.out.println("Nome: ");
		nome = a.next();
		System.out.println("E-mail: ");
		email = a.next();
		System.out.println("Número da Conta: ");
		conta = a.nextInt();
		if(isInteger(cpf) && !nome.isEmpty() && !email.isEmpty() && isInteger(conta)) {
			cadastraCliente(cpf,nome,email,conta);
		}else {
			System.out.println("Dados inválidos");
			menuCadastrarUser();
			
		}
	}
	
	/* Verifica se o cliente já foi antes cadastrado*/
	private static Boolean verificaClienteCadastrado(long cpf) {
		for(int i=0; i<listaClientes.size(); i++) {
			if(listaClientes.get(i) != null) {
				if(listaClientes.get(i).getCpf() == cpf) {
					return false;
				}
			}
		}
		return true;
	}
	
	/* Após verificar se o cliente existe, cadastra o mesmo*/
	private static void cadastraCliente(long cpf, String nome, String email, int numeroConta) {
		Usuario user = new Usuario(321, "usuario", "PoA");
		Conta conta = new Conta(numeroConta, 0.0);
		Cliente cliente = new Cliente(cpf, nome, email, conta);

		for(int i=0;i < listaClientes.size();i++) {
			if(listaClientes.get(i) == null) {
				if(verificaClienteCadastrado(cpf)) {
					listaClientes.add(cliente);
					System.out.println("Cadastrado com sucesso");
					menuCadastrarUser();
					}else {
					System.out.println("Cliente não cadastrado");
					menuCadastrarUser();
				}
			}
		}
	}
	
	/* Inicia o programa e chama os restantes */
	private static void trocarUser() {

		Scanner a = new Scanner(System.in);
		System.out.println("Digite seu CPF: ");
		int cpf = a.nextInt();
		
		verificaCliente(listaClientes,cpf);
	}
	
	/* Verifica qual cliente esta acessando */
	private static void verificaCliente(ArrayList<Cliente> listaClientes, int cpf) {
		for(int i=0;i<listaClientes.size(); i++) {
			if(listaClientes.get(i) == null) {
				System.out.println("Cliente não cadastrado");
				break;
			} else {
				if(listaClientes.get(i).getCpf() == cpf){
					mainProgram(listaClientes.get(i),controleVendas);
				}
			}
		}
	}
	/* Menu */
	private static void mainProgram(Cliente cliente, Relatorio controleVendas) {
		System.out.println("Nome: " + cliente.getNome());
		Scanner e = new Scanner(System.in);
		int define = 0;
		while(define == 0){
			System.out.println("----MAIN MENU-----");
			System.out.println("1 - Verificar Extrato: ");
			System.out.println("2 - Realizar Deposito: ");
			System.out.println("3 - Realizar Saque: ");
			System.out.println("4 - Comprar: ");
			System.out.println("5 - Sair: ");
			System.out.println("6 - Historico:");
			System.out.println("7 - Mudar usuario:");
			System.out.println("8 - Voltar ao inicio:");
			int num = e.nextInt();
			if(num > 8 || num < 1) {
				System.out.println("Valor incorreto");
				mainProgram(cliente,controleVendas);
			}
			if(num == 5) { // Para parar o programa
				define = -1;
				System.out.println("----FIM----");
				return;
			}
			int op=0;
			double oper=0;
			switch(num) {
			case 1:
				System.out.println("Digite seu CPF: ");
				op = e.nextInt();
				if(op == cliente.getCpf()){
					cliente.getConta().visualizarSaldo(cliente.getConta());;
				}else {
					System.out.println("CPF inválido.");
				}
				break;
			case 2:
				System.out.println("Digite seu CPF: ");
				op = e.nextInt();
				System.out.println("Digite o valor: ");
				oper = e.nextDouble();
				if(op == cliente.getCpf()){
					cliente.getConta().deposito(oper);
				} else {
					System.out.println("CPF inválido.");
				}
				break;
			case 3:
				System.out.println("Digite seu CPF: ");
				op = e.nextInt();
				System.out.println("Digite o valor: ");
				oper = e.nextDouble();
				if(op == cliente.getCpf()){
					cliente.getConta().transferencia(estabelecimento, oper);
				}else {
					System.out.println("CPF inválido.");
				}
				break;
			case 4:
				System.out.println("Digite seu CPF: ");
				op = e.nextInt();
				if(verificaSeExisteProdutos()){
					comprar(op,cliente,controleVendas);
				}else {
					System.out.println("Nao existe produtos cadastrados.");
				}
				break;
			case 6:
				historicoVendas(cliente, controleVendas);
				break;
			case 7:
				trocarUser();
				break;
			case 8:
				menuCadastrarUser();
				break;
			}
			
		}
	}
	
	private static Boolean verificaSeExisteProdutos() {
		if(produto[0]==null) {
			return false;
		}
		return true;
		
	}
	//metodo para chamar os historicos de vendas.
	private static void historicoVendas(Cliente cliente, Relatorio controleVendas) {
		Scanner a = new Scanner(System.in);
		System.out.println("1 - Cliente que mais compra: ");
		System.out.println("2 - Achar Cliente na Lista: ");
		int abc = a.nextInt();
		if(abc > 2 || abc < 1) {
			System.out.println("Valor incorreto");
			historicoVendas(cliente,controleVendas);
		}
		switch(abc) {
		case 1:
			controleVendas.clienteQueMaisComprou();
			break;
		case 2:
			System.out.print("Sr(a) ");
			controleVendas.clienteRealizaMonetizacao(cliente);
			break;
		}
	}

	// metodo para utilizar a ferramenta de compra
	private static void comprar(int verif, Cliente cliente, Relatorio controleVendas) {

		for(int i=0;i<produto.length;i++) {
			if(produto[i] != null) {
				System.out.println("Digite o codigo do produto: ");
				System.out.println("Codigo: "+ i + " - Produto : "+produto[i].getNome() 
						+ " Preco: " + produto[i].getPreco());
			}else {
				break;
			}
		}
		
		Scanner b = new Scanner(System.in);
		int operador = b.nextInt();
		if(cliente.getCpf() == verif){
			switch(operador) {
				case 0:
					cliente.getConta().transferencia(cliente.getConta(), produto[operador].getPreco());
					controleVendas.addVenda(produto[operador], cliente);
					mainProgram(cliente,controleVendas);
					return;
				case 1:
					cliente.getConta().transferencia(cliente.getConta(),produto[operador].getPreco());
					controleVendas.addVenda(produto[operador], cliente);
					mainProgram(cliente,controleVendas);
					return;
				case 2:
					cliente.getConta().transferencia(cliente.getConta(), produto[operador].getPreco());
					controleVendas.addVenda(produto[operador], cliente);
					mainProgram(cliente,controleVendas);
					return;
				case 3:
					cliente.getConta().transferencia(cliente.getConta(), produto[operador].getPreco());
					controleVendas.addVenda(produto[operador], cliente);
					mainProgram(cliente,controleVendas);
					return;
				case 4:
					cliente.getConta().transferencia(cliente.getConta(), produto[operador].getPreco());
					controleVendas.addVenda(produto[operador], cliente);
					mainProgram(cliente,controleVendas);
					return;
			}
		
		}
		
	}
	public static boolean isInteger(Object object) {
		if(object instanceof Integer) {
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
		if(object instanceof Double) {
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