package designpattern.decorator.ingredients;

import designpattern.decorator.ToppingDecorator;

public class Egg extends ToppingDecorator {
    @Override
    public String Name() {
        return "달걀";
    }

    @Override
    public int Kcal() {
        return 100;
    }
}
