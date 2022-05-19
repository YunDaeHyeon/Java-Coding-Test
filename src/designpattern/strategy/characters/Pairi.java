package designpattern.strategy.characters;

import designpattern.strategy.Pokemon;
import designpattern.strategy.skill.Defensibility;
import designpattern.strategy.skill.Flame;

public class Pairi extends Pokemon {
    public Pairi(){
        attack = new Flame();
        passive = new Defensibility();
    }
    @Override
    protected void name() {
        System.out.println("이름 : 파이리, 속성 : 불");
    }
}