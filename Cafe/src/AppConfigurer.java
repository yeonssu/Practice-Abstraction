import discount.BEDiscountCondition;
import discount.DiscountCondition;
///플로그램의 주요로직을 바꾸지 않고 환경설정 파일만 바꿔주면 된다
public class AppConfigurer {
    public DiscountCondition discountCondition() {
        return new BEDiscountCondition(20);
    }
}
