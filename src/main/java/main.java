import com.example.usermanagment.bean.Roll;
import com.example.usermanagment.bean.User;
import com.example.usermanagment.dao.Json;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.HashSet;
import java.util.Set;


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
//        String rollInJsonFormat = "{\"id\":1\"rollName\":\"Driver\", \"users\":[{\"id\":1\"name\":\"shayan\", \"emai\":\"shayan@.com\",\"country\":\"USA\" }]}";
        Set<User> users = new HashSet<>();
        Set<Roll> rolls = new HashSet<>();
        User user = new User();
        user.setId(1L);
        user.setName("Shayan");
        user.setEmail("shayan@com");
        user.setCountry("USA");
        Roll roll = new Roll();
        roll.setId(1L);
        roll.setRollName("teacher");
        users.add(user);
        rolls.add(roll);
        roll.setUsers(users);
        user.setRolls(rolls);
        try {
//            User user = Json.parseStringToJson(userInJsonFormat);
//            Roll roll = Json.parseStringToRoll(rollInJsonFormat);
//            System.out.println(user.getAddresses());
            System.out.println(Json.parseRollToString(roll));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

    }
}
