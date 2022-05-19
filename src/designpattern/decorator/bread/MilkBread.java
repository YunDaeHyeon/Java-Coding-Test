package designpattern.decorator.bread;

import designpattern.decorator.Toast;

public class MilkBread extends Toast {
    public MilkBread() {
        name.append("우유식빵 토스트");
        addKcal(350);
    }
}
