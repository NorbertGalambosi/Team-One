package ConferencePersistence.Validator;
import DomainClasses.Conference;

public class ConferenceValidator implements IValidator<Conference> {
    @Override
    public void validate(Conference conference) throws ValidatorException {
        //verificarea ID-ului entitatii se face in baza de date = > sql exception
        if (conference.getName().equals(""))
            throw(new ValidatorException("Conference name cannot be empty."));
        if (conference.getEdition()<0)
            throw(new ValidatorException("Conference edition cannot be negative."));
        if (conference.getInterval().equals(""))
            throw(new ValidatorException("Conference interval cannot be empty"));
        if (conference.getCallForPapers().equals(""))
            throw(new ValidatorException("Conference Call For Papers cannot be empty"));
        if (conference.getProposalsDeadline().compareTo(conference.getAbstractDeadline())>0)
            throw(new ValidatorException("Conference proposals deadline cannot be after abstract deadline."));
        if (conference.getAbstractDeadline().compareTo(conference.getBiddingDeadline())>0)
            throw(new ValidatorException("Conference abstract deadline cannot be after bidding deadline."));
        if (conference.getBiddingDeadline().compareTo(conference.getReviewsDedline())>0)
            throw(new ValidatorException("Conference bidding deadline cannot be after review deadline."));
        if (conference.getNrParticipants()<=0)
            throw(new ValidatorException("Conference cannot have no participants."));
    }
}
