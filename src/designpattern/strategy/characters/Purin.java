package designpattern.strategy.characters;

import designpattern.strategy.Pokemon;
import designpattern.strategy.skill.Avoidability;
import designpattern.strategy.skill.Sing;

public class Purin extends Pokemon {
    public Purin() {
        attack = new Sing();
        passive = new Avoidability();
    }

    @Override
    protected void name() {
        System.out.println("이름 : 푸린, 속성 : 노멀");
    }
}
