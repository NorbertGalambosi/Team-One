package Validator;


import DomainClasses.Session;

public class Validator_Session implements IValidator<Session>{
    @Override
    public void validate(Session session) throws Validator_Exception {
        //verificarea ID-ului entitatii se face in baza de date = > sql exception
        //idConference, daca nu exista in baza de date = > sql exception
        if (session.getName().equals("")){
            throw(new Validator_Exception("Session name cannot be empty."));
        }
        if (session.getIdRoom().equals("")){
            throw(new Validator_Exception("Session room ID cannot be empty."));
        }
        if (session.getDuration().equals("")){
            throw(new Validator_Exception("Session duration cannot be empty."));
            // eventual s-ar putea verificat si daca conine caraterul ":" (ex: 05:30 - valid, 5 - invalid)
        }
    }
}