package chap15.arraylist;

import javax.xml.namespace.QName;
import java.util.Arrays;
import java.util.List;

public class ArrayAsListExample {
    public static void main(String[] args) {

        //내부적으로 ArrayList가 동작
        List<String> list1 = Arrays.asList("홍길동", "신용권", "감자바");

        for (String name : list1) {
            System.out.println("Name = " + name);
        }


        List<Integer> list2 = Arrays.asList(1, 2, 3);
        for (Integer integer : list2) {
                System.out.println(integer);
        }
    }
}
