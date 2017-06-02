package Servlets;

import ConferencePersistence.Controller.Controller_Conference;
import ConferencePersistence.Controller.Controller_PcMember;
import ConferencePersistence.Controller.Controller_Session;
import ConferencePersistence.Repository.Repository_Conference;
import ConferencePersistence.Repository.Repository_PcMember;
import ConferencePersistence.Repository.Repository_Session;
import DomainClasses.Conference;
import DomainClasses.PcMember;
import DomainClasses.Session;
import Validator.Validator_Conference;
import Validator.Validator_PcMember;
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
 * Created by gnorb on 02-Jun-17.
 */
@WebServlet(name = "PopulateSessionLists_Servlet")
public class PopulateSessionLists_Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter printWriter = response.getWriter();
        response.setContentType("text/plain");
        Controller_Conference ctrlC = new Controller_Conference(new Repository_Conference(), new Validator_Conference());
        List<Conference> confList = new ArrayList<>();
        for (Conference o : ctrlC.getAllConference())
            confList.add(o);
        int idConf = confList.size();

        String action = request.getParameter("action");
        Controller_Session ctrlS = new Controller_Session(new Repository_Session(), new Validator_Session());
        List<Session> sesList = new ArrayList<>();
        if (action.equals("sessions")) {
            for (Session s : ctrlS.getAllSessions())
                sesList.add(s);
            String sessionNames = "";
            for (Session s : sesList)
                if (s.getIdConference() == idConf)
                    sessionNames = sessionNames + s.getName() + "|";
            printWriter.print(sessionNames);
        }

     if(action.equals("pcmbs")) {
         Repository_PcMember repository_pcMember = new Repository_PcMember();
         Validator_PcMember validator = new Validator_PcMember();
         Controller_PcMember ctrl = new Controller_PcMember(repository_pcMember, validator);
         List<PcMember> pcMembers = new ArrayList<>();
         String names = "";
         for (PcMember p : ctrl.getAllPcMembers())
             names = names + p.getName() + "|";
         printWriter.print(names);
     }
    }
}
