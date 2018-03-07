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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jhonatan Holanda
 */
public class FuncionarioDAO extends ExecuteSQL{
    
    public FuncionarioDAO(Connection con) {
        super(con);
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
}
