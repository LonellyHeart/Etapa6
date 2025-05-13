/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package etapa3.conexao;
  
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author HEARTHLONELY
 */
public class Conexao {

      public static void main(String[] args) {

          Conexao conexao = new Conexao();
          Connection conn = conexao.conectar();
          conexao.desconectar(conn);
      }

      public static Connection conectar() {
          Connection conn = null;
          try {
              Class.forName("com.mysql.cj.jdbc.Driver");
              conn = DriverManager.getConnection("jdbc:mysql://localhost/etapa4", "root", "1234"); //Supersenha0112 ou 1234
              System.out.println("Conectou com o banco de dados!!!!");
          } catch (SQLException ex) {
              System.out.println("Erro: Não foi possivel se conectar no banco de dados!");
          } catch (ClassNotFoundException ex) {
              System.out.println("Erro: Driver JDBC nao encontrado!.");
          }

          return conn;
      }

      public void desconectar(Connection conn) {
          try {
              if (conn != null && !conn.isClosed()) {
                  conn.close();
                  System.out.println("Voce se desconectou do banco de dados.");
              }
          } catch (SQLException ex) {
              System.out.println("Nao foi possivel desconectar do banco dados.");
          }
      }
  }

