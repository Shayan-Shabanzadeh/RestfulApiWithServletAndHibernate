package com.example.usermanagment.web;

import com.example.usermanagment.bean.Entity;
import com.example.usermanagment.bean.Roll;
import com.example.usermanagment.dao.Json;
import com.example.usermanagment.dao.OneToManyDAO;
import com.example.usermanagment.dao.OneToManyDAOFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import static com.example.usermanagment.dao.Json.getRequestBody;
import static com.example.usermanagment.dao.Json.sendResponseInJsonFormat;

public class RollServlet extends HttpServlet {

    private OneToManyDAO oneToManyDAO;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        allRolls(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        insertRoll(req , resp);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        updateRoll(req , resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            deleteRoll(req , resp);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void init() throws ServletException {
        oneToManyDAO = OneToManyDAOFactory.getInstanceForRollDAO();
    }


    private void allRolls(HttpServletRequest req , HttpServletResponse resp) throws IOException {
        List<Entity> rolls = oneToManyDAO.selectAll();
        StringBuilder sb= new StringBuilder();
        for(Entity user : rolls){
            sb.append(user).append("\n");
        }
        sendResponseInJsonFormat(resp , sb.toString());
    }

    private void insertRoll(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String requestBody = getRequestBody(req);
        Roll roll = Json.parseStringToRoll(requestBody);
        oneToManyDAO.save(roll);
        String rollInJsonFormat = Json.parseRollToString(roll);
        sendResponseInJsonFormat(resp , rollInJsonFormat);
    }
    private void deleteRoll(HttpServletRequest req , HttpServletResponse resp) throws IOException, SQLException {
        String requestBody = getRequestBody(req);
        Roll roll = Json.parseStringToRoll(requestBody);
        oneToManyDAO.delete(roll.getId());
        String rollInJsonFormat = Json.parseRollToString(roll);
        sendResponseInJsonFormat(resp , rollInJsonFormat);
    }

    private void updateRoll(HttpServletRequest req , HttpServletResponse resp) throws IOException {
        String requestBody = getRequestBody(req);
        Roll roll = Json.parseStringToRoll(requestBody);
        oneToManyDAO.update(roll);
        String rollInJsonFormat = Json.parseRollToString(roll);
        sendResponseInJsonFormat(resp , rollInJsonFormat);
    }
}
