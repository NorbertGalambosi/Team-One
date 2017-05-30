package ConferencePersistence.Repository;

import DBUtils.DBConnection;
import DomainClasses.PcMember;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Waiting on 24-May-17.
 */
public class Repository_PcMember implements IRepository<Integer, PcMember> {
    private DBConnection connection;

    public Repository_PcMember(){
        super();
        connection = new DBConnection();
    }

    @Override
    public void save(PcMember entity) throws SQLException {
        Connection conn = connection.getConnection();
        try(PreparedStatement preStmt = conn.prepareStatement("insert into PcMember values (?,?,?,?,?,?,?,?)")){
            preStmt.setInt(1,entity.getid());
            preStmt.setString(2, entity.getName());
            preStmt.setString(3,entity.getAffiliation());
            preStmt.setString(4,entity.getEmail());
            preStmt.setString(5,entity.getWebpage());
            preStmt.setString(6,entity.getUsername());
            preStmt.setString(7,entity.getPassword());
            preStmt.setBoolean(8,entity.isPay());
            preStmt.executeUpdate();
        } catch (SQLException e) {
          //  e.printStackTrace();
            throw(e);
        }
        int sizePcMember_type=0;
        try(PreparedStatement preStmt=conn.prepareStatement("select count(*) as [Size] from PcMember_Type")) {
            try(ResultSet result = preStmt.executeQuery()) {
                if (result.next()) {
                    sizePcMember_type = result.getInt("SIZE");
                }
            }
        }catch(SQLException ex){
            System.out.println("Error DB "+ex);
        }
        sizePcMember_type++;
        for(String PCtype:entity.getType()) {
            System.out.println("Size sizePcMember_type :" + sizePcMember_type);
            try (PreparedStatement prestmt = conn.prepareStatement("insert into PcMember_Type values(?,?,?)")) {
                prestmt.setInt(1, sizePcMember_type);
                prestmt.setInt(2, entity.getid());
                prestmt.setString(3, PCtype);
                prestmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            sizePcMember_type++;
        }
    }

    @Override
    public Iterable<PcMember> findAll() {
        List<PcMember> pcMemberList = new ArrayList<>();
        Connection conn = connection.getConnection();
        try(PreparedStatement prstmt = conn.prepareStatement("select * from PcMember")) {
            try(ResultSet result = prstmt.executeQuery()){
                while(result.next()){
                    Integer id = result.getInt(1);
                    String name = result.getString(2);
                    String aff = result.getString(3);
                    String em = result.getString(4);
                    String web = result.getString(5);
                    String usr = result.getString(6);
                    String pw = result.getString(7);
                    boolean payed = result.getBoolean(8);
                    PcMember pcMember = new PcMember(id,name,aff,em,web,usr,pw,payed);
                    pcMemberList.add(pcMember);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for (PcMember pcMember:pcMemberList) {
            try(PreparedStatement prstmt = conn.prepareStatement("select type from PcMember_Type where idPcMember=?")){
                prstmt.setInt(1,pcMember.getid());
                try(ResultSet result = prstmt.executeQuery()){
                    while(result.next()){
                        pcMember.setType(result.getString("type"));
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return pcMemberList;
    }

    @Override
    public PcMember findOne(Integer id) {
            Connection conn = connection.getConnection();
            PcMember pcMember = new PcMember();

        try(PreparedStatement prstmt = conn.prepareStatement("select * from PcMember where idPcMember=?")) {
            prstmt.setInt(1,id);
            try(ResultSet result = prstmt.executeQuery()){
                if(result.next()){
                    Integer idP = result.getInt(1);
                    String name = result.getString(2);
                    String aff = result.getString(3);
                    String em = result.getString(4);
                    String web = result.getString(5);
                    String usr = result.getString(6);
                    String pw = result.getString(7);
                    boolean payed = result.getBoolean(8);
                    pcMember.setid(idP);
                    pcMember.setName(name);
                    pcMember.setAffiliation(aff);
                    pcMember.setEmail(em);
                    pcMember.setWebpage(web);
                    pcMember.setUsername(usr);
                    pcMember.setPassword(pw);
                    pcMember.setPay(payed);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

            try(PreparedStatement prstmt = conn.prepareStatement("select type from PcMember_Type where idPcMember=?")){
                prstmt.setInt(1,id);
                try(ResultSet result = prstmt.executeQuery()){
                    while(result.next()){
                        pcMember.setType(result.getString("type"));
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        return pcMember;
    }

    //return a list of IDs,each id represents the pcMember by the type we are looking for,can find the pcmember with findeOne
    public List<Integer> findByType(String type){
        List<Integer> pcMemberIDList = new ArrayList<>();
        Connection conn = connection.getConnection();
        try(PreparedStatement prstmt = conn.prepareStatement("select idPcMember from PcMember_Type where type=?")){
            prstmt.setString(1,type);
            try(ResultSet res = prstmt.executeQuery()){
                while (res.next()){
                    pcMemberIDList.add(res.getInt("idPcMember"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pcMemberIDList;
    }
    //can be used for login (check user,pass,type,everything if user and pass are ok)
    public PcMember findByUserPass(String user,String pass){
        PcMember pcMember = new PcMember();
        Connection conn = connection.getConnection();
        try(PreparedStatement prstmt = conn.prepareStatement("select * from PcMember where username=? and password=?")) {
            prstmt.setString(1,user);
            prstmt.setString(2,pass);
            try(ResultSet result = prstmt.executeQuery()){
                if(result.next()){
                    Integer idP = result.getInt(1);
                    String name = result.getString(2);
                    String aff = result.getString(3);
                    String em = result.getString(4);
                    String web = result.getString(5);
                    String usr = result.getString(6);
                    String pw = result.getString(7);
                    boolean payed = result.getBoolean(8);
                    pcMember.setid(idP);
                    pcMember.setName(name);
                    pcMember.setAffiliation(aff);
                    pcMember.setEmail(em);
                    pcMember.setWebpage(web);
                    pcMember.setUsername(usr);
                    pcMember.setPassword(pw);
                    pcMember.setPay(payed);
                    try(PreparedStatement prepstmt = conn.prepareStatement("select type from PcMember_Type where idPcMember=?")){
                        prepstmt.setInt(1,pcMember.getid());
                        try(ResultSet res = prepstmt.executeQuery()){
                            while(res.next()){
                                pcMember.setType(res.getString("type"));
                            }
                        }
                    }
                    return pcMember;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void addType(Integer idPcMember,String type) {
        Connection conn = connection.getConnection();

        int sizeType = 0;
        try (PreparedStatement preStmt = conn.prepareStatement("select count(*) as [Size] from PcMember_Type")) {
            try (ResultSet result = preStmt.executeQuery()) {
                if (result.next()) {
                    sizeType = result.getInt("SIZE");
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error DB " + ex);
        }
        sizeType++;
        System.out.println("Size sizePcMember_type :" + sizeType);
        try (PreparedStatement prestmt = conn.prepareStatement("insert into PcMember_Type values(?,?,?)")) {
            prestmt.setInt(1, sizeType);
            prestmt.setInt(2, idPcMember);
            prestmt.setString(3, type);
            prestmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
