package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbConnection {
    private Connection myConnection;
    public DbConnection(){}
    public void init()
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            myConnection= DriverManager.getConnection("jdbc:mysql://localhost:3306/lab7_1?useUnicode=true&serverTimezone=UTC", "root", "1234");
        }
        catch(ClassNotFoundException | SQLException e)
        {
            System.out.println(e);
        }
    }

    public Connection getMyConnection()
    {
        return myConnection;
    }

    public void close(ResultSet rs)
    {
        if(rs !=null)
        {
            try
            {
                rs.close();
            }
            catch(Exception e){}
        }
    }
    public void destroy()
    {
        if(myConnection !=null)
        {
            try
            {
                myConnection.close();
            }
            catch(Exception e){}
        }
    }

}
