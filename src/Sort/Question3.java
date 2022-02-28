package Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Question3 {
    static int MAX = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        Integer[] A = new Integer[Integer.parseInt(st.nextToken())];
        Integer[] B = new Integer[A.length];
        int K = Integer.parseInt(st.nextToken());
        String[] temp = br.readLine().split(" ");
        for(int i = 0 ; i < A.length ; i++)
            A[i] = Integer.parseInt(temp[i]);
        temp = br.readLine().split(" ");
        for(int i = 0 ; i < B.length ; i++)
            B[i] = Integer.parseInt(temp[i]);
        Arrays.sort(A); // 오름차순 수행
        Arrays.sort(B, Collections.reverseOrder()); // 내림차순 수행
        // 배열 A에서 K개의 가장 작은 숫자를 찾기
        // 배열 B에서 K개의 가장 큰 숫자를 찾기
        // 그 둘을 바꾸기
        for(int i = 0 ; i < K ; i++){
            int dummy = B[i];
            B[i] = A[i];
            A[i] = dummy;
        }
        // 최대값 출력
        for(int i = 0 ; i < A.length ; i++){
            MAX += A[i];
        }
        System.out.print(MAX);
    }
}
