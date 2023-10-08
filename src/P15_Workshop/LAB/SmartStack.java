package P15_Workshop.LAB;

import java.util.function.Consumer;

public class SmartStack {

    private Node top;
    private int size;

    private static class Node {
        private int val;
        private Node prev;

        public Node(int val, Node prev) {
            this.val = val;
            this.prev = prev;
        }
    }

    public void push (int element) {
        top = new Node(element, top);
        size++;
    }

    public int pop () {
        int val = top.val;
        top = top.prev;
        size --;
        return val;
    }

    public int peek () {
        return top.val;
    }

    public int size (){
        return size;
    }

    public void forEach (Consumer<Integer> consumer) {
        Node last = top;

        while (last != null) {
            int val = last.val;
            last = last.prev;
            consumer.accept(val);
        }
    }

    public boolean isEmpty () {
        return size == 0;
    }
}
