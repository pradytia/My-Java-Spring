package database;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import javax.sql.RowSet;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class DatabaseAdapter {

    public static Connection getConecctionMysql(){

        try {
            Class.forName("com.centurylink.mdw.assets.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/3306","root","abc123");
            return conn;
        }catch (Exception ex){
            System.out.println(ex.getMessage());
            return null;
        }
    }

    public static CachedRowSet getConnectionMsql2(String sql) throws SQLException {

        RowSetFactory rowSetFactory = null;
        CachedRowSet crs = null;

        //Creating the connection
        String url = "jdbc:mysql://localhost:3306/db_artikel";
        String user = "root";
        String pass = "root";
        Connection con = null;

        try {
            // disetting dalam pom xml
            Class.forName("com.mysql.jdbc.Driver");

            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            con = DriverManager.getConnection(url, user, pass);

            if(con != null){
                System.out.println("Connected to the database test1");
            }else {
                System.out.println("Cannot Connected to Database");
            }

            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery(sql);

            rowSetFactory = RowSetProvider.newFactory();
            crs = rowSetFactory.createCachedRowSet();
            crs.populate(rs);

        }catch (Exception ex){
            ex.getMessage();
            ex.printStackTrace();
            System.out.println(ex.getMessage());
        }finally {
            con.close();
        }
        return crs;
    }
}
