package Servlets;

import ConferencePersistence.Controller.Controller_Review;
import ConferencePersistence.Repository.Repository_Review;
import DomainClasses.Review;
import Validator.Validator_PcMember;
import Validator.Validator_Review;

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
@WebServlet(name = "ServletAddReview")
public class ServletAddReview extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doFindId");
        PrintWriter responseWriter = response.getWriter();
        response.setContentType("text/plain");
        String action = request.getParameter("action");
        if (action.equals("review")) {
            System.out.println("sadasdas");
            Integer idP = Integer.parseInt(request.getParameter("idP"));
            System.out.println(idP);
            Integer idR =  Integer.parseInt(request.getParameter("idR"));
            System.out.println(idR);
            String recomandation = request.getParameter("recomandation");
            System.out.println(recomandation);
            String qualifier = request.getParameter("qualifier");
            System.out.println(qualifier);
            Controller_Review cp = new Controller_Review(new Repository_Review(), new Validator_Review());
            Review review = new Review(idP,idR,recomandation,qualifier);
            cp.updateReview(review,idP,idR);
            System.out.println(review.toString());
            responseWriter.print("succes");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
