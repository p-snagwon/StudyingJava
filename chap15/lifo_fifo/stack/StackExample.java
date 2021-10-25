package chap15.lifo_fifo.stack;

import java.util.Stack;

public class StackExample {

    public static void main(String[] args) {

        Stack<Coin> coinBox = new Stack<>();

        coinBox.push(new Coin(100));
        coinBox.push(new Coin(50));
        coinBox.push(new Coin(500));
        coinBox.push(new Coin(300));

        while (!coinBox.isEmpty()) {
            Coin coin = coinBox.pop();
            System.out.println("꺼내온 동전: "+ coin.getValue());
        }
    }
}
