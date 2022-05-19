package designpattern.strategy.characters;

import designpattern.strategy.Pokemon;
import designpattern.strategy.skill.MillionVolt;
import designpattern.strategy.skill.Speedability;

public class Pikachu extends Pokemon {
    public Pikachu() {
        attack = new MillionVolt();
        passive = new Speedability();
    }

    @Override
    protected void name(){
        System.out.println("이름 : 피카츄, 속성 : 번개");
    }
}
