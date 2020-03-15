//$Id$
package com.alex.zoho;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {
	
	private static Connection connection = null;
    private static DataBaseConnection dataBaseConnection = new DataBaseConnection();
    private DataBaseConnection(){

    }

    public static DataBaseConnection getDbInstance(){
        return dataBaseConnection;
    }

    public  Connection getConnection( ) throws SQLException, ClassNotFoundException {
        if(connection == null) {
            try {
                String url = "jdbc:mysql://localhost/web";
                String userName = "root";
                String password = "";
                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection(url, userName, password);
                System.out.println("Connection Created");
                return connection;

            } catch (Exception ex) {
                //System.out.println(ex);
                throw ex;
            }
        }else{
            return connection;
        }
    }
}
