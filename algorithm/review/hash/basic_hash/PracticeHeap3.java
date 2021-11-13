package heap;

import java.util.ArrayList;
import java.util.Collections;

public class PracticeHeap3 {

    public ArrayList<Integer> heapArray = null;

    public PracticeHeap3(Integer data) {
        heapArray = new ArrayList<>();

        heapArray.add(null);
        heapArray.add(data);
    }

    public boolean insert(Integer data) {
        if (heapArray == null) {
            heapArray = new ArrayList<>();

            heapArray.add(null);
            heapArray.add(data);
            return true;
        } else {

            heapArray.add(data);

            Integer inserted_idx = heapArray.size() -1;
            Integer parent_idx = inserted_idx / 2;
            while (move_up(inserted_idx)) {

                Collections.swap(heapArray, inserted_idx, parent_idx);
                inserted_idx = parent_idx;
            }
            return true;
        }
    }

    private boolean move_up(Integer inserted_idx) {

        if (inserted_idx <= 1) {
            return false;
        } else {
            Integer parent_idx = inserted_idx / 2;
            if (heapArray.get(inserted_idx) > heapArray.get(parent_idx)) {
                return true;
            } else {
                return false;
            }
        }
    }

    public Integer pop() {
        Integer returned_data, popped_idx, left_child_idx, right_child_idx;

        if (heapArray == null) {
            return null;
        } else {

            returned_data = heapArray.get(1);

            heapArray.set(1, heapArray.get(heapArray.size()-1));
            heapArray.remove(heapArray.get(heapArray.size() - 1));
            popped_idx = 1;

            while (this.move_down(popped_idx)) {

                left_child_idx = popped_idx * 2;
                right_child_idx = popped_idx * 2 + 1;

                if (heapArray.size() <= right_child_idx) {
                    // 왼쪽노드만 있는 경우

                    Collections.swap(heapArray, left_child_idx, popped_idx);
                    popped_idx = left_child_idx;
                }
                // 왼쪽 오른쪽 둘다 있는 경우
                else {
                    if (heapArray.get(right_child_idx) > heapArray.get(left_child_idx)) {
                        if (heapArray.get(right_child_idx) > heapArray.get(popped_idx)) {
                            Collections.swap(heapArray, popped_idx, right_child_idx);
                            popped_idx = right_child_idx;
                        }
                    } else {
                        if (heapArray.get(left_child_idx) > heapArray.get(popped_idx)) {
                            Collections.swap(heapArray, popped_idx, left_child_idx);
                            popped_idx = left_child_idx;
                        }
                    }
                }
            }

            return returned_data;
        }
    }

    private boolean move_down(Integer popped_idx) {
        Integer left_child_popped_idx, right_child_popped_idx;

        left_child_popped_idx = popped_idx * 2;
        right_child_popped_idx = popped_idx * 2 + 1;

        //노드가 전혀 없을떄
        if (heapArray.size() <= left_child_popped_idx) {
            return false;
        } else if (heapArray.size() <= right_child_popped_idx) {
            //노드가 왼쪽에만 있을떄
            if (heapArray.get(popped_idx) < heapArray.get(left_child_popped_idx)) {
                return true;
            } else {
                return false;
            }

        } else {
            //노드가 왼쪽오른쪽 모두다 있을때

            if (heapArray.get(left_child_popped_idx) > heapArray.get(right_child_popped_idx)) {
                if (heapArray.get(left_child_popped_idx) > heapArray.get(popped_idx)) {
                    return true;
                } else {
                    return false;
                }
            } else {
                if (heapArray.get(right_child_popped_idx) > heapArray.get(popped_idx)) {
                    return true;
                } else {
                    return false;
                }
            }
        }

    }

    public static void main(String[] args) {

        PracticeHeap3 heap = new PracticeHeap3(5);
        heap.insert(10);
        heap.insert(8);


        System.out.println(heap.heapArray);

        heap.pop();

        System.out.println(heap.heapArray);



    }


}