package chap15.comparator;

import java.util.Comparator;

public class DescendingComparator implements Comparator<Fruit> {

    // o1의 가격이 o2의 가격보다 컷을때 리턴값이 -1이라고 설정하면 내림차순 정렬
    @Override
    public int compare(Fruit o1, Fruit o2) {

        if(o1.price < o2.price) return 1;
        else if(o1.price == o2.price) return 0;
        else return -1;
        //지금 이건 내림차순 정렬이고 오름차순정렬로 만들고 싶으면 1 과 -1을 바꿔 주면 된다.
    }
}
