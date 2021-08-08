package com.example.usermanagment.dao;

import com.example.usermanagment.bean.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Json {
    private static ObjectMapper objectMapper = getDefaultObjectMapper();

    private static ObjectMapper getDefaultObjectMapper(){
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper;
    }

   public static String parseUserToJsonString(User user) throws JsonProcessingException {
        return objectMapper.writeValueAsString(user);
   }

   public static User parseStringToJson(String json) throws JsonProcessingException {
        return objectMapper.readValue(json , User.class);
   }
}
