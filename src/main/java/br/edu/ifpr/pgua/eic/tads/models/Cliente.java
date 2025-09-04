package br.edu.ifpr.pgua.eic.tads.models;

import java.util.ArrayList;
import br.edu.ifpr.pgua.eic.tads.models.Produto;

public class Cliente extends Usuario{

    private Carrinho carrinho;

    public Cliente(String email, String nome) {
        super(email, nome);
    }

    public void setCarrinho(Carrinho carrinho){
        this.carrinho = carrinho;
    }

    public boolean adicionarProdutoCarrinho(Produto newProduto){
        if (newProduto == null) {
            return false;
        }
        return this.carrinho.getProdutos().add(newProduto);
    }
}
