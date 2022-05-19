package designpattern.decorator.bread;

import designpattern.decorator.Toast;

public class WheatBread extends Toast {
    public WheatBread() {
        name.append("호밀식빵 토스트");
        addKcal(250);
    }
}
