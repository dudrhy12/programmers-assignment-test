import java.util.List;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        List<Integer> numbers = List.of(3, 5, 3, 2, 5, 8);

        List<Integer> result = removeDuplicates(numbers);

        System.out.println(result);
    }

    public static List<Integer> removeDuplicates(List<Integer> numbers) {
        List<Integer> result = new ArrayList<>();

        for (int i=0; i<numbers.size(); i++){
            if (result.contains(numbers.get(i))){
                continue;
            } else {
                result.add(numbers.get(i));
            }
        }
        return result;

    }
}