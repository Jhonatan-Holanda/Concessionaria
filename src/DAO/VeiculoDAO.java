/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Veiculos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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
    
    //Excluir
    public String Excluir_Veiculo(Veiculos a ){
        
        String sql = "DELETE FROM veiculos WHERE modelo = ?";
        
        try{
           PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setString(1, a.getModelo());
            if(ps.executeUpdate() > 0){
                return "Excluído com sucesso";
            }else{
                return "Erro ao Excluir";
            }
        }catch(Exception ex){
                return ex.getMessage();
        }
    }
  
  public List<Veiculos> ListarComboVeiculo(){
        String sql = "SELECT modelo FROM veiculos order by modelo";
        List<Veiculos> lista = new ArrayList<>();
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if(rs != null){
                while(rs.next()){
                    Veiculos a = new Veiculos();
                    a.setModelo(rs.getString(1));
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
      public List<Veiculos> ListarTabela(){
    String sql = "SELECT * FROM veiculos";
    List<Veiculos> lista = new ArrayList<>();
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs!=null) {
                while(rs.next()){
                  Veiculos p = new Veiculos();
                  p.setCod(rs.getInt(1));
                  p.setModelo(rs.getString(2));
                  p.setFabricante(rs.getString(3));
                  p.setCor(rs.getString(4));                  
                  p.setAno(rs.getInt(5));
                  p.setPreço(rs.getString(6));
                  p.setChassi(rs.getString(7)); 
                  lista.add(p);
                }
                return lista;
            }else{
            return null;
            }
        } catch (Exception e) {
            return null;
        }
        
        
    }
    
    public List<Veiculos> ListarTabelaNome(String nome){
    String sql = "SELECT * FROM veiculos WHERE modelo='"+nome+"'";
    List<Veiculos> lista = new ArrayList<>();
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs!=null) {
                while(rs.next()){
                  Veiculos p = new Veiculos();
                 p.setCod(rs.getInt(1));
                  p.setModelo(rs.getString(2));
                  p.setFabricante(rs.getString(3));
                  p.setCor(rs.getString(4));                  
                  p.setAno(rs.getInt(5));
                  p.setPreço(rs.getString(6));
                  p.setChassi(rs.getString(7)); 
                  lista.add(p);
                }
                return lista;
            }else{
            return null;
            }
        } catch (Exception e) {
            return null;
        }
        
        
    }
    public List<Veiculos> ListarTabelaCodigo(int cod){
    String sql = "SELECT * FROM veiculos WHERE idveiculos='"+cod+"'";
    List<Veiculos> lista = new ArrayList<>();
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs!=null) {
                while(rs.next()){
                  Veiculos p = new Veiculos();
                 p.setCod(rs.getInt(1));
                  p.setModelo(rs.getString(2));
                  p.setFabricante(rs.getString(3));
                  p.setCor(rs.getString(4));                  
                  p.setAno(rs.getInt(5));
                  p.setPreço(rs.getString(6));
                  p.setChassi(rs.getString(7)); 
                  lista.add(p);
                }
                return lista;
            }else{
            return null;
            }
        } catch (Exception e) {
            return null;
        }
        
        
    }
}
