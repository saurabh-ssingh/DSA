package org.example.linkedlist;

/**
 * This class represents a simple singly linked list data structure.
 * It allows operations such as adding nodes to the end of the list and printing the list.
 */
public class LinkedList {
    private Node head;
    private Node tail;
    private Integer length = 0;

    /**
     * Inner class representing a node in the linked list.
     */
    class Node {
        Integer value;
        Node next;

        /**
         * Constructor to create a new node with a given value.
         *
         * @param value the value to be stored in the node
         */
        public Node(Integer value) {
            this.value = value;
        }
    }

    /**
     * Constructor to create a linked list with an initial node.
     *
     * @param value the value of the initial node in the linked list
     */
    public LinkedList(Integer value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    /**
     * Prints the value of the head node of the linked list.
     */
    public void printHead() {
        System.out.println("Head --> " + head.value);
    }

    /**
     * Prints the value of the tail node of the linked list.
     *
     */
    public void printTail() {
        System.out.println("Tail --> " + tail.value);
    }

    /**
     * Prints the length of the linked list.
     */
    public void printLength() {
        System.out.println("Length --> " + length);
    }

    /**
     * Prints all the values in the linked list.
     */
    public void printLinkedList() {
        Node temp = head;
        while (temp != null) {
            System.out.println("In printLinkedList method --> " + temp.value);
            temp = temp.next;
        }
    }

    /**
     * Appends a new node with a given value to the end of the linked list.
     *
     * @param value the value to be added to the end of the linked list
     */
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

    public Node removeLast(){
        if (length == 0){
            return null;
        }
        Node tempNode = head;
        Node preNode = head;
        while (tempNode.next != null){
            preNode = tempNode;
            tempNode = tempNode.next;
        }
        tail = preNode;
        tail.next = null;
        length--;
        if (length == 0){
            head = null;
            tail = null;
        }
        return tempNode;
    }

    public void prepend(Integer value){
        Node newNode = new Node(value);
        if(length == 0){
            head = newNode;
            tail = newNode;
        }else {
            newNode.next = head;
            head = newNode;
        }
        length++;
    }

    public Node removeFirst(){
        if (length == 0){
            return null;
        }
        Node tempNode = head;
        head = head.next;
        tempNode.next = null;
        length--;
        if (length == 0){
            tail = null;
        }
        return tempNode;
    }

    public Node get(int index){
        if (index < 0 || index > length){
            return null;
        }
        Node tempNode = head;
        for (int i = 0; i < index; i++){
            tempNode = tempNode.next;
        }
        return tempNode;
    }

    public boolean set(int index, int value){
        Node tempNode = get(index);
        if (tempNode != null){
            tempNode.value = value;
            return true;
        }
        return false;
    }

    public boolean insert(int index, int value){
        if (index < 0 || index > length){
            return false;
        }
        if (index == 0){
            prepend(value);
            return true;
        }
        if (index == length){
            append(value);
            return true;
        }
        Node newNode = new Node(value);
        Node tempNode = get(index - 1);
        newNode.next = tempNode.next;
        tempNode.next = newNode;
        length++;
        return true;
    }
    public Node remove(int index){
        if (index < 0 || index > length){
            return null;
        }
        if (index == 0){
            return removeFirst();
        }
        if (index == length -1){
            return removeLast();
        }
        //time complexity of get() method is O(n)
        Node previousNode = get(index -1);
        Node tempNode = previousNode.next;

        previousNode.next = tempNode.next;
        tempNode.next = null;
        length--;
        return tempNode;
    }

    public void reverse(){
        //swapping technique
        Node temp = head;
        head = tail;
        tail = temp;

        Node after = temp.next;
        Node before = null;

        for (int i = 0; i < length; i++){
            after = temp.next;
            temp.next = before;
            before = temp;
            temp = after;
        }

    }

    /**
     * Main method to demonstrate the usage of the LinkedList class.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        LinkedList myLinkedList = new LinkedList(10);

        // myLinkedList.printHead();
        // myLinkedList.printTail();
        // myLinkedList.printLength();

        myLinkedList.append(20);
        myLinkedList.printLinkedList();

        myLinkedList.prepend(5);
        myLinkedList.printLinkedList();

        System.out.println("remove last item ---> "+ myLinkedList.removeLast().value);
        System.out.println("remove last item  if list has 1 value---> "+ myLinkedList.removeLast().value);
        System.out.println("remove last item if list is empty ---> "+ myLinkedList.removeLast());
        System.out.println("remove first item ---> "+ myLinkedList.removeFirst().value);
        System.out.println("remove first item  if list has 1 value---> "+ myLinkedList.removeFirst().value);
        System.out.println("remove first item if list is empty ---> "+ myLinkedList.removeFirst());
        System.out.println("Get item at index 1 --> "+ myLinkedList.get(1).value);
        myLinkedList.printLinkedList();

        myLinkedList.set(1, 40);
        myLinkedList.printLinkedList();

        myLinkedList.insert(1, 30);
        myLinkedList.printLinkedList();

        myLinkedList.remove(1);
        myLinkedList.printLinkedList();

        myLinkedList.reverse();
        myLinkedList.printLinkedList();

    }
}
