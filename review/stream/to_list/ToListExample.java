package review.stream.to_list;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class ToListExample {
    public static void main(String[] args) {
        List<Student> totalList = Arrays.asList(
                new Student("홍길동", 10, Student.Sex.FEMALE),
                new Student("김수애", 6, Student.Sex.MALE),
                new Student("신용권", 10, Student.Sex.FEMALE),
                new Student("박수미", 6, Student.Sex.MALE)
        );

        //남학생들만 List 생성
        List<Student> maleList = totalList.stream()
                .filter(s -> s.getSex() == Student.Sex.MALE)
                .collect(Collectors.toList());

        maleList.stream()
                .forEach(s -> System.out.println(s.getName()));


        //여학생들만 묶어서 HashSet생성

        HashSet<Student> femaleSet = totalList.stream()
                .filter(s -> s.getSex() == Student.Sex.FEMALE)
                .collect(Collectors.toCollection(HashSet::new));

        femaleSet.stream()
                .forEach(s -> System.out.println(s.getName()));


    }
}
