package ConferencePersistence.Controller;

import ConferencePersistence.Repository.Repository_Session;
import DomainClasses.Session;

/**
 * Created by Waiting on 25-May-17.
 */
public class Controller_Session {
    public Repository_Session repositorySession;

    public Controller_Session(Repository_Session repo){
        this.repositorySession=repo;
    }

    public void addSession(Session entity){
        this.repositorySession.save(entity);
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
}
