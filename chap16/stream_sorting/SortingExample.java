package chap16.stream_sorting;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

public class SortingExample {
    public static void main(String[] args) {

        IntStream intStream = Arrays.stream(new int[]{5, 3, 2, 4, 1});
        intStream
                .sorted()
                .forEach(n -> System.out.println(n + ","));
        System.out.println();


        List<Student> studentList = Arrays.asList(
                new Student("홍길동", 30),
                new Student("김민수", 40),
                new Student("박상원", 20)
        );

        studentList.stream()
                .sorted()
                .forEach(s -> {
                    System.out.println(s.getScore());
                });
        System.out.println();

        //내림차순
        studentList.stream()
                .sorted(Comparator.reverseOrder())
                .forEach(s -> {
                    System.out.println(s.getScore());
                });
    }
}
