package heap;

import jdk.dynalink.linker.LinkerServices;

import java.util.ArrayList;
import java.util.Collections;

public class PracticeHeap2 {

    public ArrayList<Integer> heap = null;

    public PracticeHeap2(Integer data) {
        heap = new ArrayList<>();

        heap.add(null);
        heap.add(data);
    }

    public boolean insert(Integer data) {

        Integer inserted_idx, parent_idx;

        //1.heap에 데이터가 없는 경우
        if (this.heap == null) {
            heap = new ArrayList<>();

            heap.add(null);
            heap.add(data);
        } else {
            //2.heap에 데이터가 있는 경우
            heap.add(data);

            inserted_idx = heap.size() -1;

            while (move_up(inserted_idx)) {

                parent_idx = inserted_idx / 2;
                Collections.swap(heap, inserted_idx, parent_idx);
                inserted_idx = parent_idx;
            }
        }
        return true;
    }

    public boolean move_up(Integer inserted_idx) {
//        inserted_idx = heap.size() -1;

        if (inserted_idx <= 1) {
            return false;
        }

        Integer parent_idx = inserted_idx / 2;

        //inserted_idx 의 값과 parent_idx의 값을 비교
        if (this.heap.get(inserted_idx) > this.heap.get(parent_idx)) {
            return true;
        } else {
            return false;
        }
    }

    public Integer pop() {
        Integer returned_data, popped_idx, left_child_popped_idx, right_child_popped_idx;
        if (this.heap == null) {
            return null;
        } else {
         //데이터가 있으면
            returned_data = this.heap.get(1);
            this.heap.set(1, this.heap.size() - 1);
            this.heap.remove(this.heap.size() - 1);
            popped_idx = 1;

            while (move_down(popped_idx)) {

                left_child_popped_idx = popped_idx * 2;
                right_child_popped_idx = popped_idx * 2 + 1;

                if (right_child_popped_idx >= this.heap.size()) {
                    if (this.heap.get(left_child_popped_idx) > this.heap.get(popped_idx)) {
                        Collections.swap(this.heap, popped_idx, left_child_popped_idx);
                        popped_idx = left_child_popped_idx;
                    }
                } else {
                    if (this.heap.get(right_child_popped_idx) < this.heap.get(left_child_popped_idx)) {
                        if (this.heap.get(popped_idx) < this.heap.get(left_child_popped_idx)) {
                            Collections.swap(heap, popped_idx, left_child_popped_idx);
                            popped_idx = left_child_popped_idx;
                        }
                    } else {
                        if (this.heap.get(popped_idx) < this.heap.get(right_child_popped_idx)) {
                            Collections.swap(heap, popped_idx, right_child_popped_idx);
                            popped_idx = right_child_popped_idx;

                        }
                    }
                }
            }

            //1. 자식노드가 없는경우
            //2. 왼쪽노드만 있는 경우
            //3. 왼쪽 오른쪽 둘다 있는 경우
        }
        return returned_data;
    }

    private boolean move_down(Integer popped_idx) {
        Integer left_child_popped_idx, right_child_popped_idx;

        left_child_popped_idx = popped_idx * 2;
        right_child_popped_idx = popped_idx * 2 + 1;

        //1. 자식노드가 없는경우
        // size가 2라고 치면은 자식노드가 없어야하므로 size가 2보다 크거나 같아야해 근데 2 >= 2 쓰면은 size에 따라서 플렉서블하게 적용되는걱이 아니라
        // 2라도 딱 고정되기때문에 문제가 발생한다. 그래서 2를 의미하는 left_child_popped_idx 를 쓴거다 그니까 size에따라서 유동적으로 대응하기위해서라고 이해하면 될것 같은데... ㅋ
        if (left_child_popped_idx >= this.heap.size()) {
            return false;
        } else if (right_child_popped_idx >= this.heap.size()) {
            //2. 왼쪽노드만 있는 경우
            if (this.heap.get(popped_idx) < this.heap.get(right_child_popped_idx)) {
                return true;
            } else {
                return false;
            }
        } else {
            //3. 왼쪽 오른쪽 둘다 있는 경우

            if (this.heap.get(right_child_popped_idx) < this.heap.get(left_child_popped_idx)) {
                if (this.heap.get(popped_idx) < this.heap.get(left_child_popped_idx)) {
                    return true;
                } else {
                    return false;
                }
            } else {
                if (this.heap.get(popped_idx) < this.heap.get(right_child_popped_idx)) {
                    return true;
                } else {
                    return false;
                }
            }
        }


    }

    public static void main(String[] args) {
        PracticeHeap2 heapTest = new PracticeHeap2(15);
        heapTest.insert(10);
        heapTest.insert(8);
        heapTest.insert(5);
        heapTest.insert(4);
        heapTest.insert(20);
        System.out.println(heapTest.heap);

        heapTest.pop();
        System.out.println(heapTest.heap);
    }
}
