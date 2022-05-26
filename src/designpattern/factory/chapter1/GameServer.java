package designpattern.factory.chapter1;

public class GameServer {
    public GameServerFactory gameServerFactory;

    public GameServer() {
        System.out.println("GameServer : 정상 연결 완료 \n");
    }

    public GameServer(GameServerFactory gameServerFactory){
        this.gameServerFactory = gameServerFactory;
    }

    public void execute(String game){
        Game games;
        games = gameServerFactory.chooseGame(game);
        games.BootingGame();
        games.RunGame();
    }
}
