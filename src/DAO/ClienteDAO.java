package DAO;

import Modelo.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClienteDAO extends ExecuteSQL {
    public ClienteDAO(Connection con){
    super(con);
    }
    
    public String InserirCliente(Cliente c){
    String sql = "INSERT INTO cliente VALUES (0,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setString(1,c.getNome());
            ps.setString(2,c.getEmail());
            ps.setString(3,c.getCidade());
            ps.setString(4,c.getEstado());
            ps.setString(5,c.getRG());
            ps.setString(6,c.getCPF());
            ps.setString(7,c.getTelefone());
            ps.setString(8,c.getCNH()); 
            if (ps.executeUpdate()>0) {
                return "Cadastrado Com Sucesso";
            }else{
                return "Erro Ao Cadastrar";
            }
        } catch (SQLException ex) {
            return ex.getMessage();
        }
    }
}
