package designpattern.decorator;

public abstract class Toast {
    public StringBuffer name = new StringBuffer();
    public int kcal;
    public void serve(){
        getName();
        getKcal();
    }

    public void getName(){
        System.out.println("주문한 토스트 : "+name);
    }

    public void getKcal(){
        System.out.println("칼로리 : "+kcal+"Kcal\n");
    }

    public void addTopping(ToppingDecorator td){
        addName(td.Name());
        addKcal(td.Kcal());
    }

    public void addName(String name){
        this.name.insert(0, name);
    }

    public void addKcal(int kcal){
        this.kcal += kcal;
    }
}
