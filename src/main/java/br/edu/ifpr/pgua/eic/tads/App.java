package br.edu.ifpr.pgua.eic.tads;

import io.javalin.Javalin;

/**
 * Hello world!
 *
 */
public class App {
    // public static ArrayList<Produto> bdProdutos = new ArrayList<>();

    public static void main(String[] args) {
        Javalin app = Javalin.create(config -> {
            config.staticFiles.add(staticFiles->{
                staticFiles.directory = "/public";
                staticFiles.location = io.javalin.http.staticfiles.Location.CLASSPATH;
            });
        }).start(8080);

        app.get("/", ctx ->{
            ctx.redirect("/index.html");
        });
    }
}
