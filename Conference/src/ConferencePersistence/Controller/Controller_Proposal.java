package ConferencePersistence.Controller;

import ConferencePersistence.Repository.Repository_Proposal;
import DomainClasses.Proposal;
import Validator.Validator_Exception;
import Validator.Validator_Proposal;

import java.sql.SQLException;
import java.util.List;

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
            repositoryProposal.save(entity);
            return true;
        }catch(Validator_Exception e){
            e.printStackTrace();
            return false;
        } catch (SQLException e) {
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
    public void assignReviewer(Integer idProp,Integer idRev){
        this.repositoryProposal.assignReviewer(idProp,idRev);
    }
    public void assignBidder(Integer idBidder,Integer idprop){
        this.repositoryProposal.assignBidder(idBidder, idprop);
    }

    public Iterable<Integer> findBidderIDs(Integer idProposal){
        return repositoryProposal.findBidderIds(idProposal);
    }
    public Iterable<Integer> findReviewerIDs(Integer idProposal){
        return repositoryProposal.findReviewerIds(idProposal);
    }
    public Iterable<Proposal> findByAuthor(String AuthorName){
        return this.repositoryProposal.findByAuthor(AuthorName);
    }


    public Iterable<Proposal> findEnemyProposals(String user) {
        return this.repositoryProposal.findEnemyProposals(user);
    }

    public Proposal findByName(String proposal, String author) {
        return this.repositoryProposal.findByName(proposal, author);
    }
}
