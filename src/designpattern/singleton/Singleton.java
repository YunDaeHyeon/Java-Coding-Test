package designpattern.singleton;

public class Singleton {
    private static Singleton singleton = new Singleton();

    private Singleton() {
        System.out.println("Singleton 패턴을 사용하는 경우");
    }

    public static Singleton getInstance(){
        return singleton;
    }
}
