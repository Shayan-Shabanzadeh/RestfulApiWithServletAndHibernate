package com.example.usermanagment.web;

import com.example.usermanagment.bean.User;
import com.example.usermanagment.dao.Json;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class testServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = new User(1 ,"ali" , "ali@.com" , "iran" );
        String userInJsonFormat = Json.parseUserToJsonString(user);
        PrintWriter out = resp.getWriter();
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        out.print(userInJsonFormat);
        resp.sendRedirect("/demo5_war_exploded/user");
        out.flush();
    }
}
