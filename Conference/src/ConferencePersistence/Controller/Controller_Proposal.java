package ConferencePersistence.Controller;

import ConferencePersistence.Repository.Repository_Proposal;
import DomainClasses.Proposal;
import Validator.Validator_Exception;
import Validator.Validator_Proposal;

/**
 * Created by Viman Adrian on 25.05.2017.
 */
public class Controller_Proposal {

    protected Repository_Proposal repositoryProposal;
    protected Validator_Proposal validatorProposal;

    public Controller_Proposal(Repository_Proposal repositoryProposal,Validator_Proposal vali) {
        this.repositoryProposal = repositoryProposal;
        this.validatorProposal = vali;
    }

    public boolean save(Proposal entity) {
        try{
            validatorProposal.validate(entity);
            this.repositoryProposal.save(entity);
            //System.out.println(entity);
            return true;
        }catch(Validator_Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public void update(Proposal proposal, Integer integer){
        try{
            validatorProposal.validate(proposal);
            this.repositoryProposal.update(proposal, integer);
        }catch(Validator_Exception e){
            e.printStackTrace();
        }
    }
    public Proposal findById(Integer integer){
        return this.repositoryProposal.findOne(integer);
    }

    public Iterable<Proposal> findAll(){
        return this.repositoryProposal.findAll();
    }

    public void delete(Integer integer){
        this.repositoryProposal.delete(integer);
    }

    public Iterable<Proposal> findByAutor(Integer integer){
        return this.repositoryProposal.findByAuthor(integer);
    }

    public Iterable<Proposal> findByReviewer(Integer integer){
        return this.repositoryProposal.findByReviewer(integer);
    }

    public Iterable<Proposal> findByBidder(Integer integer){
        return this.repositoryProposal.findByBidder(integer);
    }

}
