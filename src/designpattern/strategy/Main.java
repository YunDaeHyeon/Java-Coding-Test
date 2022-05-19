package designpattern.strategy;

import designpattern.strategy.characters.Pairi;
import designpattern.strategy.characters.Pikachu;
import designpattern.strategy.characters.Purin;
import designpattern.strategy.skill.Defensibility;
import designpattern.strategy.skill.MillionVolt;

public class Main {
    public static void main(String[] args){
        Pokemon pikachu = new Pikachu();
        pikachu.introduce();

        Pokemon pairi = new Pairi();
        pairi.introduce();

        Pokemon purin = new Purin();
        purin.introduce();

        purin.setAttack(new MillionVolt());
        purin.setPassive(new Defensibility());

        purin.introduce();
    }
}
