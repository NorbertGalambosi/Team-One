package Servlets;

import ConferencePersistence.Controller.Controller_Conference;
import ConferencePersistence.Controller.Controller_Session;
import ConferencePersistence.Repository.Repository_Conference;
import ConferencePersistence.Repository.Repository_Session;
import DomainClasses.Conference;
import Validator.Validator_Conference;
import Validator.Validator_Session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

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
        if (action.equals("create")){
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
            Controller_Conference ctrlC = new Controller_Conference(new Repository_Conference(),new Validator_Conference());
            Controller_Session ctrlS = new Controller_Session (new Repository_Session(),new Validator_Session());
            List<Conference> confList = new ArrayList<>();
            for(Conference o:ctrlC.getAllConference())
                    confList.add(o);
            java.util.Date newDate = new java.util.Date("MM/dd/yyyy");
            Date startDate;
            Conference conference = new Conference(confList.size()+1,confname,Integer.parseInt(edt),interv,call, prop,abstr,bid,revs,partnr,active)

        }

    }
}
