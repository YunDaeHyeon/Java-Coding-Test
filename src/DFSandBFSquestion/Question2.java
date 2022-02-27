package DFSandBFSquestion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
Question2 - 미로 탈출
동빈이는 N x M 크기의 직사각형 형태의 미로에 갇혀 있다. 미로에는 여러 마리의 괴물이 있어 이를 피해 탈출해야 한다.
동빈이의 위치는 (1, 1)이고 미로의 출구는 (N, M)의 위치에 존재하며 한 번에 한 칸씩 이동할 수 있다. 이때 괴물이 있는 부분은 0으로, 괴물이 없는 부분은 1로 표시되어 있다. 미로는 반드시 탈출 할 수 있는 형태로 제시된다. 이때, 동빈이가 탈출하기 위해 움직여야 하는 최소 칸의 개수를 구하시오. *칸을 셀 때는 시작 칸과 마지막 칸을 모두 포함해서 계산한다.*

[ 입력 조건 ]
- 첫째 줄에 두 정수 N, M이 주어진다. 다음 N개의 줄에는 각각 M개의 정수(0 혹은 1)로 미로의 정보가 주어진다. 각각의 수들은 공백 없이 붙어서 입력으로 제시된다.
  또한 시작 칸과 마지막 칸은 항상 1이다.

[ 출력 조건 ]
- 첫째 줄에 최소 이동 칸의 개수를 출력한다.

[ 입력 예시 ]
5 6
101010
111111
000001
111111
111111

[ 출력 예시 ]
10
 */
class Node{
    private int x;
    private int y;
    public Node(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }
}

public class Question2 {
    public static int N, M;
    public static int[][] graph;
    public static int[] PositionX = {0, 0, -1, 1}; // 상 하 좌 우
    public static int[] PositionY = {-1, 1, 0, 0}; // 상 하 좌 우
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " "); // N, M 입력받음
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new int[N][M];
        for(int i = 0; i < graph.length; i++){
            String[] temp = br.readLine().split("");
            for(int j = 0; j < graph[i].length; j++){
                graph[i][j] = Integer.parseInt(temp[j]);
            }
        }
        System.out.println("반복 끝");
        dfs(0,0);
    }
    public static void dfs(int x, int y){
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(x, y));
        while(!queue.isEmpty()){
            Node node;
            node = queue.poll();
            x = node.getX();
            y = node.getY();
            for(int i = 0 ; i < PositionX.length; i++){
                int dx = x + PositionX[i]; // 이동
                int dy = y + PositionY[i];
                if(dx < 0 || dy < 0 || dx >= N || dy >= M) continue; // 이동한 값이 미로를 벗어나면
                if(graph[dx][dy] == 0) continue; // 이동한 값이 몬스터라면
                if(graph[dx][dy] == 1){
                    graph[dx][dy] = graph[x][y] + 1;
                    queue.offer(new Node(dx, dy));
                }
            }
        }
        System.out.println(graph[N-1][M-1]); // 최단 거리 반환
    }
}
