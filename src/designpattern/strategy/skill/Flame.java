package designpattern.strategy.skill;

import designpattern.strategy.Attack;

public class Flame implements Attack {
    @Override
    public void motion() {
        System.out.println("공격 스킬 - 불꽃 : 뜨거운 불꽃을 쏘아 공격");
    }
}
