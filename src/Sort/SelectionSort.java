package Sort;

// 1. 주어진 리스트에서 최소값을 찾는다.
// 2. 최솟값을 맨 앞자리의 값과 교환한다.
// 3. 맨 앞자리를 제외한 나머지 값들 중 최솟값을 찾아 위와 같은 방법으로 반복한다.
// 중요 : N개의 데이터 중 N-1개가 정렬되어있다는 것은 마지막 원소가 최댓값이라는 의미. 그러기에
// 정렬을 할 필요가 없음.

public class SelectionSort {
    // 정렬 대상 배열 선언
    public static int[] arr = {9, 7, 8, 6, 5, 4, 3, 2, 1, 10};
    public static void main(String[] args){
        // 바깥 반복문 : 정렬 순서 (마지막 순서는 마지막 원소가 최댓값이라는 의미이기에 -1을 함.)
        for(int i = 0 ; i < arr.length-1; i++){
            // 최솟값을 가지고 있는 인덱스 찾기
            for(int j = i + 1; j < arr.length; j++){
                if(arr[j]<arr[i]){ // arr[i] : 맨 앞자리, arr[j] : 최솟값
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.println("== 졍렬 결과 ==");
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i]+" ");
        }
    }
}
