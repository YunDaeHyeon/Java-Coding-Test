package designpattern.adapter;

/*
    어뎁터(Adapter) 패턴
     : 컴포넌트가 맞지 않아 바로 사용할 수 없을 때
    > 호환되지 않는 두 인터페이스를 작동시킬 수 있도록 만든 인터페이스
   이해
    - 삼성 휴대전화에 무선 이어폰 Buds 대신 애플의 무선 이어폰 Airpods을 사용할 수 있도록 하는 것
    - 두 이어폰의 기능은 재생과 멈춤으로 한정
    - Buds는 재생 기능에 play(), 멈춤 기능에 stop() 메소드를 사용
    - Airpods은 재생 기능에 playing(), 멈춤 기능에 stopping() 메소드를 사용
 */
public class Main {
    public static void main(String[] args){
        SamsungPhone samsungPhone = new SamsungPhone();
    }
}
