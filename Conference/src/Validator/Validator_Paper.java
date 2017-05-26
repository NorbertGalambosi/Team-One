package Validator;

import DomainClasses.Paper;

public class Validator_Paper implements  IValidator<Paper> {
    @Override
    public void validate(Paper paper) throws Validator_Exception {
        //verificarea ID-ului entitatii se face in baza de date = > sql exception
        if (paper.getName().equals("")){
            throw(new Validator_Exception("Paper name cannot be empty"));
        }
        if (paper.getFileName().equals("")){
            throw(new Validator_Exception("Paper filename cannot be empty"));
        }
    }
}
