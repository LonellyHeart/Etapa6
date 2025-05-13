/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package etapa3.dao;

import etapa3.beans.Login;
import etapa3.conexao.Conexao;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;


/**
 *
 * @author HEARTHLONELY
 */
public class LoginDao {
    
    public String criptografarSenha(String senha) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(senha.getBytes());
            byte[] digest = md.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b : digest) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Erro ao criptografar a senha", e);
        }
    
}
    
    public void inserir(Login login){
                                
                    String sql = "INSERT INTO login(nome, login, senha) VALUES (?, ?, ?)";
                    
                    try (Connection conn = Conexao.conectar()) {
                        PreparedStatement stmt = conn.prepareStatement(sql);
                        stmt.setString(1, login.getNome());
                        stmt.setString(2, login.getLogin());
                        stmt.setString(3, criptografarSenha(login.getSenha()));
                        stmt.execute();  
                        
                        
                    } catch (Exception e) {
                        System.out.println("Erro ao inserir produto: " + e.getMessage());
                    }
    
    }
}
