package ConferencePersistence.Controller;

import ConferencePersistence.Repository.Repository_Paper;
import DomainClasses.Paper;
import Validator.Validator_Paper;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by IoanBogdan on 04.06.2017.
 */
public class Controller_PaperTest {
    Validator_Paper validator_paper;
    Repository_Paper repo;
    Controller_Paper ctrl;
    Paper paper;

    @Before
    public void setUp() throws Exception {
        validator_paper = new Validator_Paper();
        repo = new Repository_Paper();
        ctrl = new Controller_Paper(repo, validator_paper);
        paper = new Paper(1,"Name1","File1");
        ctrl.addPaper(paper);
        paper = new Paper(2,"Name2","File2");
        ctrl.addPaper(paper);
    }
    @Test
    public void addPaper() throws Exception {
        paper = new Paper(3,"Name3","File3");
        ctrl.addPaper(paper);
        assertEquals(paper,ctrl.findById(3));
    }

    @Test
    public void updatePaper() throws Exception {
        paper = new Paper(3,"Name5","File5");
        ctrl.updatePaper(paper,2);
        assertEquals(paper,ctrl.findById(3));
    }

    @Test
    public void findById() throws Exception {
        paper = new Paper(2,"Name2","File2");
        assertEquals(paper,ctrl.findById(2));
    }

}