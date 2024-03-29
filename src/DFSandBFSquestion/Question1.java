package DFSandBFSquestion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
Question 1 - 음료수 얼려먹기
N x M 크기의 얼음 틀이 있다. 구멍이 뚫려 있는 부분은 0, 칸막이자 존재하는 부분은 1로 표시된다. 구멍이 뚫려있는 부분끼리 상, 하, 좌, 우로 붙어 있는 경우 서로
 연결되어 있는 것으로 간주한다. 이때, 얼음 틀의 모양이 주어졌을 때 생성되는 총 아이스크림의 개수를 구하는 프로그램을 작성하시오.
 다음의 4x5 얼음틀 예시에서는 아이스크림이 총 3개 생성된다.
 00110
 00011
 11111
 00000

[ 입력 조건 ]
- 첫 번재 줄에 얼음 틀의 세로 길이 N과 가로 길이 M이 주어진다.
- 두 번째 줄 부터 N + 1번째 줄까지 얼음 틀의 형태가 주어진다.
- 이때 구멍이 뚫려있는 부분은 0, 그렇지 않은 부분(벽)은 1이다.

[ 출력 조건 ]
- 한 번에 만들 수 있는 아이스크림의 개수를 출력한다.
 */
public class Question1 {
    public static int N;
    public static int M;
    public static int[][] iceCream;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int count = 0; // 아이스크림의 개수
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        iceCream = new int[N][M];
        for(int i = 0; i < N; i++){
            String[] temp = br.readLine().split("");
            for(int j = 0; j < M; j++){
                iceCream[i][j] = Integer.parseInt(temp[j]);
            }
        }

        for(int x = 0 ; x < N; x++){
            for(int y = 0 ; y < M; y++){
                if(dfs(x, y)){
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    public static boolean dfs(int x, int y){
        if(x < 0 || x >= N || y < 0 || y >= M){
            return false ; // 얼음틀의 크기를 벗어남.
        }
        if(iceCream[x][y] == 0){
            iceCream[x][y] = 1;
            dfs(x+1, y); // 우
            dfs(x-1,y); // 좌
            dfs(x, y-1); // 상
            dfs(x, y+1); // 하
            return true;
        }
        return false;
    }
}
