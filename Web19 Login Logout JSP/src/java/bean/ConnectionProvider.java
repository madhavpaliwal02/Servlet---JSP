package bean;

import static bean.Provider.*;
import java.sql.*;

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
    
    public static Connection getCon(){
        return con;
    }
}
