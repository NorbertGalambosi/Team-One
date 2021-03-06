package Servlets;

import ConferencePersistence.Controller.Controller_Paper;
import ConferencePersistence.Controller.Controller_PcMember;
import ConferencePersistence.Controller.Controller_Proposal;
import ConferencePersistence.Controller.Controller_Review;
import ConferencePersistence.Repository.Repository_Paper;
import ConferencePersistence.Repository.Repository_PcMember;
import ConferencePersistence.Repository.Repository_Proposal;
import ConferencePersistence.Repository.Repository_Review;
import DomainClasses.Paper;
import DomainClasses.PcMember;
import DomainClasses.Proposal;
import DomainClasses.Review;
import Validator.Validator_Paper;
import Validator.Validator_PcMember;
import Validator.Validator_Proposal;
import Validator.Validator_Review;

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
        if(action.equals("proposalChange")){
            String proposal = request.getParameter("proposal");
            String author = request.getParameter("user");
            //System.out.println(proposal);
            Controller_Proposal cp = new Controller_Proposal(new Repository_Proposal(),new Validator_Proposal());
            Proposal pr = cp.findByName(proposal, author);
            //System.out.println(pr);
            String s = pr.getName()+"|"+pr.getKeywords()+"|"+pr.getTopics()+"|"+pr.getFullPaper().getName()+"|"+pr.getFullPaper().getFileName()+"|"+pr.getAbstractPaper().getName()+"|"+pr.getAbstractPaper().getFileName();
            if(cp.status(proposal)){
                s = s+"|"+"accepted";
            }
            else
                s=s+"|"+"rejected";
            responseWriter.print(s);
        }
        if(action.equals("proposalChange2")){
            String proposal = request.getParameter("proposal");
            String author = request.getParameter("user");
            //System.out.println(proposal);
            Controller_Review cp = new Controller_Review(new Repository_Review(),new Validator_Review());
            String reviews="";
            for (Review rev:cp.findByProposalName(proposal, author)) {
                reviews=reviews+rev.getQualifier()+"*"+rev.getid()+"|";
            }
            responseWriter.print(reviews);
            //System.out.println(pr);
        }
        if(action.equals("reviewChange")){
            Integer id = Integer.parseInt(request.getParameter("review"));
            Controller_Review cp = new Controller_Review(new Repository_Review(), new Validator_Review());
            Review rev = cp.getReviewByID(id);
            responseWriter.print(rev.getQualifier()+"|"+rev.getRecommendation()+"|");
            //System.out.println(rev);
        }
        if(action.equals("enemyProposalsChange")){
            String proposal = request.getParameter("proposal");
            Controller_Proposal cp = new Controller_Proposal(new Repository_Proposal(), new Validator_Proposal());
            Proposal pr = cp.findByName(proposal,null);
            responseWriter.print(pr.getName()+"|"+pr.getKeywords()+"|"+pr.getTopics()+"|"+pr.getAutor().getName()+"|");
        }
        if(action.equals("theirsProposalBid")){
            String proposal = request.getParameter("proposal");
            String user = request.getParameter("user");
            Controller_Proposal cp = new Controller_Proposal(new Repository_Proposal(), new Validator_Proposal());
            Controller_PcMember ctrlPCM = new Controller_PcMember(new Repository_PcMember(),new Validator_PcMember());
            for (PcMember p:ctrlPCM.getAllPcMembers()) {
                int count = 0;
                if (p.getName().equals(user)) {
                    for (String s : p.getType())
                        if (s.equals("Reviewer"))
                            count = 1;
                    if (count == 0)
                        ctrlPCM.addTypeToPcMember(p.getid(), "Reviewer");
                }
            }
            for (Proposal pr:cp.findAll())
                if (pr.getName().equals(proposal)) {
                    pr.setAccepted(true);
                    cp.update(pr,pr.getid());
                }
            if(cp.bid(proposal,user)){
                responseWriter.print("succes");
            }else
                responseWriter.print("eroare");
        }
        if(action.equals("editProposal")){
            String proposal = request.getParameter("name");
            String keywords = request.getParameter("keywords");
            String topics = request.getParameter("topics");
            System.out.println(proposal+" "+keywords+" "+topics);
            Controller_Proposal cp = new Controller_Proposal(new Repository_Proposal(), new Validator_Proposal());
            if(cp.update(proposal, keywords, topics)){
                responseWriter.print("succes");
            }else
                responseWriter.print("eroare");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter responseWriter = response.getWriter();
        response.setContentType("text/plain");
        String action = request.getParameter("action");
        if (action.equals("uploadA")) {
            String fileName = request.getParameter("filename");
            String abstrName = request.getParameter("abstrName");
            System.out.println(fileName+" "+abstrName);
            Controller_Paper ctrlPaper = new Controller_Paper(new Repository_Paper(),new Validator_Paper());
            for (Paper p:ctrlPaper.getAllPaper()){
                if (p.getName().equals(abstrName)) {
                    p.setFileName(fileName);
                    ctrlPaper.updatePaper(p,p.getid());
                }
            }
            responseWriter.print("success");
        }
        if (action.equals("uploadF")) {
            String fileName = request.getParameter("filename");
            String fullName = request.getParameter("fullName");
            System.out.println(fileName+" "+fullName+" ");
            Controller_Paper ctrlPaper = new Controller_Paper(new Repository_Paper(),new Validator_Paper());
            for (Paper p:ctrlPaper.getAllPaper()){
                if (p.getName().equals(fullName)) {
                    p.setFileName(fileName);
                    ctrlPaper.updatePaper(p,p.getid());
                }
            }
            responseWriter.print("success");
        }
        if (action.equals("editAbs")) {
            String fileName = request.getParameter("file");
            String abstr = request.getParameter("edit");
            System.out.println(fileName+" "+abstr+" ");
            Controller_Paper ctrlPaper = new Controller_Paper(new Repository_Paper(),new Validator_Paper());
            for (Paper p:ctrlPaper.getAllPaper()){
                if (p.getName().equals(abstr)) {
                    p.setFileName(fileName);
                    ctrlPaper.updatePaper(p,p.getid());
                }
            }
            responseWriter.print("success|"+fileName);
        }
        if (action.equals("editFull")) {
            String fileName = request.getParameter("file");
            String full = request.getParameter("edit");
            Controller_Paper ctrlPaper = new Controller_Paper(new Repository_Paper(),new Validator_Paper());
            for (Paper p:ctrlPaper.getAllPaper()){
                if (p.getName().equals(full)) {
                    p.setFileName(fileName);
                    ctrlPaper.updatePaper(p,p.getid());
                }
            }
            responseWriter.print("success|"+fileName);
        }

    }
}
