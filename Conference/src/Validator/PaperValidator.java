package ConferencePersistence.Validator;

import DomainClasses.Paper;

public class PaperValidator implements  IValidator<Paper> {
    @Override
    public void validate(Paper paper) throws ValidatorException {
        //verificarea ID-ului entitatii se face in baza de date = > sql exception
        if (paper.getName().equals("")){
            throw(new ValidatorException("Paper name cannot be empty"));
        }
        if (paper.getFileName().equals("")){
            throw(new ValidatorException("Paper filename cannot be empty"));
        }
    }
}
