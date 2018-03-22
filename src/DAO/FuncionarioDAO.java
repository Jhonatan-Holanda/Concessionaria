/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Funcionario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * 
 */
public class FuncionarioDAO extends ExecuteSQL{
    
    public FuncionarioDAO(Connection con) {
        super(con);
    }
    public String SalvarFuncionario(Funcionario c){
        String sql = "INSERT INTO funcionario VALUES (0,?,?,?,?,?,?,?,?,?)";
       try{
       PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setString(1,c.getNome());
            ps.setString(2,c.getEmail());
            ps.setString(3,c.getCpf());
            ps.setString(4,c.getTelefone());
            ps.setString(5,c.getRg());
            ps.setString(6,c.getNumeropis());
            ps.setString(7,c.getLogin());
            ps.setString(8,c.getSenha());
            ps.setInt(9,c.getPatente());
            if (ps.executeUpdate()>0) {
                return "Cadastro salvo com sucesso";
            }else{
                return "Erro Ao Salvar o cadastro";
            }
           
       }catch (SQLException ex){
           return ex.getMessage();
    }
    }
    
    
    
    public boolean Logar(String login, String senha){
        boolean finalResult = false;
    
    try{
        String consulta = "select login, senha from funcionario where login = '"+login+"' and senha ='"+senha+"' and patente = 0";
        PreparedStatement ps = getCon().prepareStatement(consulta);
        ResultSet rs = ps.executeQuery();
        
        if(rs != null){
            while(rs.next()){
                Funcionario a = new Funcionario();
                a.setLogin(rs.getString(1));
                a.setSenha(rs.getString(2));
                finalResult = true;
            }
        }
    }catch(Exception e){
    }
    return finalResult;
  }
  public boolean Logar_gerente(String login, String senha){
        boolean finalResult = false;
    
    try{
        String consulta = "select login, senha from funcionario where login = '"+login+"' and senha ='"+senha+"' and patente = 1";
        PreparedStatement ps = getCon().prepareStatement(consulta);
        ResultSet rs = ps.executeQuery();
        
        if(rs != null){
            while(rs.next()){
                Funcionario a = new Funcionario();
                a.setLogin(rs.getString(1));
                a.setSenha(rs.getString(2));
                a.setCod(rs.getInt(3));
                finalResult = true;
            }
        }
    }catch(Exception e){
    }
    return finalResult;
  }
  
  public String Excluir_Funcionario(Funcionario a ){
        
        String sql = "DELETE FROM funcionario WHERE nome = ?";
        
        try{
           PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setString(1, a.getNome());
            if(ps.executeUpdate() > 0){
                return "Excluído com sucesso";
            }else{
                return "Erro ao Excluir";
            }
        }catch(Exception ex){
                return ex.getMessage();
        }
    }
  
  public List<Funcionario> ListarComboFuncionario(){
        String sql = "SELECT nome FROM funcionario order by nome";
        List<Funcionario> lista = new ArrayList<>();
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if(rs != null){
                while(rs.next()){
                    Funcionario a = new Funcionario();
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
     public List<Funcionario> ListarTabela(){
    String sql = "SELECT * FROM funcionario";
    List<Funcionario> lista = new ArrayList<>();
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs!=null) {
                while(rs.next()){
                  Funcionario p = new Funcionario();
                  p.setCod(rs.getInt(1));
                  p.setNome(rs.getString(2));
                  p.setEmail(rs.getString(3));
                  p.setCpf(rs.getString(4));                  
                  p.setTelefone(rs.getString(5));
                  p.setRg(rs.getString(6));
                  p.setNumeropis(rs.getString(7));                  
                  p.setLogin(rs.getString(8));
                  p.setSenha(rs.getString(9));
                  p.setPatente(rs.getInt(10));
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
  
   public String Alterar_Funcionario(Funcionario a){
        
        String sql = "UPDATE funcionario SET nome = ? ,email = ?,cpf = ?, telefone = ? , rg = ? , numeropis = ? , login = ?,  senha = ? WHERE idfuncionario = ? ";
        
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);

            ps.setString(1, a.getNome());
            ps.setString(2,a.getEmail());
            ps.setString(3, a.getCpf());
            ps.setString(4, a.getTelefone());
            ps.setString(5, a.getRg());
            ps.setString(6, a.getNumeropis());
            ps.setString(7, a.getLogin());
            ps.setString(8, a.getSenha());
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
    

    public List<Funcionario> ListarTabelaNome(String nome){
    String sql = "SELECT * FROM funcionario WHERE Nome='"+nome+"'";
    List<Funcionario> lista = new ArrayList<>();
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs!=null) {
                while(rs.next()){
                  Funcionario p = new Funcionario();
                  p.setCod(rs.getInt(1));
                  p.setNome(rs.getString(2));
                  p.setEmail(rs.getString(3));
                  p.setCpf(rs.getString(4));                  
                  p.setTelefone(rs.getString(5));
                  p.setRg(rs.getString(6));
                  p.setNumeropis(rs.getString(7));                  
                  p.setLogin(rs.getString(8));
                  p.setSenha(rs.getString(9));
                  p.setPatente(rs.getInt(10));
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
    public List<Funcionario> ListarTabelaCodigo(int cod){
    String sql = "SELECT * FROM funcionario WHERE idfuncionario='"+cod+"'";
    List<Funcionario> lista = new ArrayList<>();
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs!=null) {
                while(rs.next()){
                  Funcionario p = new Funcionario();
                  p.setCod(rs.getInt(1));
                  p.setNome(rs.getString(2));
                  p.setEmail(rs.getString(3));
                  p.setCpf(rs.getString(4));                  
                  p.setTelefone(rs.getString(5));
                  p.setRg(rs.getString(6));
                  p.setNumeropis(rs.getString(7));                  
                  p.setLogin(rs.getString(8));
                  p.setSenha(rs.getString(9));
                  p.setPatente(rs.getInt(10));
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
   
   public boolean Testar_Funcionario(int cod){
        boolean Resultado = false;

        try{
            String sql  = "SELECT * FROM funcionario WHERE idfuncionario = "+cod;
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
    
        public List<Funcionario> CapturarFuncionario(int cod){
            String sql = "SELECT * FROM funcionario WHERE idfuncionario = "+cod;
            List<Funcionario> lista = new ArrayList<>();

            try{
                PreparedStatement ps = getCon().prepareStatement(sql);
                ResultSet rs = ps.executeQuery();

                if( rs!= null){
                    while(rs.next()){
                             
                        
                    Funcionario a = new Funcionario();
                    a.setNome(rs.getString(2));
                    a.setEmail(rs.getString(3));                    
                    a.setCpf(rs.getString(4));
                    a.setTelefone(rs.getString(5));
                    a.setRg(rs.getString(6));
                    a.setNumeropis(rs.getString(7));
                    a.setLogin(rs.getString(8));
                    a.setSenha(rs.getString(9));
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
   
      public List<Funcionario> ConsultaCodigoFuncionario( String nome){
            String sql = "SELECT idfuncionario FROM funcionario WHERE nome = '"+ nome +"'";
            List<Funcionario> lista = new ArrayList<>();
            try{
                PreparedStatement ps = getCon().prepareStatement(sql);
                ResultSet rs = ps.executeQuery();

                if(rs != null){

                    while(rs.next()){
                        Funcionario a = new Funcionario();
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
}
