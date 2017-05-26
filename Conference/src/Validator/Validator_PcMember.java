package Validator;

import DomainClasses.PcMember;

public class Validator_PcMember implements IValidator<PcMember>{
    @Override
    public void validate(PcMember pcmember) throws Validator_Exception {
        //verificarea ID-ului entitatii se face in baza de date = > sql exception
        if (pcmember.getName().equals("")){
            throw(new Validator_Exception("PC Member name cannot be empty"));
        }
        if (pcmember.getAffiliation().equals("")){
            throw(new Validator_Exception("PC Member affiliation cannot be empty"));
        }
        if (!pcmember.getEmail().contains(".") || !pcmember.getEmail().contains("@") || pcmember.getEmail().equals("")){
            throw(new Validator_Exception("Wrong PC Member email format"));
        }
        if (pcmember.getWebpage().equals("") || !pcmember.getWebpage().contains(".")){
            throw(new Validator_Exception("Wrong PC Member webpage format"));
        }
        if (pcmember.getUsername().equals("")){
            throw(new Validator_Exception("PC Member username cannot be empty"));
        }
        if (pcmember.getPassword().equals("")){
            throw(new Validator_Exception("PC Member password cannot be empty"));
        }
        // TREBUIE SI ASTA?
        /*
        if (pcmember.getType().size()==0){
            throw(new Validator_Exception("PC Member type cannot be empty"));
        }*/
    }
}