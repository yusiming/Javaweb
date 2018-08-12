package yu.reflectTest;

/**
 * @Auther: yusiming
 * @Date: 2018/8/12 15:46
 * @Description:
 */
public class User {
    private String username;
    private String password;

    public User() {
    }

    private User(String username, String password) {
        this.username = username;
        this.password = password;
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
}
