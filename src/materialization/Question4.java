package materialization;

/* 완전탐색 & 구현 Question - 게임 개발
현민이는 게임 캐릭터가 맵 안에서 움직이는 시스템을 개발 중이다. 캐릭터가 있는 장소는 1 x 1 크기의 정사각형으로 이뤄진
N x M 크기의 직사각형으로, 각각의 칸은 육지 또는 바다이다. 캐릭터는 동서남북 중 한 곳을 바라본다.
맵의 각 칸은 (A, B)로 나타낼 수 있고, A는 북쪽으로부터 떨어진 칸의 개수, B는 서쪽으로부터 떨어진 칸의 개수이다.
캐릭터는 상하좌우로 움직일 수 있고, 바다로 되어 있는 공간에는 갈 수 없다. 캐릭터의 움직임을 설정하기 위해 정해 놓은 메뉴얼은 이러하다.
    1. 현재 위치에서 현재 방향을 기준으로 왼쪽 방향(반시계 방향으로 90도 회전한 방향)부터 차례대로 갈 곳을 정한다.
    2. 캐릭터의 바로 왼쪽 방향에 아직 가보지 않은 칸이 존재한다면, 왼쪽 방향으로 회전한 다음 왼쪽으로 한 칸을 전진한다.
       왼쪽 방향에 가보지 않은 칸이 없다면, 왼쪽 방향을 회전만 수행하고 1단계로 돌아간다.
    3. 만약, 네 방향 모두 이미 가본 칸이거나 바다로 되어 있는 칸인 경우에는, 바라보는 방향을 유지한 채로 한 칸 뒤로 가고 1단계로 돌아간다.
       단, 이때 뒤쪽 방향이 바다인 칸이라 뒤로 갈 수 없는 경우에는 움직임을 멈춘다.
현민이는 위 과정을 반복적으로 수행하면서 캐릭터의 움직임에 이상이 있는지 테스트하려고 한다. 메뉴얼에 따라 캐릭터를 이동시킨 뒤에,
캐릭터가 방문한 칸의 개수를 출력하는 프로그램을 만드시오.

[ 입력 조건 ]
- 첫째 줄에 맵의 세로 크기 N과 가로 크기 M을 공백으로 구분하여 입력한다.
- 둘째 줄에 게임 캐릭터가 있는 칸의 좌표 (A, B)와 바라보는 방향 d가 각각 서로 공백으로 구분하여 주어진다.
  방향 d의 값으로는 다음과 같이 4가지가 존재한다.
  0 : 북쪽, 1 : 동쪽, 2 : 남쪽, 3 : 서쪽
- 셋째 줄 부터 맵이 육지인지 바다인지에 대한 정보가 주어진다. N개의 줄에 맵의 상태가 북쪽부터 남쪽 순서대로,
  각 줄의 데이터는 서쪽부터 동쪽 순서대로 주어진다. 맵의 외각은 항상 바다로 되어 있다.
  0 : 육지, 1 : 바다
- 처음에 게임 캐릭터가 위치한 칸의 상태는 항상 육지이다.
[ 출력 조건 ]
- 첫째 줄에 이동을 마친 후 캐릭터가 방문한 칸의 수를 출력한다.
[ 입력 예시 ]
4 4         // 4 x 4 맵 생성
1 1 0       // (1,1)에 북쪽(0)을 바라보고 서 있는 캐릭터
1 1 1 1     // 첫 줄은 모두 바다
1 0 0 1     // 둘째 줄은 바다 육지 육지 바다
1 1 0 1     // 셋째 줄은 바다 바다 육지 바다
1 1 1 1     // 넷째 줄은 모두 바다
[ 출력 예시 ]
3

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Question4 {
    static int[] positionX = {0,1,0,-1}; // 북 동 남 서
    static int[] positionY = {-1,0,1,0}; // 북 동 남 서
    static int direction;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " "); // 맵의 크기 입력
        int[][] map = new int[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())]; // [N][M]
        st = new StringTokenizer(br.readLine(), " ");
        int A = Integer.parseInt(st.nextToken()); // 게임캐릭터의 좌표 Y
        int B = Integer.parseInt(st.nextToken()); // 게임캐릭터의 좌표 X
        direction = Integer.parseInt(st.nextToken()); // 방향
        int count = 1; // 시작지점 자체가 이미 방문지점이므로 0이 아닌 1부터 시작
        int directionCount = 0; // 3단계 방향 전환 카운트 변수
        for(int i = 0 ; i < map.length ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < map[i].length; j++) map[i][j] = Integer.parseInt(st.nextToken()); // 맵 생성
        }
        map[A][B] = 1; // 시작지 방문 처리
        // 움직임 시작
        while(true) {
            turnLeft(); // 현재 위치에서 현재 방향을 기준으로 왼쪽 방향부터 갈 곳을 정한다.
            int x = B + positionX[direction]; // 바라보는 방향으로 전진
            int y = A + positionY[direction];
            if(map[y][x] == 0){ // 왼쪽 방향에 아직 가보지 않은 칸이 존재한다면, (= 육지인 경우)
                map[y][x] = 1; // 방문처리
                count++; // 방문한 칸의 횟수 카운트
                directionCount = 0; // 방향 초기화
                B = x; // 캐릭터 위치 이동
                A = y; // 캐릭터 위치 이동
                System.out.println("방문한 위치 : ("+A+","+B+")");
                for(int a = 0 ; a < map.length ; a++){
                    for(int b = 0 ; b < map[a].length; b++){
                        System.out.print(map[a][b]+" ");
                    }
                    System.out.println();
                }
            }else{  // 왼쪽 방향에 가보지 않은 칸이 존재하지 않다면, (= 바다인 경우)
                directionCount++; // 왼쪽으로 방향 전환을 했으니 +1
            }
            if(directionCount == 4){ // 북 동 남 서 모두 가봤다면
                x = B - positionX[direction]; // 바라보는 방향 유지하고 한 칸 뒤로
                y = A - positionY[direction];
                if(map[y][x] == 0){ // 뒤로 갈 수 있는 경우 (육지인 경우)
                    B = x;  // 캐릭터 위치 이동
                    A = y;
                }else{ // 뒤로 갈 수 없는 경우 (바다인 경우)
                    break;
                }
                directionCount = 0;
            }
        }
        System.out.println(count);
    }
    public static void turnLeft(){
        direction -= 1;
        if(direction < 0) direction = 3; // 0 : 북쪽, 1 : 동쪽, 2 : 남쪽, 3 : 서쪽
    }
}
