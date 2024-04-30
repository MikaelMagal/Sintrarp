package main.myapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        Connection connection = null;
        try {
            // Carregar o driver JDBC do PostgreSQL
            Class.forName("org.postgresql.Driver");

            // Configurar os parâmetros de conexão
            String url = "jdbc:postgresql://localhost:5432/ficha_sintrarp";
            String user = "postgres";
            String password = "Mikael2012";

            // Estabelecer a conexão com o banco de dados
            connection = DriverManager.getConnection(url, user, password);

            // Se a conexão for bem-sucedida, você pode realizar operações no banco de dados aqui
            System.out.println("Conexão estabelecida com sucesso!");

            // Não se esqueça de fechar a conexão quando terminar de usá-la
            connection.close();
        } catch (ClassNotFoundException e) {
            System.out.println("Driver PostgreSQL não encontrado. Certifique-se de incluir o driver JDBC em seu classpath.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Erro ao estabelecer a conexão com o banco de dados.");
            e.printStackTrace();
        } finally {
            // Certifique-se de fechar a conexão no bloco finally para garantir que ela seja sempre fechada, mesmo se ocorrer uma exceção.
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}