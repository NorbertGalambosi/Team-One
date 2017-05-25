package ConferencePersistence.Repository;

import DBUtils.DBConnection;
import DomainClasses.Conference;
import DomainClasses.Proposal;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by crys_ on 25.05.2017.
 */
public class Repository_Proposal implements IRepository<Integer, Proposal>{

    private DBConnection connection;
    private Repository_Paper repoPaper;
    private Repository_PcMember repoPCMember;

    public Repository_Proposal()
    {
        super();
        repoPaper = new Repository_Paper();
        repoPCMember = new Repository_PcMember();
        connection = new DBConnection();
    }

    @Override
    public void save(Proposal entity) {
        Connection conn = connection.getConnection();
        try (PreparedStatement preStmt = conn.prepareStatement("insert into Proposal values (?,?,?,?,?,?,?)")) {
            preStmt.setInt(1, entity.getid());
            preStmt.setString(2, entity.getName());
            preStmt.setString(3, entity.getFullPaper());
            preStmt.setString(4, entity.getAbstractPaper());
            preStmt.setString(5, entity.getKeywords());
            preStmt.setString(6, entity.getTopics());
            preStmt.setBoolean(7, entity.isAccepted());
            preStmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Proposal findOne(Integer integer) {
        Connection conn = connection.getConnection();
        Proposal proposal= new Proposal();

        try (PreparedStatement prstmt = conn.prepareStatement("select * from Proposal where idProposal=?")) {
            prstmt.setInt(1, integer);
            try (ResultSet result = prstmt.executeQuery()) {
                if (result.next()) {
                    proposal.setid(result.getInt(1));
                    proposal.setName(result.getString(2));
                    proposal.setFullPaper(result.getString(3));
                    proposal.setAbstractPaper(result.getString(4));
                    proposal.setKeywords(result.getString(5));
                    proposal.setTopics(result.getString(6));
                    proposal.setAccepted(result.getBoolean(7));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return proposal;
    }

    public void update(Proposal entity, int id){
        Connection conn =  connection.getConnection();
        try(PreparedStatement preStmt = conn.prepareStatement("update Proposal set nameProposal=?,fullPaper=?,abstractPaper=?,keywords=?,topics=?,accepted=? WHERE idProposal=?")){
            preStmt.setString(1, entity.getName());
            preStmt.setString(2, entity.getFullPaper());
            preStmt.setString(3, entity.getAbstractPaper());
            preStmt.setString(4, entity.getKeywords());
            preStmt.setString(5, entity.getTopics());
            preStmt.setBoolean(6, entity.isAccepted());
            preStmt.setInt(7, id);
            preStmt.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Iterable<Proposal> findAll() {
        List<Proposal> proposalList = new ArrayList<>();
        Connection conn = connection.getConnection();
        try(PreparedStatement prstmt = conn.prepareStatement("select * from Proposal")) {
            try(ResultSet result = prstmt.executeQuery()){
                while(result.next()){
                    Proposal proposal= new Proposal();
                    proposal.setid(result.getInt(1));
                    proposal.setName(result.getString(2));
                    proposal.setFullPaper(result.getString(3));
                    proposal.setAbstractPaper(result.getString(4));
                    proposal.setKeywords(result.getString(5));
                    proposal.setTopics(result.getString(6));
                    proposal.setAccepted(result.getBoolean(7));
                    proposalList.add(proposal);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return proposalList;
    }

    public void delete(Integer id){
        Connection conn = connection.getConnection();
        try(PreparedStatement prstmt = conn.prepareStatement("delete from Proposal where idProposal=?")){
            prstmt.setInt(1,id);
            prstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Proposal findByAuthor(Integer integer) {
        Connection conn = connection.getConnection();
        Proposal proposal= new Proposal();
        int fullpaper, abstractpaper, reviewer,autor;
        fullpaper = -1;
        abstractpaper = -1;
        autor = -1;

        reviewer = -1;
        try (PreparedStatement prstmt = conn.prepareStatement("select * from Proposal where idReviewer=?")) {
            prstmt.setInt(1, integer);
            try (ResultSet result = prstmt.executeQuery()) {
                if (result.next()) {
                    proposal.setid(result.getInt(1));
                    proposal.setName(result.getString(2));
                    fullpaper = result.getInt(3);
                    abstractpaper = result.getInt(4);
                    proposal.setKeywords(result.getString(5));
                    proposal.setTopics(result.getString(6));
                    proposal.setAccepted(result.getBoolean(7));
                    autor = result.getInt(8);

                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        proposal.setFullPaper(repoPaper.findOne(fullpaper));
        proposal.setAbstractPaper(repoPaper.findOne(abstractpaper));
        proposal.setAutor(repoPCMember.findOne(autor));
        return proposal;
    }

    public Proposal findByReviewer(Integer integer) {
        Connection conn = connection.getConnection();
        Proposal proposal= new Proposal();
        int fullpaper, abstractpaper, autor ;
        fullpaper = -1;
        abstractpaper = -1;
        autor = -1;
        try (PreparedStatement prstmt = conn.prepareStatement("select * from Proposal where idAutor=?")) {
            prstmt.setInt(1, integer);
            try (ResultSet result = prstmt.executeQuery()) {
                if (result.next()) {
                    proposal.setid(result.getInt(1));
                    proposal.setName(result.getString(2));
                    fullpaper = result.getInt(3);
                    abstractpaper = result.getInt(4);
                    proposal.setKeywords(result.getString(5));
                    proposal.setTopics(result.getString(6));
                    proposal.setAccepted(result.getBoolean(7));
                    autor = result.getInt(8);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        proposal.setFullPaper(repoPaper.findOne(fullpaper));
        proposal.setAbstractPaper(repoPaper.findOne(abstractpaper));
        proposal.setAutor(repoPCMember.findOne(autor));
        return proposal;
    }
}
