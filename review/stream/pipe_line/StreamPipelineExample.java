package review.stream.pipe_line;

import java.util.Arrays;
import java.util.List;

public class StreamPipelineExample {

    public static void main(String[] args) {

        List<Member> list = Arrays.asList(
                new Member("홍길동", Member.MALE, 30),
                new Member("홍길동", Member.FEMALE, 20),
                new Member("홍길동", Member.MALE, 33),
                new Member("홍길동", Member.FEMALE, 24)
        );

        double ageAvg = list.stream()
                .filter(m ->
                    m.getSex() == Member.MALE)
                .mapToInt(Member::getAge)
                .average()
                .getAsDouble();

        System.out.println("남자 평균 나이: "+ ageAvg);
    }
}
