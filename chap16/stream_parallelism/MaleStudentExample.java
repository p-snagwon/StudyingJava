package chap16.stream_parallelism;

import chap16.stream_collect.Student;

import java.util.Arrays;
import java.util.List;

public class MaleStudentExample {

    public static void main(String[] args) {

        List<Student> totalList = Arrays.asList(
                new Student("홍길동", 10, Student.Sex.MALE),
                new Student("김수애", 6, Student.Sex.FEMALE),
                new Student("신용권", 10, Student.Sex.MALE),
                new Student("박수미", 6, Student.Sex.FEMALE)
        );


        //r 은 사용자 지정 클래스(여기서는 MaleStudent)이고 t는 필터링 된 요소들
        MaleStudent maleStudent = totalList.parallelStream()
                .filter(s -> s.getSex() == Student.Sex.MALE)
                .collect(
                        () -> new MaleStudent(),
                        (r, t) -> r.accumulate(t),
                        (r1, r2) -> r1.combine(r2)
                );

        maleStudent.getList().stream()
                .forEach(s -> System.out.println(s.getName()));
    }
}
