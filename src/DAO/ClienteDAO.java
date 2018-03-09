package DAO;

import Modelo.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
    //Excluir
    public List<Cliente> ListarComboCliente(){
        String sql = "SELECT nome FROM cliente ORDER BY nome";
        List<Cliente> lista = new ArrayList<>();
        
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            if(rs != null){
            while(rs.next()){
            Cliente a = new Cliente();
            a.setNome(rs.getString(1));
            lista.add(a);
            }
                return lista;
            }else{
                return null;
            }

        }catch(Exception e){
            return null;
        }
       
   }
    public String Excluir_Cliente(Cliente a){
            String sql = "DELETE FROM cliente WHERE nome = ?";
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
}
