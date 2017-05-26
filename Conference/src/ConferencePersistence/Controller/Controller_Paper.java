package ConferencePersistence.Controller;
import ConferencePersistence.Repository.Repository_Paper;
import DomainClasses.Paper;
/**
 * Created by crys_ on 25.05.2017.
 */


public class Controller_Paper {

    private Repository_Paper repositoryPaper;

    public Controller_Paper(Repository_Paper repo){this.repositoryPaper=repo;}

    public void addPaper(Paper paper){
        this.repositoryPaper.save(paper);
    }

    public void updatePaper(Paper paper, int id){
        this.repositoryPaper.update(paper,id);
    }

    public Iterable<Paper> getAllPaper(){
        return this.repositoryPaper.findAll();
    }

    public Paper findById(int id){
        return this.repositoryPaper.findOne(id);
    }

}
