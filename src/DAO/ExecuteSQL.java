/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.*;
import javax.security.auth.login.Configuration;

/**
 *
 * @author root
 */
public class ExecuteSQL {
    
    private Connection con;
    
    public ExecuteSQL(Connection con){
        setCon(con);
    }
    public Connection getCon(){
        return con;
    }
    public void setCon(Connection con){
        this.con = con;
    }
}
