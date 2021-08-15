package com.example.usermanagment.web;

import com.example.usermanagment.bean.Address;
import com.example.usermanagment.bean.User;
import com.example.usermanagment.dao.Json;
import com.example.usermanagment.dao.OneToManyDAO;
import com.example.usermanagment.dao.OneToManyDAOFactory;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import java.util.stream.Collectors;

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
        oneToManyDAO = OneToManyDAOFactory.getInstance();
    }

    private void insertUser(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String requestBody = getRequestBody(req);
        User newUser = Json.parseStringToJson(requestBody);
        ArrayList<Address> addresses = new ArrayList<>(newUser.getAddresses());
        Long userId = oneToManyDAO.saveUserWithOutAddress(newUser);
        oneToManyDAO.saveUserAddress(userId ,addresses);
        String userInJsonFormat = Json.parseUserToJsonString(newUser);
        sendResponseInJsonFormat(resp , userInJsonFormat);
    }
    private void deleteUser(HttpServletRequest req , HttpServletResponse resp) throws IOException, SQLException {
        String requestBody = getRequestBody(req);
        User user = Json.parseStringToJson(requestBody);
        oneToManyDAO.deleteUser(user.getId());
        String userInJsonFormat = Json.parseUserToJsonString(user);
        sendResponseInJsonFormat(resp , userInJsonFormat);
    }

    private void updateUser(HttpServletRequest req , HttpServletResponse resp) throws IOException {
        String requestBody = getRequestBody(req);
        User user = Json.parseStringToJson(requestBody);
        oneToManyDAO.updateUser(user);
        String userInJsonFormat = Json.parseUserToJsonString(user);
        sendResponseInJsonFormat(resp , userInJsonFormat);
    }

    private void allUsers(HttpServletRequest req , HttpServletResponse resp) throws IOException {
        List<User> users = oneToManyDAO.selectAllUsers();
        StringBuilder sb= new StringBuilder();
        for(User user : users){
            sb.append(user).append("\n");
        }
        sendResponseInJsonFormat(resp , sb.toString());
    }

    private String getRequestBody(HttpServletRequest req) throws IOException {
        return req.getReader().lines().collect(Collectors.joining());
    }
    private void sendResponseInJsonFormat(HttpServletResponse resp , String json) throws IOException {
        PrintWriter writer = resp.getWriter();
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        writer.println(json);
        writer.close();
    }
}
