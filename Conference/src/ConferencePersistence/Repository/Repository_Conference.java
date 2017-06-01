package ConferencePersistence.Repository;

import DBUtils.DBConnection;
import DomainClasses.Conference;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Viman Adrian on 25.05.2017.
 */
public class Repository_Conference implements IRepository<Integer, Conference> {

    private DBConnection connection;

    public Repository_Conference() {
        super();
        connection = new DBConnection();
    }

    @Override
    public void save(Conference entity) {
        Connection conn = connection.getConnection();
        try (PreparedStatement preStmt = conn.prepareStatement("insert into Conference values (?,?,?,?,?,?,?,?,?,?,?)")) {
            preStmt.setInt(1, entity.getid());
            preStmt.setString(2, entity.getName());
            preStmt.setInt(3, entity.getEdition());
            preStmt.setString(4, entity.getInterval());
            preStmt.setString(5, entity.getCallForPapers());
            preStmt.setString(6, entity.getProposalsDeadline());
            preStmt.setString(7, entity.getAbstractDeadline());
            preStmt.setString(8, entity.getBiddingDeadline());
            preStmt.setString(9, entity.getReviewsDedline());
            preStmt.setInt(10, entity.getNrParticipants());
            preStmt.setBoolean(11, entity.isActiv());
            preStmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Conference entity, int id){
        Connection conn =  connection.getConnection();
        try(PreparedStatement preStmt = conn.prepareStatement("update Conference set nameConference=?,edition=?,interval=?,callForPapers=?,proposalsDeadline=?,abstractDeadline=?,biddingDeadline=?,reviewsDeadline=?,nrParticipants=?,activ=? WHERE idConference=?")){
            preStmt.setString(1, entity.getName());
            preStmt.setInt(2, entity.getEdition());
            preStmt.setString(3, entity.getInterval());
            preStmt.setString(4, entity.getCallForPapers());
            preStmt.setString(5, entity.getProposalsDeadline());
            preStmt.setString(6, entity.getAbstractDeadline());
            preStmt.setString(7, entity.getBiddingDeadline());
            preStmt.setString(8, entity.getReviewsDedline());
            preStmt.setInt(9, entity.getNrParticipants());
            preStmt.setBoolean(10, entity.isActiv());
            preStmt.setInt(11, id);
            preStmt.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Iterable<Conference> findAll() {
        List<Conference> conferenceList = new ArrayList<>();
        Connection conn = connection.getConnection();
        try(PreparedStatement prstmt = conn.prepareStatement("select * from Conference")) {
            try(ResultSet result = prstmt.executeQuery()){
                while(result.next()){
                    Conference conference = new Conference();
                    conference.setid(result.getInt(1));
                    conference.setName(result.getString(2));
                    conference.setEdition(result.getInt(3));
                    conference.setInterval(result.getString(4));
                    conference.setCallForPapers(result.getString(5));
                    conference.setProposalsDeadline(result.getString(6));
                    conference.setAbstractDeadline(result.getString(7));
                    conference.setBiddingDeadline(result.getString(8));
                    conference.setReviewsDedline(result.getString(9));
                    conference.setNrParticipants(result.getInt(10));
                    conference.setActiv(result.getBoolean(11));
                    conferenceList.add(conference);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conferenceList;
    }

    @Override
    public Conference findOne(Integer integer) {
        Connection conn = connection.getConnection();
        Conference conference = new Conference();

        try (PreparedStatement prstmt = conn.prepareStatement("select * from Conference where idConference=?")) {
            prstmt.setInt(1, integer);
            try (ResultSet result = prstmt.executeQuery()) {
                if (result.next()) {
                    conference.setid(result.getInt(1));
                    conference.setName(result.getString(2));
                    conference.setEdition(result.getInt(3));
                    conference.setInterval(result.getString(4));
                    conference.setCallForPapers(result.getString(5));
                    conference.setProposalsDeadline(result.getString(6));
                    conference.setAbstractDeadline(result.getString(7));
                    conference.setBiddingDeadline(result.getString(8));
                    conference.setReviewsDedline(result.getString(9));
                    conference.setNrParticipants(result.getInt(10));
                    conference.setActiv(result.getBoolean(11));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conference;
    }

    public Conference findLatest() {
        Connection conn = connection.getConnection();
        Conference conference = new Conference();

        try (PreparedStatement prstmt = conn.prepareStatement("select * from Conference where idConference=(Select MAX(idConference) FROM Conference)")) {
            try (ResultSet result = prstmt.executeQuery()) {
                if (result.next()) {
                    conference.setid(result.getInt(1));
                    conference.setName(result.getString(2));
                    conference.setEdition(result.getInt(3));
                    conference.setInterval(result.getString(4));
                    conference.setCallForPapers(result.getString(5));
                    conference.setProposalsDeadline(result.getString(6));
                    conference.setAbstractDeadline(result.getString(7));
                    conference.setBiddingDeadline(result.getString(8));
                    conference.setReviewsDedline(result.getString(9));
                    conference.setNrParticipants(result.getInt(10));
                    conference.setActiv(result.getBoolean(11));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conference;
    }
}
