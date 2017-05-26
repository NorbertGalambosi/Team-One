package Servlets;

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
@WebServlet(name = "RegisterLogin_Servlet")
public class RegisterLogin_Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter respons = response.getWriter();
        String action = request.getParameter("action");
        System.out.println("Action :"+action);
        //cum se face cu action,se face si cu restul
        //parametrul din fuctia .getParameter (aici "action") reprezinta numele pe care il are ce trimiteti voi din jsp
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
