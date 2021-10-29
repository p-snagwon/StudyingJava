package chap16.stream_reduce;

import java.util.Arrays;
import java.util.List;

public class ReductionExample {
    public static void main(String[] args) {

        List<Student> studentList = Arrays.asList(
                new Student("홍길동", 92),
                new Student("신용권", 92),
                new Student("감자바", 88)
        );

        int sum1 = studentList.stream()
                .mapToInt(Student::getScore)
                .sum();

        int sum2 = studentList.stream()
                .mapToInt(Student::getScore)
                .reduce((a, b) -> a + b)
                .getAsInt();

        //값이 없을 경우를 대비할 경우 디폴트값 지정
        int sum3 = studentList.stream()
                .mapToInt(Student::getScore)
                .reduce(0, (a,b) -> a+b);


        System.out.println(sum1);
        System.out.println(sum2);
        System.out.println(sum3);

    }
}
