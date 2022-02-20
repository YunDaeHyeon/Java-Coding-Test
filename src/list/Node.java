package list;

public class Node<E> {
    E data;

    // Node<E>의 경우 '노드 자체'를 가리키기에 타입을 Node<E>로 지정한다.
    Node<E> next; // 다음 노드 객체를 가리키는 주소(래퍼런스, Reference) 변수
    Node(E data){
        this.data = data;
        this.next = null;
    }
}
