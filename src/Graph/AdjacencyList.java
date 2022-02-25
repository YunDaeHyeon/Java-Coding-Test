package Graph;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

class Adj{
    private LinkedList<Integer>[] adj; // 인접 리스트 생성
    private int v; // 정점의 개수

    public Adj(int v){
        this.v = v;
        adj = new LinkedList[v+1];
        // 그래프가 1부터 시작하면 LinkedList[v+1]. ( 0은 비우기 )
        // 그래프가 0부터 시작하면 LinkedList[v]
        for(int i = 0; i < v+1; i++){
            adj[i] = new LinkedList<>();
        }
    }
    public void createEdge(int v1, int v2){
        adj[v1].add(v2);
        adj[v2].add(v1); // 하나를 빼면 방향 인접 리스트
    }
    public void print(){
        for(int i = 1; i < adj.length; i++)
            System.out.println("정점 "+i+"의 인접 노드 : "+adj[i]);
    }
}

//가중치가 없는 그래프(연결리스트)
public class AdjacencyList{
    public static void main(String[] args) throws IOException {
        int V = 7;
        Adj adj = new Adj(V);
        adj.createEdge(1, 2);
        adj.createEdge(1, 3);
        adj.createEdge(2, 4);
        adj.createEdge(2, 5);
        adj.createEdge(6, 4);
        adj.createEdge(6, 5);
        adj.createEdge(3, 7);
        adj.createEdge(6, 7);

        adj.print();
    }
}
