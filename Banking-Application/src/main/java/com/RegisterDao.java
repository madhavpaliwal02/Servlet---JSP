package com;

import java.sql.*;
import java.util.ArrayList;

public class RegisterDao {

    public static int register(User u) {
        int status = 0;
        String q = "insert into user (uname, email, pass) values (?,?,?)";
        String q2 = "insert into balance (email, bal) values (?,?)";

        try {
            Connection con = ConnectionProvider.getCon();
            
            PreparedStatement ps = con.prepareStatement(q);
            ps.setString(1, u.getUname());
            ps.setString(2, u.getEmail());
            ps.setString(3, u.getUpass());

            PreparedStatement ps2 = con.prepareStatement(q2);
            ps2.setString(1, u.getEmail());
            ps2.setInt(2, 0);

            status = ps.executeUpdate();
            status += (ps2.executeUpdate() - 1);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public static boolean validate(String email, String pass) {
        boolean status = false;
        String q = "select * from user where email = ? and pass=? ";
        try {
            Connection con = ConnectionProvider.getCon();
            PreparedStatement st = con.prepareStatement(q);

            st.setString(1, email);
            st.setString(2, pass);

            ResultSet rs = st.executeQuery();

            status = rs.next();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public static User getUser(String email, String pass) {
        User u = null;
        String q = "select uname, email, pass from user where email=? and pass=? ";
        try {
            if (RegisterDao.validate(email, pass)) {
                Connection con = ConnectionProvider.getCon();
                PreparedStatement st = con.prepareStatement(q);

                st.setString(1, email);
                st.setString(2, pass);

                ResultSet rs = st.executeQuery();

                u = new User();
                while (rs.next()) {
                    u.setUname(rs.getString(1));
                    u.setEmail(rs.getString(2));
                    u.setUpass(rs.getString(3));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return u;
    }

    public static int viewBal(String email) {
        int balance = 0;
        String q = "select bal from balance where email=?";
        try {
            Connection con = ConnectionProvider.getCon();
            PreparedStatement st = con.prepareStatement(q);

            st.setString(1, email);

            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                balance = rs.getInt(1);
            }
        } catch (SQLException e) {
        }
        return balance;
    }

    public static boolean deposit(User u, int amt) {
        boolean status = false;
        String q = "update balance set bal=bal+? where email=? ";
        String q2 = "insert into transaction (uname, amount, status, balance) values (?,?,?,?)";
        try {
            Connection con = ConnectionProvider.getCon();
            PreparedStatement st = con.prepareStatement(q);
            
            PreparedStatement st2 = con.prepareStatement(q2);

            st.setInt(1, amt);
            st.setString(2, u.getEmail());
            
            st2.setString(1, u.getUname());
            st2.setInt(2, amt);
            st2.setString(3, "Credit");
            st2.setInt(4, viewBal(u.getEmail())+amt);
            
            st.executeUpdate();
            st2.executeUpdate();
            status = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public static boolean withdraw(User u, int amt) {
        boolean status = false;
        String q = "update balance set bal=bal-? where email=? ";
        String q2 = "insert into transaction (uname, amount, status, balance) values (?,?,?,?)";
        try {
            Connection con = ConnectionProvider.getCon();
            PreparedStatement st = con.prepareStatement(q);
            
            PreparedStatement st2 = con.prepareStatement(q2);

            st.setInt(1, amt);
            st.setString(2, u.getEmail());
            
            st2.setString(1, u.getUname());
            st2.setInt(2, amt);
            st2.setString(3, "Debit");
            st2.setInt(4, viewBal(u.getEmail())-amt);
            
            st.executeUpdate();
            st2.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }
    
    public static ArrayList<Transaction> getTrans(User u) {
        ArrayList<Transaction> trans = new ArrayList<>();
        Transaction t = null;
        String q = "select * from transaction where uname=?";
        try {
            Connection con = ConnectionProvider.getCon();
            PreparedStatement st = con.prepareStatement(q);

            st.setString(1, u.getUname());
            
            ResultSet rs = st.executeQuery();
            
            while(rs.next()){
                t = new Transaction();
                t.setId(rs.getInt(1));
                t.setUname(rs.getString(2));
                t.setAmount(rs.getInt(3));
                t.setStatus(rs.getString(4));
                t.setBalance(rs.getInt(5));
                t.setTime(rs.getTimestamp(6));
                trans.add(t);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return trans;
    }
}
