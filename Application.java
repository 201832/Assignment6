package Singleton;

import java.sql.*;
import java.util.Scanner;

class Database{
    private static Database instance;

    private Database()
    {
        String link = "jdbc:postgresql://localhost:5432/example";
        String login = "postgres";
        String pass = "postgres";

        try {
            Connection con = DriverManager.getConnection(link, login, pass); //connect to the database using object of Connection class
        }
        catch(SQLException ex) //use try catch block for Exception handling with SQLException class
        {
            ex.printStackTrace(); //print an exception
        }
    }

    public static Database getInstance() //method to control access to the instance
    {
        if(instance == null) //checking for null field
        {
            instance = new Database(); //call constructor of this class
        }
        return instance; //return our instance
    }

    public void query(String sql) throws SQLException
    {
        String link = "jdbc:postgresql://localhost:5432/example";
        String login = "postgres";
        String pass = "postgres";
        Connection con = DriverManager.getConnection(link , login, pass); //connect to the database using object of Connection class
        Statement st = con.createStatement(); //execute queries with the database, creating statement
        ResultSet rs = st.executeQuery(sql); //we will call executeQuery to execute queries for database and get results from our query (sql)

        while(rs.next()){ //loop for resultSet for processing till ResultSet object has some data inside

            System.out.println("id: " + rs.getInt("example_id") + " | string: " + rs.getString("example_name"));
        }
    }
}

public class Application
{
    public static void main(String args[])
    {
        //declare instances of Database class and call method query, then we see that they have same result
        try
        {
            Database foo = Database.getInstance();
            foo.query("SELECT * from example");
        }
        catch(SQLException ex) {
            ex.printStackTrace();
        }

        try {
            Database bar = Database.getInstance();
            bar.query("SELECT * from example");
        }
        catch(SQLException ex) {
            ex.printStackTrace();
        }
    }
}
