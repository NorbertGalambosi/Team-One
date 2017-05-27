package ConferencePersistence.Controller;

import ConferencePersistence.Repository.Repository_PcMember;
import DomainClasses.PcMember;
import Validator.Validator_Exception;
import Validator.Validator_PcMember;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Waiting on 24-May-17.
 */
public class Controller_PcMember {
    private Repository_PcMember repositoryPcMember;
    private Validator_PcMember validatorPcMember;

    public Controller_PcMember(Repository_PcMember repo,Validator_PcMember valid){
        this.repositoryPcMember=repo;
        this.validatorPcMember=valid;
    }

    public void addPcMember(PcMember member){
        try{
            validatorPcMember.validate(member);
            repositoryPcMember.save(member);
        } catch (Validator_Exception e) {
            e.printStackTrace();
        }

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
