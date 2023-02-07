package model;

public class account {
    private int id_account;
    private String username;
    private String pass;
    private String passHash;
    private int permission;
    private String name;
    private int status = 1;

    public account(int id_account, String username, String pass, String passHash, int permission, String name) {
        this.id_account = id_account;
        this.username = username;
        this.pass = pass;
        this.passHash = passHash;
        this.permission = permission;
        this.name = name;
    }

    public account() {
    }

    public int getId_account() {
        return id_account;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setId_account(int id_account) {
        this.id_account = id_account;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getPassHash() {
        return passHash;
    }

    public void setPassHash(String passHash) {
        this.passHash = passHash;
    }

    public int getPermission() {
        return permission;
    }

    public void setPermission(int permission) {
        this.permission = permission;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
}
