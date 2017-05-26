package DomainClasses;

import java.io.Serializable;

/**
 * Created by Waiting on 20-May-17.
 */
public class Session implements Serializable,Identifiable<Integer> {
    protected Integer id;
    protected Integer idConference;
    protected String name;
    protected String idRoom;
    protected String duration;

    public Session(Integer id, Integer idConf,String name, String idRoom, String duration) {
        this.id = id;
        this.idConference = idConf;
        this.name = name;
        this.idRoom = idRoom;
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdRoom() {
        return idRoom;
    }

    public void setIdRoom(String idRoom) {
        this.idRoom = idRoom;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public Integer getIdConference() {
        return idConference;
    }

    public void setIdConference(Integer idConference) {
        this.idConference = idConference;
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
        return "Session{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", idRoom='" + idRoom + '\'' +
                ", duration='" + duration + '\'' +
                '}';
    }
}
