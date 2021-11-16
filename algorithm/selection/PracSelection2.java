package selection;

import java.util.ArrayList;
import java.util.Collections;

public class PracSelection2 {

    public ArrayList<Integer> sort(ArrayList<Integer> dataList) {

        int lowest;

        for (int stand = 0; stand < dataList.size() - 1; stand++) {

            lowest = stand;

            for (int index = stand + 1; index < dataList.size(); index++) {

                if (dataList.get(lowest) > dataList.get(index)) {

                    lowest = index;
                }
            }

            Collections.swap(dataList, stand, lowest);

        }

        return dataList;
    }

    public static void main(String[] args) {


        PracSelection2 pracSelection2 = new PracSelection2();

        ArrayList<Integer> dataList = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            dataList.add((int) (Math.random() * 100));
        }

        System.out.println(        pracSelection2.sort(dataList));

    }
}
