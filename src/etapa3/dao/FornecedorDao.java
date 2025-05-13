/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package etapa3.dao;

import etapa3.beans.Fornecedor;
import etapa3.conexao.Conexao;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HEARTHLONELY
 */
public class FornecedorDao {

    public void inserir(Fornecedor fornecedor) {

        String sql = "INSERT INTO fornecedor(razaoSocial, cnpj, contato, endereco, informacoesAdicionais) VALUES (?,?,?,?,?)";

        try ( Connection conn = Conexao.conectar()) {
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, fornecedor.getRazaoSocial());
            stmt.setString(2, fornecedor.getCnpj());
            stmt.setString(3, fornecedor.getContato());
            stmt.setString(4, fornecedor.getEndereco());
            stmt.setString(5, fornecedor.getInformacoesAdicionais());
            stmt.execute();

        } catch (Exception e) {
            System.out.println("Erro ao inserir fornecedor: " + e.getMessage());
        }

    }

    public List<Fornecedor> getFornecedor(String nomeFornecedor) {
        String sql = "SELECT * FROM fornecedor WHERE razaoSocial LIKE ?";
        
        try ( Connection conn = Conexao.conectar()) {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, "%" + nomeFornecedor + "%");
            ResultSet rs = stmt.executeQuery();

            List<Fornecedor> listaFornecedor = new ArrayList<>();

            while (rs.next()) {
                Fornecedor fornecedor = new Fornecedor();

                fornecedor.setId(rs.getInt("id"));
                fornecedor.setRazaoSocial(rs.getString("razaoSocial"));
                fornecedor.setCnpj(rs.getString("cnpj"));
                fornecedor.setContato(rs.getString("contato"));
                fornecedor.setEndereco(rs.getString("endereco"));
                fornecedor.setInformacoesAdicionais(rs.getString("informacoesAdicionais"));

                listaFornecedor.add(fornecedor);

            }

            return listaFornecedor;

        } catch (Exception e) {
            return null;
        }
    }

}
