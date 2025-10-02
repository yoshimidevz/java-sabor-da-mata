package br.edu.ifpr.pgua.eic.tads.db;

import java.sql.Connection;

public class FabricaDeConexoes {
    private FabricaDeConexoes instance;

    private static final String DB_TYPE = "mysql";
    private static final String DB_HOST = "localhost";
    private static final String DB_PORT = "3306";
    private static final String DB_NAME = "ecommerce";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "root";
    private static final String DB_URL = "jdbc:" + DB_TYPE + "://" + DB_HOST + ":" + DB_PORT + "/" + DB_NAME;

    public FabricaDeConexoes(){
    }

    public static FabricaDeConexoes getInstance(){
        if (instance == null){
            instance = new FabricaDeConexoes();
        }
        return instance;
    }

    public static Connection getConnection() throws RuntimeException {
        try {
            return java.sql.DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
