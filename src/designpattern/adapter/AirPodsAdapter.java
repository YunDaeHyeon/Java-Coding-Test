package designpattern.adapter;

public class AirPodsAdapter extends AirPods implements AirPodsInterface{
    public AirPodsAdapter() {
        System.out.println("AirPods이 SamsungPhone과 호환됩니다.");
    }

    @Override
    public void play() {
        super.playing();
    }

    @Override
    public void stop() {
        super.stopping();
    }
}
