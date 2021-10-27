package chap16.stream_introduction;

import java.util.Arrays;
import java.util.List;

public class MapAndReduceExample {

    public static void main(String[] args) {

        List<Student> studentList = Arrays.asList(
                new Student("홍길동", 30),
                new Student("신용권", 50),
                new Student("박상원", 70)
        );

        double avg =
                studentList.stream()
                        .mapToInt(Student::getScore)
                        .average()
                        .getAsDouble();

        System.out.println("평균 점수: "+ avg);



    }
}
