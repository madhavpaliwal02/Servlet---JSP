package bean;

import java.sql.*;

public class LoginDao {
    
    public static boolean validate(LoginBean bean){
        boolean status =  false;
        String q = "select * from user1 where uname=? and pass=? ";
        
        try{
            Connection con = ConnectionProvider.getCon();
            
            PreparedStatement ps = con.prepareStatement(q);
            
            ps.setString(1, bean.getUsername());
            ps.setString(2, bean.getPassword());
            
            ResultSet rs = ps.executeQuery();
            status = rs.next();
        } 
        catch(Exception e){
            e.printStackTrace();
        }
        return status;
    }
}
