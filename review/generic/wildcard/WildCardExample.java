package review.generic.wildcard;

import java.lang.reflect.Array;
import java.util.Arrays;

public class WildCardExample {

    public static void registerCourse(Course<?> course) {
        System.out.println(course.getName() + "수강생" + Arrays.toString(course.getStudents()));

    }

    public static void registerStudent(Course<? extends Student> course) {
        System.out.println(course.getName() + "수강생" + Arrays.toString(course.getStudents()));

    }


    public static void main(String[] args) {


        Course<Person> personCourse = new Course<>("일반인 과정", 5);
        personCourse.add(new Person("일반인"));
        personCourse.add(new Worker("직장인"));
        personCourse.add(new Student("학생"));
        personCourse.add(new HighStudent("고등학생"));

        registerCourse(personCourse);


        Course<Student> StudentCourse = new Course<>("학생 과정", 5);
//        StudentCourse.add(new Person("일반인"));
//        StudentCourse.add(new Worker("직장인"));
       StudentCourse.add(new Student("학생"));
        StudentCourse.add(new HighStudent("고등학생"));

        registerStudent(StudentCourse);

    }
}
