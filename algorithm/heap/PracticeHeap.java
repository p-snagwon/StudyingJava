package heap;

import java.util.ArrayList;
import java.util.Collections;

public class PracticeHeap {
    public ArrayList<Integer> heapArray = null;

    public PracticeHeap(Integer data) {
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

            insert_idx = heapArray.size() -1;

            while (move_up(insert_idx)) {
                parent_idx = insert_idx/ 2;
                Collections.swap(heapArray, insert_idx, parent_idx);

                insert_idx = parent_idx;
            }
        }

        return true;
    }

    private boolean move_up(Integer insert_idx) {
        if ( insert_idx <= 1) {
            return false;
        } else {
            Integer parent_idx = insert_idx / 2;
            if (this.heapArray.get(insert_idx) > this.heapArray.get(parent_idx)) {
                return true;
            } else {
                return false;
            }
        }
    }

    public Integer pop() {
        Integer returned_data, popped_idx, left_child_popped_idx, right_child_popped_idx;

        if (this.heapArray == null) {
            return null;
        } else {

            returned_data = this.heapArray.get(1);

            this.heapArray.set(1, this.heapArray.get(this.heapArray.size() - 1));
            this.heapArray.remove(this.heapArray.get(this.heapArray.size() - 1));
            popped_idx = 1;

            while (this.move_down(popped_idx)) {

                left_child_popped_idx = popped_idx * 2;
                right_child_popped_idx = popped_idx * 2 + 1;

                //1. 오른쪽만 없을때
                if (right_child_popped_idx >= heapArray.size()) {
                    if (this.heapArray.get(left_child_popped_idx) > this.heapArray.get(popped_idx)) {
                        Collections.swap(heapArray, popped_idx, left_child_popped_idx);
                        popped_idx = left_child_popped_idx;
                    }
                }
                //2.왼쪽오른쪽 모두 있을떄
                else {
                    if (this.heapArray.get(left_child_popped_idx) < this.heapArray.get(right_child_popped_idx)) {
                        Collections.swap(heapArray, popped_idx, right_child_popped_idx);
                    } else {
                        Collections.swap(heapArray, popped_idx, left_child_popped_idx);
                    }
                }
            }
            return returned_data;
        }
    }

    public boolean move_down(Integer popped_idx) {
        Integer left_child_popped_idx, right_child_popped_idx;

        left_child_popped_idx = popped_idx * 2;
        right_child_popped_idx = popped_idx * 2 + 1;

        // CASE1: 왼쪽 자식 노드도 없을 때 (자식 노드가 하나도 없을 때)
        if (left_child_popped_idx >= this.heapArray.size()) {
            return false;
            // CASE2: 오른쪽 자식 노드만 없을 때
        } else if (right_child_popped_idx >= this.heapArray.size()) {
            if (this.heapArray.get(popped_idx) < this.heapArray.get(left_child_popped_idx)) {
                return true;
            } else {
                return false;
            }
            // CASE3: 왼쪽/오른쪽 자식 노드가 모두 있을 때
        } else {
            if (this.heapArray.get(left_child_popped_idx) > this.heapArray.get(right_child_popped_idx)) {
                if (this.heapArray.get(popped_idx) < this.heapArray.get(left_child_popped_idx)) {
                    return true;
                } else {
                    return false;
                }
            } else {
                if (this.heapArray.get(popped_idx) < this.heapArray.get(right_child_popped_idx)) {
                    return true;
                } else {
                    return false;
                }
            }
        }
    }

    public static void main(String[] args) {
        PracticeHeap heapTest = new PracticeHeap(15);

        heapTest.insert(10);
        heapTest.insert(8);
        heapTest.insert(5);
        heapTest.insert(4);
        heapTest.insert(20);
        System.out.println(heapTest.heapArray);

        heapTest.pop();
        System.out.println(heapTest.heapArray);
    }
}
