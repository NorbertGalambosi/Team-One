package Validator;
import DomainClasses.Conference;

public class Validator_Conference implements IValidator<Conference> {
    @Override
    public void validate(Conference conference) throws Validator_Exception {
        //verificarea ID-ului entitatii se face in baza de date = > sql exception
        if (conference.getName().equals(""))
            throw(new Validator_Exception("Conference name cannot be empty."));
        if (conference.getEdition()<0)
            throw(new Validator_Exception("Conference edition cannot be negative."));
        if (conference.getInterval().equals(""))
            throw(new Validator_Exception("Conference interval cannot be empty"));
        if (conference.getCallForPapers().equals(""))
            throw(new Validator_Exception("Conference Call For Papers cannot be empty"));
        if (conference.getProposalsDeadline().compareTo(conference.getAbstractDeadline())>0)
            throw(new Validator_Exception("Conference proposals deadline cannot be after abstract deadline."));
        if (conference.getAbstractDeadline().compareTo(conference.getBiddingDeadline())>0)
            throw(new Validator_Exception("Conference abstract deadline cannot be after bidding deadline."));
        if (conference.getBiddingDeadline().compareTo(conference.getReviewsDedline())>0)
            throw(new Validator_Exception("Conference bidding deadline cannot be after review deadline."));
        //if (conference.getNrParticipants()<=0)    initial poate avea 0
        //    throw(new Validator_Exception("Conference cannot have no participants."));
    }
}
