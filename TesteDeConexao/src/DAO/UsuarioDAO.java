package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;

import fabricaDeConexao.ConexaoBD;
import model.Usuario;

public class UsuarioDAO {
    
    public void createUsuario(Usuario usuario) {
        
        Connection connection = new ConexaoBD().getConnection();
        PreparedStatement stmt = null;
        
        String insert = "INSERT INTO usuario(nome, email, senha) VALUES (?, ?, ?)";
        
    }
    
}
