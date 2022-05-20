package designpattern.adapter;

public class Buds {
    public Buds() {
        System.out.println("무선 이어폰 호환 시스템");
    }
    public void play(){
        System.out.println("삼성 Buds 음악 재생 중...");
    }
    public void stop(){
        System.out.println("삼성 Buds 음악을 중지합니다!");
    }
}
