package ConferencePersistence.Controller;
import ConferencePersistence.Repository.Repository_Paper;
import DomainClasses.Paper;
import Validator.Validator_Exception;
import Validator.Validator_Paper;
/**
 * Created by crys_ on 25.05.2017.
 */


public class Controller_Paper {

    private Repository_Paper repositoryPaper;
    private Validator_Paper validatorPaper;

    public Controller_Paper(Repository_Paper repo, Validator_Paper validator_paper){
        this.repositoryPaper=repo;
        this.validatorPaper=validator_paper;
    }

    public void addPaper(Paper paper) {
        try {
            this.validatorPaper.validate(paper);
            this.repositoryPaper.save(paper);
        } catch (Validator_Exception e) {
            e.printStackTrace();
        }
    }
    public void updatePaper(Paper paper, int id) {
        try {
            this.validatorPaper.validate(paper);
            this.repositoryPaper.update(paper, id);
        }catch (Validator_Exception e)
        {
            e.printStackTrace();
        }
    }

    public Iterable<Paper> getAllPaper(){
        return this.repositoryPaper.findAll();
    }

    public Paper findById(int id){
        return this.repositoryPaper.findOne(id);
    }

}
