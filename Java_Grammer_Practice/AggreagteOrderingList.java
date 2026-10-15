import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        List<String> users = List.of(
                "kim", "lee", "kim", "park", "lee", "kim"
        );

        Map<String, Integer> result = countUsers(users);

        System.out.println(result);
    }

    public static Map<String, Integer> countUsers(List<String> users) {
        Map<String, Integer> result = new HashMap<>();

        for (int i = 0; i < users.size(); i++){
            if (result.containsKey(users.get(i))){
                result.put(users.get(i), result.get(users.get(i))+1);
            }
            else {
                result.put(users.get(i), 1);
            }
        }

        return result;

    }
}