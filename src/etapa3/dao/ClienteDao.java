/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package etapa3.dao;

import etapa3.beans.Cliente;
import etapa3.conexao.Conexao;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ClienteDao { 
                
               public void inserir(Cliente cliente){
                        
                    String sql = "INSERT INTO cliente(nome, cpf, contato, endereco, email) VALUES (?,?,?,?,?)";
                    
                    try (Connection conn = Conexao.conectar()) {
                        PreparedStatement stmt = conn.prepareStatement(sql);
                        stmt.setString(1, cliente.getNome());
                        stmt.setString(2, cliente.getCpf());
                        stmt.setString(3, cliente.getContato());
                        stmt.setString(4, cliente.getEndereco());
                        stmt.setString(5, cliente.getEmail());
                        stmt.execute();  
                        
                        
                    } catch (Exception e) {
                        System.out.println("Erro ao inserir cliente: " + e.getMessage());
                    }
                    
                }
               public List<Cliente> getCliente(String nomeCliente){
                String sql = "SELECT * FROM cliente WHERE nome LIKE ?";
                
                try (Connection conn = Conexao.conectar()) {
                    PreparedStatement stmt = conn.prepareStatement(sql);
                    stmt.setString(1,"%" + nomeCliente + "%");
                    ResultSet rs = stmt.executeQuery();            
                    

                    List<Cliente> listaCliente = new ArrayList<>();

                    while (rs.next()) {
                        Cliente cliente = new Cliente();
         
                        cliente.setId(rs.getInt("id"));
                        cliente.setNome(rs.getString("nome"));
                        cliente.setCpf(rs.getString("cpf"));
                        cliente.setContato(rs.getString("contato"));
                        cliente.setEndereco(rs.getString("endereco"));
                        cliente.setEmail(rs.getString("email"));
                        
                        listaCliente.add(cliente);
                            
                    }

                    return listaCliente;
                    
                } catch (Exception e) {
                    return null;
                }
           }
               
              public Cliente preencherComboBox(String nomeCliente){
                  Cliente cliente = null;
                  String sql = "SELECT cpf, contato, endereco, email FROM Cliente WHERE nome = ?";
                  
                  try (Connection conn = Conexao.conectar()) {
                    PreparedStatement stmt = conn.prepareStatement(sql);
                    stmt.setString(1, nomeCliente);
                    ResultSet rs = stmt.executeQuery();
        
                    if (rs.next()) {
                        cliente = new Cliente();
                        cliente.setCpf(rs.getString("cpf"));
                        cliente.setContato(rs.getString("contato"));
                        cliente.setEndereco(rs.getString("endereco"));
                        cliente.setEmail(rs.getString("email"));
                     }
                } catch (Exception e) {
                       return null;
                }
    return cliente;
            }  
}
