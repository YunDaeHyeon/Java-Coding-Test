package designpattern.decorator.ingredients;

import designpattern.decorator.ToppingDecorator;

public class Ham extends ToppingDecorator {
    @Override
    public String Name() {
        return "햄";
    }

    @Override
    public int Kcal() {
        return 200;
    }
}
