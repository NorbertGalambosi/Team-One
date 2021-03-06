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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Created by gnorb on 30-May-17.
 */
@WebServlet(name = "Chair_Servlet")
public class Chair_Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter responseWriter = response.getWriter();
        response.setContentType("text/plain");
        String action = request.getParameter("action");
            String confname = request.getParameter("confname");
            String edt = request.getParameter("edt");
            String ses = request.getParameter("ses");
            String interv = request.getParameter("interv");
            String call = request.getParameter("call");
            String bid = request.getParameter("bid");
            String prop = request.getParameter("prop");
            String abstr = request.getParameter("abstr");
            String full = request.getParameter("full");
            String revs = request.getParameter("revs");
            String partnr = request.getParameter("partnr");
            String active = request.getParameter("active");
            Controller_Conference ctrlC = new Controller_Conference(new Repository_Conference(), new Validator_Conference());
            Controller_Session ctrlS = new Controller_Session(new Repository_Session(), new Validator_Session());
            List<Conference> confList = new ArrayList<>();
            List<Session> sesList = new ArrayList<>();
            for (Conference o : ctrlC.getAllConference())
                confList.add(o);
            for (Session s : ctrlS.getAllSessions())
                sesList.add(s);
            boolean activ = false;
            if (active.equals("checked"))
                activ = true;
            else
                activ = false;
            if (action.equals("create")) {
                Conference conference = new Conference(confList.size() + 1, confname, Integer.parseInt(edt), interv, call, prop, abstr, full, bid, revs, Integer.parseInt(partnr), activ);
                System.out.println(conference);
                ctrlC.addConference(conference);
                String[] sesArg = ses.split(" ");
                int size = sesList.size();
                for (String s : sesArg) {
                    Random nr = new Random();
                    System.out.println(s);
                    String idr = String.valueOf(nr.nextInt(500));
                    String duration = String.valueOf(nr.nextInt(200));
                    ctrlS.addSession(new Session(size+1, conference.getid(), s, idr, duration));
                    size++;
                }
            }
            if (action.equals("update")){
                Conference conference = new Conference(confList.size(), confname, Integer.parseInt(edt), interv, call, prop, abstr, full, bid, revs, Integer.parseInt(partnr), activ);
                System.out.println(conference);
                ctrlC.updateConference(conference,conference.getid());
                String[] sesArg = ses.split(" ");
                int size = sesList.size();
                for(int i=1;i<sesArg.length;i=i+2){
                    System.out.println(i+" "+sesArg[i]);
                    int count=0;
                    for(Session s:sesList) {
                        if (s.getName().equals(sesArg[i]))
                            count++;
                    }
                    if (count == 0) {
                        Random nr = new Random();
                        String idr = String.valueOf(nr.nextInt(500));
                        String duration = String.valueOf(nr.nextInt(200));
                        ctrlS.addSession(new Session(size+1, conference.getid(), sesArg[i], idr, duration));
                        size++;
                    }
                }
            }
    }
}