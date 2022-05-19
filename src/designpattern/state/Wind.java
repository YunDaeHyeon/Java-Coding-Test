package designpattern.state;

public class Wind implements State{
    public Wind() {
        System.out.println("<<현재 상태 : 송풍>>");
    }

    @Override
    public void on_button(ElectricFan EF) {
        System.out.println("\n***on 버튼 눌림***\n"+"송풍에서 수면 상태로 바뀜\n");
        EF.setState(new Sleep());
    }

    @Override
    public void off_button(ElectricFan EF) {
        System.out.println("\n***off 버튼 눌림***\n"+"송품에서 정지 상태로 바뀜\n");
        EF.setState(new Stop());
    }
}
