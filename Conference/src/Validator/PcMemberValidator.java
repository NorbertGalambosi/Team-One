package Validator;

import DomainClasses.PcMember;

public class PcMemberValidator implements IValidator<PcMember>{
    @Override
    public void validate(PcMember pcmember) throws ValidatorException {
        //verificarea ID-ului entitatii se face in baza de date = > sql exception
        if (pcmember.getName().equals("")){
            throw(new ValidatorException("PC Member name cannot be empty"));
        }
        if (pcmember.getAffiliation().equals("")){
            throw(new ValidatorException("PC Member affiliation cannot be empty"));
        }
        if (!pcmember.getEmail().contains(".") || !pcmember.getEmail().contains("@") || pcmember.getEmail().equals("")){
            throw(new ValidatorException("Wrong PC Member email format"));
        }
        if (pcmember.getWebpage().equals("") || !pcmember.getWebpage().contains(".")){
            throw(new ValidatorException("Wrong PC Member webpage format"));
        }
        if (pcmember.getUsername().equals("")){
            throw(new ValidatorException("PC Member username cannot be empty"));
        }
        if (pcmember.getPassword().equals("")){
            throw(new ValidatorException("PC Member password cannot be empty"));
        }
        // TREBUIE SI ASTA?
        /*
        if (pcmember.getType().size()==0){
            throw(new ValidatorException("PC Member type cannot be empty"));
        }*/
    }
}