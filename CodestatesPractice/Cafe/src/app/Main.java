package app;

//⭐️무인 카페 키오스크 프로그램 만들기⭐
//< 요구사항️ >
// 1. 커피와 차만 판매 -> 메뉴 : 커피(아메리카노,카페라떼) 차(페퍼민트티,루이보스티)
// 2. 메뉴에서 이름과 가격이 출력되어야한다
// 3. 옵션선택가능 : 커피는 샷추가여부, 차는 티백 제거 여부
// 4. 단 하나의 음료만 주문 가능
// 5. 할인 조건 : 코드스테이츠 수강생 500원 할인 (변동가능)
public class Main {
    public static void main(String[] args) {
        //어떤 객체를 사용할지, 생성할지를 결정하는 역할만 하는 클래스를 만들어 분리
        AppConfigurer appConfigurer = new AppConfigurer();
        Kiosk kiosk = new Kiosk(appConfigurer.discountCondition());

        kiosk.operate();
    }
}
/*
설계(프로그램 만드는 과정)
1. 가장 먼저 객체를 생각해야한다
커피, 차 -> Coffee, Tea
상품들의 목록 저장소 -> ProductRepository
할인 조건 -> CozDiscountCondition
프로그램의 메인 로직 -> app.Kiosk
2. 세부사항
커피, 차 -> 이름, 가격, id, 옵션
공통정보 : 이름, 가격, id -> Product클래스로 상속하자
각각 다른 정보 : 옵션 -> Product클래스에 추상메서드로 정의하여 각각에 오버라이딩하자
3.
*/