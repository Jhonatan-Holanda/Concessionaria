package DAO;

import Modelo.Promocao;
import Modelo.Veiculos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rudinilly
 */
public class PromocaoDAO extends ExecuteSQL{
    public PromocaoDAO(Connection con){
    super(con);
    }
    
    public String Inserir_Promocao(Promocao p){
    String sql = "INSERT INTO promocao VALUES (0,?,?,?)";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setString(1,p.getVeiculo());
            ps.setInt(2,p.getPercentual());
            ps.setString(3,p.getData_expiracao());
            
            if(ps.executeUpdate()>0){
            return "Cadastrado";
            }else{
            return "Erro";
            }
        } catch (Exception e) {
        return null;
        }    
    }
    public List<Veiculos> ListarComboVeiculos(){
    String sql = "SELECT modelo FROM veiculos";
   List<Veiculos> lista = new ArrayList<>();
   
       try {
           PreparedStatement pr = getCon().prepareStatement(sql);
           ResultSet rs = pr.executeQuery();
           
           if(rs!= null){
            while(rs.next()){
                Veiculos v = new Veiculos();
                v.setModelo(rs.getString(1));
                lista.add(v);
            }        
            return lista;
           }else{
            return null;
           }           
       } catch (SQLException ex) {
       return null;
       }
   
    
    }
    
    public List<Promocao> ListarComboPromocao(){
    String sql = "SELECT veiculo FROM promocao";
    List<Promocao> lista = new ArrayList<>();
   
       try {
           PreparedStatement pr = getCon().prepareStatement(sql);
           ResultSet rs = pr.executeQuery();
           
           if(rs!= null){
            while(rs.next()){
                Promocao p = new Promocao();
                p.setVeiculo(rs.getString(1));
                lista.add(p);
            }        
            return lista;
           }else{
            return null;
           }           
       } catch (SQLException ex) {
       return null;
       }
    
    
   
    }
    public String ExcluirPromocao(Promocao p){
    String sql = "DELETE FROM promocao WHERE veiculo =?";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setString(1,p.getVeiculo());
            if (ps.executeUpdate()>0) {
                return "Excluido com sucesso";
            
            }else{
                return "Excluido com sucesso";
            }
        } catch (Exception e) {
            return null;
        }
    
    }
    
    public List<Promocao> ListarTabela(Promocao p){
    String sql = "SELECT * FROM promocao";
    List<Promocao> lista = new ArrayList<>();
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs!=null) {
                while(rs.next()){
                  p.setCode(rs.getInt(1));
                  p.setVeiculo(rs.getString(2));
                  p.setPercentual(rs.getInt(3));
                  p.setData_expiracao(rs.getString(4));
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
    
    public List<Promocao> ListarTabelaNome(String nome){
    String sql = "SELECT * FROM promocao WHERE veiculo='"+nome+"'";
    List<Promocao> lista = new ArrayList<>();
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs!=null) {
                while(rs.next()){
                  Promocao p = new Promocao();
                  p.setCode(rs.getInt(1));
                  p.setVeiculo(rs.getString(2));
                  p.setPercentual(rs.getInt(3));
                  p.setData_expiracao(rs.getString(4));
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
    public List<Promocao> ListarTabelaCodigo(int cod){
    String sql = "SELECT * FROM promocao WHERE idpromocao='"+cod+"'";
    List<Promocao> lista = new ArrayList<>();
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs!=null) {
                while(rs.next()){
                  Promocao p = new Promocao();
                  p.setCode(rs.getInt(1));
                  p.setVeiculo(rs.getString(2));
                  p.setPercentual(rs.getInt(3));
                  p.setData_expiracao(rs.getString(4));
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