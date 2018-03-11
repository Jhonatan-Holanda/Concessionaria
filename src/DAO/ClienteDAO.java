package DAO;

import Modelo.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

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
  //Alterar
    public List<Cliente> ConsultaCodigoCliente( String nome){
            String sql = "SELECT idcliente FROM cliente WHERE nome = '"+ nome +"'";
            List<Cliente> lista = new ArrayList<>();
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
   
            if(rs != null){
                
                while(rs.next()){
                    Cliente a = new Cliente();
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
    public String Alterar_Cliente(Cliente a){
        
        String sql = "UPDATE cliente SET nome = ? ,email = ?,cidade = ?, estado = ? , rg = ? , cpf = ? , telefone = ?,  cnh = ? WHERE idcliente = ? ";
        
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);

            ps.setString(1, a.getNome());
            ps.setString(2,a.getEmail());
            ps.setString(3, a.getCidade() );
            ps.setString(4, a.getEstado());
            ps.setString(5, a.getRG());
            ps.setString(6, a.getCPF());
            ps.setString(7, a.getTelefone());
            ps.setString(8, a.getCNH());
            ps.setInt(9, a.getCod());

            if(ps.executeUpdate() > 0){
                return "Atualizado com sucesso";
            }else{
                return "Erro ao Atualizar";
            }
            
        }catch(SQLException e){
            return e.getMessage();
        }
    }
    public boolean Testar_Cliente(int cod){
    boolean Resultado = false;
   
    try{
        String sql  = "SELECT * FROM cliente WHERE idcliente = "+cod;
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

    public List<Cliente> CapturarCliente(int cod){
        String sql = "SELECT *  FROM cliente WHERE idcliente = "+cod;
        List<Cliente> lista = new ArrayList<>();
        
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if( rs!= null){
                while(rs.next()){
                Cliente a = new Cliente();
                a.setCod(rs.getInt(1));
                a.setNome(rs.getString(2));
                a.setEmail(rs.getString(3));
                a.setCidade(rs.getString(4));
                a.setEstado(rs.getString(5));
                a.setRG(rs.getString(6));
                a.setCPF(rs.getString(7));
                a.setTelefone(rs.getString(8));
                a.setCNH(rs.getString(9));
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
}
