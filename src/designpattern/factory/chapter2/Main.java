package designpattern.factory.chapter2;

import designpattern.factory.chapter2.server.JPGameServer;
import designpattern.factory.chapter2.server.KRGameServer;

public class Main {
    public static void main(String[] args){
        GameServer gameServer = new KRGameServer();
        gameServer.execute("supermario");
        gameServer = new JPGameServer();
        gameServer.execute("tetris");
    }
}
