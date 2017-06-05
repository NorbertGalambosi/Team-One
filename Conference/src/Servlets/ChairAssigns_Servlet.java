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
import sun.java2d.cmm.PCMM;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by gnorb on 02-Jun-17.
 */
@WebServlet(name = "ChairAssigns_Servlet")
public class ChairAssigns_Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter responseWriter = response.getWriter();
        response.setContentType("text/plain");
        String action = request.getParameter("action");
        System.out.println(action);
        Controller_Session ctrlSession = new Controller_Session(new Repository_Session(),new Validator_Session());
        Controller_PcMember ctrlPcM = new Controller_PcMember(new Repository_PcMember(),new Validator_PcMember());
        List<PcMember> pcMemberList = new ArrayList<>();
        Controller_Conference ctrlC = new Controller_Conference(new Repository_Conference(), new Validator_Conference());
        List<Conference> confList = new ArrayList<>();
        for (Conference o : ctrlC.getAllConference())
            confList.add(o);
        int idConf = confList.size();
        if (action.equals("chair")){
            String sessionName = request.getParameter("session");
            String chairName = request.getParameter("chair");
            Session session = ctrlSession.findByName(sessionName);
            PcMember pcMember = new PcMember();
            for (PcMember p:ctrlPcM.getAllPcMembers())
                if (p.getName().equals(chairName))
                    pcMember=p;
            Random nr = new Random();
            ctrlSession.addChairToSession(nr.nextInt(500),session.getid(),pcMember.getid());
            responseWriter.print("done");
        }
        if (action.equals("listeners")){
            String sessions = request.getParameter("session");
            String listener = request.getParameter("listeners");
            Session session = ctrlSession.findByName(sessions);
            for (PcMember p:ctrlPcM.getAllPcMembers())
                    if (p.getName().equals(listener)) {
                        Random nr = new Random();
                        ctrlSession.addListenerToSession(nr.nextInt(500), session.getid(), p.getid());
                    }
            responseWriter.print("done");
        }
        if (action.equals("speakers")){
            String sessions = request.getParameter("session");
            String speaker = request.getParameter("speaker");
            Session session = ctrlSession.findByName(sessions);
            for (PcMember p:ctrlPcM.getAllPcMembers())
                if (p.getName().equals(speaker)) {
                    Random nr = new Random();
                    ctrlSession.addSpeakerToSession(nr.nextInt(500), session.getid(), p.getid());
                }
            responseWriter.print("done");
        }
    }
}
