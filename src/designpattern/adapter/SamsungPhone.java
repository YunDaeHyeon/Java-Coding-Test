package designpattern.adapter;

public class SamsungPhone {
    Buds buds = new Buds();
    AirPodsAdapter airPodsAdapter;

    public SamsungPhone() {
        installAirPods();
        System.out.println();
        testBuds();
        System.out.println();
        testAirPods();
    }

    public void installAirPods(){
        airPodsAdapter = new AirPodsAdapter();
        System.out.println("Buds와 새로 구입한 AirPods을 연결합니다.");
    }

    public void testBuds(){
        buds.play();
        buds.stop();
    }

    public void testAirPods(){
        airPodsAdapter.play();
        airPodsAdapter.stop();
    }
}
