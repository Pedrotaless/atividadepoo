/**
* Para rodar no terminal
* javac Main.java && java Main
* ----------------------------------------------
* Para ativar o conector java
* export CLASSPATH=mysql-connector-j-8.4.0.jar:.
* */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        // Parâmetros de conexão
        String url = "jdbc:mysql://acilab.com.br:3309/db2001";
        String user = "root";
        String password = "admin";

        try {
            // Estabelece a conexão
            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println("Conexão estabelecida com sucesso!");

            // Cria um statement para executar consultas
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM Produtos";
            ResultSet resultSet = statement.executeQuery(query);

            // Processa o resultado
            while (resultSet.next()) {
                System.out.println("=> " + resultSet.getString("Nome"));
            }

            //Fecha os recursos
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}