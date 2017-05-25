package DomainClasses;

import java.io.Serializable;

/**
 * Created by Waiting on 20-May-17.
 */
public class Paper implements Serializable,Identifiable<Integer> {
    protected Integer id;
    protected String name;
    protected String fileName;

    public Paper(Integer id, String name, String fileName) {
        this.id = id;
        this.name = name;
        this.fileName = fileName;
    }

    public Paper() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
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
                ", fileName='" + fileName + '\'' +
                '}';
    }
}
