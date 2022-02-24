package dfs;

public class DFS_Recursion {
    static boolean[] visited = new boolean[8]; // 노드가 1 ~ 7까지 있으므로
    static int[][] graph = {{},{1, 2, 3},{5, 6},{1, 4, 7},{3, 7},{2},{2},{3,4}};
    public static void main(String[] args){
        dfs(1);
    }
    public static void dfs(int node){
        visited[node] = true;
        System.out.print(node+" ");
        for(int nodeIndex : graph[node]){
            if(!visited[nodeIndex]){
                dfs(nodeIndex);
            }
        }
    }
}
