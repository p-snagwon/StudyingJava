package bubble;


import java.util.ArrayList;
import java.util.Collections;

public class Bubble {

    public static void main(String[] args) {

        ArrayList<Integer> dataList = new ArrayList<>();

        dataList.add(9);
        dataList.add(2);
        dataList.add(3);
        dataList.add(8);

        for (int index = 0; index < dataList.size() - 1; index++) {
            if (dataList.get(index) > dataList.get(index + 1)) {
                Collections.swap(dataList, index, index+1);
            }
        }

        System.out.println(dataList);
    }


}
