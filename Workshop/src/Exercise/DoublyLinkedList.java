package Exercise;

import org.w3c.dom.Node;

import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;

public class DoublyLinkedList {
    private int size;
    private Node head;
    private Node tail;

    private class Node{
        private Node prev;
        private Node next;
        private int item;

        public Node(int item) {
            this.item = item;
        }
    }

    public void addFirst(int element){
        Node newNode = new Node(element);
        if(this.size==0){
            this.head=this.tail=newNode;
        }else{
            newNode.next=this.head;
            this.head.prev=newNode;
            this.head=newNode;
        }
        size++;
    }
    public void addLast(int element){
        Node newNode = new Node(element);
        if(this.size==0){
            this.head=this.tail=newNode;
        }else{
            newNode.prev=this.tail;
            this.tail.next=newNode;
            this.tail=newNode;
        }
        size++;
    }
    public int get(int index){
        checkIndex(index);
        Node current;
        if(index<=this.size/2){
            current=this.head;
            for (int i = 0; i <index ; i++) {
                current=current.next;
            }
        }else{
            current=this.tail;
            for (int i = this.size-1; i>index; i--) {
                current=current.prev;
            }
        }
        return current.item;
    }

    private void checkIndex(int index) {
        if(index<0 || index>=this.size){
            String message = String.format("Index: %d, Size: %d",index,this.size);
            throw new IndexOutOfBoundsException(message);
        }

    }
    public int removeFirst(){
        checkEmpty();
        int firstItem = this.head.item;
        this.head=this.head.next;

        if(this.head==null){
            this.tail=null;
        }else{
            this.head.prev=null;
        }
        size--;
        return firstItem;
    }
    public int removeLast(){
        checkEmpty();
        int lastItem = this.tail.item;
        this.tail=this.tail.prev;
        if(this.tail==null){
            this.head=null;
        }else{
            this.tail.next=null;
        }
        size--;
        return lastItem;
    }

    private void checkEmpty() {
        if(isEmpty()){
            throw new NoSuchElementException("The list is empty!");
        }
    }
    public void forEach(Consumer<Integer> consumer){
        Node current = this.head;
        while (current!=null){
            consumer.accept(current.item);
            current=current.next;
        }
    }
    public int[] toArray(){
        int[] result = new int[this.size];
        Node current = this.head;
        AtomicInteger num = new AtomicInteger();
        while (current!=null){
            result[num.getAndIncrement()]=current.item;
            current=current.next;
        }
        return result;
    }

    private boolean isEmpty() {
        return this.size==0;
    }
}
