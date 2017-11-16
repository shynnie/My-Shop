package vn.edu.myshop.myshop;

/**
 * Created by quangngoc430 on 16/11/2017.
 */

public class User {
    private String username;
    private String password;
    private int userID;

    public User() {
    }

    public User(String username, String password, int userID) {
        this.username = username;
        this.password = password;
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }
}
