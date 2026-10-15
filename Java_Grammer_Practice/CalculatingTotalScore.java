import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<String> users = List.of("kim", "lee", "kim", "park", "lee");
        List<Integer> scores = List.of(10, 20, 15, 5, 30);

        System.out.println(totalScores(users, scores));
    }

    public static Map<String, Integer> totalScores(
            List<String> users,
            List<Integer> scores) {

        Map<String, Integer> result = new HashMap<>();

        for (int i=0; i<users.size(); i++){
            String user = users.get(i);
            if (result.containsKey(users.get(i))){
                result.put(user, result.get(user)+scores.get(i));
            } else {
                result.put(user, scores.get(i));
            }
        }

        return result;

    }
}