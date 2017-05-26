package DomainClasses;

import java.io.Serializable;

/**
 * Created by Waiting on 20-May-17.
 */
public class Paper implements Serializable,Identifiable<Integer> {
    protected Integer id;
    protected String name;

    public Paper(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        return "Paper{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
