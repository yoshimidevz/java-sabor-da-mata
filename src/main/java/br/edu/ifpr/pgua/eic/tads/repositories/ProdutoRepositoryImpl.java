package br.edu.ifpr.pgua.eic.tads.repositories;
import br.edu.ifpr.pgua.eic.tads.interfaces.ProdutoInterface;
import br.edu.ifpr.pgua.eic.tads.models.Produto;

public class ProdutoRepositoryImpl implements ProdutoInterface {
    String con;
    @Override
    public void save(Produto produto){  
        System.out.println("Salvo no banco de dados");
        if (con != null) {
            String query = "INSERT INTO produtos (id, nome, categoria, preco, descricao, imagem) VALUES ('"+produto.getId()+"', '"+produto.getNome()+"', '"+produto.getCategoria()+"', "+produto.getPreco()+", '"+produto.getDescricao()+"', '"+produto.getImagem()+"')";
        }
    }
}
