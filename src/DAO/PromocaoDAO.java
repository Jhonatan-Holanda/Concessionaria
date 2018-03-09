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
    
   
}
