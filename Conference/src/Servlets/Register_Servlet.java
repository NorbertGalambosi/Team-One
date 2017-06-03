package Servlets;

import ConferencePersistence.Controller.Controller_PcMember;
import ConferencePersistence.Repository.Repository_PcMember;
import DomainClasses.PcMember;
import Validator.Validator_PcMember;

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
 * Created by crys_ on 30-May-17.
 */
@WebServlet(name = "Register_Servlet")
public class Register_Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter responseWriter = response.getWriter();
        response.setContentType("text/plain");
        String action = request.getParameter("action");
        if (action.equals("register")) {
            Integer id = Integer.parseInt(request.getParameter("id"));
            String nume = request.getParameter("nume");
            String affiliation = request.getParameter("affiliation");
            String email = request.getParameter("email");
            String webpage = request.getParameter("webpage");
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String type = request.getParameter("type");
            System.out.println(type);
            if(type.equals("Author")){
                Controller_PcMember controllerPcMember = new Controller_PcMember(new Repository_PcMember(),new Validator_PcMember());
                PcMember member = new PcMember(id, nume, affiliation, email, webpage, username, password, true);
                if(controllerPcMember.addPcMember(member)) {
                    controllerPcMember.addTypeToPcMember(member.getid(),type);
                    responseWriter.print("SuccessAuthor");
                }
                else
                    responseWriter.print("Invalid");
            }
            if(type.equals("Listener")){
                Controller_PcMember controllerPcMember = new Controller_PcMember(new Repository_PcMember(),new Validator_PcMember());
                PcMember member = new PcMember(id, nume, affiliation, email, webpage, username, password, true);
                if(controllerPcMember.addPcMember(member)) {
                    controllerPcMember.addTypeToPcMember(member.getid(), type);
                    responseWriter.print("SuccessListener");
                }
                else
                    responseWriter.print("Invalid");
            }

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
