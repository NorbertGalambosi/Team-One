package ConferencePersistence.Controller;

import ConferencePersistence.Repository.Repository_PcMember;
import DomainClasses.PcMember;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Waiting on 24-May-17.
 */
public class Controller_PcMember {
    private Repository_PcMember repositoryPcMember;

    public Controller_PcMember(Repository_PcMember repo){
        this.repositoryPcMember=repo;
    }

    public void addPcMember(PcMember member){
        repositoryPcMember.save(member);
    }
    public void addTypeToPcMember(Integer idPcMember,String type){
        repositoryPcMember.addType(idPcMember,type);
    }
    public Iterable<PcMember> getAllPcMembers(){
        return repositoryPcMember.findAll();
    }
    public PcMember findByID(Integer id){
        return repositoryPcMember.findOne(id);
    }
    public List<PcMember> findAllByType(String type){
        List<Integer> idOfTypes = repositoryPcMember.findByType(type);
        List<PcMember> pcMemberList = new ArrayList<>();
        for(Integer i:idOfTypes)
            pcMemberList.add(repositoryPcMember.findOne(i));
        return pcMemberList;
    }
    public PcMember findByUserPass(String user,String pass){
        return repositoryPcMember.findByUserPass(user, pass);
    }
}
