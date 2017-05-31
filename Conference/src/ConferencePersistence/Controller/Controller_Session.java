package ConferencePersistence.Controller;

import ConferencePersistence.Repository.Repository_Session;
import DomainClasses.Session;
import Validator.Validator_Exception;
import Validator.Validator_Session;

import java.util.List;

/**
 * Created by Waiting on 25-May-17.
 */
public class Controller_Session {
    protected Repository_Session repositorySession;
    protected Validator_Session validatorSession;


    public Controller_Session(Repository_Session repo,Validator_Session valid){
        this.repositorySession=repo;
        this.validatorSession=valid;
    }

    public void addSession(Session entity){
        try {
            validatorSession.validate(entity);
            this.repositorySession.save(entity);
        } catch (Validator_Exception e) {
            e.printStackTrace();
        }
    }
    public void addChairToSession(Integer id,Integer idS,Integer idC){
        this.repositorySession.addChair(id, idS, idC);
    }
    public void addListenerToSession(Integer id,Integer idS,Integer idL){
        this.repositorySession.addListener(id, idS, idL);
    }
    public void addSpeakerToSession(Integer id,Integer idS,Integer idSp){
        this.repositorySession.addSpeaker(id, idS, idSp);
    }
    public Session findSessionByID(Integer id){
        return repositorySession.findOne(id);
    }
    public Iterable<Session> getAllSessions(){
        return repositorySession.findAll();
    }

    public Iterable<Session> findByConference(Integer integer) {
        return this.repositorySession.findByConference(integer);
    }
}
