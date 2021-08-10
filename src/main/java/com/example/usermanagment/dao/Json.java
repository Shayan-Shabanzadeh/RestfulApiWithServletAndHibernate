package com.example.usermanagment.dao;

import com.example.usermanagment.bean.Address;
import com.example.usermanagment.bean.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

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
    public static String parseStringToAddress(Address address) throws JsonProcessingException {
        return objectMapper.writeValueAsString(address);
    }
}
