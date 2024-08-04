import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class CustomLinkedList {
    private Node head;

    // Inserting a new node with the provided data / info
    public void insert(int data) {
        Node newNode = new Node(data);
        if(head == null) {
            head = newNode;
        } else {
            Node current = head;
            while(current.next != null) {
                current = current.next;
            } current.next = newNode;
        }
    }

    // Deletion of the FIRST occurrence of a node within the list
    public void delete(int data) {
        if(head == null) {
            return;
        }
        if(head.data == data) {
            head = head.next;
            return;
        }
        Node current = head;
        while(current. next != null && current.next.data != data) {
            current = current.next;
        }
        if(current.next != null) {
            current.next = current.next.next;
        }
    }

    // Returning the iterator which is used to traverse the linked list
    public Iterator<Integer> iterator() {
        return new LinkedListIterator();
    }

    // Implemented for node filling - data inclusion within the node
    private class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private class LinkedListIterator implements Iterator<Integer> {
        private Node current = head;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Integer next() {
            if(!hasNext()) {
                throw new NoSuchElementException();
            }
            int data = current.data;
            current = current.next;
            return data;
        }
    }

    public static void main(String[] args) {
        CustomLinkedList linkedList = new CustomLinkedList();

        // Reading integers from the text file, and inserting them into the linked list
        try(BufferedReader br = new BufferedReader(new FileReader("input.txt"))) {
            String line;
            while((line = br.readLine()) != null) {
                int data = Integer.parseInt(line.trim());
                linkedList.insert(data);
            }
        } catch(IOException e) {
            System.err.println("Error reading from file: " + e.getMessage());
        }

        // Iterator over the list and display the elements
        System.out.println("\nLinked list before deleting element(s): ");
        Iterator<Integer> iterator = linkedList.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next() + " ");
        }
        System.out.println();

        // Deletion of element
        linkedList.delete(9);
        System.out.println("The number 9 has been deleted from the list!");

        // Redisplay the list post deletion
        System.out.println("\nLinked list after deleting element(s): ");
        iterator = linkedList.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next() + " ");
        }
    }
}