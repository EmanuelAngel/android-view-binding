package Model;

public class User {
    private int dni;
    private String userName;
    private String nickName;
    private String password;

    public User(int dni, String userName, String nickName, String password) {
        this.dni = dni;
        this.userName = userName;
        this.nickName = nickName;
        this.password = password;
    }

    public int getDni() {
        return dni;
    }

    public String getUserName() {
        return userName;
    }

    public String getNickName() {
        return nickName;
    }

    public String getPassword() {
        return password;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
