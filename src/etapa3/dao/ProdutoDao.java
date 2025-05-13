/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package etapa3.dao;

import etapa3.beans.Fornecedor;
import etapa3.beans.Produto;
import etapa3.conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HEARTHLONELY
 */
public class ProdutoDao {
                
                    public void inserir(Produto produto){
                        
                    String sql = "INSERT INTO produto(nome, fornecedor, volumetria, origem, valorUnitario, informacoesAdicionais) VALUES (?, ?, ? ,? ,? ,?)";
                    
                    try (Connection conn = Conexao.conectar()){
                        PreparedStatement stmt = conn.prepareStatement(sql);
                        stmt.setString(1, produto.getNome());
                        stmt.setString(2, produto.getFornecedor().getRazaoSocial());
                        stmt.setInt(3, produto.getVolumetria());
                        stmt.setString(4, produto.getOrigem());
                        stmt.setDouble(5, produto.getValorUnitario());
                        stmt.setString(6, produto.getInformacoesAdicionais());
                        stmt.execute();  
                        
                        
                    } catch (Exception e) {
                        System.out.println("Erro ao inserir produto: " + e.getMessage());
                    }
                    
                }

               public List<Produto> getProduto(String nomeProduto){
                String sql = "SELECT * FROM produto WHERE nome LIKE ?";
                try (Connection conn = Conexao.conectar()) {
                    PreparedStatement stmt = conn.prepareStatement(sql);
                    stmt.setString(1,"%" + nomeProduto + "%");
                    ResultSet rs = stmt.executeQuery();            
                    

                    List<Produto> listaProduto = new ArrayList<>();

                    while (rs.next()) {
                        Produto produto = new Produto();
                        
                        produto.setId(rs.getInt("id"));
                        produto.setNome(rs.getString("nome"));
                        Fornecedor fornecedor = new Fornecedor();
                        fornecedor.setRazaoSocial(rs.getString("fornecedor"));
                        produto.setFornecedor(fornecedor);
                        produto.setVolumetria(rs.getInt("volumetria"));
                        produto.setOrigem(rs.getString("origem"));
                        produto.setValorUnitario(rs.getDouble("valorUnitario"));
                        produto.setInformacoesAdicionais("informacoesAdicionais");

                        listaProduto.add(produto);
                            
                    }

                    return listaProduto;
                    
                } catch (Exception e) {
                    return null;
                }
           }
}