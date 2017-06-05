package Servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import ConferencePersistence.Controller.Controller_Review;
import ConferencePersistence.Repository.Repository_Review;
import DBUtils.DBConnection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DomainClasses.Review;
import Validator.Validator_Review;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;


@WebServlet("/PopulateTable")
public class Servlet_Reviews extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public Servlet_Reviews() {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ArrayList<Review> country= new ArrayList<Review>();
        Controller_Review controller_review = new Controller_Review(new Repository_Review(), new Validator_Review());
        country = (ArrayList<Review>) controller_review.getAllReviews();
        Gson gson = new Gson();
        JsonElement element = gson.toJsonTree(country, new TypeToken<List<Review>>() {}.getType());

        JsonArray jsonArray = element.getAsJsonArray();
        response.setContentType("application/json");
        response.getWriter().print(jsonArray);


    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}