package fabricaDeConexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexaoBD {
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/bd_detection";
    private static final String USUARIO = "root";
    private static final String SENHA = "root";
    
    public static Connection getConnection() {
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USUARIO, SENHA);
        } catch (ClassNotFoundException | SQLException ex) {
            throw new RuntimeException("Erro de conexão:" + ex);
        }
    }
    
    public static void closeConnection(Connection connection, PreparedStatement stmt) {
        if(connection != null && stmt != null) {
            try {
                connection.close();
                stmt.close();
            } catch (SQLException ex) {
                System.out.println("Erro ao fechar conexão: " + ex.getMessage());
            }
        }
    }
    
    public static void closeConnection(Connection connection, PreparedStatement stmt, ResultSet rs) {
        if(connection != null && stmt != null && rs != null) {
            try {
                connection.close();
                stmt.close();
                rs.close();
            } catch (SQLException ex) {
                System.out.println("Erro ao fechar conexão: " + ex.getMessage());
            }
        }
    }
    
    
}
