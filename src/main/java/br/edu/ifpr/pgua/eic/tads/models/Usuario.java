package br.edu.ifpr.pgua.eic.tads.models;

public class Usuario {
    private String username;
    private String email;

    public Usuario(String username, String email) {
        this.username = username;
        this.email = email;
    }

    @Override
    public String toString() {
        return "User:" + this.username + ", Email" + this.email;
                
    }  
}
