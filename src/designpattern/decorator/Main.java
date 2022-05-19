package designpattern.decorator;

import designpattern.decorator.bread.ButterBread;
import designpattern.decorator.bread.NomalBread;
import designpattern.decorator.bread.WheatBread;
import designpattern.decorator.ingredients.Cheese;
import designpattern.decorator.ingredients.Egg;
import designpattern.decorator.ingredients.Ham;
import designpattern.decorator.ingredients.Vegetable;

/*
    데코레이터(Decorator) 패턴
     : 기본 클래스를 조합해서 많은 클래스를 만들어야 할 때
     > 너무 많아질 수 있는 장식을 '조용히(?) 어떻게 처리하는가'를 설명하는 디자인 패턴
     > Decorator 패턴은 주인공으로 여기서의 주인공은 꼭 있어야만 하는 존재가 아니고
     장식처럼 없어도 되는 존재

     @ 예제 프로젝트 이해
        - 토스트를 판매할 때 칼로리를 계산해 알려주는 토스트 가게가 있음
        - 현재 판매하는 메뉴는 치즈 토스트, 여채 토스트, 햄 토스트 3종류
        - 앞으로도 재료는 늘어나고 재료를 혼합한 토스트 종류가 늘어날 예정
        - 기본 재료를 조합해 만드는 토스트의 종류를 하이ㅜ 클래스로 계속 추가할 수 있는
        상속 구조로 만든다면 기본 재료가 추가될 때마다 그것을 조합해 만들어지는 토스트의 종류(클래스)는
        수십 가지로 늘어날 것.
    적용
        1. Decorator 패턴을 적용하면 식빵은 상속 구조를 사용
        2. 빵의 종류가 늘어나는 것에 대해서는 Toast라는 상위 클래스를 만들고 하위 클래스에 식빵의 종류를 둠
        3. Decorator 패턴은 재료를 기본 재료(햄, 치즈, 달걀, 야채)와 복합 재료로 나누는 것 부터 시작
        4. 기본 재료는 하위 클래스에 놓고 상위 클래스 ToppiongDecorator라는 이름의 클래스를 만듦
        5. 혼합 재료는 기본 재료를 계속 늘려 나가는 방식으로 프로그래밍
 */
public class Main {
    public static void main(String[] args){
        Toast toast1 = new NomalBread();
        toast1.addTopping(new Cheese());
        toast1.addTopping(new Ham());
        toast1.serve();

        Toast toast2 = new WheatBread();
        toast2.addTopping(new Vegetable());
        toast2.addTopping(new Egg());
        toast2.serve();

        Toast toast3 = new ButterBread();
        toast3.addTopping(new Ham());
        toast3.addTopping(new Ham());
        toast3.addTopping(new Ham());
        toast3.serve();
    }
}
