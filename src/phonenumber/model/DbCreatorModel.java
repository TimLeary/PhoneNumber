/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phonenumber.model;
import java.sql.*;
/**
 *
 * @author David
 */
public class DbCreatorModel {
    public DbCreatorModel(String db_name){
        Connection c = null;
        Statement stmt = null;
        
        try{
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:" + db_name);
            
            System.out.println("Opened database successfully");
            
            stmt = c.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS `PERSON` " +
                         "(`id`	INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                         "`family_name`	TEXT NOT NULL," + 
                         "`forename`	TEXT NOT NULL)"; 
            stmt.executeUpdate(sql);
            stmt.close();
            
            stmt = c.createStatement();

            sql = "CREATE TABLE IF NOT EXISTS `PHONE_NUMBER` " +
                         "(`id`	INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                         "`person_id`	INTEGER NOT NULL," + 
                         "`phone_num`	TEXT NOT NULL)"; 
            stmt.executeUpdate(sql);
            stmt.close();
            c.close();
            
        } catch (Exception e) {
            System.out.println(e.getClass().getName() + " " +e.getMessage());
        }
        
        
    }
}
