package review.stream.reduce;

import java.util.Arrays;
import java.util.List;

public class ReductionExample {

    public static void main(String[] args) {
        List<Student> studentList = Arrays.asList(
                new Student("홍길동", 92),
                new Student("신용권", 95),
                new Student("감자바", 88)
        );

        int sum = studentList.stream()
                .mapToInt(Student::getScore)
                .sum();

        int sum2 = studentList.stream()
                .map(Student :: getScore)
                .reduce((a, b) -> a+b)//sum과 같은 기능
                .get();

        int sum3 = studentList.stream()
                .map(Student::getScore)
                .reduce(0, (a, b) -> a + b);

        System.out.println(sum);
        System.out.println(sum2);
        System.out.println(sum3);
    }
}
