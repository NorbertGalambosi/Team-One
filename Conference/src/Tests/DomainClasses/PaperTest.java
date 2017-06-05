package DomainClasses;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by IoanBogdan on 04.06.2017.
 */
public class PaperTest {
    private Paper paper;
    @Before
    public void setUp() throws Exception {
        paper = new Paper(1,"Paper Name","fileName.pdf");
    }

    @Test
    public void getName() throws Exception {
        assertEquals("Paper Name", paper.getName());
        assertNotEquals("Paper Nameles", paper.getName());
    }

    @Test
    public void setName() throws Exception {
        paper.setName("New Paper Name");
        assertEquals("New Paper Name", paper.getName());
    }

    @Test
    public void getFileName() throws Exception {
        assertEquals("fileName.pdf", paper.getFileName());
    }

    @Test
    public void setFileName() throws Exception {
        paper.setFileName("newFileName.pdf");
        assertEquals("newFileName.pdf", paper.getFileName());
    }

    @Test
    public void setid() throws Exception {
        Integer id=2;
        paper.setid(id);
        assertEquals(id, paper.getid());
    }

    @Test
    public void getid() throws Exception {
        paper.setid(2);
        Integer id=2;
        assertEquals(id, paper.getid());
    }

}