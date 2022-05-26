package designpattern.factory.chapter2;

public abstract class Games {
    public String title, version;

    public void BootingGame() {
        System.out.println("게임명 : " + title);
        System.out.println("게임 버전 : " + version);
        System.out.println(title + "게임이 실행 준비되었습니다.\n");
    }

    public void RunGame() {
        System.out.println(title + "을 시작합니다.\n");
    }
}