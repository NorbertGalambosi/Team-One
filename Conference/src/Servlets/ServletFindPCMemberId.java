package Servlets;

import ConferencePersistence.Controller.Controller_PcMember;
import ConferencePersistence.Controller.Controller_Proposal;
import ConferencePersistence.Repository.Repository_PcMember;
import ConferencePersistence.Repository.Repository_Proposal;
import DomainClasses.Paper;
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
 * Created by crys_ on 03.06.2017.
 */
@WebServlet(name = "ServletFindPCMemberId")
public class ServletFindPCMemberId extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doFindId");
        PrintWriter responseWriter = response.getWriter();
        response.setContentType("text/plain");
        String action = request.getParameter("action");
        Integer id = 0;
        if (action.equals("check")) {
            String user = request.getParameter("user");
            Controller_PcMember cp = new Controller_PcMember(new Repository_PcMember(), new Validator_PcMember());
            id = cp.findByUser(user);
            System.out.println(id);
            if(id!=0)
                responseWriter.print(id);
            else
                responseWriter.print("eroare");
        }

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
