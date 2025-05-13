/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package etapa3.dao;

import etapa3.beans.Venda;
import etapa3.conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author MATRIZ
 */
public class VendaDao {

    public void inserir(Venda venda) {
                                             
                    String sql = "INSERT INTO venda(cpf, nome, contato,email, endereco, produto, quantidade, valorUnitario, desconto, valorTotal) VALUES (?, ?, ?, ?, ? ,? ,? ,? ,?,?)";
 
                    try (Connection conn = Conexao.conectar()) {
                        PreparedStatement stmt = conn.prepareStatement(sql);
                        stmt.setString(1, venda.getCpf());
                        stmt.setString(2, venda.getNome().getNome());
                        stmt.setString(3, venda.getContato());
                        stmt.setString(4, venda.getEmail());
                        stmt.setString(5, venda.getEndereco());
                        stmt.setString(6, venda.getProduto().getNome());
                        stmt.setInt(7, venda.getQuantidade());
                        stmt.setDouble(8, venda.getValorUnitario());
                        stmt.setInt(9, venda.getDesconto());
                        stmt.setDouble(10, venda.getValorTotal());
                        stmt.execute();  

                        
                        
                    }  catch (SQLException e) {
                            throw new RuntimeException("Erro ao inserir uma nova venda: " + e.getMessage(), e);
                    }
                    
                }
    
}
