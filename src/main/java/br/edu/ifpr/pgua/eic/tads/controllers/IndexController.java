package br.edu.ifpr.pgua.eic.tads.controllers;

import br.edu.ifpr.pgua.eic.tads.utils.ProdutoData;
import br.edu.ifpr.pgua.eic.tads.models.Produto;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IndexController {
    
    public Handler get = (Context ctx) -> {
        Map<String, Object> model = new HashMap<>();
        
        // Produtos em destaque
        List<Produto> produtosDestaque = ProdutoData.getProdutosDestaque();
        model.put("produtosDestaque", produtosDestaque);
        
        // Categorias
        model.put("categorias", ProdutoData.getCategorias());
        
        ctx.render("index.html", model);
    };
}

