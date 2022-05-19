package designpattern.decorator.bread;

import designpattern.decorator.Toast;

public class ButterBread extends Toast {
    public ButterBread() {
        name.append("버터식빵 토스트");
        addKcal(400);
    }
}
