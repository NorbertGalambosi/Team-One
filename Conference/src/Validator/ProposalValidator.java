package Validator;

import DomainClasses.Proposal;

public class ProposalValidator implements IValidator<Proposal> {
    @Override
    public void validate(Proposal proposal) throws ValidatorException {
        //verificarea ID-ului entitatii se face in baza de date = > sql exception
        if (proposal.getName().equals("")){
            throw(new ValidatorException("Proposal name cannot be empty"));
        }
        if (proposal.getKeywords().equals("")){
            throw(new ValidatorException("Proposals need to have at least one keyword"));
        }
        if (proposal.getTopics().equals("")){
            throw(new ValidatorException("Proposals need to have at least one topic"));
        }
    }
}