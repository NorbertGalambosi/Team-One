package Servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

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
            System.out.println(confname+" "+edt+" "+ses+" "+interv+" "+call+" "+bid
                    +" "+prop
                    +" "+abstr+" "+full+" "+revs+" "+partnr+" "+active);
        }

    }
}
