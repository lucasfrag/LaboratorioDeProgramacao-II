package app;

public class Cliente {
    private String cpf, nome, email;
    private Conta conta;

    public Cliente(String cpf, String nome, String email, Conta conta) {
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.conta = conta;
    }

    /* Getters */
    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public Conta getConta() {
        return conta;
    }
    
    /* Setters */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }
    
    
}