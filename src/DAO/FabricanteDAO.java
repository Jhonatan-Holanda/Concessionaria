/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Fabricante;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jhonatan Holanda
 */
public class FabricanteDAO extends ExecuteSQL{
    
    public FabricanteDAO(Connection con) {
        super(con);
    }
    
    public String Inserir_Fabricante(Fabricante f){
        
        String sql = "INSERT INTO fabricante VALUES (0,?)";
        
        try{
            
            PreparedStatement ps = getCon().prepareStatement(sql);
            
            ps.setString(1,f.getNome());
        
            if(ps.executeUpdate() > 0){
                return "Inserido com Sucesso";
            }else{
                return "Erro ao Inserir";
            }
            
        }catch(Exception e){
            return e.getMessage();
        }
    }
    
    public List<Fabricante> ListarComboFabricante(){
        String sql = "SELECT nome FROM fabricante order by nome";
        List<Fabricante> lista = new ArrayList<>();
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if(rs != null){
                while(rs.next()){
                    Fabricante a = new Fabricante();
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
    
    public List<Fabricante> ConsultaNomeFabricante(String nome){
        String sql = "SELECT nome FROM fabricante where nome = '"+nome+"'";
        List<Fabricante> lista = new ArrayList<>();
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if(rs != null){
                while(rs.next()){
                    Fabricante a = new Fabricante();
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
    //Excluir
    public String Excluir_Fabricante(Fabricante a){
            String sql = "DELETE FROM fabricante WHERE nome = ?";
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setString(1,a.getNome());
   
            if(ps.executeUpdate() > 0){
                return "Excluido com Sucesso";
            }else{
                return "Erro ao Excluir";
            }
            
        }catch( SQLException e){
            return e.getMessage();
        }
    }
    public List<Fabricante> ListarTabela(){
    String sql = "SELECT * FROM fabricante";
    List<Fabricante> lista = new ArrayList<>();
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs!=null) {
                while(rs.next()){
                  Fabricante p = new Fabricante();
                  p.setCod(rs.getInt(1));
                  p.setNome(rs.getString(2));
                
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
    
    public List<Fabricante> ListarTabelaNome(String nome){
    String sql = "SELECT * FROM fabricante WHERE Nome='"+nome+"'";
    List<Fabricante> lista = new ArrayList<>();
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs!=null) {
                while(rs.next()){
                  Fabricante p = new Fabricante();
                  p.setCod(rs.getInt(1));
                  p.setNome(rs.getString(2));
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
    public List<Fabricante> ListarTabelaCodigo(int cod){
    String sql = "SELECT * FROM fabricante WHERE idfabricante='"+cod+"'";
    List<Fabricante> lista = new ArrayList<>();
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs!=null) {
                while(rs.next()){
                  Fabricante p = new Fabricante();
                  p.setCod(rs.getInt(1));
                  p.setNome(rs.getString(2));
                
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
