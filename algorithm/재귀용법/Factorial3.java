package 재귀용법;

import java.util.ArrayList;

public class Factorial3 {

    public int factorial(ArrayList<Integer> dataList) {
        if (dataList.size() <= 0) {
            return 0;
        } else {
            return dataList.get(0) + factorial(new ArrayList<Integer>(dataList.subList(1, dataList.size())));
        }

    }

    public static void main(String[] args) {

        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 10; i++) {
            arrayList.add(i);
        }

        Factorial3 factorial3 = new Factorial3();

        System.out.println(        factorial3.factorial(arrayList));
    }
}
