package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class CreateGraph{
    int verTex; // 정점의 개수
    int edge; // 간선의 개수
    int[][] graph; // 그래프 표현
    boolean[] visit; // 방문 여부
    private LinkedList<Integer>[] list; // 인접리스트 생성

    public CreateGraph(int vertex, int edge){
        verTex = vertex;
        this.edge = edge;
        graph = new int[vertex][vertex];
        visit = new boolean[vertex];
        list = new LinkedList[verTex];
        for(int i = 0 ; i < verTex; i++){
            list[i] = new LinkedList<>();
        }
    }

    public void graphInit(){
        // 방문 초기화
        Arrays.fill(visit, false);
    }

    public void makeGraphEdge(int from, int to){
        // 양방향으로 간선 연결하기
        graph[from][to] = 1;
        graph[to][from] = 1;
        // 인접리스트 표현하기
        list[from].add(to);
        list[to].add(from);
    }

    public void createMatrix(){
        for(int i = 0 ; i < verTex; i++){
            for(int j = 0 ; j < verTex; j++){
                System.out.print(graph[i][j]+" ");
            }
            System.out.println();
        }
    }

    public void createList(){
        for(int i = 0; i < list.length; i++){
            Collections.sort(list[i]);
            System.out.print(list[i]+" ");
        }
    }

    public void useStack(int edge){
        Stack<Integer> stack = new Stack<>();
        stack.push(edge);
        visit[edge] = true; // 방문처리
        System.out.print(edge+" ");

        while(!stack.isEmpty()){// 스택이 비어있을 때 까지
            int v = stack.peek(); // 스택에서 제거하지 않고 꺼낸다.
            boolean flag = false; // 방문 여부 판별
            for(int i = 0 ; i < verTex; i++){
                if(graph[v][i] == 1 && !visit[i]){
                    // 정점들이 서로 연결되어있고 방문하지 않았다면
                    visit[i] = true; // 방문처리
                    flag = true;
                    stack.push(i); // 스택에 넣기
                    System.out.print(i+ " ");
                    break;
                }
            }
            if(!flag){
                // 방문하지 않았다면 스택에서 꺼낸다.
                stack.pop();
            }
        }
    }

    public void useRecursion(int edge){
        visit[edge] = true;
        System.out.print(edge+" ");
        for(int i = 0 ; i < verTex; i++){
            if(graph[edge][i] == 1 && !visit[i]){
                visit[i] = true;
                useRecursion(i);
            }
        }
    }
}

public class DFS {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        System.out.print("정점(VerTex)의 개수 입력 : ");
        int vertex = Integer.parseInt(br.readLine());
        System.out.print("간선(Edge)의 개수 입력 : ");
        int edge = Integer.parseInt(br.readLine());

        CreateGraph createGraph = new CreateGraph(vertex, edge);
        System.out.println("간선(Edge) 입럭(from<->to)");

        for (int i = 0; i < edge; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            createGraph.makeGraphEdge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        System.out.print("Stack을 사용한 탐색 결과 : ");
        createGraph.useStack(0);
        System.out.println();

        // 스택 방문 초기화
        createGraph.graphInit();

        System.out.print("재귀를 사용한 탐색 결과 : ");
        createGraph.useRecursion(0);
        System.out.println();

        System.out.println("== 그래프 인접행렬 표현 == ");
        createGraph.createMatrix();

        System.out.println("== 그래프 인접리스트 표현 ==");
        createGraph.createList();
    }
}
