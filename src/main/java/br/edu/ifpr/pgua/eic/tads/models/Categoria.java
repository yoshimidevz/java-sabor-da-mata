package br.edu.ifpr.pgua.eic.tads.models;

public class Categoria {
    private String nome;
    private String imagem;
    private String descricao;
    private String link;
    
    public Categoria(String nome, String imagem, String descricao, String link) {
        this.nome = nome;
        this.imagem = imagem;
        this.descricao = descricao;
        this.link = link;
    }
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getImagem() {
        return imagem;
    }
    
    public void setImagem(String imagem) {
        this.imagem = imagem;
    }
    
    public String getDescricao() {
        return descricao;
    }
    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public String getLink() {
        return link;
    }
    
    public void setLink(String link) {
        this.link = link;
    }
}

