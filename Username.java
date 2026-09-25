
import java.io.Serializable;

public class Username implements Serializable {

    private final String username;
    private final String password;
    private final Integer id;
    private boolean registered;


    public Username(String username, String password, Integer id) {

        this.username = username;
        this.password = password;
        this.id = id;
        this.registered = false;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Integer getId() {
        return id;
    }

    public boolean IsRegistered() {
        return registered == true;
    }

    public void setRegistered() {
        registered = true;
    }

    



}