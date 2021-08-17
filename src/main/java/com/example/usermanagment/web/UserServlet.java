package com.example.usermanagment.web;

import com.example.usermanagment.bean.User;
import com.example.usermanagment.bean.Entity;
import com.example.usermanagment.dao.Json;
import com.example.usermanagment.dao.OneToManyDAO;
import com.example.usermanagment.dao.OneToManyDAOFactory;



import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

import java.sql.SQLException;
import java.util.List;


import static com.example.usermanagment.dao.Json.getRequestBody;
import static com.example.usermanagment.dao.Json.sendResponseInJsonFormat;

public class UserServlet extends HttpServlet {
    private OneToManyDAO oneToManyDAO;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        allUsers(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       insertUser(req , resp);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        updateUser(req , resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

            try {
                deleteUser(req, resp);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
    }

    @Override
    public void init(){
        oneToManyDAO = OneToManyDAOFactory.getInstanceForUserDAO();
    }

    private void insertUser(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String requestBody = getRequestBody(req);
        User newUser = Json.parseStringToJson(requestBody);
        oneToManyDAO.save(newUser);
        String userInJsonFormat = Json.parseUserToJsonString(newUser);
        sendResponseInJsonFormat(resp , userInJsonFormat);
    }
    private void deleteUser(HttpServletRequest req , HttpServletResponse resp) throws IOException, SQLException {
        String requestBody = getRequestBody(req);
        User user = Json.parseStringToJson(requestBody);
        oneToManyDAO.delete(user.getId());
        String userInJsonFormat = Json.parseUserToJsonString(user);
        sendResponseInJsonFormat(resp , userInJsonFormat);
    }

    private void updateUser(HttpServletRequest req , HttpServletResponse resp) throws IOException {
        String requestBody = getRequestBody(req);
        User user = Json.parseStringToJson(requestBody);
        oneToManyDAO.update(user);
        String userInJsonFormat = Json.parseUserToJsonString(user);
        sendResponseInJsonFormat(resp , userInJsonFormat);
    }

    private void allUsers(HttpServletRequest req , HttpServletResponse resp) throws IOException {
        List<Entity> users = oneToManyDAO.selectAll();
        StringBuilder sb= new StringBuilder();
        for(Entity user : users){
            sb.append(user).append("\n");
        }
        sendResponseInJsonFormat(resp , sb.toString());
    }


}
