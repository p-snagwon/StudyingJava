package chap15.treeset;

import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetExample {


    public static void main(String[] args) {
        TreeSet<Integer> scores = new TreeSet<>();
        scores.add(87);
        scores.add(98);
        scores.add(75);
        scores.add(90);
        scores.add(80);

        Integer score = null;

        score = scores.first();
        System.out.println("가장 낮은 점수: " + score);

        score = scores.last();
        System.out.println("가장 높은 점수: " + score + "\t");

        score = scores.lower(90);
        System.out.println("90점 바로 아래 점수: " + score);

        score = scores.higher(87);
        System.out.println("87보다 큰수: " + score);


        //98이 있으면 98을 리턴 , 없으면 98보다 바로 작은 것을 리턴
        score = scores.floor(98);
        System.out.println("98 floor: " + score);

        score = scores.ceiling(88);
        System.out.println("87 ceilling: " + score);

        //pollfirst는 가져와버리고 제거 해버림
//        while (!scores.isEmpty()) {
//            score = scores.pollFirst();
//            System.out.println(score + "(남은 객체 수: )" + scores.size());
//
//        }
//
        for (Integer integer : scores) {
            System.out.println(integer);
        }

        while (!scores.isEmpty()) {
            score = scores.pollLast();
           System.out.println(score + "(남은 객체 수: )" + scores.size());
        }
//

    }
}
