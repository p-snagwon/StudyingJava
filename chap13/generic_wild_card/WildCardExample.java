package chap13.generic_wild_card;

public class WildCardExample {

    public static void registerCourse(Course<?> course) {

    }

    public static void registerCourseStudent(Course<? extends Student> course ) {

    }
    public static void registerCourseWorker(Course<? super Student> course ) {

    }

    public static void main(String[] args) {

        registerCourse(new Course<Person>("일반인 과정", 5));
        registerCourse(new Course<Worker>("근로자 과정", 5));
        registerCourse(new Course<Student>("학생 과정", 5));
        registerCourse(new Course<HighStudent>("고등학생 과정", 5));



//        registerCourseStudent(new Course<Person>("일반인 과정", 5));
//        registerCourseStudent(new Course<Worker>("근로자 과정", 5));
        registerCourseStudent(new Course<Student>("학생 과정", 5));
        registerCourseStudent(new Course<HighStudent>("고등학생 과정", 5));



        registerCourseWorker(new Course<Person>("일반인 과정", 5));
//        registerCourseWorker(new Course<Worker>("근로자 과정", 5));
        registerCourseWorker(new Course<Student>("학생 과정", 5));
//        registerCourseWorker(new Course<HighStudent>("고등학생 과정", 5));

    }
}
