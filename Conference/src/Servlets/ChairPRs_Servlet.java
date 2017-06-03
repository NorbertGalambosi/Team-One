package Servlets;

import ConferencePersistence.Controller.Controller_PcMember;
import ConferencePersistence.Controller.Controller_Proposal;
import ConferencePersistence.Repository.Repository_PcMember;
import ConferencePersistence.Repository.Repository_Proposal;
import DomainClasses.PcMember;
import DomainClasses.Proposal;
import Validator.Validator_PcMember;
import Validator.Validator_Proposal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by gnorb on 02-Jun-17.
 */
@WebServlet(name = "ChairPRs_Servlet")
public class ChairPRs_Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter responseWriter = response.getWriter();
        response.setContentType("text/plain");
        String action = request.getParameter("action");
        if (action.equals("papers")){
            Controller_Proposal ctrl = new Controller_Proposal(new Repository_Proposal(),new Validator_Proposal());
            String prposals = "";
            for(Proposal p:ctrl.findAll())
                if (p.isAccepted())
                    prposals = prposals+p.toStringJS()+"|";
            responseWriter.print(prposals);
        }
        if (action.equals("reviewers")){
            Controller_PcMember ctrl = new Controller_PcMember(new Repository_PcMember(),new Validator_PcMember());
            String reviewers = "";
            for (PcMember p:ctrl.getAllPcMembers())
                for (String type:p.getType())
                    if (type.equals("Reviewer"))
                        reviewers = reviewers+p.getName()+"|";
            responseWriter.print(reviewers);
        }
    }
}
