package designpattern.strategy;

import designpattern.strategy.characters.Pairi;
import designpattern.strategy.characters.Pikachu;
import designpattern.strategy.characters.Purin;
import designpattern.strategy.skill.Defensibility;
import designpattern.strategy.skill.MillionVolt;


/*
    전략(Strategy) 패턴
     : 자주 바뀌는 것이 기능일 때
     문제점 - 기능변화
        1. 기술이 발전함에 따라 공격과 패시브 기술이 계속 교체되지만 이에 대한 해결책 X
        2. 클래스 설계 원칙 중 OCP(개방 폐쇄 원칙)를 위반하는 것일 뿐 아니라 프로그램을 복잡하게 만듦
     해결책
        - 자주 바뀌는 것이 무엇인지 찾아 그들을 별도의 상속 구조로 만들어 사용
        - 자주 바뀌는 것이 attack(), passive()이기 때문에 이들을 클래스로 만들고 상속 구조로 설계
        - 추가되는 공격 기술을 하위 클래스에 계속 추가할 수 있음
     정리
        - 전략(Strategy)패턴은 기능(메소드, 전력)이 자주 바뀌기 때문에 이들을 오른쪽에 별도로 구성하고
        내부에서 변화하도록 한다.
        - 메소드(전략)마다 각각의 클래스로 먼저 바꾸고 이를 <<interface>> 타입의 상속 구조로 만들어
        구현한다.

 */
public class Main {
    public static void main(String[] args){
        Pokemon pikachu = new Pikachu();
        pikachu.introduce();

        Pokemon pairi = new Pairi();
        pairi.introduce();

        Pokemon purin = new Purin();
        purin.introduce();

        purin.setAttack(new MillionVolt());
        purin.setPassive(new Defensibility());

        purin.introduce();
    }
}
