package materialization;

/* 완전탐색 & 구현 Question - 왕실의 나이트
행복 왕국의 왕실 정원은 체스과 같은 8x8 좌표 평면이다. 왕실 정원의 특정한 한 칸에 나이트가 서 있다.
나이트는 매우 충성스러운 신하로서 매일 무술을 연마한다. 나이트는 말을 타고 있기 때문에 이동을 할 때는 L자 형태로만 이동할 수 있으며
정원 밖으로는 나갈 수 없다. 나이트는 특정한 위치에서 다음과 같은 2가지 경우로 이동할 수 있다.
    1. 수평으로 두 칸 이동한 뒤에 수직으로 한 칸 이동하기
    2. 수직으로 두 칸 이동한 뒤에 수평으로 한 칸 이동하기
이처럼 8*8 좌표 평면 상에서 나이트의 위치가 주어졌을 때 나이트가 이동할 수 있는 경우의 수를 출력하는 프로그램을 작성하시오.
이때, 왕실의 정원에서 행 위치를 표현할 때는 1부터 8로 표현하며, 열 위치를 표현할 때는 a부터 h로 표현한다.
예를 들어 나이트가 a1에 있을 때 이동할 수 있는 경우의 수는 다음 2가지이다. a1의 위치는 좌표 평면에서 구석의 위치에 해당하며
나이트는 정원 밖으로 나갈 수 없기 때문이다.
    1. 오른쪽으로 두 칸 이동 후 아래로 한 칸 이동하기(c2)
    2. 아래로 두 칸 이동 후 오른쪽으로 한 칸 이동하기(b3)
또 다른 예로 나이트가 c2에 위치해 있다면 나이트가 이동할 수 있는 경우의 수는 6가지 이다.
[ 입력 조건 ]
 - 첫째 줄에 8x8 좌표 평면상에서 현재 나이트가 위치한 곳의 좌표를 나타내는 두 문자로 구성된 문자열이 입력된다.
 - 입력 문자는 a1처럼 열과 행으로 이뤄진다.
[ 출력 조건 ]
 - 첫째 줄에 나이트가 이동할 수 있는 경우의 수를 출력하시오.
[ 입력 예시 ]
a1
[ 출력 예시 ]
2
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Question3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] steps = {{2, -1}, {2, 1}, {1, 2}, {-1, 2}, {-2, 1}, {-2, -1}, {-1, -2}, {1, -2}};
        String[] result = br.readLine().split("");
        int x = result[0].charAt(0)-96;
        int y = Integer.parseInt(result[1]);
        int count = 0;
        for(int i = 0 ; i < steps.length; i++){
            int tempX = x + steps[i][0];
            int tempY = y + steps[i][1];
            if(tempX <= 8 && tempX >= 1 && tempY <= 8 && tempY >= 1) count++;
        }
        System.out.println(count);
    }
}
