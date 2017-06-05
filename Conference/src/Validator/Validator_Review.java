package Validator;

import DomainClasses.Review;

public class Validator_Review implements IValidator<Review>{
    @Override
    public void validate(Review review) throws Validator_Exception {
        //verificarea ID-ului entitatii se face in baza de date = > sql exception
        //idReviewer si idPaper, daca nu exista in baza de date = > sql exception
        if (review.getRecommendation().equals("")){
            throw(new Validator_Exception("Review recommendation cannot be empty."));
        }
        if (review.getQualifier().equals("")){
            throw(new Validator_Exception("Review qualifier cannot be empty."));
        }
    }
}
