package ConferencePersistence.Repository;

import DBUtils.DBConnection;
import DomainClasses.Review;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Waiting on 24-May-17.
 */
public class Repository_Review implements IRepository<Integer, Review> {
    private DBConnection connection;

    public Repository_Review(){
        super();
        connection = new DBConnection();
    }

    @Override
    public void save(Review entity) {
        Connection conn = connection.getConnection();
        try(PreparedStatement prstmt = conn.prepareStatement("insert into Reviews values(?,?,?,?,?)")) {
            prstmt.setInt(1,entity.getid());
            prstmt.setInt(2,entity.getIdPaper());
            prstmt.setInt(3,entity.getIdReviewer());
            prstmt.setString(4,entity.getRecommendation());
            prstmt.setString(5,entity.getQualifier());
            prstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<Review> findAll() {
        Connection conn = connection.getConnection();
        ArrayList<Review> reviewList = new ArrayList<>();
        try(PreparedStatement prstmt = conn.prepareStatement("select * from Reviews")){
            try(ResultSet res = prstmt.executeQuery()){
                while(res.next()){
                    Integer id = res.getInt(1);
                    Integer idP = res.getInt(2);
                    Integer idR = res.getInt(3);
                    String recomm = res.getString(4);
                    String qual = res.getString(5);
                    Review rev = new Review(id,idP,idR,recomm,qual);
                    reviewList.add(rev);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reviewList;
    }

    @Override
    public Review findOne(Integer IDrev) {
        Connection conn = connection.getConnection();
        try(PreparedStatement prstmt = conn.prepareStatement("select * from Reviews where idReview=?")){
            prstmt.setInt(1,IDrev);
            try(ResultSet res = prstmt.executeQuery()){
                if(res.next()){
                    Integer id = res.getInt(1);
                    Integer idP = res.getInt(2);
                    Integer idR = res.getInt(3);
                    String recomm = res.getString(4);
                    String qual = res.getString(5);
                    Review rev = new Review(id,idP,idR,recomm,qual);
                    return rev;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public void delete(Integer id){
        Connection conn = connection.getConnection();
        try(PreparedStatement prstmt = conn.prepareStatement("delete from Reviews where idReview=?")){
            prstmt.setInt(1,id);
            prstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void update(Review entity, Integer id, Integer id2){
        Connection conn =  connection.getConnection();
        try(PreparedStatement preStmt = conn.prepareStatement("update Reviews set recomandation=?,qualifier=? WHERE idPaper=? AND idReviewer=? ")){
            preStmt.setString(1, entity.getRecommendation());
            preStmt.setString(2, entity.getQualifier());
            preStmt.setInt(3, id);
            preStmt.setInt(4, id2);
            preStmt.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

//    public  ArrayList<Review> getAllReviews() {
//        Connection conn = connection.getConnection();
//        ArrayList<Review> countryList = new ArrayList<Review>();
//        try {
//          //  Statement statement = connection.createStatement();
//         //   ResultSet rs = statement.executeQuery("select * from Reviews limit 10");
//
//            while(rs.next()) {
//                Review country=new Review();
//                country.setid(rs.getInt("idReview"));
//                country.setIdPaper(rs.getInt("idPaper"));
//                country.setIdReviewer(rs.getInt("idReviewer"));
//                country.setRecommendation(rs.getString("recomandation"));
//                country.setQualifier(rs.getString("qualifier"));
//                countryList.add(country);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return countryList;
//    }

    public Iterable<Review> findByProposalName(String proposal) {
        Connection conn = connection.getConnection();
        List<Review> reviewList = new ArrayList<>();
        Integer id = 0;
        try(PreparedStatement preStmt = conn.prepareStatement("SELECT idProposal FROM Proposal where nameProposal=?")){
            preStmt.setString(1, proposal);
            ResultSet resultSet = preStmt.executeQuery();
            if(resultSet.next()){
                id = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try(PreparedStatement preStmt = conn.prepareStatement("SELECT * FROM Reviews where idPaper=?")){
            preStmt.setInt(1,id);
            ResultSet resultSet = preStmt.executeQuery();
            while(resultSet.next()){
                Review rev = new Review();
                rev.setid(resultSet.getInt(1));
                rev.setIdPaper(resultSet.getInt(2));
                rev.setIdReviewer(resultSet.getInt(3));
                rev.setRecommendation(resultSet.getString(4));
                rev.setQualifier(resultSet.getString(5));
                reviewList.add(rev);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reviewList;
    }

}
