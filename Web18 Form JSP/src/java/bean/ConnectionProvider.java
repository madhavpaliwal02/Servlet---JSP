package bean;

import java.sql.*;
import static bean.Provider.*;

public class ConnectionProvider {
    private static Connection con = null;
    
    static{
        try{
            Class.forName(DRIVER);
            con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public static Connection getConnection (){
        return con;
    }
}
