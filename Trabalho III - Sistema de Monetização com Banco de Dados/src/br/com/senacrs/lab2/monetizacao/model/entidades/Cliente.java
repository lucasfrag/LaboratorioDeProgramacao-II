package br.com.senacrs.lab2.monetizacao.model.entidades;

public class Cliente {
    private String nome, email;
    private long cpf;
    private Conta conta;

    public Cliente(long cpf, String nome, String email, Conta conta) {
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.conta = conta;
    }

    /* Getters */
    public long getCpf() {
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
    public void setCpf(long cpf) {
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