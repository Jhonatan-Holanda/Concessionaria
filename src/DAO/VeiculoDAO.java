/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Veiculos;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author Jhonatan Holanda
 */
public class VeiculoDAO extends ExecuteSQL{
    
    public VeiculoDAO(Connection con) {
        super(con);
    }
    public String Inserir_Veiculos(Veiculos v){
        
        String sql = "INSERT INTO veiculos VALUES (0,?,?,?,?,?,?)";
        
        try{
            
            PreparedStatement ps = getCon().prepareStatement(sql);
            
            ps.setString(1,v.getModelo());
            ps.setString(2,v.getFabricante());
            ps.setString(3,v.getCor());
            ps.setInt(4,v.getAno());
            ps.setString(5,v.getPreço());
            ps.setString(6,v.getChassi());
            
            if(ps.executeUpdate() > 0){
                return "Inserido com Sucesso";
            }else{
                return "Erro ao Inserir";
            }
            
        }catch(Exception e){
            return e.getMessage();
        }
    }
    
    
}
