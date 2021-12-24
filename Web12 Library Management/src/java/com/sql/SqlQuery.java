package com.sql;

//import java.util.*;
import java.sql.*;
import java.util.ArrayList;

public class SqlQuery {

    // Getting object of connection with installed database 
    public static Connection getConnection() {

        Connection con = null;
        try {
            // Loading Driver
            Class.forName("com.mysql.jdbc.Driver");

            // Establishing COnnection
            String url = "jdbc:mysql://localhost/projectlibrary";
            con = DriverManager.getConnection(url, "root", "123456");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }

    
    // LIBRARIAN CRUD
    // Inserting Librarian
    public static int insertLib(Librarian lib) {
        //String name, String uname, String pass
        int status = 0;
        try {
            Connection con = SqlQuery.getConnection();

            String q = "insert into librarian (name, uname, pass) values (?,?,?)";
            PreparedStatement ps = con.prepareStatement(q);

            ps.setString(1, lib.getName());
            ps.setString(2, lib.getUname());
            ps.setString(3, lib.getPass());

            status = ps.executeUpdate();

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }

    // Fetching details Librarian
    public static ArrayList<Librarian> selectAllLib() {
        ArrayList<Librarian> liblist = new ArrayList<>();

        try {
            Connection con = SqlQuery.getConnection();

            String q = "select * from librarian";
            Statement s = con.createStatement();

            ResultSet rs = s.executeQuery(q);

            while (rs.next()) {
                Librarian lib = new Librarian();
                lib.setName(rs.getString(2));
                lib.setUname(rs.getString(3));
                lib.setPass(rs.getString(4));
                liblist.add(lib);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return liblist;
    }

    // Removing librarian
    public static int deleteLib(String name, String uname) {
        int status = 0;
        try {
            Connection con = SqlQuery.getConnection();

            Statement s = con.createStatement();

            String q2 = "delete from librarian where name='" + name + "' and uname='" + uname + "'";

            status = s.executeUpdate(q2);

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    // Validating librarian 
    public static String matchLib(String uname) {
//        String name = "";
        String p = "";

        try {
            Connection con = SqlQuery.getConnection();

            String q = "select pass from librarian where uname = '" + uname + "'";
//            PreparedStatement ps = con.prepareStatement(q);
//            ps.setString(1, uname);

            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery(q);

            p = String.valueOf(rs.getInt(1));

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
//        if(p>0)
        return p;
//        return 0;
    }

    
    // BOOKS CRUD
    // Insert Book
    public static int insertBook(Book b) {
        int status = 0;
        try {
            Connection con = SqlQuery.getConnection();

            String q = "insert into books (bname, bdesc, bauth, bedition) values (?,?,?,?)";

            PreparedStatement ps = con.prepareStatement(q);

            ps.setString(1, b.getName());
            ps.setString(2, b.getDesc());
            ps.setString(3, b.getAuth());
            ps.setInt(4, b.getEdition());

            status = ps.executeUpdate();

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }

    // Fetching details Book
    public static ArrayList<Book> selectAllBook() {
        ArrayList<Book> booklist = new ArrayList<>();

        try {
            Connection con = SqlQuery.getConnection();

            String q = "select * from books";
            Statement s = con.createStatement();

            ResultSet rs = s.executeQuery(q);

            while (rs.next()) {
                Book b = new Book();
                b.setName(rs.getString(2));
                b.setDesc(rs.getString(3));
                b.setAuth(rs.getString(4));
                b.setEdition(rs.getInt(5));
                booklist.add(b);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return booklist;
    }

    // Removing Book
    public static int deleteBook(String name, int edition) {
        int status = 0;
        try {
            Connection con = SqlQuery.getConnection();

            Statement s = con.createStatement();

            String q2 = "delete from books where bname='" + name + "' and bedition='" + edition + "'";

            status = s.executeUpdate(q2);

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }
    
     // Validating Student  
    public static int matchBook(String name, int edi) {
        boolean bool = false;
        try {
            Connection con = SqlQuery.getConnection();

            String q = "select bedition from books where name = ?";

            PreparedStatement ps = con.prepareStatement(q);
            ps.setString(1, name);
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next())
                if(edi == rs.getInt(1))
                    bool = true;

            con.close();
        } catch (Exception e) {e.printStackTrace();}
        if(bool)
            return 1;
        else
            return 0;
    }

    
    // STUDENTS CRUD
    // Insert Student
    public static int insertStu(Student s) {
        int status = 0;
        try {
            Connection con = SqlQuery.getConnection();

            String q = "insert into students (name, rollno, email, pass, course) values (?,?,?,?,?)";

            PreparedStatement ps = con.prepareStatement(q);

            ps.setString(1, s.getName());
            ps.setString(2, s.getRollno());
            ps.setString(3, s.getEmail());
            ps.setString(4, s.getPass());
            ps.setString(5, s.getCourse());

            status = ps.executeUpdate();

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }

    // Fetching details Student
    public static ArrayList<Student> selectAllStu() {
        ArrayList<Student> stulist = new ArrayList<>();

        try {
            Connection con = SqlQuery.getConnection();

            String q = "select * from students";
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(q);

            while (rs.next()) {
                Student s = new Student();
                s.setName(rs.getString(2));
                s.setRollno(rs.getString(3));
                s.setEmail(rs.getString(4));
                s.setPass(rs.getString(5));
                s.setCourse(rs.getString(6));

                stulist.add(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stulist;
    }

    // Removing Student
    public static int deleteStu(String name, String rollno) {
        int status = 0;
        try {
            Connection con = SqlQuery.getConnection();

            Statement s = con.createStatement();

            String q2 = "delete from students where name='" + name + "' and rollno='" + rollno + "'";

            status = s.executeUpdate(q2);

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    // Validating Student  
    public static Student matchStu(String rollno) {
        Student s = null;
        try {
            Connection con = SqlQuery.getConnection();

            String q = "select pass from students where rollno = ?";

            PreparedStatement ps = con.prepareStatement(q);
            ps.setString(1, rollno);
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                s.setPass(rs.getString("pass"));
            }

            con.close();
        } catch (Exception e) {e.printStackTrace();}
//        if(s!=null)
            return s;
//        else
//            return null;
    }
    
}
