package ConferencePersistence.Controller;

import ConferencePersistence.Repository.Repository_Proposal;
import DomainClasses.Proposal;

/**
 * Created by Viman Adrian on 25.05.2017.
 */
public class Controller_Proposal {

    protected Repository_Proposal repositoryProposal = new Repository_Proposal();

    public void save(Proposal entity){
        this.repositoryProposal.save(entity);
    }

    public Proposal findById(Integer integer){
        return this.repositoryProposal.findOne(integer);
    }

    public void update(Proposal proposal, Integer integer){
        this.repositoryProposal.update(proposal, integer);
    }

    public Iterable<Proposal> findAll(){
        return this.repositoryProposal.findAll();
    }

    public void delete(Integer integer){
        this.delete(integer);
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
