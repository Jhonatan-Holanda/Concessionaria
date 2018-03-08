/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author root
 */
public class Conexao {
    
  public static Connection AbrirConexao(){
    Connection con = null;
  
    try{
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost/concessionaria";
        con = DriverManager.getConnection(url,"rudi","rudi");
    }catch(Exception e){
        JOptionPane.showMessageDialog(null, "Erro na conexão com o banco","Video Locadora",JOptionPane.ERROR_MESSAGE);
        e.getMessage();
    }
  
    return con;
  
  }
  
  public static void FecharConexao(Connection con){
      try{
          con.close();
      }catch(Exception e){
          JOptionPane.showMessageDialog(null, "Erro ao encerrar conexão com banco"+e.getMessage());
      }
  }
}
