package MVC;

public class model1 {
    private String username;
    private String password;

    public model1() {
        
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
        System.out.println(username);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        System.out.println(password);
    }
}
