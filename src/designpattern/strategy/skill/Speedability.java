package designpattern.strategy.skill;

import designpattern.strategy.Passive;

public class Speedability implements Passive {
    @Override
    public void detail() {
        System.out.println("패시브 스킬 - 스피드 : 한 번에 두 번 공격");
    }
}
