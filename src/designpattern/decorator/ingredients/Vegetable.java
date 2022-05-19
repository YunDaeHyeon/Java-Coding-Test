package designpattern.decorator.ingredients;

import designpattern.decorator.ToppingDecorator;

public class Vegetable extends ToppingDecorator {
    @Override
    public String Name() {
        return "야채";
    }

    @Override
    public int Kcal() {
        return 10;
    }
}
