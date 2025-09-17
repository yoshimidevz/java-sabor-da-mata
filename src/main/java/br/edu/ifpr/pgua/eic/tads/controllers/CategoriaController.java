package br.edu.ifpr.pgua.eic.tads.controllers;

import br.edu.ifpr.pgua.eic.tads.models.Produto;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CategoriaController {
    
    // Lista de produtos mockados (em uma aplicação real, viria do banco de dados)
    private static List<Produto> produtos = new ArrayList<>();
    
    static {
        // Inicializa produtos de exemplo
        produtos.add(new Produto("1", "Geleia de Juçara", "geleia", 24.90, 
            "Geleia artesanal feita com 100% de polpa de juçara nativa da Mata Atlântica", 
            "/images/produto-geleia-jucara.jpg"));
        produtos.add(new Produto("2", "Geleia de Pitanga", "geleia", 22.90, 
            "Doce sabor da pitanga em uma geleia cremosa e natural", 
            "/images/produto-geleia-pitanga.jpg"));
        produtos.add(new Produto("3", "Geleia de Cambuci", "geleia", 26.90, 
            "Geleia exclusiva feita com cambuci, fruta rara da Mata Atlântica", 
            "/images/produto-geleia-cambuci.jpg"));
        produtos.add(new Produto("4", "Geleia de Uvaia", "geleia", 23.90, 
            "Geleia doce e aromática de uvaia, perfeita para acompanhar pães e bolos", 
            "/images/produto-geleia-uvaia.jpg"));
        produtos.add(new Produto("5", "Polpa de Cambuci", "polpa", 18.50, 
            "Polpa congelada pura de cambuci, fruta típica da região sudeste", 
            "/images/produto-polpa-cambuci.jpg"));
        produtos.add(new Produto("6", "Pitanga Desidratada", "desidratado", 15.90, 
            "Pitangas desidratadas naturalmente, sem conservantes ou açúcar adicionado", 
            "/images/produto-pitanga-desidratada.jpg"));
        produtos.add(new Produto("7", "Picolé de Uvaia", "picole", 8.50, 
            "Picolé artesanal de uvaia, fruta doce e aromática da Mata Atlântica", 
            "/images/produto-picole-uvaia.jpg"));
    }
    
    public Handler getGeleias = (Context ctx) -> {
        Map<String, Object> model = new HashMap<>();
        
        // Filtra produtos da categoria geleia
        List<Produto> geleias = produtos.stream()
            .filter(p -> "geleia".equals(p.getCategoria()))
            .collect(Collectors.toList());
        
        model.put("categoria", "Geleias");
        model.put("descricaoCategoria", "Sabores únicos das frutas nativas da Mata Atlântica transformados em geleias cremosas e naturais");
        model.put("produtos", geleias);
        model.put("imagemBanner", "/images/category-geleias.jpg");
        
        ctx.render("categoria.html", model);
    };
    
    public Handler getPolpas = (Context ctx) -> {
        Map<String, Object> model = new HashMap<>();
        
        List<Produto> polpas = produtos.stream()
            .filter(p -> "polpa".equals(p.getCategoria()))
            .collect(Collectors.toList());
        
        model.put("categoria", "Polpas");
        model.put("descricaoCategoria", "Polpas congeladas 100% naturais das melhores frutas da Mata Atlântica");
        model.put("produtos", polpas);
        model.put("imagemBanner", "/images/category-polpas.jpg");
        
        ctx.render("categoria.html", model);
    };
    
    public Handler getDesidratados = (Context ctx) -> {
        Map<String, Object> model = new HashMap<>();
        
        List<Produto> desidratados = produtos.stream()
            .filter(p -> "desidratado".equals(p.getCategoria()))
            .collect(Collectors.toList());
        
        model.put("categoria", "Desidratados");
        model.put("descricaoCategoria", "Frutas desidratadas sem conservantes, mantendo todo o sabor natural");
        model.put("produtos", desidratados);
        model.put("imagemBanner", "/images/category-desidratados.jpg");
        
        ctx.render("categoria.html", model);
    };
    
    public Handler getPicoles = (Context ctx) -> {
        Map<String, Object> model = new HashMap<>();
        
        List<Produto> picoles = produtos.stream()
            .filter(p -> "picole".equals(p.getCategoria()))
            .collect(Collectors.toList());
        
        model.put("categoria", "Picolés");
        model.put("descricaoCategoria", "Picolés artesanais refrescantes feitos com frutas nativas");
        model.put("produtos", picoles);
        model.put("imagemBanner", "/images/category-picoles.jpg");
        
        ctx.render("categoria.html", model);
    };
}

