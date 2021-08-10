import com.example.usermanagment.bean.Address;
import com.example.usermanagment.bean.User;
import com.example.usermanagment.dao.Json;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.ArrayList;
import java.util.Arrays;

public class main {
    public static void main(String[] args) {
//        ArrayList<Address> addresses = new ArrayList<>(Arrays.asList(new Address(1 , "sergerg") , new Address(2 , "regergerg")));
//        User user = new User(1 , "Shayan" ,"shayan@.com" , "Iran" , addresses);
//        try {
//            System.out.println(Json.parseUserToJsonString(user));
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//        }
        String userInJsonFormat = "{\"id\":1,\"name\":\"Shayan\",\"email\":\"shayan@.com\",\"country\":\"Iran\",\"addresses\":[{\"id\":1,\"address\":\"sergerg\"},{\"id\":2,\"address\":\"regergerg\"}]}";
        try {
            User user = Json.parseStringToJson(userInJsonFormat);
            System.out.println(user.getAddresses());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

    }
}
