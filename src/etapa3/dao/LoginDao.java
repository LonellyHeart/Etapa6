/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package etapa3.dao;

import etapa3.beans.Login;
import etapa3.conexao.Conexao;
import etapa3.util.Criptografia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


/**
 *
 * @author HEARTHLONELY
 */
public class LoginDao {
    
    public void inserir(Login login){
                                
                    String sql = "INSERT INTO login(nome, login, senha) VALUES (?, ?, ?)";
                    
                    try (Connection conn = Conexao.conectar()) {
                        PreparedStatement stmt = conn.prepareStatement(sql);
                        stmt.setString(1, login.getNome());
                        stmt.setString(2, login.getLogin());
                        stmt.setString(3, Criptografia.criptografarSenha(login.getSenha()));
                        stmt.execute();  
                        
                        
                    }  catch (SQLException e) {
                          throw new RuntimeException("Erro ao inserir novo login de usuario: " + e.getMessage(), e);
                    }
    
    }
}
