package products;

public class ProductRepository {
    private Product[] products = new Product[]{
            new Coffee(1,"Americano",3000,false),
            new Coffee(2,"Caffe Latte", 3500, false),
            new Tea(3,"Peppermint tea",4000, false),
            new Tea(4, "Rooibos tea", 4500, false)
    };

    public Product[] getProducts() {
        return products;
    }
    //id를 받아와서 상푸을 찾아 리턴하는 메서드
    public Product findById(int productId) {
        for(Product product : products) {
            if (product.getId() == productId) return product;
        }
        return null;
    }
}
