package stack;

import java.util.Arrays;
import java.util.EmptyStackException;

public class Stack<E> implements StackInterface<E> {
    private static final int DEFAULT_CAPACITY = 10; // 최소 크기
    private static final Object[] EMPTY_ARRAY = {}; // 빈 배열 선언
    private Object[] array; // 요소를 담을 배열 선언
    /*
    Object는 모든 자바 클래스의 최상위 클래스이다.
    Stack을 사용할 때 넘어오는 클래스가 Primitive 혹은 Wrapper일 수 있기에 Object 배열 선언
     */
    private int size; // 요소의 개수 (배열의 크기가 아닌 요소의 개수)

    // 초기 공간을 할당하지 않았을 경우의 생성자
    public Stack() {
        this.array = EMPTY_ARRAY; // 초기 공간이 없는 빈 배열을 array에 대입
        this.size = 0;  // 요소의 개수
    }

    // 초기 공간을 할당하였을 경우의 생성자
    public Stack(int capacity) {
        this.array = new Object[capacity]; // 파라미터의 값 만큼 Object[] array의 크기 할당
        this.size = 0; // 요소의 개수
    }

    // 기본적으로 스택은 Vector 클래스를 상속받기에 ArrayList와 유사하다.
    // 데이터를 효율적으로 관리하기 위해 최적화를 틈틈히 수행해야 할 필요가 있다.
    // 요소의 개수가 배열에 얼마나 차 있는지 확인하고 적절한 크기에 맞춰 배열의 크기를 컨트롤한다. (동적할당)
    private void resize() {

        // util의 Arrays.equals(array1, array2)를 사용하여 두 배열이 같은지 비교한다.
        // EMPTY_ARRAY의 경우 static final로 선언되어 비어있는 상수 배열이다.
        // resize()를 불러올 때 스택이 비어있을 경우
        if (Arrays.equals(array, EMPTY_ARRAY)) {
            array = new Object[DEFAULT_CAPACITY]; // 스택이 비어있으므로 최소 크기를 지정
            return;
        }

        int arrayCapacity = array.length; // 현재 스택의 크기 저장
        // resize()를 불러올 때 스택이 가득 차있을 경우
        if (size == DEFAULT_CAPACITY) { // 스택에 있는 요소의 개수가 기본 배열의 크기(10)보다 크면
            int newSize = arrayCapacity * 2; // 스택이 가득 차있으므로 현재 배열의 크기를 두 배로 늘린다.

            // Arrays.copyOf(array1, length)를 사용하여 용량을 두 배로 늘린 배열을 기존의 배열에 복사한다.
            array = Arrays.copyOf(array, newSize);
            return;
        }

        // resize()를 불러올 때 요소가 현재 스택 크기의 절반보다 작을 경우
        if (size < (arrayCapacity / 2)) {
            int newSize = arrayCapacity / 2;

            // Math.max(value1, value2)는 두 개의 인자 중 큰 값을 리턴한다.
            // 스택의 크기가 최소 크기(10)보다 작게 설정되는 것을 방지하기 위함.
            array = Arrays.copyOf(array, Math.max(DEFAULT_CAPACITY, newSize));
            return;
        }
    }

    @Override
    public E push(E item) {
        if(size == array.length) // push()를 수행했을 때 스택의 용량이 꽉 찬 상태라면
            resize();
        array[size] = item; // Stack은 Last in First Out 이기에 push를 수행하면 top에 요소를 추가한다.
        size++; // 요소를 추가한 뒤 요소의 개수를 늘린다.
        return item;
    }

    @Override
    public E pop() {
        if(size == 0) // 만약 스택에 삭제할 요소가 존재하지 않는다면 스택이 비어있는 의미이기에 예외를 발생시킨다.
            throw new EmptyStackException(); // EmptyStackException은 스택이 비어있는 것을 나타내는 예외이다.

        @SuppressWarnings("unchecked")
        E obj = (E) array[size-1]; // 삭제될 요소를 반환하기 위한 임시 변수 선언
        array[size-1] = null; // 스택 top의 요소 삭제
        size--; // 요소의 개수 줄이기
        resize(); // 스택 재할당
        return obj;
    }

    @SuppressWarnings("unchecked")
    @Override
    public E peak() {
        if(size == 0)
            throw new EmptyStackException();
        return (E) array[size-1]; // 배열에서 마지막 원소의 인덱스는 개수보다 1개 작다.
    }

    @Override
    public int search(E value) { // search는 찾으려는 데이터가 top으로부터 얼마나 떨어져 있는지 찾기 위한 메소드
        for(int i = size - 1; i >= 0 ; i--){ // size-1은 요소의 top의 인덱스를 의미
            if(array[i].equals(value)){
                return size - i;
            }
        }
        return -1; // 일치하는 데이터가 없는 경우
    }

    @Override
    public int size() { // size()는 현재 스택에 있는 요소의 개수를 반환한다.
        return size;
    }

    @Override
    public void clear() { // clear()는 현재 스택의 모든 요소를 초기화한다.
        for(int i = 0 ; i < size; i++)
            array[i] = null; // 현재 스택에 있는 요소를 모두 null로 초기화 한다.
        size = 0; // 요소의 개수를 0으로 초기화
        resize(); // 스택의 크기를 다시 제어
    }

    @Override
    public boolean empty() { // 스택이 비어있는지에 대한 여부를 판별
        return size == 0;
        // size(요소의 개수)가 0이라면 true(1)를 반환, 아니라면 false(0)를 반환
    }
}
