package ConferencePersistence.Repository;

import DBUtils.DBConnection;
import DomainClasses.Session;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Waiting on 24-May-17.
 */
public class Repository_Session implements IRepository<Integer, Session> {
    private DBConnection connection;

    public Repository_Session(){
        super();
        connection = new DBConnection();
    }

    @Override
    public void save(Session entity) {
        Connection conn = connection.getConnection();
        try(PreparedStatement prstmt = conn.prepareStatement("insert into Session values(?,?,?,?,?)")){
            prstmt.setInt(1,entity.getid());
            prstmt.setInt(2,entity.getIdConference());
            prstmt.setString(3,entity.getName());
            prstmt.setString(4,entity.getIdRoom());
            prstmt.setString(5,entity.getDuration());
            prstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Iterable<Session> findAll() {
        Connection conn = connection.getConnection();
        List<Session> sessionList = new ArrayList<>();
        try(PreparedStatement prstmt = conn.prepareStatement("select * from Session")){
            try(ResultSet res = prstmt.executeQuery()){
                while (res.next()){
                    Integer id = res.getInt(1);
                    Integer idS = res.getInt(2);
                    String name = res.getString(3);
                    String idR = res.getString(4);
                    String dur = res.getString(5);
                    Session session = new Session(id,idS,name,idR,dur);
                    sessionList.add(session);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sessionList;
    }

    @Override
    public Session findOne(Integer integer) {
        Connection conn = connection.getConnection();
        try(PreparedStatement prstmt = conn.prepareStatement("select * from Session where idSession=?")){
            prstmt.setInt(1,integer);
            try(ResultSet res = prstmt.executeQuery()){
                if (res.next()){
                    Integer idS = res.getInt(2);
                    String name = res.getString(3);
                    String idR = res.getString(4);
                    String dur = res.getString(5);
                    Session session = new Session(integer,idS,name,idR,dur);
                    return session;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public Session findOne(String name) {
        Connection conn = connection.getConnection();
        try(PreparedStatement prstmt = conn.prepareStatement("select * from Session where nameSession=?")){
            prstmt.setString(1,name);
            try(ResultSet res = prstmt.executeQuery()){
                if (res.next()){
                    Integer integer = res.getInt(1);
                    Integer idS = res.getInt(2);
                    String idR = res.getString(4);
                    String dur = res.getString(5);
                    Session session = new Session(integer,idS,name,idR,dur);
                    return session;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void addChair(Integer id,Integer idS,Integer idC){
        Connection conn = connection.getConnection();
        try(PreparedStatement prstmt = conn.prepareStatement("insert into Session_Chair values(?,?,?)")){
           prstmt.setInt(1,id);
           prstmt.setInt(2,idS);
           prstmt.setInt(3,idC);
           prstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void addListener(Integer id,Integer idS,Integer idL){
        Connection conn = connection.getConnection();
        try(PreparedStatement prstmt = conn.prepareStatement("insert into Session_Listener values(?,?,?)")){
            prstmt.setInt(1,id);
            prstmt.setInt(2,idS);
            prstmt.setInt(3,idL);
            prstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void addSpeaker(Integer id,Integer idS,Integer idSp){
        Connection conn = connection.getConnection();
        try(PreparedStatement prstmt = conn.prepareStatement("insert into Session_Speakers values(?,?,?)")){
            prstmt.setInt(1,id);
            prstmt.setInt(2,idS);
            prstmt.setInt(3,idSp);
            prstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public Iterable<Session> findByConference(Integer integer){
        List<Session> sessionList = new ArrayList<>();
        Connection conn = connection.getConnection();
        try(PreparedStatement prstmt = conn.prepareStatement("select * from Session where idConference=?")){
            prstmt.setInt(1,integer);
            try(ResultSet res = prstmt.executeQuery()){
                while (res.next()){
                    Integer id = res.getInt(1);
                    Integer idS = res.getInt(2);
                    String name = res.getString(3);
                    String idR = res.getString(4);
                    String dur = res.getString(5);
                    Session session = new Session(id,idS,name,idR,dur);
                    sessionList.add(session);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sessionList;
    }

}
