package designpattern.strategy.skill;

import designpattern.strategy.Attack;

public class Sing implements Attack {
    @Override
    public void motion() {
        System.out.println("공격 스킬 - 노래하기 : 노래를 불러 상대를 잠재움");
    }
}
