package travel.management.system;

import java.sql.*;

public class Conn {
    
    Connection c;
    Statement s;
    Conn(){
        //JDBC -- Java Database Connectivity
        try{
           Class.forName("com.mysql.cj.jdbc.Driver"); //driver for mysql
           c = DriverManager.getConnection("jdbc:mysql:///tms", "root", "PKG_@0058");
           s = c.createStatement();
        }catch (Exception e) {
            e.printStackTrace();
        }   
    }
    
}
