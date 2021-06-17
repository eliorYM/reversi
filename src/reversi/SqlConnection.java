/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reversi;

import java.beans.Statement;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author elior studies
 */

public class SqlConnection {
    
    public SqlConnection() throws ClassNotFoundException{
        
    
try {
            //Create Connection
            //String connectionUrl = "jdbc:sqlserver://localhost:1433;"
            //       + "databaseName=NORTHWND;";
            String DB_URL = "jdbc:sqlserver://localhost:1433;databaseName=as;integratedSecurity=true";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = DriverManager.getConnection(DB_URL);
           
            // declare of statement and resultSet
            Statement statement;
            ResultSet rs;
            
            // the statement to be execute
            String query = "select * from employees";
            
            statement = (Statement) conn.createStatement();
            
            // execute and get the result set.
            rs = null; //statement.execute(query);
            
            // run over the resultSet
            while(rs.next()){
                
                System.out.print(rs.getInt("ID")+" ");
                System.out.print(rs.getString("Name")+ " ");
                System.out.print(rs.getString("Gmail")+" ");
                System.out.print(rs.getDate("Password"));
                System.out.println("");
            }
            
            // close the resorces
            rs.close();
            //statement.close();
            conn.close();
            
//Create Statment

//Execute
        } catch (SQLException ex) {
            //Logger.getLogger(SQLconction.class.getName()).log(Level.SEVERE, null, ex);
        }

}
}