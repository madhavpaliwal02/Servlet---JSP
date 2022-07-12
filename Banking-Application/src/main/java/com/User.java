package com;


public class User {
    private String uname, upass, email;
    
    public User(){
    }
    
    public User(String email, String uname, String upass){
        this.uname = uname;
        this.upass = upass;
        this.email = email;
    }
    
    public User(String email, String upass){
        this.upass = upass;
        this.email = email;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUpass() {
        return upass;
    }

    public void setUpass(String upass) {
        this.upass = upass;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
}
