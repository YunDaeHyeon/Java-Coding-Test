package designpattern.factory.chapter2;

public abstract class GameServer {
    protected abstract Games chooseGame(String game);
    public GameServer(){
        System.out.println("GameServer : 정상 연결 완료\n");
    }
    public void execute(String game){
        Games games;
        games = chooseGame(game);
        games.BootingGame();
        games.RunGame();
    }
}
