package Servlets;

import ConferencePersistence.Controller.Controller_Proposal;
import ConferencePersistence.Controller.Controller_Review;
import ConferencePersistence.Repository.Repository_Proposal;
import ConferencePersistence.Repository.Repository_Review;
import DomainClasses.Proposal;
import DomainClasses.Review;
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
 * Created by Viman Adrian on 04.06.2017.
 */
@WebServlet(name = "Reviewer_Servlet")
public class Reviewer_Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter responseWriter = response.getWriter();
        response.setContentType("text/plain");
        String action = request.getParameter("action");
        if (action.equals("myProposals")) {
            String user = request.getParameter("user");
            System.out.println(user);
            Controller_Proposal cp = new Controller_Proposal(new Repository_Proposal(), new Validator_Proposal());
            String proposals = "";
            for (Proposal p:cp.findByReviewer(user)) {
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
                s = s+"|"+"accepted"+"|";
            }
            else
                s=s+"|"+"rejected"+"|";
            s=s+pr.getAutor().getName();
            responseWriter.print(s);
        }

        if(action.equals("proposalChange2")){
            String proposal = request.getParameter("proposal");
            String author = request.getParameter("user");
            //System.out.println(proposal);
            Controller_Review cp = new Controller_Review(new Repository_Review(),new Validator_Review());
            String reviews="";
            for (Review rev:cp.findByProposalName(proposal, author)) {
                reviews=reviews+rev.getNumeReviewer()+": "+rev.getQualifier()+"*"+rev.getid()+"|";
            }
            responseWriter.print(reviews);
            //System.out.println(pr);
        }

        if(action.equals("mineSubmitReview")){
            String proposal = request.getParameter("proposal");
            String user = request.getParameter("user");
            String qualifier = request.getParameter("qualifier");
            String recom = request.getParameter("recom");
            Controller_Review cp = new Controller_Review(new Repository_Review(),new Validator_Review());
            if(cp.saveReview(proposal, user, qualifier, recom))
                responseWriter.print("succes");
            else
                responseWriter.print("error");
        }

        if(action.equals("fillMyReview")){
            String proposal = request.getParameter("proposal");
            String user = request.getParameter("user");
            Controller_Review cp = new Controller_Review(new Repository_Review(),new Validator_Review());
            Review rev = cp.findReview(proposal, user);
            System.out.println(rev.getQualifier()+"|"+rev.getRecommendation()+"|");
            responseWriter.print(rev.getQualifier()+"|"+rev.getRecommendation()+"|");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
