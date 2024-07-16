package org.example.linkedlist;

public class LinkedList {
    private Node head;
    private Node tail;
    private Integer length = 0;

    class Node {
        Integer value;
        Node next;

        public Node(Integer value) {
            this.value = value;
        }
    }

    public LinkedList(Integer value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    //    public void printHead(){
//        System.out.println("Head --> "+ head.value);
//    }
//    public void printTail(){
//        System.out.println("Tail --> "+ tail.value);
//    }
    public void printLength() {
        System.out.println("Length --> " + length);
    }

    public void printLinkedList() {
        Node temp = head;
        while (temp != null) {
            System.out.println("In printLinkedList method --> " + temp.value);
            temp = temp.next;
        }
    }

    public void append(Integer value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }
}
