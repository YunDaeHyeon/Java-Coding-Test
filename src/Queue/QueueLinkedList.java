package Queue;

import java.util.NoSuchElementException;

public class QueueLinkedList<E> implements Queue<E> {
    private Node<E> head; // 큐에서 가장 앞에 있는 노드 객체(front)를 가리킨다.
    private Node<E> tail; // 큐에서 가장 뒤에 있는 노드 객체(rear)를 가리킨다.
    private int size; // 큐에 있는 노드의 개수

    QueueLinkedList(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    /*
    offer 구현
    1. 큐 tail(rear)에 새로운 데이터(newNode)를 삽입한다.
    2. 기존 tail(rear)의 래퍼런스를 새로운 데이터(newNode)를 가리키도록 바꾼다.
    3. tail(rear)를 새로운 데이터(newNode)로 바꾼다.
    4. 성공적으로 제거되었다면 true를 반환한다.
     */
    @Override
    public boolean offer(E value) {
        Node<E> newNode = new Node<E>(value);
        // 만약 큐가 비어있을 경우
        if(size == 0){
            head = newNode;
        }else{ // 큐가 비어있지 않다면 마지막 노드(tail)가 새로운 데이터(newNode)를 가리키도록 한다.
            tail.next = newNode;
        }
        // tail을 새로운 데이터(newNode)로 바꿔준다.
        tail = newNode;
        size++; // 새로운 데이터가 입력되었으니 큐의 크기는 증가한다.
        return true;
    }

    /*
    poll 구현
    1. 큐 head(front)의 데이터(data)와 래퍼런스(next)를 제거한다.(null로 변경)
    2. head(front)를 기존 head(front)의 다음 노드로 변경한다.
    3. 성공적으로 삭제되었다면 삭제된 데이터(data)를 반환한다.
    자바에서 제공하는 Queue API를 보면 remove()와 offer()를 둘 다 제공한다.
    두 메소드의 차이는 "삭제할 요소가 없을 때 던지는 반환값"의 차이이다.
    remove()의 경우 삭제할 요소가 없으면 NoSuchElementException을 던진다.
    poll()의 경우 삭제할 요소가 없으면 null을 던진다.
     */
    @Override
    public E poll() {
        // 삭제할 요소가 없다면 null을 던진다.
        if(size == 0){
            return null;
        }
        E element = head.data; // 삭제할 데이터를 반환하기 위해 임시 제네릭 변수에 저장한다.
        Node<E> nextNode = head.next; // 데이터가 삭제된다면 삭제되는 데이터의 다음 노드를 head(front)로 지정하기 위해 가져온다.

        // 기존 head(front)의 데이터와 래퍼런스를 삭제한다.
        head.data = null;
        head.next = null;

        // head(front)를 삭제된 데이터의 다음 노드로 변경한다.
        head = nextNode;
        size--; // poll을 통하여 요소가 하나 제거되었으니 큐의 크기는 감소한다.
        return element;
    }

    // remove는 위 주석과 같이 삭제할 요소가 없으면 예외를 던지기에 poll()메소드에서 null이 반환되는 것을 이용한다.
    public E remove(){
        E element = poll();
        if(element == null){
            throw new NoSuchElementException();
        }
        return element;
    }

    /*
    peek 구현
    1. peek를 호출했는데 큐에 데이터가 없다면 null을 던진다.
    2. 현 큐의 head(front)의 데이터(data)를 반환한다.
    peek는 List의 element()와 대응된다. 따라서 peek는 값이 존재하지 않다면 null을 던지며 element()는 값이 없다면 예외를 던진다.
     */
    @Override
    public E peek() {
        if(size == 0){ // 큐에 데이터가 없다면
            return null;
        }
        return head.data; // 현 head(front)의 데이터(data)를 반환한다.
    }

    // peek는 위 주석과 같이 데이터가 없다면 peek()로부터 null이 반환되는 것을 이용한다.
    public E element(){
        E element = peek();
        if(element == null){
            throw new NoSuchElementException();
        }
        return element;
    }

    // 현재 큐에 있는 데이터의 개수를 반환한다.
    public int size(){
        return size;
    }

    // 현재 큐가 비어있는지 판별한다.
    // 큐가 비어있다면 true를, 비어있지 않다면 false를 반환한다.
    public boolean isEmpty(){
       return size == 0;
    }

    // 현재 찾고자 하는 데이터가 큐에 존재하는지 찾는다.
    // 만약, 찾고자 하는 데이터가 큐에 존재하면 true를, 존재하지 않는다면 false를 반환한다.
    public  boolean contains(Object value){
        // 큐의 head(front)부터 노드 x가 null이 될 때 까지 찾고자 하는 데이터(data)와 x의 데이터(data)가 같은지 판별한다.
        for(Node<E> x = head; x != null; x = x.next){
            if(value.equals(x.data)){ // 찾고자 하는 데이터가 x의 데이터와 같을 시
                return true;
            }
        }
        return false; // 찾고자 하는 데이터가 큐에 존재하지 않는다.
    }

    // 큐의 모든 데이터를 제거한다.
    // 가비지 콜렉터(GC)의 효율을 위하여 모든 데이터를 명시적으로 null 처리한다.
    public void clear(){
        for(Node<E> x = head; x != null;){
            Node<E> next = x.next; // x가 가리키는 레퍼런스를 next 노드에 대입한다.
            x.data = null; // x의 데이터 삭제
            x.next = null; // x의 레퍼런스 삭제
            x = next; // 다음 노드로 변경
        }
        size = 0; // 큐의 모든 요소가 삭제되었으니 큐의 크기는 0
        // 큐의 모든 요소가 삭제되었으니 head(front)와 tail(rear)또한 존재하지 않기에 모두 null 처리
        head = null;
        tail = null;
    }
}
