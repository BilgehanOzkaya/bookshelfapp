package stukov.factory.bookshelfapp.dao;

import java.sql.*;

public class DB {
        public static Connection getCon(){
            Connection con=null;
            try{
                Class.forName("org.postgresql.Driver");
                con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/bookshelfapp",
                        "postgres", "admin");

            }catch(Exception e){System.out.println(e);}
            return con;
        }
    }

