class Product {
    private String name;
    private int price;

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}

class Order {
    private Product product;
    private int quantity;

    public Order(Product product, int quantity) {
        if (product == null){
            throw new IllegalArgumentException();
        }

        if (quantity < 1){
            throw new IllegalArgumentException();
        }
        this.product = product;
        this.quantity = quantity;

    }

    public int getTotalPrice() {
        int price = this.product.getPrice();
        int quantity = this.quantity;

        return price*quantity;

    }
}