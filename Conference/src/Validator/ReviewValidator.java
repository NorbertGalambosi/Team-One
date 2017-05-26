package Validator;

import DomainClasses.Review;

public class ReviewValidator implements IValidator<Review>{
    @Override
    public void validate(Review review) throws ValidatorException {
        //verificarea ID-ului entitatii se face in baza de date = > sql exception
        //idReviewer si idPaper, daca nu exista in baza de date = > sql exception
        if (review.getRecommendation().equals("")){
            throw(new ValidatorException("Review recommendation cannot be empty."));
        }
        if (review.getQualifier().equals("")){
            throw(new ValidatorException("Review qualifier cannot be empty."));
        }
    }
}
