package dfs;
import java.util.Stack;
public class DFS_Stack {
    static boolean[] visited = new boolean[8];
    static int[][] graph = {{},{1, 2, 3},{5, 6},{1, 4, 7},{3, 7},{2},{2},{3,4}}; // 인접리스트
    static Stack<Integer> stack = new Stack<>();
    public static void main(String[] args) {
        stack.push(1);
        visited[1] = true;
        // 스택이 비어있지 않으면 계속 반복
        while(!stack.isEmpty()) {
            // 스택에서 하나를 꺼냅니다.
            int nodeIndex = stack.pop();
            // 방문 노드 출력
            System.out.print(nodeIndex + " -> ");
            // 꺼낸 노드와 인접한 노드 찾기
            for (int LinkedNode : graph[nodeIndex]) {
                // 인접한 노드를 방문하지 않았을 경우에 스택에 넣고 방문처리
                if(!visited[LinkedNode]) {
                    stack.push(LinkedNode);
                    visited[LinkedNode] = true;
                }
            }
        }
    }
}