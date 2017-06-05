package DomainClasses;

import java.io.Serializable;

/**
 * Created by Waiting on 20-May-17.
 */
public class Listeners implements Serializable,Identifiable<Integer> {
    protected Integer id;
    protected String name;
    protected String username;
    protected String password;
    protected String email;
    protected boolean pay;

    public Listeners(Integer id, String name, String username, String password, String email, boolean pay) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
        this.email = email;
        this.pay = pay;
    }
    @Override
    public Integer getid() {
        return id;
    }
    @Override
    public void setid(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isPay() {
        return pay;
    }

    public void setPay(boolean pay) {
        this.pay = pay;
    }

    @Override
    public String toString() {
        return "Listeners{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", pay=" + pay +
                '}';
    }
}
