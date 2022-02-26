package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class CreateBFS{
    int vertex; // 정점의 수
    int edge; // 간선의 수
    int[][] graph; // 그래프
    boolean[] visited; // 방문 체크
    private LinkedList<Integer>[] list; // 인접리스트 생성

    public CreateBFS(int vertex, int edge){
        this.vertex = vertex;
        this.edge = edge;
        graph = new int[vertex][vertex];
        visited = new boolean[vertex];
        list = new LinkedList[vertex];
        for(int i = 0 ; i < vertex; i++){
            list[i] = new LinkedList<>();
        }
    }

    public void graphInit(){
        Arrays.fill(visited, false);
    }

    public void makeGraphEdge(int from, int to){
        // 양방향 간선 연결
        graph[from][to] = 1;
        graph[to][from] = 1;
        // 인접리스트 표현
        list[from].add(to);
        list[to].add(from);
    }

    public void createMatrix(){
        for(int i = 0 ; i < vertex; i++){
            for(int j = 0 ; j < vertex; j++){
                System.out.print(graph[i][j]+" ");
            }
            System.out.println();
        }
    }

    public void createList(){
        for(int i = 0 ; i < list.length; i++){
            Collections.sort(list[i]);
            System.out.print(list[i]+" ");
        }
    }

    // @Param 시작지점 노드
    public void useBFS(int startNode){
        // 선입선출
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(startNode); // 처음 시작지점을 큐에 넣는다.
        visited[startNode] = true; // 시작 정점 방문 처리

        // 큐에 있는 모든 정점에 방문할 때 까지 (큐가 텅 빌때까지)
        while(!queue.isEmpty()){
            int temp = queue.poll(); // 큐에 있는 정점을 하나 뺀다.
            System.out.print(temp+" ");

            for(int i = 0; i < vertex; i++){
                if(graph[temp][i] == 1 && !visited[i]){ // graph[temp][i] == 1은 graph[from][to] == 1와 같은 의미
                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }
    }

}

public class BFS {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("정점(vertex)과 간선(edge)의 개수를 입력하세요");
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int vertex = Integer.parseInt(st.nextToken()); // 정점의 개수 입력
        int edge = Integer.parseInt(st.nextToken()); // 간선의 개수 입력
        CreateBFS createBFS = new CreateBFS(vertex, edge);
        System.out.println("간선(Edge) 입력(from <-> to)");
        for(int i = 0 ; i < edge; i++){
            st = new StringTokenizer(br.readLine()," ");
            createBFS.makeGraphEdge(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        }
        System.out.print("BFS 탐색 결과 : ");
        createBFS.useBFS(0);
        System.out.println();
        System.out.println("== 그래프 인접 행렬 표현 ==");
        createBFS.createMatrix();
        System.out.println("== 그래프 인접 리스트 표현 ==");
        createBFS.createList();
    }
}
