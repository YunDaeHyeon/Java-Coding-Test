package designpattern.factory.chapter1;

public abstract class Game {
    public String title, version;
    public void BootingGame(){
        System.out.println("게임 명 : "+title);
        System.out.println("게임 버전 : "+version);
        System.out.println(title + "게임이 실행 준비 되었습니다.\n");
    }
    public void RunGame(){
        System.out.println(title+"을 시작합니다.\n");
    }
}
