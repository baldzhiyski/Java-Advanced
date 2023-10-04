import java.util.function.Consumer;

public class CustomStack {
    private Node top;
    private int size;

    private static class Node{
        private int val;
        private Node previous;

        public Node(int val, Node previous) {
            this.val = val;
            this.previous = previous;
        }
    }
    public void push(int element){
        Node newNode = new Node(element,top);
        top = newNode;
        size++;
    }
    public int size(){
        return size;
    }
    public int peek(){
        return top.val;
    }
    public  int pop(){
        int lastItem = top.val;
        top=top.previous;
        size--;
        return lastItem;
    }
    public void forEach(Consumer<Integer> consumer){
        Node lastNode = top;
        while (lastNode!=null){
            consumer.accept(lastNode.val);
            lastNode=lastNode.previous;
        }
    }
    public boolean isEmpty(){
        return size==0;
    }
}
