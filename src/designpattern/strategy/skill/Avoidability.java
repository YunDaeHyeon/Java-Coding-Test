package designpattern.strategy.skill;

import designpattern.strategy.Passive;

public class Avoidability implements Passive {
    @Override
    public void detail() {
        System.out.println("패시브 스킬 - 회피 : 30% 확률로 공격 회피");
    }
}
