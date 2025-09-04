package br.edu.ifpr.pgua.eic.tads.models;

import br.edu.ifpr.pgua.eic.tads.App;
import br.edu.ifpr.pgua.eic.tads.models.Produto;

public class Administrador extends Usuario{

    public Administrador(String email, String nome) {
        super(email, nome);
    }

    public Boolean cadastrarProduto(Produto newProduto){
        if (newProduto == null) return false;

        // App.bdProdutos.add(newProduto);
        return true;
    }
}
