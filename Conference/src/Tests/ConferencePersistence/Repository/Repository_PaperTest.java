package ConferencePersistence.Repository;

import DomainClasses.Paper;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by IoanBogdan on 04.06.2017.
 */
public class Repository_PaperTest {
    Repository_Paper repo;
    Paper paper;

    @Before
    public void setUp() throws Exception {
        repo = new Repository_Paper();
        paper = new Paper(1,"Name1","File1");
        repo.save(paper);
        paper = new Paper(2,"Name2","File2");
        repo.save(paper);
    }

    @Test
    public void save() throws Exception {
        paper = new Paper(3,"Name3","File3");
        repo.save(paper);
        assertEquals(paper, repo.findOne(3));
    }

    @Test
    public void update() throws Exception {
        paper = new Paper(4,"Name4","File2");
        repo.update(paper,2);
        assertEquals(paper, repo.findOne(4));
    }


    @Test
    public void findOne() throws Exception {
        Integer id = 2;
        assertEquals(paper, repo.findOne(id));
    }

}