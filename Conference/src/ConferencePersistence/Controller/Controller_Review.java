package ConferencePersistence.Controller;

import ConferencePersistence.Repository.Repository_Review;
import DomainClasses.Review;

/**
 * Created by Waiting on 24-May-17.
 */
public class Controller_Review {
    private Repository_Review repositoryReview;

    public Controller_Review(Repository_Review repo){
        this.repositoryReview=repo;
    }

    public void addReview(Review rev){
        this.repositoryReview.save(rev);
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
}
