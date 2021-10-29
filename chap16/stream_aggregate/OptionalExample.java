package chap16.stream_aggregate;

import org.w3c.dom.stylesheets.LinkStyle;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

public class OptionalExample {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();

        /*double avg = list.stream()
                .mapToInt(Integer::intValue)
                .average()
                .getAsDouble();
*/
        //요소의 값이 없는 상태에서 getAsDouble을 실행하면 NoSuchElementException 발생
//        System.out.println("방법1_평균: " + avg);

        OptionalDouble optional = list.stream()
                .mapToInt(Integer::intValue)
                .average();

        //방법1
        if (optional.isPresent()) {
            System.out.println("평균: " + optional.getAsDouble());
        } else {
            System.out.println("평균은 0.0이다");
        }

        //방법2
        double avg = list.stream()
                .mapToInt(Integer::intValue)
                .average()
                //average의 값이 있으면 더블값이 리턴되지만 없으면 orElse에서 내가 지정한 값이 리턴됨으로서 오류가 나지않는다.
                .orElse(0.0);
        System.out.println("평균은: " + avg);

        list.add(2);
        list.add(3);

        list.stream()
                .mapToInt(Integer::intValue)
                .average()
                .ifPresent(a -> System.out.println("방법3_평균: " + a));
    }
}
