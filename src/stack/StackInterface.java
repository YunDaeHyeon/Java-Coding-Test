package stack;

// 스택은 Vector 클래스를 상속받아 사용한다. 내부 구조는 Object[]이기에 전체적인 메소드 구조와 유사하다.
public interface StackInterface<E> { // 효율적인 자료구조를 구축하기 위해 제네릭 사용

    // 스택 top에 요소를 추가하는 push 구현
    E push(E item);

    // 스택 top에 있는 요소를 제거하는 pop 구현
    // @return 제거된 요소
    E pop();

    // 스택 top에 요소를 제거하지 않고 반환하는 peek 구현
    // @return 스택의 맨 위에 있는 요소
    E peak();

    // 스택의 top부터 특정 요소가 몇 번째 위치에 있는지 반환.
    // 중복되는 원소가 있을 경우 가장 위에 있는 요소의 위치가 반환된다.
    // @return 스택의 top부터 요소가 일치하는 첫 번째 위치를 반환.
    //          만약, 일치하는 요소가 없을 시 -1 반환.
    int search(E value);

    // 스택의 요소 개수를 반환
    // @return 스택의 요소 개수
    int size();

    // 스택에 있는 모든 요소 삭제
    void clear();

    // 스택에 요소가 비어있는지 확인
    // @return 스택에 요소가 없으면 true, 그 이외는 false
    boolean empty();
}
