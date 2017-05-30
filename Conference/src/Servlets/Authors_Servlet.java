package Servlets;

import ConferencePersistence.Controller.Controller_Conference;
import ConferencePersistence.Repository.Repository_Conference;
import DomainClasses.Conference;
import Validator.Validator_Conference;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Viman Adrian on 30.05.2017.
 */
@WebServlet(name = "Authors_Servlet")
public class Authors_Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doGet");
        PrintWriter responseWriter = response.getWriter();
        response.setContentType("text/plain");
        String action = request.getParameter("action");
        if (action.equals("populate")) {
                Controller_Conference controllerConference = new Controller_Conference(new Repository_Conference(),new Validator_Conference());
                Conference conf = controllerConference.findLatest();
                if (conf == null)
                    responseWriter.print("Invalid");
                else
                    responseWriter.print(conf.getCallForPapers());
            }
    }
}
