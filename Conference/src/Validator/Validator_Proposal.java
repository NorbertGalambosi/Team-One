package Validator;

import DomainClasses.Proposal;

public class Validator_Proposal implements IValidator<Proposal> {
    @Override
    public void validate(Proposal proposal) throws Validator_Exception {
        //verificarea ID-ului entitatii se face in baza de date = > sql exception
        if (proposal.getName().equals("")){
            throw(new Validator_Exception("Proposal name cannot be empty"));
        }
        if (proposal.getKeywords().equals("")){
            throw(new Validator_Exception("Proposals need to have at least one keyword"));
        }
        if (proposal.getTopics().equals("")){
            throw(new Validator_Exception("Proposals need to have at least one topic"));
        }
    }
}