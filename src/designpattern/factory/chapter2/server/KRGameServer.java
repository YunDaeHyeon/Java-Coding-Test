package designpattern.factory.chapter2.server;

import designpattern.factory.chapter2.GameServer;
import designpattern.factory.chapter2.Games;
import designpattern.factory.chapter2.games.KRSuperMario;
import designpattern.factory.chapter2.games.KRTetris;

public class KRGameServer extends GameServer {
    KRSuperMario superMario = new KRSuperMario();
    KRTetris tetris = new KRTetris();
    @Override
    protected Games chooseGame(String game) {
        if(game.equals("supermario")){
            return superMario;
        }
        else if(game.equals("tetris")){
            return tetris;
        }
        else{
            System.out.println("지원하지 않는 게임입니다.");
            return null;
        }
    }
}
