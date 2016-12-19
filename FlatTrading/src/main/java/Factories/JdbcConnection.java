package Factories;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;


public class JdbcConnection {


    private static JdbcConnection instance;
    private Connection connection;
    private Properties properties;

    private JdbcConnection() {
        this.properties=new Properties();
        try {
            properties.load(new FileInputStream("C:\\Users\\Айрат\\IdeaProjects\\FlatTrading\\src\\main\\resources\\connection.properties"));
            String url = properties.getProperty("jdbc.url");
            String user=properties.getProperty("jdbc.name");
            String ps = properties.getProperty("jdbc.password");
            String driverName= properties.getProperty("jdbc.driver");
            Class.forName(driverName);
            connection= DriverManager.getConnection(url,user,ps);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Class not found");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error connection");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static  {
        instance = new JdbcConnection();
    }


    public static JdbcConnection getInstance() {
        return instance;
    }

    public Connection getConnection() {
        return this.connection;
    }



}
