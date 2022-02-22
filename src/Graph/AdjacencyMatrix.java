package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class AdjacencyMatrix {
    public static void main(String[] args) throws IOException {
        // V = 정점의 개수, E = 간선의 개수
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int[][] graph = new int[V+1][V+1]; // 노드 0이 존재하면 V를, 노드 1이 존재한다면 배열의 크기를 임의로 1 증가
        int row, col, cost;
        for(int i = 0; i < E; i++){
            st = new StringTokenizer(br.readLine(), " ");
            row = Integer.parseInt(st.nextToken());
            col = Integer.parseInt(st.nextToken());
            cost = Integer.parseInt(st.nextToken());
            graph[row][col] = cost;
            graph[col][row] = cost;
        }
        for(int i = 1 ; i < V+1; i++){
            for(int j = 1 ; j < V+1; j++){
                System.out.print(graph[i][j]+" ");
            }
            System.out.println();
        }
        br.close();
    }
}
