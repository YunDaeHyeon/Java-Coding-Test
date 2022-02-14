package materialization;

/*
구현 - 시각
정수 N이 입력되면 00시 00분 00초부터 N시 59분 59초까지의 모든 시각 중에서 3이 하나라도 포함되는 모든 경우의 수를 구하는 프로그램을 작성하시오.
예를 들어 1을 입력했을 때 다음은 3이 하나라도 포함되어 있으므로 세어야 하는 시각이다.
 - 00시 00분 03초
 - 00시 13분 30초
반면에 다음은 3이 하나도 포함되어 있지 않으므로 세면 안 되는 시각이다.
 - 00시 02분 55초
 - 01시 27분 45초

[ 입력 조건 ]
 - 첫째 줄에 정수 N이 입력된다.

[ 출력 조건 ]
 - 00시 00분 00초부터 N시 59분 59초까지의 모든 시각 중에서 3이 하나라도 포함되는 모든 경우의 수를 출력한다.

[ 입력 예시 ]
5

[ 출력 예시 ]
11485
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Question2 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int count = 0;
        for(int i = 0 ; i <= N; i++){
            for(int m = 0 ; m < 60; m++){
                for(int s = 0 ; s < 60; s++){
                    if((String.valueOf(i)+m+s).contains("3")) count++;
                }
            }
        }
        System.out.println(count);
    }
}
