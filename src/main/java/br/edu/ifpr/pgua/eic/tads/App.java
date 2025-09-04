package br.edu.ifpr.pgua.eic.tads;

import br.edu.ifpr.pgua.eic.tads.controllers.IndexController;
import br.edu.ifpr.pgua.eic.tads.models,Produto;
import io.javalin.Javalin;

/**
 * Hello world!
 *
 */
public class App {
    // public static ArrayList<Produto> bdProdutos = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("Hello world!");

        Javalin app = Javalin.create().start(7070);

        app.get("/tads24", ctx -> ctx.result("TADS24 EH TOP"));
    }
}
