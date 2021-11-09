package heap;

import java.util.ArrayList;
import java.util.Collections;

public class Heap {
    public ArrayList<Integer> heapArray = null;

    public Heap(Integer data) {
        heapArray = new ArrayList<>();

        heapArray.add(null);
        heapArray.add(data);
    }

    public boolean insert(Integer data) {

        Integer insert_idx, parent_idx;

        if (heapArray == null) {
            heapArray = new ArrayList<>();

            heapArray.add(null);
            heapArray.add(data);
        } else {
            heapArray.add(data);

            insert_idx = this.heapArray.size()-1;
            while (this.move_up(insert_idx)) {

                parent_idx = insert_idx / 2;
                Collections.swap(this.heapArray, insert_idx, parent_idx);
                insert_idx = parent_idx;
            }

        }


        return true;


    }

    public Integer pop() {
        if (this.heapArray == null) {
            return null;
        } else {
            return this.heapArray.get(1);
        }
    }

    private boolean move_up(Integer insert_idx) {

        if (insert_idx <= 1) {
            return false;
        }

        Integer parent_idx = insert_idx / 2;
        if (this.heapArray.get(insert_idx) > this.heapArray.get(parent_idx)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean move_down(Integer popped_idx) {
        Integer left_child_popped_idx, right_child_popped_idx;

        left_child_popped_idx = popped_idx *2;
        right_child_popped_idx = popped_idx * 2 + 1;

        //Case1: 왼쪽자식노드가 없을떄(자식노드가 하나도 없을떄)
        if (left_child_popped_idx >= heapArray.size()) {
            return false;
        } else if (right_child_popped_idx >= this.heapArray.size()) {
            if (this.heapArray.get(popped_idx) < this.heapArray.get(left_child_popped_idx)) {
                return true;
            } else {
                return false;
            }
        } else {
            //왼쪽 오른쪽 모두 다있는 경우
            if (this.heapArray.get(left_child_popped_idx) > this.heapArray.get(right_child_popped_idx)) {
                if (this.heapArray.get(popped_idx) < this.heapArray.get(left_child_popped_idx)) {
                    return true;
                } else {
                    return false;
                }
                if (this.heapArray.get(popped_idx) < this.heapArray.get(right_child_popped_idx)) {
                    return true;
                } else {
                    return false;
                }
            }
        }
    }

    public static void main(String[] args) {

        Heap heap = new Heap(15);

        heap.insert(10);
        heap.insert(8);
        heap.insert(5);
        heap.insert(4);
        heap.insert(20) ;

        System.out.println(heap.heapArray);
    }
}
