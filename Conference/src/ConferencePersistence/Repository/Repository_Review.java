package ConferencePersistence.Repository;

import DBUtils.DBConnection;
import DomainClasses.Review;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
    public Iterable<Review> findAll() {
        Connection conn = connection.getConnection();
        List<Review> reviewList = new ArrayList<>();
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

}
