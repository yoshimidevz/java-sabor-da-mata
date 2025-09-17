package br.edu.ifpr.pgua.eic.tads.utils;

import br.edu.ifpr.pgua.eic.tads.models.Produto;
import br.edu.ifpr.pgua.eic.tads.models.Categoria;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ProdutoData {
    
    public static List<Produto> getProdutosDestaque() {
        List<Produto> produtos = new ArrayList<>();
        
        produtos.add(new Produto("1", "Geleia de Juçara", "geleia", 24.90, 
            "Geleia artesanal feita com 100% de polpa de juçara nativa da Mata Atlântica", 
            "/images/produto-geleia-jucara.jpg"));
            
        produtos.add(new Produto("2", "Polpa de Cambuci", "polpa", 18.50,
            "Polpa congelada pura de cambuci, fruta típica da região sudeste",
            "/images/produto-polpa-cambuci.jpg"));
            
        produtos.add(new Produto("3", "Pitanga Desidratada", "desidratado", 15.90,
            "Pitangas desidratadas naturalmente, sem conservantes ou açúcar adicionado",
            "/images/produto-pitanga-desidratada.jpg"));
            
        produtos.add(new Produto("4", "Picolé de Uvaia", "picole", 8.50,
            "Picolé artesanal de uvaia, fruta doce e aromática da Mata Atlântica",
            "/images/produto-picole-uvaia.jpg"));
            
        return produtos;
    }
    
    public static List<Produto> getTodosProdutos() {
        List<Produto> produtos = getProdutosDestaque();
        
        // Adicionar mais produtos para a loja
        produtos.add(new Produto("gel-2", "Geleia de Pitanga", "geleia", 22.90,
            "Doce sabor da pitanga em uma geleia cremosa e natural",
            "/images/produto-geleia-jucara.jpg"));
            
        produtos.add(new Produto("gel-3", "Geleia de Cambuci", "geleia", 26.90,
            "Geleia exclusiva feita com cambuci, fruta rara da Mata Atlântica",
            "/images/produto-geleia-jucara.jpg"));
            
        produtos.add(new Produto("gel-4", "Geleia de Uvaia", "geleia", 23.90,
            "Geleia doce e aromática de uvaia, perfeita para acompanhar pães e bolos",
            "/images/produto-geleia-jucara.jpg"));
            
        return produtos;
    }
    
    public static List<Produto> getProdutosPorCategoria(String categoria) {
        List<Produto> todosProdutos = getTodosProdutos();
        List<Produto> produtosFiltrados = new ArrayList<>();
        
        for (Produto produto : todosProdutos) {
            if (produto.getCategoria().equals(categoria)) {
                produtosFiltrados.add(produto);
            }
        }
        
        return produtosFiltrados;
    }
    
    public static List<Categoria> getCategorias() {
        List<Categoria> categorias = new ArrayList<>();
        
        categorias.add(new Categoria("Geleias", "/images/category-geleias.jpg",
            "Geleias artesanais com frutas nativas", "/categoria/geleias"));
            
        categorias.add(new Categoria("Polpas", "/images/category-polpas.jpg",
            "Polpas congeladas 100% naturais", "/categoria/polpas"));
            
        categorias.add(new Categoria("Desidratados", "/images/category-desidratados.jpg",
            "Frutas desidratadas sem conservantes", "/categoria/desidratados"));
            
        categorias.add(new Categoria("Picolés", "/images/category-picoles.jpg",
            "Picolés artesanais refrescantes", "/categoria/picoles"));
            
        return categorias;
    }

    public static List<Produto> buscarProdutos(String categoria, String busca, String ordenacao) {
        List<Produto> produtos = getTodosProdutos();
        List<Produto> produtosFiltrados = new ArrayList<>();

        // Filtrar por categoria
        if (categoria != null && !categoria.isEmpty() && !categoria.equalsIgnoreCase("all")) {
            produtos = produtos.stream()
                .filter(p -> p.getCategoria().equalsIgnoreCase(categoria))
                .collect(Collectors.toList());
        }

        // Filtrar por busca (nome ou descrição)
        if (busca != null && !busca.isEmpty()) {
            String buscaLower = busca.toLowerCase();
            produtos = produtos.stream()
                .filter(p -> p.getNome().toLowerCase().contains(buscaLower) || 
                             p.getDescricao().toLowerCase().contains(buscaLower))
                .collect(Collectors.toList());
        }

        // Ordenar
        if (ordenacao != null && !ordenacao.isEmpty()) {
            if (ordenacao.equalsIgnoreCase("asc")) {
                Collections.sort(produtos, Comparator.comparingDouble(Produto::getPreco));
            } else if (ordenacao.equalsIgnoreCase("desc")) {
                Collections.sort(produtos, Comparator.comparingDouble(Produto::getPreco).reversed());
            }
        }

        return produtos;
    }
}