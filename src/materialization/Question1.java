package materialization;

/* 구현 - 상하좌우
여행가 A는 NxN 크기의 정사각형 공간 위에 서 있다. 이 공간은 1x1 크기의 정 사각형으로 나누어져 있다.
가장 왼쪽 위 좌표는 (1,1)이며, 가장 오른쪽 아래 좌표는 (N, N)에 해당한다. 여행가 A는 상, 하, 좌, 우 방향으로 이동할 수 있으며,
시작 좌표는 항상 (1,1)이다. 우리 앞에는 여행가 A 가 이동할 계획이 적인 계획서가 놓여 있다.
계획서에는 하나의 줄에 띄어쓰기를 기준으로 하여 L, R, U, D 중 하나의 문자가 반복적으로 적혀있다.

[ 계획서 내용 ]
R -> R -> R -> U -> D -> D

각 문자의 의미는 다음과 같다.
- L : 왼쪽으로 한 칸 이동
- R : 오른쪽으로 한 칸 이동
- U : 위로 한 칸 이동
- D : 아래로 한 칸 이동
이때, 여행가 A가 NxN 크기의 정사각형 공간을 벗어나는 움직임은 무시한다. 예를 들어 (1,1)의 위치에서 L 혹은 U를 만나면 무시된다.
계획서가 주어졌을 때 여행가 A가 최종적으로 도착할 지점의 좌표를 출력하는 프로그램을 작성하시오.

[ 입력 조건 ]
첫째 줄에 공간의 크기를 나타내는 N이 주어진다.
둘째 줄에 여행가 A가 이동할 계획서 내용이 주어진다.

[ 출력 조건 ]
첫째 줄에 여행가 A가 최종적으로 도착할 지점의 좌표 (X, Y)를 공백으로 구분하여 출력한다.

[ 입력 예시 ]
5
R R R U D D

[ 출력 예시 ]
3 4
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Question1 {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1,1, 0, 0};
    static char[] moveTypes = {'L', 'R', 'U', 'D'};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = 1, y = 1;
        int N = Integer.parseInt(br.readLine());
        String[] plans = br.readLine().split(" ");
        for(int i = 0; i < plans.length; i++){
            for(int j = 0; j < moveTypes.length; j++){
                if(plans[i].charAt(0) == moveTypes[j]){
                     int nx = x + dx[j];
                     int ny = y + dy[j];
                    if(x < 1 || x > N || y < 1 || y > N) continue;
                    x = nx;
                    y = ny;
                }
            }
        }
        System.out.println((x+1)+" "+(y+1));

    }
}