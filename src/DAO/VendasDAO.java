
package DAO;

import Modelo.Venda;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class VendasDAO extends ExecuteSQL{
    public VendasDAO(Connection con){
    super(con);
    }
    
    public String InserirVenda(Venda f){
        String sql = "INSERT INTO vendas VALUES (0,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setString(1, f.getCliente());
            ps.setString(2, f.getVeiculo());
            ps.setString(3, f.getFabricante());
            ps.setString(4, f.getChassi());
            ps.setString(5, f.getModoPagamento());
            ps.setString(6, f.getTipoPagamento());
            ps.setString(7, f.getParcelas());
            ps.setString(8, f.getPreco());
            ps.setDouble(9, f.getDesconto());
            ps.setDouble(10, f.getValofinal());
            ps.setInt(11, f.getIdfuncionario());
            if (ps.executeUpdate()>0) {
                return "Deu certo";            
            }else{
             return "Falhou";                   
            }
        } catch (Exception e) {
            return e.getMessage();
        }
        }
    
}
