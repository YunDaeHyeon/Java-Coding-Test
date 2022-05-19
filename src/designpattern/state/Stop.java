package designpattern.state;

public class Stop implements State{

    @Override
    public void on_button(ElectricFan EF) {
        System.out.println("\n ***on 버튼 눌림***\n"+"정지에서 송풍 상태로 바뀜\n");
        EF.setState(new Wind());
    }

    @Override
    public void off_button(ElectricFan EF) {
        System.out.println("\n***off 버튼 눌림***\n"+"상태 변화 없음\n");
    }
}
