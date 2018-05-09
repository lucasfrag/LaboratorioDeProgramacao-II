
public class Conta {
    private int numero;
    private double saldo;

    public Conta(int numero, double saldo) {
        this.numero = numero;
        this.saldo = saldo;
    }
    
    public void visualizarSaldo(Conta conta) {
        conta.getSaldo();
    }
    
    public void transferencia(Conta conta, double valor) {
    	 if (saldo >= valor) {
    		 saldo = saldo - valor;
    		 conta.saldo = saldo + valor;
    	 } else {
    		 System.out.println("Saldo insuficiente para realizar opera��o!");
    	 }
    }
    
    public void deposito(double valor) {
        if (valor > 0) {
        	saldo = saldo + valor;
            System.out.println("Dep�sito realizado com sucesso!");
        } else {
        	System.out.println("Valor inv�lido!");
        }
    	
    }
    
    /* Getters */
    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }
    
    /* Setters */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    
}