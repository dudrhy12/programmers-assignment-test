
import java.util.*;

public class Main {

    static class Product {
        private String name;
        private int stock;

        public Product(String name, int stock) {
            this.name = name;
            this.stock = stock;
        }

        public String getName() {
            return name;
        }

        public int getStock() {
            return stock;
        }

        public void setStock(int stock) {
            this.stock = stock;
        }
    }

    public static String decreaseStock(
            Product product,
            int quantity) {

        if (product == null){
            return "상품 없음";
        }
        if (quantity < 1){
            return "잘못된 수량";
        }
        if (product.getStock() < quantity){
            return "재고 부족";
        }

        product.setStock(product.getStock()-quantity);
        return "차감 성공";

    }

    public static void main(String[] args) {
        Product product = new Product("Keyboard", 10);

        System.out.println(decreaseStock(product, 3));
        System.out.println(decreaseStock(product, 8));
        System.out.println(decreaseStock(null, 1));
        System.out.println(product.getStock());
    }
}
