package gerteor.connect;

import javax.naming.Context;
import javax.naming.NamingException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class PostgreSQLJDBC {

    private static PostgreSQLJDBC inst = null;

    public static PostgreSQLJDBC getInst(){
        if (inst == null)
            inst = new PostgreSQLJDBC();
        return inst;
    }

    public Connection getConncetion(){
        Connection cn = null;
        try {
            Properties prop=new Properties();
            InputStream in=PostgreSQLJDBC.class.getClassLoader().getResourceAsStream("configuration.properties");
            prop.load(in);
            String drivers = prop.getProperty("dbcp.driverClassName");
            String connectionURL = prop.getProperty("dbcp.url");
            String username = prop.getProperty("dbcp.username");
            String password = prop.getProperty("dbcp.password");
            Class.forName(drivers);
            cn=DriverManager.getConnection(connectionURL,username,password);
            in.close();
            System.out.println("Connection Successful");
        } catch (SQLException | IOException | ClassNotFoundException e) {
            System.err.println(e.getClass().getName()+": "+e.getMessage());

        }
        System.out.println("Opened database successfully");
        return cn;
    }
}