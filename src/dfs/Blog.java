package dfs;

import java.util.Arrays;
import java.util.Stack;

class MyGraph {
    int vertexCnt;
    int[][] m;
    boolean[] visit;

    public MyGraph(int N) {
        vertexCnt = N;
        m = new int[N][N];
        visit = new boolean[N];
    }

    public void init() {
        Arrays.fill(visit, false);
    }

    public void makeUndirectedEdge(int from, int to) {
        m[from][to] = 1;
        m[to][from] = 1;
    }

    public void dfsStack(int v) {
        Stack<Integer> st = new Stack<>();
        st.push(v);
        visit[v] = true;
        System.out.print(v + "  ");

        while (!st.isEmpty()) {
            int now = st.peek();
            boolean flag = false;

            for (int i = 0; i < vertexCnt; ++i) {
                if (m[now][i] == 1 && !visit[i]) {
                    visit[i] = true;
                    flag = true;
                    st.push(i);
                    System.out.print(i + "  ");
                    break;
                }
            }

            if (!flag) {
                st.pop();
            }
        }
    }

    public void dfsRecursion(int v) {
        visit[v] = true;
        System.out.print(v + "  ");

        for (int i = 0; i < vertexCnt; ++i) {
            if (m[v][i] == 1 && !visit[i]) {
                visit[i] = true;
                dfsRecursion(i);
            }
        }
    }
}

public class Blog {

    public static void main(String[] args) {
        MyGraph mg = new MyGraph(8);
        mg.makeUndirectedEdge(0, 1);
        mg.makeUndirectedEdge(0, 2);
        mg.makeUndirectedEdge(0, 3);
        mg.makeUndirectedEdge(1, 4);
        mg.makeUndirectedEdge(1, 5);
        mg.makeUndirectedEdge(2, 6);
        mg.makeUndirectedEdge(3, 6);
        mg.makeUndirectedEdge(3, 7);
        mg.dfsStack(0);
        mg.init();
        mg.dfsRecursion(0);
    }
}
