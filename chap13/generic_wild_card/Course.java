package chap13.generic_wild_card;

public class Course<T> {
    private String name;
    private T[] students;

    public Course(String name, int capacity) {
        this.name = name;
        // error -> students = new T[capacity];  아직 T타입이  확정되지않은 상태에서 new연산자를 이요해서 배열을 만들 수 없다.
        students = (T[]) (new Object[capacity]);
    }

    public String getName() {
        return name;
    }

    public T[] getStudents() {
        return students;
    }

    public void add(T t) {
        for (int i = 0; i < students.length; i++) {
            if (students[i] == null) {
                students[i] = t;
                break;
            }
        }
    }
}
