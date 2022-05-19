package designpattern.state;

public class Sleep implements State{
    public Sleep() {
        System.out.println("<<현재 상태 : 수면>>");
    }

    @Override
    public void on_button(ElectricFan EF) {
        System.out.println("\n***on 버튼 눌림***\n"+"수면에서 송풍 상태로 바뀜\n");
        EF.setState(new Wind());
    }

    @Override
    public void off_button(ElectricFan EF) {
        System.out.println("\n***off 버튼 눌림***\n"+"수면에서 정지 상태로 바뀜\n");
        EF.setState(new Stop());
    }
}
