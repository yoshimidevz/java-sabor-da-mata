package br.edu.ifpr.pgua.eic.tads.models;

public class Produto {
    private String nome;
    private double preco;  
    private Integer estoque;

    public Produto(String nome, double preco, Integer suply) {
        this.nome = nome;
        this.preco = preco;
        this.estoque = 0;
    }
    @Override
    public String toString() {
        return this.nome + " - " + this.preco;
    }
}
