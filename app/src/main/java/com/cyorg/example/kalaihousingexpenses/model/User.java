package com.cyorg.example.kalaihousingexpenses.model;

/**
 * Created by HCL on 12/3/2016.
 */
public class User {

    private String username;
    private String password;
    private int accessLevel;
    private boolean adminApproved;

    public static final int READ_ACCESS_LEVEL = 0;
    public static final int WRITE_ACCESS_LEVEL = 1;

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

    public int getAccessLevel() {
        return accessLevel;
    }

    public void setAccessLevel(int accessLevel) {
        this.accessLevel = accessLevel;
    }

    public boolean isAdminApproved() {
        return adminApproved;
    }

    public void setAdminApproved(boolean adminApproved) {
        this.adminApproved = adminApproved;
    }
}
