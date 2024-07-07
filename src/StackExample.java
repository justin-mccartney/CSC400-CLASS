import java.util.EmptyStackException;

public class StackExample {
    private int maxSize;
    private int[] stackArray;
    private int top;

    public StackExample(int size) {
        maxSize = size;
        stackArray = new int[maxSize];
        top = -1;
    }

    public void push(int value) {
        if(isFull()) {
            System.out.println("Stack is full, cannot push " + value);
        } else {
            stackArray[++top] = value;
        }
    }

    public int pop() {
        if(isEmpty()) {
            throw new EmptyStackException();
        } else {
            return stackArray[top--];
        }
    }

    public int peek() {
        if(isEmpty()) {
            throw new EmptyStackException();
        } else {
            return stackArray[top];
        }
    }

    public boolean isEmpty() {
        return(top == -1);
    }

    public boolean isFull() {
        return(top == maxSize - 1);
    }

    public static void main(String[] args) {
        StackExample stack = new StackExample(5);

        stack.push(5);
        stack.push(10);
        stack.push(15);
        stack.push(20);
        stack.push(25);

        System.out.println("The top element of the stack is " + stack.peek());

        System.out.println("Elements popped from stack.");
        while(!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
