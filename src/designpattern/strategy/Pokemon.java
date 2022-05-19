package designpattern.strategy;

public abstract class Pokemon{
    public Attack attack;
    public Passive passive;
    public Pokemon(){};
    public void introduce(){
        name();
        attack.motion();
        passive.detail();
    }
    protected abstract void name();
    public void setAttack(Attack attack){
        this.attack = attack;
    }
    public void setPassive(Passive passive)
    {
        this.passive = passive;
    }
}