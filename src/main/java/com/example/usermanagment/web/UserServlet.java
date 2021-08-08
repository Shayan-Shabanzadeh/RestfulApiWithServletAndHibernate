package com.example.usermanagment.web;

import com.example.usermanagment.bean.User;
import com.example.usermanagment.dao.Json;
import com.example.usermanagment.dao.UserDao;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.HTTP;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLDecoder;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

public class UserServlet extends HttpServlet {
    private UserDao userDao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        allUsers(req , resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //new user
       insertUser(req , resp);

    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        updateUser(req , resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            deleteUser(req , resp);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void init(){
        userDao = new UserDao();
    }

    private void insertUser(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String requestBody = getRequestBody(req);
        User newUser = Json.parseStringToJson(requestBody);
        userDao.insertUser(newUser);
        String userInJsonFormat = Json.parseUserToJsonString(newUser);
        PrintWriter writer = resp.getWriter();
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        writer.write(userInJsonFormat);
        writer.close();
    }
    private void deleteUser(HttpServletRequest req , HttpServletResponse resp) throws IOException, SQLException {
        String requestBody = getRequestBody(req);
        User user = Json.parseStringToJson(requestBody);
        userDao.deleteUser(user.getId());
        String userInJsonFormat = Json.parseUserToJsonString(user);
        PrintWriter writer = resp.getWriter();
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        writer.write(userInJsonFormat);
        writer.close();
    }

    private void updateUser(HttpServletRequest req , HttpServletResponse resp) throws IOException {
        String requestBody = getRequestBody(req);
        User user = Json.parseStringToJson(requestBody);
        userDao.updateUser(user);
        String userInJsonFormat = Json.parseUserToJsonString(user);
        PrintWriter writer = resp.getWriter();
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        writer.write(userInJsonFormat);
        writer.close();
    }

    private void allUsers(HttpServletRequest req , HttpServletResponse resp) throws IOException {
        List<User> users = userDao.selectAllUsers();
        PrintWriter writer = resp.getWriter();
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        for(User user : users){
            String userInJsonFormat = Json.parseUserToJsonString(user);
            writer.println(userInJsonFormat);
        }
        writer.close();
    }

    private String getRequestBody(HttpServletRequest req) throws IOException {
        return req.getReader().lines().collect(Collectors.joining());
    }
}
