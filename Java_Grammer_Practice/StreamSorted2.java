
import java.util.*;
import java.util.stream.*;
import java.util.function.*;

public class Main {

    static class Order {
        String category;
        int price;
        int quantity;

        Order(String category, int price, int quantity) {
            this.category = category;
            this.price = price;
            this.quantity = quantity;
        }

        int getTotal() {
            return price * quantity;
        }
    }

    public static List<String> rankCategories(List<Order> orders) {
        return orders.stream()
                .collect(Collectors.groupingBy(
                        order -> order.category,
                        Collectors.summingInt(order -> order.getTotal())
                ))
                .entrySet().stream()
                .sorted((a,b) -> Integer.compare(
                        b.getValue(), a.getValue()
                ))
                .map(entry -> entry.getKey())
                .collect(Collectors.toList());
        }

    public static void main(String[] args) {
        List<Order> orders = Arrays.asList(
                new Order("전자제품", 100, 2),
                new Order("식품", 10, 10),
                new Order("전자제품", 50, 2),
                new Order("의류", 30, 1),
                new Order("식품", 20, 3)
        );

        System.out.println(rankCategories(orders));
        // 기대 결과: [전자제품, 식품, 의류]
    }
}
