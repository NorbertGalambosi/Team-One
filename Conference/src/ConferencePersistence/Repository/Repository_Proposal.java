package ConferencePersistence.Repository;

import DBUtils.DBConnection;
import DomainClasses.Conference;
import DomainClasses.PcMember;
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
        try (PreparedStatement preStmt = conn.prepareStatement("insert into Proposal values (null,?,?,?,?,?,?,?)")) {
            preStmt.setString(1, entity.getName());
            //preStmt.setInt(3, entity.getFullPaper().getid());
            preStmt.setInt(2,0);
            //preStmt.setInt(4, entity.getAbstractPaper().getid());
            preStmt.setInt(3,0);
            preStmt.setString(4, entity.getKeywords());
            preStmt.setString(5, entity.getTopics());
            preStmt.setBoolean(6, false);
            preStmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Proposal findOne(Integer integer) {
        Connection conn = connection.getConnection();
        Proposal proposal= new Proposal();
        int fullPaper = -1, abstractPaper = -1, autor = -1;
        List<PcMember> revieweri = new ArrayList<PcMember>();
        try (PreparedStatement prstmt = conn.prepareStatement("select * from Proposal where idProposal=?")) {
            prstmt.setInt(1, integer);
            try (ResultSet result = prstmt.executeQuery()) {
                if (result.next()) {
                    proposal.setid(result.getInt(1));
                    proposal.setName(result.getString(2));
                    fullPaper = result.getInt(3);
                    abstractPaper = result.getInt(4);
                    proposal.setKeywords(result.getString(5));
                    proposal.setTopics(result.getString(6));
                    proposal.setAccepted(result.getBoolean(7));
                    autor = result.getInt(8);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        proposal.setFullPaper(repoPaper.findOne(fullPaper));
        proposal.setAbstractPaper(repoPaper.findOne(abstractPaper));
        proposal.setAutor(repoPCMember.findOne(autor));
        proposal.setReviewers(this.findReviewers(integer));
        proposal.setBidders(this.findBidders(integer));
        return proposal;
    }

    public void update(Proposal entity, int id){
        Connection conn =  connection.getConnection();
        try(PreparedStatement preStmt = conn.prepareStatement("update Proposal set nameProposal=?,fullPaper=?,abstractPaper=?,keywords=?,topics=?,accepted=?,idAutor=? WHERE idProposal=?")){
            preStmt.setString(1, entity.getName());
            preStmt.setInt(2, entity.getFullPaper().getid());
            preStmt.setInt(3, entity.getAbstractPaper().getid());
            preStmt.setString(4, entity.getKeywords());
            preStmt.setString(5, entity.getTopics());
            preStmt.setBoolean(6, entity.isAccepted());
            preStmt.setInt(7, id);
            preStmt.setInt(8,entity.getAutor().getid());
            preStmt.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Iterable<Proposal> findAll() {
        List<Integer> proposalIds = new ArrayList<>();
        List<Proposal> proposalList = new ArrayList<>();
        Connection conn = connection.getConnection();
        try(PreparedStatement prstmt = conn.prepareStatement("select idProposal from Proposal")) {
            try(ResultSet result = prstmt.executeQuery()){
                while(result.next()){
                    proposalIds.add(result.getInt(1));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for (Integer id: proposalIds) {
            proposalList.add(this.findOne(id));
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

    public Iterable<Proposal> findByAuthor(Integer integer) {
        List<Integer> proposalIds = new ArrayList<>();
        List<Proposal> proposalList = new ArrayList<>();
        Connection conn = connection.getConnection();
        try(PreparedStatement prstmt = conn.prepareStatement("select idProposal from Proposal where idAutor=?")) {
            prstmt.setInt(1,integer);
            try(ResultSet result = prstmt.executeQuery()){
                while(result.next()){
                    proposalIds.add(result.getInt(1));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for (Integer id: proposalIds) {
            proposalList.add(this.findOne(id));
        }
        return proposalList;
    }

    public Iterable<Proposal> findByReviewer(Integer integer) {
        List<Integer> proposalIds = new ArrayList<>();
        List<Proposal> proposalList = new ArrayList<>();
        Connection conn = connection.getConnection();
        try(PreparedStatement prstmt = conn.prepareStatement("select idProposal from Proposal pr, Reviewer_Proposal rp where pr.idProposal = rp.idProposal")) {
            try(ResultSet result = prstmt.executeQuery()){
                while(result.next()){
                    proposalIds.add(result.getInt(1));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for (Integer id: proposalIds) {
            proposalList.add(this.findOne(id));
        }
        return proposalList;
    }

    public Iterable<Proposal> findByBidder(Integer integer){
        List<Integer> proposalIds = new ArrayList<>();
        List<Proposal> proposalList = new ArrayList<>();
        Connection conn = connection.getConnection();
        try(PreparedStatement prstmt = conn.prepareStatement("select idProposal from Proposal pr, Bidder_Proposal bp where pr.idProposal = bp.idProposal")) {
            try(ResultSet result = prstmt.executeQuery()){
                while(result.next()){
                    proposalIds.add(result.getInt(1));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for (Integer id: proposalIds) {
            proposalList.add(this.findOne(id));
        }
        return proposalList;
    }

    protected Iterable<Integer> findBidderIds(Integer integer){
        List<Integer> bidders = new ArrayList<Integer>();
        Connection conn = connection.getConnection();
        try (PreparedStatement preStmt = conn.prepareStatement("select idPcMember from Bidder_Proposal where idProposal=?")) {
            preStmt.setInt(1,integer);
            try(ResultSet result = preStmt.executeQuery()){
                while(result.next()){
                    bidders.add(result.getInt(1));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bidders;
    }

    protected Iterable<PcMember> findBidders(Integer integer){
        List<PcMember> bidders = new ArrayList<PcMember>();
        List<Integer> bidderIds = (List<Integer>) this.findBidderIds(integer);
        Connection conn = connection.getConnection();
        for (Integer id: bidderIds) {
            bidders.add(repoPCMember.findOne(id));
        }
        return bidders;
    }


    protected Iterable<Integer> findReviewerIds(Integer integer){
        List<Integer> reviewers = new ArrayList<Integer>();
        Connection conn = connection.getConnection();
        try (PreparedStatement preStmt = conn.prepareStatement("select idReviewer from Reviewer_Proposal where idProposal=?")) {
            preStmt.setInt(1,integer);
            try(ResultSet result = preStmt.executeQuery()){
                while(result.next()){
                    reviewers.add(result.getInt(1));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reviewers;
    }

    protected Iterable<PcMember> findReviewers(Integer integer){
        List<PcMember> reviewers = new ArrayList<PcMember>();
        List<Integer> reviewerIds = (List<Integer>) this.findReviewerIds(integer);
        Connection conn = connection.getConnection();
        for (Integer id: reviewerIds) {
            reviewers.add(repoPCMember.findOne(id));
        }
        return reviewers;
    }

}
