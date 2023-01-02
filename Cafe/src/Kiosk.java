//import discount.BEDiscountCondition;
//import discount.CozDiscountCondition;
import discount.DiscountCondition;
import products.Product;
import products.ProductRepository;
import java.util.Scanner;

public class Kiosk {
    Scanner scanner = new Scanner(System.in);
    private ProductRepository productRepository = new ProductRepository();
    //**의존성주입**
    //Kiosk->cozDiscountCondition : 구현에 의존하고있다 구체클래스에 의존하고있다
    //Kiosk->DiscountCondition -> cozDiscountCondition : 역할에 의존하고있다
    //private CozDiscountCondition cozDiscountCondition = new CozDiscountCondition(500);
    //private BEDiscountCondition beDiscountCondition = new BEDiscountCondition(20);
    //위 두개처럼 작성하지않고 인터페이스로 적용하여 외부에서 결정하여 전달하고 호출
    //또한 생성자를 만들어 외부에서 만들어서 주입받도록 한다
    private DiscountCondition discountCondition;
    public Kiosk(DiscountCondition discountCondition){
        this.discountCondition = discountCondition;
    }
    public void operate(){
        //1️⃣메뉴 출력
        printMenu();

        //2️⃣메뉴 고르기 -> 입력받기
        Product selectedProduct = chooseMenu();

        //3️⃣옵션적용하기(따로따로 만들어야하므로 추상클래스로 만들자)
        // 1. 상품에따라 적절한 옵션을 물어봐주기 -> 2. 사용자가 선택한 옵션 적용 -> 3. 옵션 선택내용을 문자열로 만들기
        selectedProduct.applyOption();

        //4️⃣할인 여부 묻고 할인 적용하기 -> 변동가능하므로 추상클래스나 인터페이스로 구현
        //5️⃣주문 내역 출력
        order(selectedProduct);
    }
    //리팩토링 cmd+option+M
    private void order(Product selectedProduct) {
        //의존성주입
        //int price = cozDiscountCondition.discount(selectedProduct.getPrice());
        //int price = beDiscountCondition.discount(selectedProduct.getPrice());
        //위 두개처럼 작성하지 않고 인터페이스 이용
        int price = discountCondition.discount(selectedProduct.getPrice());
        System.out.println("주문이 완료되었습니다. ");
        System.out.printf("주문 상품 : %s %s\n", selectedProduct.getName(), selectedProduct.getOptionToString());
        System.out.printf("가격 : %d",price);
    }
    private Product chooseMenu() {
        int selectedId = Integer.parseInt(scanner.nextLine());
        return productRepository.findById(selectedId);
    }
    private void printMenu() {
        System.out.println("# 메뉴");
        System.out.println("-".repeat(50));
        for (Product p : productRepository.getProducts()){
            System.out.printf("(%d) %-15s %d\n",p.getId(), p.getName(), p.getPrice());
        }

        System.out.println("-".repeat(50));
        System.out.println("메뉴를 골라주세요.");
    }
}