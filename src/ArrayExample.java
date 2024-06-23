public class ArrayExample {
    public static void main(String[] args) {
        // Defining the array - what it will look like
        // NOTE: This is a fixed size array, meaning the 5 is a predetermined length
        int[] array = new int[5];

        // Value assignment
        // NOTE: The index does not begin at 1, and end at 5...
        // Instead, the index begins at 0, and ends at 4.
        array[0] = 10;
        array[1] = 20;
        array[2] = 30;
        array[3] = 40;
        array[4] = 40;

        // Printing the array values
        // array.length = 5
        for(int i = 0; i < array.length; i++) {
            System.out.println("Element " + i + ": " + array[i]);
        }
    }
}
