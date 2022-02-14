package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
    Greedy Algorithm Question 2 - 큰 수의 법칙
    동빈이의 큰 수의 법칙은 다양한 수로 이루어진 배열이 있을 때 주어진 수들을 M번 더하여 가장 큰 수를 만드는 법칙.
    단, 배열의 특정한 인텍스(번호)에 해당하는 수가 연속해서 K번 초과하여 더해질 수 없다.
    ex : 순서대로 2, 4, 5, 4, 6으로 이루어진 배열이 있을 때 M은 8, K은 3일 때 특정한 인덱스(번호)는 3번까지만 더해질 수 있다.
    큰 수의 법칙에 따르면 6 + 6 + 6 + 5 + 6 + 6 + 6 + 5 = 46이 된다.
    단, 서로 다른 인덱스에 해당하는 수가 같은 경우에도 서로 다른 것으로 간주한다.
    3, 4, 3, 4, 3으로 이루어진 배열이 있을 때 M은 7, K는 2일 때 특정한 인덱스는 4번까지만 더해질 수 있다. 하지만, 가장 큰 수는 4지만
    서로 다른 인덱스(번호)를 가지고 있어 4를 번갈아 두 번씩 더하는 것이 가능하다.
    4 + 4 + 4 + 4 + 4 + 4 + 4 = 28이 가능.
    배열의 크기 N, 숫자가 더해지는 횟수 M, 특정한 번호 반복 제한 K가 주어질 때 큰 수의 법칙에 따른 결과를 출력하시오.
    [ 입력 예시 ]       [ 출력 예시 ]
    5 8 3               46
    2 4 5 4 6
 */

public class Question2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int[] N = new int[Integer.parseInt(st.nextToken())]; // 배열의 크기
        int M = Integer.parseInt(st.nextToken()); // 숫자가 더해지는 횟수
        int K = Integer.parseInt(st.nextToken()); // K번 초과하여 더해지기 금지.

        // 배열[N]에 값 대입하기
        st = new StringTokenizer(br.readLine()," ");
        for(int i = 0; i < N.length; i++) N[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(N); // 배열 N을 오름차순 정렬
        int first = N[N.length-1];
        int second = N[N.length-2];
        int count = 0; // 반복문 횟수
        int result = 0; // 최종 결과

        // M번 만큼 더하기
        for(int i = 0; i < M; i++){
            if(count == K){
                result += second;
                count = 0;
            }else{
                result += first;
                count++;
            }
        }
        System.out.println(result);
    }
}