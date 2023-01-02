package app.products;

public abstract class Product {
    //이름 가격 id
    private int id;
    private String name;
    private int price;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public Product(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
    public abstract void applyOption();
    public abstract String getOptionToString();
}
