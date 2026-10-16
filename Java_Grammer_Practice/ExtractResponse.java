import java.util.HashMap;
import java.util.Map;

public class Main {

    public static int getCount(Map<String, Object> response) {
        if (response == null){
            return 0;
        }
        if (response.containsKey("count")){
            if (!(response.get("count") instanceof Number)){
                return 0;
            } else {
                return ((Number) response.containsKey("count")).intValue();
            }
        }

    }

    public static void main(String[] args) {
        Map<String, Object> response = new HashMap<>();
        response.put("count", 3);

        System.out.println(getCount(response)); // 3
        System.out.println(getCount(null));     // 0

        response.put("count", "abc");
        System.out.println(getCount(response)); // 0
    }
}