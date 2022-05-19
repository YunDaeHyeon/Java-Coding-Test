package designpattern.state;

/*
    상태(State)패턴
     : 자주 바뀌는 것이 상태일 때
     문제점 - 상태 변화
        1. ElecFan 클래스에서는 조건문(if ~ else if)을 사용했는데 이 코드만으로는 상태의 변화를 쉽게
        읽을 수 없음
        2. 상태(추가, 삭제)가 바뀌면 on_button(), off_button() 메소드에 이를 반영해야 하므로
        계속해서 코드 수정이 필요
        3. 클래스 설계 원칙 중 OCP(개방 폐쇠 원칙)를 위반하는 것일 뿐 아니라 프로그램을 복잡하게 만들어
        유지보수를 어렵게 함
     해결책
        - 자주 바뀌는 것이 상태(송풍, 정지, 수면, 약풍, 중간풍, 강풍 등)이므로 조건문으로 처리하던
        상태를 클래스로 변경
        - 클래스를 상속 구조(인터페이스 포함) 형태로 만들어 하위 클래스에서 상태를 추가 및
        삭제할 수 있도록 만듬.
    정리
        - State 패턴은 자주 바뀌는 상태를 클래스로 만들고 이를 <<interface>> 타입의 상속 구조로 만듬
        - 상태의 변경이 그 안에서만 이루어지게 하여 주 클래스에 미치는 영향을 최소화하도록 설계한 패턴
 */
public class Main {
    public static void main(String[] args){
        ElectricFan EF = new ElectricFan();
        EF.operation();
    }
}
