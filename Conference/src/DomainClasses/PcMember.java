package DomainClasses;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Waiting on 20-May-17.
 */

public class PcMember implements Serializable,Identifiable<Integer> {
    protected Integer id;
    protected String name;
    protected String affiliation;
    protected String email;
    protected String webpage;
    protected String username;
    protected String password;
    protected boolean pay;
    protected List<String> type = new ArrayList<>();

    public PcMember(Integer id, String name, String affiliation, String email, String webpage, String username, String password, boolean pay, List<String> type) {
        this.id = id;
        this.name = name;
        this.affiliation = affiliation;
        this.email = email;
        this.webpage = webpage;
        this.username = username;
        this.password = password;
        this.pay = pay;
        this.type = type;
    }
    public PcMember(Integer id, String name, String affiliation, String email, String webpage, String username, String password, boolean pay) {
        this.id = id;
        this.name = name;
        this.affiliation = affiliation;
        this.email = email;
        this.webpage = webpage;
        this.username = username;
        this.password = password;
        this.pay = pay;
    }
    public PcMember(){};

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAffiliation() {
        return affiliation;
    }

    public void setAffiliation(String affiliation) {
        this.affiliation = affiliation;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebpage() {
        return webpage;
    }

    public void setWebpage(String webpage) {
        this.webpage = webpage;
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

    public boolean isPay() {
        return pay;
    }

    public void setPay(boolean pay) {
        this.pay = pay;
    }

    public List<String> getType() {
        return type;
    }
    public String getOneType(int idType){
        return this.type.get(idType);
    }
    public void setType(String type) {
        this.type.add(type);
    }

    @Override
    public void setid(Integer integer) {
        this.id=integer;
    }

    @Override
    public Integer getid() {
        return this.id;
    }

    @Override
    public String toString() {
        return "PcMember{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", affiliation='" + affiliation + '\'' +
                ", email='" + email + '\'' +
                ", webpage='" + webpage + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", pay=" + pay +
                ", type='" + type + '\'' +
                '}';
    }
}
