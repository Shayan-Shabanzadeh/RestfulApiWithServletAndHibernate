package com.example.usermanagment.dao;

import com.example.usermanagment.bean.Address;
import com.example.usermanagment.bean.Roll;
import com.example.usermanagment.bean.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.stream.Collectors;

public class Json {
    private static final ObjectMapper objectMapper = getDefaultObjectMapper();

    private static ObjectMapper getDefaultObjectMapper(){
        return new ObjectMapper();
    }

   public static String parseUserToJsonString(User user) throws JsonProcessingException {
        return objectMapper.writeValueAsString(user);
   }

   public static User parseStringToJson(String json) throws JsonProcessingException {
        return objectMapper.readValue(json , User.class);
   }

   public static Address parseStringToAddress(String json) throws JsonProcessingException {
       return objectMapper.readValue(json, Address.class);
   }
    public static String parseAddressToString(Address address) throws JsonProcessingException {
        return objectMapper.writeValueAsString(address);
    }
    public static Roll parseStringToRoll(String json) throws JsonProcessingException {
        return objectMapper.readValue(json, Roll.class);
    }
    public static String parseRollToString(Roll roll) throws JsonProcessingException {
        return objectMapper.writeValueAsString(roll);
    }
    public  static  String getRequestBody(HttpServletRequest req) throws IOException {
        return req.getReader().lines().collect(Collectors.joining());
    }
    public static  void sendResponseInJsonFormat(HttpServletResponse resp , String json) throws IOException {
        PrintWriter writer = resp.getWriter();
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        writer.println(json);
        writer.close();
    }


}
