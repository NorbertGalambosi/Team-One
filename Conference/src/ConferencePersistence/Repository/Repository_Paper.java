package ConferencePersistence.Repository;

import DBUtils.DBConnection;
import DomainClasses.Paper;


import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by crys_ on 25.05.2017.
 */
public class Repository_Paper implements IRepository<Integer, Paper> {

    private DBConnection connection;

    public Repository_Paper()
    {
        super();
        connection = new DBConnection();
    }

    @Override
    public void save(Paper entity) {
        Connection conn = connection.getConnection();
        try (PreparedStatement preStmt = conn.prepareStatement("insert into Paper values (?,?,?)")) {
            preStmt.setInt(1, entity.getid());
            preStmt.setString(2, entity.getName());
            preStmt.setString(3, entity.getFileName());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Paper entity, int id){
        Connection conn =  connection.getConnection();
        try(PreparedStatement preStmt = conn.prepareStatement("update Paper set namePaper=?,fileName=?, WHERE idPaper=?")){
            preStmt.setString(1, entity.getName());
            preStmt.setString(2,entity.getFileName());
            preStmt.setInt(3, id);
            preStmt.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(Integer id){
        Connection conn = connection.getConnection();
        try(PreparedStatement prstmt = conn.prepareStatement("delete from Paper where idPaper=?")){
            prstmt.setInt(1,id);
            prstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Paper findOne(Integer integer) {
        Connection conn = connection.getConnection();
        Paper paper = new Paper();

        try (PreparedStatement prstmt = conn.prepareStatement("select * from Paper where idPaper=?")) {
            prstmt.setInt(1, integer);
            try (ResultSet result = prstmt.executeQuery()) {
                if (result.next()) {
                    paper.setid(result.getInt(1));
                    paper.setName(result.getString(2));
                    paper.setFileName(result.getString(3));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return paper;
    }

    @Override
    public Iterable<Paper> findAll() {
        List<Paper> paperList= new ArrayList<>();
        Connection conn = connection.getConnection();
        try(PreparedStatement prstmt = conn.prepareStatement("select * from Proposal")) {
            try(ResultSet result = prstmt.executeQuery()){
                while(result.next()){
                    Paper paper= new Paper();
                    paper.setid(result.getInt(1));
                    paper.setName(result.getString(2));
                    paper.setFileName(result.getString(3));
                    paperList.add(paper);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return paperList;
    }

}
