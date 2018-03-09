/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Funcionario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * 
 */
public class FuncionarioDAO extends ExecuteSQL{
    
    public FuncionarioDAO(Connection con) {
        super(con);
    }
    public String SalvarFuncionario(Funcionario c){
        String sql = "INSERT INTO funcionario VALUES (0,?,?,?,?,?,?,?,?,?)";
       try{
       PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setString(1,c.getNome());
            ps.setString(2,c.getEmail());
            ps.setString(3,c.getCpf());
            ps.setString(4,c.getTelefone());
            ps.setString(5,c.getRg());
            ps.setInt(6,c.getNumeropis());
            ps.setString(7,c.getLogin());
            ps.setString(8,c.getSenha());
            ps.setInt(9,c.getPatente());
            if (ps.executeUpdate()>0) {
                return "Cadastro salvo com sucesso";
            }else{
                return "Erro Ao Salvar o cadastro";
            }
           
       }catch (SQLException ex){
           return ex.getMessage();
    }
    }
    
    
    
    public boolean Logar(String login, String senha){
        boolean finalResult = false;
    
    try{
        String consulta = "select login, senha from funcionario where login = '"+login+"' and senha ='"+senha+"' and patente = 0";
        PreparedStatement ps = getCon().prepareStatement(consulta);
        ResultSet rs = ps.executeQuery();
        
        if(rs != null){
            while(rs.next()){
                Funcionario a = new Funcionario();
                a.setLogin(rs.getString(1));
                a.setSenha(rs.getString(2));
                finalResult = true;
            }
        }
    }catch(Exception e){
    }
    return finalResult;
  }
  public boolean Logar_gerente(String login, String senha){
        boolean finalResult = false;
    
    try{
        String consulta = "select login, senha from funcionario where login = '"+login+"' and senha ='"+senha+"' and patente = 1";
        PreparedStatement ps = getCon().prepareStatement(consulta);
        ResultSet rs = ps.executeQuery();
        
        if(rs != null){
            while(rs.next()){
                Funcionario a = new Funcionario();
                a.setLogin(rs.getString(1));
                a.setSenha(rs.getString(2));
                finalResult = true;
            }
        }
    }catch(Exception e){
    }
    return finalResult;
  }
  
  public String Excluir_Funcionario(Funcionario a ){
        
        String sql = "DELETE FROM funcionario WHERE nome = ?";
        
        try{
           PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setString(1, a.getNome());
            if(ps.executeUpdate() > 0){
                return "Excluído com sucesso";
            }else{
                return "Erro ao Excluir";
            }
        }catch(Exception ex){
                return ex.getMessage();
        }
    }
  
  public List<Funcionario> ListarComboFuncionario(){
        String sql = "SELECT nome FROM funcionario order by nome";
        List<Funcionario> lista = new ArrayList<>();
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if(rs != null){
                while(rs.next()){
                    Funcionario a = new Funcionario();
                    a.setNome(rs.getString(1));
                    lista.add(a);
                }
                return lista;
            }else{
                return null;
            }
            
        }catch(Exception ex){
            return null;
            
        }
    
    }
    
}
