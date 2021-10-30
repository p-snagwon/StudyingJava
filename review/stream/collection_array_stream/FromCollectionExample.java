package review.stream.collection_array_stream;

import java.util.Arrays;
import java.util.List;

public class FromCollectionExample {

    public static void main(String[] args) {
        List<Student> studentList = Arrays.asList(
                new Student("홍길동", 10),
                new Student("신용권", 20),
                new Student("유미선", 30)
        );

        studentList.stream()
                .forEach(s -> System.out.println(s.getName()));

        studentList.stream()
                .forEach(Student::getName);
    }
}
