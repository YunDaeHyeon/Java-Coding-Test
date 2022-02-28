package Sort;

public class QuickSort {
    public static void main(String[] args){
        int[] arr = {7, 4, 2, 8, 3, 5, 1, 6, 10, 9}; // 배열 선언
        // 배열, 시작점, 끝점에 해당하는 인덱스를 파라미터로 보낸다.
        quickSort(arr, 0, arr.length-1);
        for(int i = 0 ; i < arr.length; i++){
            System.out.print(arr[i]+" ");
        }
    }

    public static void quickSort(int[] arr, int start, int end){
        // 배열, 시작, 끝에 해당하는 변수를 보낸 뒤 리턴값을 받는다.
        int part = partition(arr, start, end);

        // 파티션 쪼개기 (분할)
        if(start<part-1){ // 시작점이 끝점 - 1보다 작으면
            quickSort(arr,start,part-1); // 파티션 쪼개기 ( 왼쪽 )
        }
        if(end>start){ // 끝점이 시작점보다 크면
            quickSort(arr, part, end); // 파티션 쪼개기 ( 오른쪽 )
        }
    }

    public static int partition(int arr[], int start, int end){
        int pivot = arr[(start+end)/2]; // 피벗 설정 (0+9)/2 = 4
        // 끝점이 시작점보다 크면 해당 파티션의 정렬을 종료한다.
        while(start<=end){ // 시작점이 끝점보다 작거나 같지 않을 때 까지 반복
            while(arr[start] < pivot){ // 시작점에 해당하는 값이 피벗보다 작으면
                start++; // 피벗보다 클 때 까지 start를 증가시킨다. (오른쪽 -> 왼쪽)
            }
            while(arr[end]>pivot){ // 끝점에 해당하는 값이 피벗보다 크면
                end--; // 피벗보다 작을 때 까지 end를 감소시킨다. (왼쪽 -> 오른쪽)
            }
            if(start<=end){ // 시작점이 끝점보다 작거나 같다면
                // 시작점에 있는 값과 끝점에 있는 값을 SWAP 한다.
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                // 그 뒤 Start, End 포인트를 한 칸씩 이동시킨다.
                start++;
                end--;
            }
        }

        // 끝점이 시작점보다 작아 해당 파티션의 정렬이 끝나면 시작점에 해당하는 인덱스를 반환한다.
        return start;
    }
}
