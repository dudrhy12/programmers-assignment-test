import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Integer> prices = List.of(
                5000, 12000, 8000, 25000, 10000
        );

        List<Integer> result = filterOrders(prices);

        System.out.println(result);
    }

    public static List<Integer> filterOrders(
            List<Integer> prices) {

        List<Integer> result = new ArrayList<>();

        for (int i=0; i < prices.size(); i++){
            if ( prices.get(i) >= 10000 ) {
                result.add(prices.get(i))
            }
        }

        return result;
    }
}