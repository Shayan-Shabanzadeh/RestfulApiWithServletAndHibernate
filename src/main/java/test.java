import com.example.usermanagment.bean.User;
import com.example.usermanagment.dao.Json;
import com.fasterxml.jackson.core.JsonProcessingException;

public class test {
    public static void main(String[] args) {
        User user = new User(1 , "ali" , "ali.com" , "iran");
        try {
            System.out.println(Json.parseUserToJsonString(user));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
