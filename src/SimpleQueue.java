import java.util.LinkedList;
import java.util.Queue;

public class SimpleQueue {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();

        // Enqueue elements
        queue.add(10);
        queue.add(20);
        queue.add(30);
        queue.add(40);

        // Display the queue
        System.out.println("Queue: " + queue);

        // Dequeue elements
        int removedElement = queue.remove();
        System.out.println("Removed Element: " + removedElement);

        // Display the queue after removal
        System.out.println("Queue after removal: " + queue);

        // Peek at the front element
        int frontElement = queue.peek();
        System.out.println("Front Element: " + frontElement);
    }
}