package Servlets;

import ConferencePersistence.Controller.Controller_Proposal;
import ConferencePersistence.Repository.Repository_Proposal;
import DomainClasses.Paper;
import DomainClasses.PcMember;
import DomainClasses.Proposal;
import Validator.Validator_Proposal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Viman Adrian on 02.06.2017.
 */
@WebServlet(name = "Author_Servlet")
public class Author_Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter responseWriter = response.getWriter();
        response.setContentType("text/plain");
        String action = request.getParameter("action");
        if (action.equals("addProposal")) {
            String name = request.getParameter("name");
            String keywords = request.getParameter("keywords");
            String topics = request.getParameter("topics");
            String autor = request.getParameter("autor");
            String full = request.getParameter("full");
            String abs = request.getParameter("abstract");
            //System.out.println(name+" "+keywords+" "+topics+" "+autor+" "+full+" "+abs);
            Controller_Proposal cp = new Controller_Proposal(new Repository_Proposal(), new Validator_Proposal());
            Proposal pr = new Proposal();
            pr.setName(name);
            pr.setKeywords(keywords);
            pr.setTopics(topics);
            PcMember p = new PcMember();
            p.setName(autor);
            pr.setAutor(p);
            Paper ppf = new Paper();
            ppf.setName(full);
            Paper ppa = new Paper();
            ppa.setName(abs);
            pr.setAbstractPaper(ppa);
            pr.setFullPaper(ppf);
            if(cp.save(pr))
                responseWriter.print("succes");
            else
                responseWriter.print("eroare");
        }

        if (action.equals("myProposals")) {
            String user = request.getParameter("user");
            Controller_Proposal cp = new Controller_Proposal(new Repository_Proposal(), new Validator_Proposal());
            String proposals = "";
            for (Proposal p:cp.findByAuthor(user)) {
                proposals = proposals + p.getName() + "|";
            }
            responseWriter.print(proposals);
        }
        if(action.equals("enemyProposals")){
            String user = request.getParameter("user");
            Controller_Proposal cp = new Controller_Proposal(new Repository_Proposal(), new Validator_Proposal());
            String proposals = "";
            for (Proposal p:cp.findEnemyProposals(user)) {
                proposals = proposals + p.getName() + "|";
            }
            responseWriter.print(proposals);
        }
        if(action.equals("myProposals")){
            String proposal = request.getParameter("proposal");
            String author = request.getParameter("user");
            Controller_Proposal cp = new Controller_Proposal(new Repository_Proposal(),new Validator_Proposal());
            String prop = "";
            cp.findByName(proposal, author);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
