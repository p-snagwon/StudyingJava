package chap15.map.hashmap;

import java.util.HashMap;
import java.util.Map;

public class HashMapExample2 {

    public static void main(String[] args) {

        Map<Student, Integer> map = new HashMap<>();

        map.put(new Student(1, "홍길동"), 95);
        map.put(new Student(1, "홍길동"), 90);

        System.out.println("총 객체 수: " + map.size());
        System.out.println(map.get( new Student(1, "홍길동")));
    }
}
