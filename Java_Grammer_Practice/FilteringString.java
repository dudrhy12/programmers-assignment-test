import java.util.List;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        List<String> words = List.of(
                "cat", "apple", "dog", "banana", "orange"
        );

        List<String> result = filterWords(words);

        System.out.println(result);
    }

    public static List<String> filterWords(List<String> words) {
        List<String> result = new ArrayList<>();

        for (int i = 0; i < words.size(); i++){
            if (words.get(i).length() >= 5){
                result.add(words.get(i));
            }
        }

        return result;

    }
}