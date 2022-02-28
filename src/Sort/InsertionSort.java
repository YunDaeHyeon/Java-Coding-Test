package Sort;
/*
1. 현재 타겟이 되는 숫자와 이전에 있는 원소를 비교한다. (첫 번째 타겟은 두 번째 원소부터)
2. 타겟이 되는 숫자가 이전 위치에 있는 원소보다 작으면 위치를 서로 교환한다.
3. 그 다음 타겟을 찾아 1, 2번을 반복한다.
 */
public class InsertionSort {
    public static int[] arr = {9, 7, 5, 8, 6, 4, 3, 2, 1, 10};
    public static void main(String[] args){
        for(int i = 1 ; i < arr.length; i++){ // 타겟 (첫 번째 타겟은 두 번째 원소부터이기에 1부터 시작)
            int target = arr[i]; // 타겟 변수
            int j = i - 1; // 이전 위치에 있는 원소들
            while(j >= 0 && target < arr[j]){ // 타겟이 이전 위치에 있는 원소보다 작으면
                arr[j+1] = arr[j]; // 이전 원소를 한 칸씩 뒤로 밀기.
                j--;
            }
            // 타겟이 이전 원소보다 크면 타겟 원소는 이전 위치(j) 뒤에 와야한다.
            // 따라서 j+1에 타겟을 대입.
            arr[j+1] = target;
        }
        System.out.println("삽입 정렬 탐색 결과");
        for(int i = 0 ; i < arr.length ; i++){
            System.out.print(arr[i]+" ");
        }
    }
}
