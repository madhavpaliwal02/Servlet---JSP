package bean;

import java.sql.*;

public class RegisterDao {

    public static int register(User u) {
        int status = 0;
        String q = "insert into user values (?,?,?)";
        try {
            Connection con = ConnectionProvider.getConnection();
            PreparedStatement ps = con.prepareStatement(q);
            
            ps.setString(1, u.getUname());
            ps.setString(2, u.getEmail());
            ps.setString(3, u.getUpass());
            
            status = ps.executeUpdate(); 

        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }
}
