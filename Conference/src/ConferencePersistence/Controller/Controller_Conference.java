package ConferencePersistence.Controller;

import ConferencePersistence.Repository.Repository_Conference;
import DomainClasses.Conference;

/**
 * Created by Viman Adrian on 25.05.2017.
 */
public class Controller_Conference {

    private Repository_Conference repositoryConference;

    public Controller_Conference(Repository_Conference repo){
        this.repositoryConference=repo;
    }

    public void addConference(Conference conference){
        this.repositoryConference.save(conference);
    }

    public void updateConference(Conference conference, int id){
        this.repositoryConference.update(conference,id);
    }

    public Iterable<Conference> getAllConference(){
        return this.repositoryConference.findAll();
    }

    public Conference findById(int id){
        return this.repositoryConference.findOne(id);
    }

}
