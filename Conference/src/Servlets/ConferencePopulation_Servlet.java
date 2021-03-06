package Servlets;

import ConferencePersistence.Controller.Controller_Conference;
import ConferencePersistence.Controller.Controller_Session;
import ConferencePersistence.Repository.Repository_Conference;
import ConferencePersistence.Repository.Repository_Session;
import DomainClasses.Conference;
import DomainClasses.Session;
import Validator.Validator_Conference;
import Validator.Validator_Session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Viman Adrian on 30.05.2017.
 */
@WebServlet(name = "ConferencePopulation_Servlet")
public class ConferencePopulation_Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter responseWriter = response.getWriter();
        response.setContentType("text/plain");
        String action = request.getParameter("action");
        if (action.equals("populate")) {
            String type = request.getParameter("req");
            Controller_Conference controllerConference = new Controller_Conference(new Repository_Conference(),new Validator_Conference());
            Conference conf = controllerConference.findLatest();
            Controller_Session controllerSession = new Controller_Session(new Repository_Session(), new Validator_Session());
            List<Session> sessions = (List<Session>) controllerSession.findByConference(conf.getid());
            if (conf == null)
                responseWriter.print("Invalid");
            if(type.equals("name"))
                responseWriter.print(conf.getName());
            if(type.equals("edition"))
                responseWriter.print(conf.getEdition());
            if(type.equals("interval"))
                responseWriter.print(conf.getInterval());
            if(type.equals("call"))
                responseWriter.print(conf.getCallForPapers());
            if(type.equals("bdeadline"))
                responseWriter.print(conf.getBiddingDeadline().toString());
            if(type.equals("pdeadline"))
                responseWriter.print(conf.getProposalsDeadline().toString());
            if(type.equals("adeadline"))
                responseWriter.print(conf.getAbstractDeadline().toString());
            if(type.equals("fdeadline"))
                responseWriter.print(conf.getFullpaperDeadline().toString());
            if(type.equals("rdeadline"))
                responseWriter.print(conf.getReviewsDedline().toString());
            if(type.equals("nrp"))
                responseWriter.print(conf.getNrParticipants().toString());
            if(type.equals("active")){
                if(conf.isActiv())
                    responseWriter.print("activ");
                else
                    responseWriter.print("inactiv");
            }
            if(type.equals("session")){
                String session = "";
                for (Session s:sessions)
                    session = session + " " + s.getName() + " ";
                responseWriter.print(session);
            }
        }
    }
}
