package list;

public interface List<E> {

    // 리스트에 요소를 추가한다.
    // 만약, 리스트가 중복을 허용하지 않을 경우. 리스트에 이미 중복되는 요소가 있다면 true를,
    // 중복되는 요소가 없으면 false를 반환.
    boolean add(E value);

    // 리스트 특정 위치에 요소를 추가. (특정 위치 및 이후의 요소들은 한 칸씩 뒤로 밀린다.)
    void add(int index, E value);

    // 리스트 index 위치에 있는 요소 삭제
    E remove(int index);

    // 리스트에서 특정 요소를 삭제한다. 동일한 요소가 여러 개일 경우 가장 처음 발견한 요소만 삭제한다.
    // 리스트에 삭제할 요소가 없거나 실패하면 false를, 삭제에 성공하면 true를 반환한다.
    boolean remove(Object value);

    // 리스트에 있는 특정 위치의 요소를 가져온다.
    E get(int index);

    // 리스트에서 특정 위치에 있는 요소를 새 요소로 대체한다.
    void set(int index, E value);

    // 리스트에서 특정 요소가 리스트에 있는지 여부를 확인한다.
    // 리스트에 특정 요소가 존재한다면 true를, 존재하지 않을 경우 false를 반환.
    boolean contains(Object value);

    // 리스트에 특정 요소가 몇 번째 위치에 있는지 반환한다.
    // 리스트에서 처음으로 일치하는 위치를 반환한다. 일치하는 요소가 없다면 -1을 반환한다.
    int indexOf(Object value);

    // 리스트에 있는 요소의 개수를 반환한다. (리스트의 크기가 아니다.)
    int size();

    // 리스트에 요소가 비어있는 지 판별한다.
    // 리스트에 요소가 없다면 true를, 요소가 있으면 false를 반환한다.
    boolean isEmpty();

    // 리스트에 있는 요소를 모두 삭제한다.
    public void clear();
}
