package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class ConnectionFactory {
    private String usuario = "root";
    private String senha = "passwd";
    private String host = "localhost";
    private String porta = "3306";
    private String timezone = "America/Sao_Paulo";
    private String bd = "Clinica";

    public Connection connect() {
        try {
            String url = "jdbc:mysql://" + host + ":" + porta + "/" + bd + "?serverTimezone=" + timezone;
            Connection conectar = DriverManager.getConnection(url, usuario, senha);
            if (conectar != null) {
                System.out.println("Conexão estabelecida com sucesso");
            }
            return conectar;
        } catch (SQLException e) {
            System.out.println("Erro ao estabelecer a conexão com o banco.");
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {

        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.connect();

        if (connection != null) {
            System.out.println("Conexão testada e aprovada.");
        } else {
            System.out.println("Falha na conexão.");
        }
    }
}