package Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/* 정렬 문제 - 성적이 낮은 순서로 학생 출력하기
N명의 학생 정보가 있다. 학생 정보는 학생의 이름과 학생의 성적으로 구분된다. 각 학생의 이름과 성적 정보가 주어졌을 때
성적이 낮은 순서대로 학생의 이름을 출력하는 프로그램을 작성하시오.

[ 입력 조건 ]
- 첫 번째 줄에 학생의 수 N이 입력된다. (1 <= N <= 100,000)
- 두 번째 줄부터 N+1번째 줄에는 학생의 이름을 나타내는 문자열 A와 학생의 성적을 나타내는 정수 B가 공백으로 구분되어 입력된다. 문자열 A의 길이와 학생의 성적은 100 이하의 자연수이다.

[ 출력 조건 ]
- 모든 학생의 이름을 성적이 낮은 순서대로 출력한다. 성적이 동일한 학생들의 순서는 자유롭게 출력해도 괜찮다.

[ 입력 예시 ]
2
홍길동 95
이순신 77

[ 출력 예시 ]
이순신 홍길동
 */

public class Question2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String[][] student = new String[Integer.parseInt(br.readLine())][2];
        for(int i = 0 ; i < student.length; i++){
            st = new StringTokenizer(br.readLine(), " ");
            student[i][0] = st.nextToken();
            student[i][1] = st.nextToken();
        }
        for(int i = 0 ; i < student.length-1; i++){
            for(int j = i + 1; j < student.length; j++){
                if(Integer.parseInt(student[i][1]) > Integer.parseInt(student[j][1])){
                    String temp_name = student[j][0];
                    String temp_age = student[j][1];
                    student[j][0] = student[i][0];
                    student[j][1] = student[i][1];
                    student[i][0] = temp_name;
                    student[i][1] = temp_age;
                }
            }
        }
        for(int i = 0 ; i < student.length ; i++){
            System.out.print(student[i][0]+" ");
        }
    }
}
