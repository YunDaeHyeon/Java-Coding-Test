package Queue;

public interface Queue<E> {

    // 큐의 가장 마지막에 요소를 추가한다.
    // 큐가 정상적으로 추가되면 true를, 그렇지 않다면 false를 반환한다.
    boolean offer(E e);

    // 큐의 첫 번째 요소를 삭제하고 삭제 된 요소를 반환한다.
    E poll();

    // 큐의 첫 번째 요소를 반환한다.
    E peek();
}
