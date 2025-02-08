package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;

import fabricaDeConexao.ConexaoBD;
import model.Usuario;

public class UsuarioDAO {
    
    Usuario userInfo = new Usuario();
    
    public void createUsuario(Usuario usuario) {
        Connection connection = new ConexaoBD().getConnection();
        PreparedStatement stmt = null;
            
        String insert = "INSERT INTO usuario(nome, email, senha) VALUES (?, ?, ?)";
        try {
            stmt = connection.prepareStatement(insert);
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getEmail());
            stmt.setString(3, usuario.getSenha());
            
            stmt.executeUpdate();
            System.out.println("Usuario criado!");
        } catch (SQLException ex) {
            System.err.println("Erro ao inserir usuario no banco: " + ex.getMessage());
        } finally {
             ConexaoBD.closeConnection(connection, stmt);
        }
        
    }
    
    public void updateUsuario(Usuario usuario) {

        Connection connection = new ConexaoBD().getConnection();
        PreparedStatement stmt = null;

        String update = "UPDATE usuario SET nome = ?, email = ?, senha = ? WHERE id = ?";
            
        try {    
            stmt = connection.prepareStatement(update);
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getEmail());
            stmt.setString(3, usuario.getSenha());
            stmt.setInt(4, usuario.getId());
            
            stmt.executeUpdate();
            System.out.println("Usuario atualizado!");
        } catch (SQLException ex) {
            System.err.println("Erro ao atualizar usuario: " + ex.getMessage());
        } finally {
            ConexaoBD.closeConnection(connection, stmt);
        }
    }
    
    public void deleteUsuario(Usuario usuario) {
        
        Connection connection = new ConexaoBD().getConnection();
        PreparedStatement stmt = null;

        String delete = "DELETE FROM usuario WHERE id = ?";
        try {    
            stmt = connection.prepareStatement(delete);
            stmt.setInt(1, usuario.getId());
            
            stmt.executeUpdate();
            System.out.println("Usuario deletado!");
        } catch (SQLException ex) {
            System.err.println("Erro ao deletar usuario: " + ex.getMessage());
        } finally {
            ConexaoBD.closeConnection(connection, stmt);
        }
    }
    
    public int selectIdUsuario(Usuario usuario) {
        
        Connection connection = new ConexaoBD().getConnection();
        PreparedStatement stmt = null;
        ResultSet result = null;
        
        int id=0;

        String select = "SELECT id FROM usuario WHERE nome = ? AND email = ? AND senha = ?";
        try {
            stmt = connection.prepareStatement(select);
            result = stmt.executeQuery();
            
            result.next();
            
            id = result.getInt("usuario.id");
            
        } catch (SQLException ex) {
            System.out.println("Erro ao procurar o usuario: " + ex.getMessage());
        } finally {
            ConexaoBD.closeConnection(connection, stmt, result);
        }
        
        return id;
    }
    
    public Usuario selecionarUsuarioPorEmail(String email) {
        
        Connection connection = new ConexaoBD().getConnection();
        PreparedStatement stmt = null;
        ResultSet result = null;
        
        Usuario usuario = new Usuario();
        
        String select = "SELECT * FROM usuario WHERE email = ?";
        try {
            stmt = connection.prepareStatement(select);
            stmt.setString(1, email);
            result = stmt.executeQuery();
            
            result.next();
            
            usuario.setEmail(result.getString("usuario.email"));
            usuario.setNome(result.getString("usuario.nome"));
            usuario.setSenha(result.getString("usuario.senha"));
            usuario.setId(result.getInt("usuario.id"));
            
        } catch (SQLException ex) {
            System.out.println("Erro ao procurar o usuario: " + ex.getMessage());
        } finally {
            ConexaoBD.closeConnection(connection, stmt, result);
        }
        
        return userInfo = usuario;
    }
    
    public boolean existeEmail(String email) {
        
        Connection connection = new ConexaoBD().getConnection();
        PreparedStatement stmt = null;
        ResultSet result = null;
        
        String select = "SELECT COUNT(*) FROM usuario WHERE email = ?";
        try {
            stmt = connection.prepareStatement(select);
            stmt.setString(1, email);
            result = stmt.executeQuery();

            if (result.next()) {
                int count = result.getInt(1);
                return count > 0;
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao procurar email no bd: " + ex.getMessage());
        }

        return false; // Retorna false se ocorrer algum erro ou se o e-mail não existir
    }
    
    public boolean existeEmail(String email, String senha) {
        
        Connection connection = new ConexaoBD().getConnection();
        PreparedStatement stmt = null;
        ResultSet result = null;
        
        String select = "SELECT COUNT(*) FROM usuario WHERE (email = ? AND senha = ?)";
        try {
            stmt = connection.prepareStatement(select);
            stmt.setString(1, email);
            stmt.setString(2, senha);
            result = stmt.executeQuery();

            if (result.next()) {
                int count = result.getInt(1);
                return count > 0;
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao procurar email no bd: " + ex.getMessage());
        }

        return false; // Retorna false se ocorrer algum erro ou se o e-mail não existir
    }
    
    /*public static void main(String[] args) { PARA TESTES 
        createUsuario(new Usuario("Matheus", "email@email.com", "senha"));
    } */
            
    
}
