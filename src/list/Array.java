package list;

class ElementClass<E>{
    private E element; // ElementClass의 타입 변수 선언

    void setElement(E element){
        this.element = element;
    }
    // 매개변수 타입에 <E>를 지정하여 제네릭 사용

    E getElement(){
        return element;
    }
    // 메소드 선언부에 <E>를 지정하여 제네릭 사용
}

public class Array {
    public static void main(String[] args) {
        ElementClass elementClassA = new ElementClass<String>(); // ElementClass의 element타입<E>에 String 지정
        ElementClass elementClassB = new ElementClass<Integer>(); // ElementClass의 element타입<E>에 Integer 지정

        elementClassA.setElement(123);
        elementClassB.setElement(12345);

        System.out.println("결과 -------------------------");
        System.out.println("제네릭 <E>에 String을 지정한 결과 : "+elementClassA.getElement());
        System.out.println("제네릭 <E>에 Integer를 지정한 결과 : "+elementClassB.getElement());

        System.out.println("출력된 타입 -------------------------");
        System.out.println("제네릭 <E>에 String을 지정한 참조 변수의 타입 : "+elementClassA.getElement().getClass().getName());
        System.out.println("제네릭 <E>에 Integer를 지정한 참조 변수의 타입 : "+elementClassB.getElement().getClass().getName());
    }
}