package designpattern.factory.chapter1;

import designpattern.factory.chapter1.game.SuperMario;
import designpattern.factory.chapter1.game.Tetris;

public class GameServerFactory {
    SuperMario superMario = new SuperMario();
    Tetris tetris = new Tetris();
    public Game chooseGame(String game){
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
