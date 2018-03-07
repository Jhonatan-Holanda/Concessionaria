package DAO;

import Modelo.Promocao;
import java.sql.Connection;
import java.sql.PreparedStatement;

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
}
