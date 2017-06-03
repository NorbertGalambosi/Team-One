package ConferencePersistence.Controller;

import ConferencePersistence.Repository.Repository_Review;
import DomainClasses.Review;
import Validator.Validator_Exception;
import Validator.Validator_Review;

/**
 * Created by Waiting on 24-May-17.
 */
public class Controller_Review {
    private Repository_Review repositoryReview;
    private Validator_Review validatorReview;

    public Controller_Review(Repository_Review repo,Validator_Review valid){
        this.repositoryReview=repo;
        this.validatorReview=valid;
    }

    public void addReview(Review rev){
        try {
            validatorReview.validate(rev);
            this.repositoryReview.save(rev);
        } catch (Validator_Exception e) {
            e.printStackTrace();
        }
    }
    public void delteReview(Integer idReview){
        this.repositoryReview.delete(idReview);
    }
    public Review getReviewByID(Integer id){
        return  this.repositoryReview.findOne(id);
    }
    public Iterable<Review> getAllReviews(){
        return this.repositoryReview.findAll();
    }

    public Iterable<Review> findByProposalName(String proposal, String author) {
        return this.repositoryReview.findByProposalName(proposal);
    }
}
