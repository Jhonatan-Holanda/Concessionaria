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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Jhonatan(cadastrar)e Matheus(Alterar)
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
    public String Alterar_Veiculos(Veiculos a){
        
         String sql = "UPDATE veiculos SET modelo = ? ,fabricante = ?,cor = ?, ano = ? ,preço = ? , chassi = ? WHERE idveiculos = ? ";
        
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            JOptionPane.showMessageDialog(null, "Cod: "+a.getCod()+"Modelo: "+a.getModelo()+"Fabricante: "+a.getFabricante()
                    +"Cor: "+a.getCor()+ "Ano: "+a.getAno()+"Preço: "+a.getPreço()+"Chassi: "+a.getChassi());
            
            
            ps.setString(1, a.getModelo());
            ps.setString(2,a.getFabricante());
            ps.setString(3, a.getCor());
            ps.setInt(4, a.getAno());
            ps.setString(5, a.getPreço());
            ps.setString(6, a.getChassi());
            ps.setInt(7, a.getCod());

            if(ps.executeUpdate() > 0){
                return "Atualizado com sucesso";
            }else{
                return "Erro ao Atualizar";
            }
            
        }catch(SQLException e){
            return e.getMessage();
        }
    }
   
    
     public boolean Testar_Veiculo(int cod){
        boolean Resultado = false;

        try{
            String sql  = "SELECT * FROM veiculos WHERE idveiculos = "+cod;
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet  rs = ps.executeQuery();

            if( rs!= null){
                while(rs.next()){
                Resultado = true;
                }
            }
        }catch(SQLException ex){
            ex.getMessage();
        }
            return Resultado;
        }
    
    
    public List<Veiculos> ConsultaCodigoVeiculo( String nome){
            String sql = "SELECT idveiculos FROM veiculos WHERE modelo = '"+ nome +"'";
            List<Veiculos> lista = new ArrayList<>();
            try{
                PreparedStatement ps = getCon().prepareStatement(sql);
                ResultSet rs = ps.executeQuery();

                if(rs != null){

                    while(rs.next()){
                        Veiculos a = new Veiculos();
                        a.setCod(rs.getInt(1));
                        lista.add(a);
                    }

                    return lista;

                }else{

                    return null;

                }

            }catch( Exception ex){
                return null;
            }
    } 
    
    
    
    public List<Veiculos> CapturarVeiculo(int cod){
            String sql = "SELECT * FROM veiculos WHERE idveiculos = "+cod;
            List<Veiculos> lista = new ArrayList<>();

            try{
                PreparedStatement ps = getCon().prepareStatement(sql);
                ResultSet rs = ps.executeQuery();

                if( rs!= null){
                    while(rs.next()){
                             
                        
                    Veiculos a = new Veiculos();
                    a.setCod(rs.getInt(1));
                    a.setModelo(rs.getString(2));
                    a.setFabricante(rs.getString(3));
                    a.setCor(rs.getString(4));                    
                    a.setAno(rs.getInt(5));
                    a.setPreço(rs.getString(6));
                    a.setChassi(rs.getString(7));
                    lista.add(a);
                    }
                return lista;

                }else{
                     return null;
                 }
            }catch( SQLException ex ){
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
