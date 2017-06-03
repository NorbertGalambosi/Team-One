package ConferencePersistence.Repository;

import DBUtils.DBConnection;
import DomainClasses.Paper;
import DomainClasses.PcMember;
import DomainClasses.Proposal;

import javax.swing.plaf.synth.SynthTextAreaUI;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
    public void save(Proposal entity) throws SQLException {
        int idProposal = 0;
        int idPcMember = 0;
        Random id = new Random();
        Connection conn = connection.getConnection();
        try (PreparedStatement preStmt = conn.prepareStatement("insert into Paper values (?,?,?)")) {
            preStmt.setInt(1,id.nextInt(500));
            preStmt.setString(2, entity.getFullPaper().getName());
            preStmt.setString(3,null);
            preStmt.executeUpdate();
        } catch (SQLException e) {
            throw e;
        }
        try (PreparedStatement preStmt = conn.prepareStatement("insert into Paper values (?,?,?)")) {
            preStmt.setInt(1,id.nextInt(500));
            preStmt.setString(2, entity.getAbstractPaper().getName());
            preStmt.setString(3,null);
            preStmt.executeUpdate();
        } catch (SQLException e) {
            throw e;
        }
        try (PreparedStatement preStmt = conn.prepareStatement("insert into Proposal values (null,?,?,?,?,?,?)")) {
            preStmt.setString(1, entity.getName());
            preStmt.setString(2, entity.getFullPaper().getName());
            preStmt.setString(3, entity.getAbstractPaper().getName());
            preStmt.setString(4, entity.getKeywords());
            preStmt.setString(5, entity.getTopics());
            preStmt.setBoolean(6, false);
            preStmt.executeUpdate();
        } catch (SQLException e) {
            throw e;
        }
        try(PreparedStatement preStmt = conn.prepareStatement("SELECT MAX(IdProposal) FROM Proposal")){
            ResultSet result = preStmt.executeQuery();
            if(result.next())
                idProposal = result.getInt(1);
        } catch (SQLException e) {
            throw e;
        }
        try(PreparedStatement preStmt = conn.prepareStatement("SELECT idPcMember FROM PcMember WHERE username = ?")){
            preStmt.setString(1,entity.getAutor().getName());
            ResultSet result = preStmt.executeQuery();
            if(result.next())
                idPcMember = result.getInt(1);
        } catch (SQLException e) {
            throw e;
        }
        try(PreparedStatement preStmt = conn.prepareStatement("INSERT INTO PcMember_Proposal VALUES (?,?)")){
            preStmt.setInt(1,idPcMember);
            preStmt.setInt(2,idProposal);
            preStmt.executeUpdate();
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public Proposal findOne(Integer integer) {
        Connection conn = connection.getConnection();
        Proposal proposal= new Proposal();
        String fullPaper = "", abstractPaper = "";
        List<PcMember> revieweri = new ArrayList<PcMember>();
        try (PreparedStatement prstmt = conn.prepareStatement("select * from Proposal where idProposal=?")) {
            prstmt.setInt(1, integer);
            try (ResultSet result = prstmt.executeQuery()) {
                if (result.next()) {
                    proposal.setid(result.getInt(1));
                    proposal.setName(result.getString(2));
                    fullPaper = result.getString(3);
                    abstractPaper = result.getString(4);
                    proposal.setKeywords(result.getString(5));
                    proposal.setTopics(result.getString(6));
                    proposal.setAccepted(result.getBoolean(7));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for(Paper p:repoPaper.findAll()){
            if (p.getName().equals(fullPaper))
                proposal.setFullPaper(p);
            if (p.getName().equals(abstractPaper))
                proposal.setAbstractPaper(p);
        }
        for(Integer i:this.findAuthorsIDByPaperID(proposal.getid()))
            proposal.setAutor(repoPCMember.findOne(i));

        for(Integer i:this.findReviewerIds(proposal.getid())) {
            PcMember pcm = repoPCMember.findOne(i);
            proposal.addReviewer(pcm);
        }
        for(Integer i:this.findBidderIds(proposal.getid())) {
            proposal.addBidder(repoPCMember.findOne(i));
        }
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

    public Iterable<Integer> findBidderIds(Integer integer){
        List<Integer> bidders = new ArrayList<Integer>();
        Connection conn = connection.getConnection();
        try (PreparedStatement preStmt = conn.prepareStatement("select idBidder from Bidder_Proposal where idProposal=?")) {
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

    public Iterable<PcMember> findBidders(Integer integer){
        List<PcMember> bidders = new ArrayList<PcMember>();
        List<Integer> bidderIds = (List<Integer>) this.findBidderIds(integer);
        Connection conn = connection.getConnection();
        for (Integer id: bidderIds) {
            bidders.add(repoPCMember.findOne(id));
        }
        return bidders;
    }


    public Iterable<Integer> findReviewerIds(Integer integer){
        List<Integer> reviewers = new ArrayList<Integer>();
        Connection conn = connection.getConnection();
        try(PreparedStatement prstmt = conn.prepareStatement("select idReviewer from Reviews where idPaper=?")) {
            prstmt.setInt(1,integer);
            try(ResultSet result = prstmt.executeQuery()){
                while(result.next()){
                    reviewers.add(result.getInt(1));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reviewers;
    }

    public Iterable<PcMember> findReviewers(Integer integer){
        List<PcMember> reviewers = new ArrayList<PcMember>();
        List<Integer> reviewerIds = (List<Integer>) this.findReviewerIds(integer);
        Connection conn = connection.getConnection();
        for (Integer id: reviewerIds) {
            reviewers.add(repoPCMember.findOne(id));
        }
        return reviewers;
    }
    public List<Integer> findAuthorsIDByPaperID(Integer id){
        Connection conn = connection.getConnection();
        List<Integer> idList = new ArrayList<>();
        try(PreparedStatement prstmt = conn.prepareStatement("select idPcMember from PcMember_Proposal where idProposal=?")){
            prstmt.setInt(1,id);
            try(ResultSet resultSet = prstmt.executeQuery()){
                while (resultSet.next())
                    idList.add(resultSet.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return idList;
    }
    public void assignReviewer(Integer idProposal,Integer idReviewer){
        Connection conn = connection.getConnection();
        Random idRandom = new Random();
        try(PreparedStatement prstmt = conn.prepareStatement("insert into Reviews VALUES (?,?,?,?,?)")){
            prstmt.setInt(1,idRandom.nextInt(500));
            prstmt.setInt(2,idProposal);
            prstmt.setInt(3,idReviewer);
            prstmt.setString(4,null);
            prstmt.setString(5,null);
            prstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void assignBidder(Integer idBidder ,Integer idProposal) throws SQLException {
        System.out.println(idBidder+" "+idProposal);
        Connection conn = connection.getConnection();
        Random idRandom = new Random();
        try(PreparedStatement prstmt = conn.prepareStatement("insert into Bidder_Proposal VALUES (?,?,?)")){
            prstmt.setInt(1,idRandom.nextInt(500));
            prstmt.setInt(2,idBidder);
            prstmt.setInt(3,idProposal);
            prstmt.executeUpdate();
        } catch (SQLException e) {
            throw e;
        }
    }
    public int findPcMemberId(String usernume) throws SQLException {
        System.out.println(usernume);
        Connection conn = connection.getConnection();
        try(PreparedStatement prstmt = conn.prepareStatement("SELECT idPcMember from PcMember where username=?")){
            prstmt.setString(1,usernume);
            ResultSet resultSet = prstmt.executeQuery();
            if(resultSet.next()){
                return resultSet.getInt(1);
            }
        } catch (SQLException e) {
            throw e;
        }return 0;
    }
    public int findProposalId(String name) throws SQLException {
        System.out.println(name);
        Connection conn = connection.getConnection();
        try(PreparedStatement prstmt = conn.prepareStatement("SELECT idProposal from Proposal where nameProposal=?")){
            prstmt.setString(1,name);
            ResultSet resultSet = prstmt.executeQuery();
            if(resultSet.next()){
                return resultSet.getInt(1);
            }
        } catch (SQLException e) {
            throw e;
        }return 0;}


    public Iterable<Proposal> findByAuthor(String numeAutor){
        Integer AuthorId = 0;
        List<Proposal> proposalList = new ArrayList<>();
        List<Integer> proposalIdList = new ArrayList<>();
        Connection conn = connection.getConnection();
        try(PreparedStatement preStmt = conn.prepareStatement("Select idPcMember from PcMember where username = ? ")){
            preStmt.setString(1,numeAutor);
            ResultSet resultSet = preStmt.executeQuery();
            if(resultSet.next()){
                AuthorId = resultSet.getInt(1);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        try(PreparedStatement preStmt = conn.prepareStatement("Select idProposal from PcMember_Proposal where idPcMember = ?")){
            preStmt.setInt(1, AuthorId);
            ResultSet resultSet = preStmt.executeQuery();
            while(resultSet.next()){
                proposalIdList.add(resultSet.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try(PreparedStatement preStmt = conn.prepareStatement("Select * from Proposal where idProposal = ?")){
            for (Integer id:proposalIdList) {
                preStmt.setInt(1,id);
                ResultSet resultSet = preStmt.executeQuery();
                if(resultSet.next()){
                    Proposal proposal = new Proposal();
                    proposal.setid(resultSet.getInt(1));
                    proposal.setName(resultSet.getString(2));
                    proposal.setFullPaper(new Paper(null,resultSet.getString(3),null));
                    proposal.setAbstractPaper(new Paper(null, resultSet.getString(4),null));
                    proposal.setKeywords(resultSet.getString(5));
                    proposal.setTopics(resultSet.getString(6));
                    proposal.setAccepted(resultSet.getBoolean(7));
                    proposalList.add(proposal);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return proposalList;
    }

    public Iterable<Proposal> findEnemyProposals(String numeAutor) {
        List<Integer> idList = new ArrayList<>();
        List<Proposal> proposalList = new ArrayList<>();
        List<Integer> proposalIdList = new ArrayList<>();
        Connection conn = connection.getConnection();
        try(PreparedStatement preStmt = conn.prepareStatement("Select idPcMember from PcMember where username <> ? ")){
            preStmt.setString(1,numeAutor);
            ResultSet resultSet = preStmt.executeQuery();
            while(resultSet.next()){
                idList.add(resultSet.getInt(1));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        try(PreparedStatement preStmt = conn.prepareStatement("Select idProposal from PcMember_Proposal where idPcMember = ?")){
            for (Integer id:idList) {
                preStmt.setInt(1, id);
                ResultSet resultSet = preStmt.executeQuery();
                while(resultSet.next()){
                    proposalIdList.add(resultSet.getInt(1));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try(PreparedStatement preStmt = conn.prepareStatement("Select * from Proposal where idProposal = ?")){
            for (Integer id:proposalIdList) {
                preStmt.setInt(1,id);
                ResultSet resultSet = preStmt.executeQuery();
                if(resultSet.next()){
                    Proposal proposal = new Proposal();
                    proposal.setid(resultSet.getInt(1));
                    proposal.setName(resultSet.getString(2));
                    proposal.setFullPaper(new Paper(null,resultSet.getString(3),null));
                    proposal.setAbstractPaper(new Paper(null, resultSet.getString(4),null));
                    proposal.setKeywords(resultSet.getString(5));
                    proposal.setTopics(resultSet.getString(6));
                    proposal.setAccepted(resultSet.getBoolean(7));
                    proposalList.add(proposal);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return proposalList;
    }

    public Proposal findByName(String proposal, String author) {
        Connection conn = connection.getConnection();
        Proposal propo= new Proposal();
        try (PreparedStatement prstmt = conn.prepareStatement("select * from Proposal where nameProposal=?")) {
            prstmt.setString(1, proposal);
            try (ResultSet result = prstmt.executeQuery()) {
                if (result.next()) {
                    propo.setid(result.getInt(1));
                    propo.setName(result.getString(2));
                    propo.setFullPaper(new Paper(null, result.getString(3),null));//fullPaper = result.getString(3);
                    propo.setAbstractPaper(new Paper(null, result.getString(4),null));//abstractPaper = result.getString(4);
                    propo.setKeywords(result.getString(5));
                    propo.setTopics(result.getString(6));
                    propo.setAccepted(result.getBoolean(7));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try(PreparedStatement prstmt = conn.prepareStatement("select fileName from Paper where namePaper =?")){
            prstmt.setString(1, propo.getFullPaper().getName());
            ResultSet resultSet = prstmt.executeQuery();
            if(resultSet.next()){
                propo.setFullPaper(new Paper(null, propo.getFullPaper().getName(), resultSet.getString(1)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try(PreparedStatement prstmt = conn.prepareStatement("select fileName from Paper where namePaper =?")){
            prstmt.setString(1, propo.getAbstractPaper().getName());
            ResultSet resultSet = prstmt.executeQuery();
            if(resultSet.next()){
                propo.setAbstractPaper(new Paper(null, propo.getAbstractPaper().getName(), resultSet.getString(1)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        int idPcMember=0;
        try(PreparedStatement prstmt = conn.prepareStatement("select idPcMember from PcMember_Proposal where idProposal = ?")){
            prstmt.setInt(1,propo.getid());
            ResultSet resultSet = prstmt.executeQuery();
            if(resultSet.next()){
                idPcMember=resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try(PreparedStatement prstmt = conn.prepareStatement("select namePcMember from PcMember where idPcMember=?")){
            prstmt.setInt(1,idPcMember);
            ResultSet resultSet = prstmt.executeQuery();
            if(resultSet.next()){
                PcMember pc = new PcMember();
                pc.setName(resultSet.getString(1));
                propo.setAutor(pc);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return propo;
    }

    public boolean status(String proposal) {
        Connection conn = connection.getConnection();
        Integer id = 0;
        try (PreparedStatement prstmt = conn.prepareStatement("select idProposal from Proposal where nameProposal=?")) {
            prstmt.setString(1, proposal);
            try (ResultSet result = prstmt.executeQuery()) {
                if (result.next()) {
                    id=result.getInt(1);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try(PreparedStatement prstmt = conn.prepareStatement("select count(id) from Bidder_Proposal where idProposal=?")){
            prstmt.setInt(1,id);
            ResultSet resultSet = prstmt.executeQuery();
            if(resultSet.next()){
                if(resultSet.getInt(1)>0){
                    return true;
                }
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
        //am mai adagat aici un coment
    }
}
