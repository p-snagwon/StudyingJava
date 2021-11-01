package algorithm.stack;

import java.util.ArrayList;

public class MyStack<T> {

    private ArrayList<T> arrayList = new ArrayList<>();

    public void push(T item) {
        arrayList.add(item);
    }

    public T pop() {
        if (arrayList.isEmpty()) {
            return null;
        }
        return arrayList.remove(arrayList.size() - 1);
    }

    public boolean isEmpty() {
        return arrayList.isEmpty();
    }


    public static void main(String[] args) {
        MyStack<Integer> myStack = new MyStack<>();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);
        myStack.push(5);

        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
    }
}
