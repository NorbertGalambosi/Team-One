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

/**
 * Created by Waiting on 25-May-17.
 */
@WebServlet(name = "Login_Servlet")
public class Login_Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter responseWriter = response.getWriter();
        response.setContentType("text/plain");
        String action = request.getParameter("action");
        if (action.equals("login")) {
            String user = request.getParameter("user");
            String passwd = request.getParameter("pass");
            String type = request.getParameter("type");
            System.out.println(user+" "+passwd+" "+type);
            if(type.equals("Author")){
                System.out.println("here"+" "+user+" "+passwd+" "+type);
                Controller_PcMember controllerPcMember = new Controller_PcMember(new Repository_PcMember(),new Validator_PcMember());
                PcMember member = controllerPcMember.findByUserPass(user,passwd);
                if (member == null) {
                    responseWriter.print("Invalid");
                    System.out.println("here invalid");
                }
                else {
                    System.out.println("here valid 1/2");
                    for (String s : member.getType())
                        if (s.equals(type)) {
                            responseWriter.print("SuccessAuthor");
                            System.out.println("here valid 2/2");
                        }
                }
            }
            if(type.equals("Chair")){
                Controller_PcMember controllerPcMember = new Controller_PcMember(new Repository_PcMember(),new Validator_PcMember());
                PcMember member = controllerPcMember.findByUserPass(user,passwd);
                if (member == null)
                    responseWriter.print("Invalid");
                else
                    for(String s:member.getType())
                        if(s.equals(type))
                            responseWriter.print("SuccessChair");
            }
            if(type.equals("Reviewer")){
                Controller_PcMember controllerPcMember = new Controller_PcMember(new Repository_PcMember(),new Validator_PcMember());
                PcMember member = controllerPcMember.findByUserPass(user,passwd);
                if (member == null)
                    responseWriter.print("Invalid");
                else
                    for(String s:member.getType())
                        if(s.equals(type))
                            responseWriter.print("SuccessReviewer");
            }
            if(type.equals("Listener")){
                Controller_PcMember controllerPcMember = new Controller_PcMember(new Repository_PcMember(),new Validator_PcMember());
                PcMember member = controllerPcMember.findByUserPass(user,passwd);
                if (member == null)
                    responseWriter.print("Invalid");
                else
                    for(String s:member.getType())
                        if(s.equals(type))
                            responseWriter.print("SuccessListener");
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
