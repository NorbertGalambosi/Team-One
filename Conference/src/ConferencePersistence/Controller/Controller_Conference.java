package ConferencePersistence.Controller;

import ConferencePersistence.Repository.Repository_Conference;
import DomainClasses.Conference;
import Validator.Validator_Conference;
import Validator.Validator_Exception;

/**
 * Created by Viman Adrian on 25.05.2017.
 */
public class Controller_Conference {

    private Repository_Conference repositoryConference;
    private Validator_Conference validatorConference;

    public Controller_Conference(Repository_Conference repo,Validator_Conference vali){
        this.repositoryConference = repo;
        this.validatorConference = vali;
    }

    public void addConference(Conference conference){
        try {
            this.validatorConference.validate(conference);
            this.repositoryConference.save(conference);
        }catch(Validator_Exception e){
            e.printStackTrace();
        }
    }

    public void updateConference(Conference conference, int id){
        try {
            this.validatorConference.validate(conference);
            this.repositoryConference.update(conference,id);
        }catch(Validator_Exception e){
            e.printStackTrace();
        }
    }

    public Iterable<Conference> getAllConference(){
        return this.repositoryConference.findAll();
    }

    public Conference findById(int id){
        return this.repositoryConference.findOne(id);
    }

}
