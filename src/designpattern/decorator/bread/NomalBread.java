package designpattern.decorator.bread;

import designpattern.decorator.Toast;

public class NomalBread extends Toast {
    public NomalBread() {
        name.append("식빵 토스트");
        addKcal(300);
    }
}
