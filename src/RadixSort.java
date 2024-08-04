import java.util.Arrays;

public class RadixSort {
    // Main method for Radix Sort
    public static void radixSort(int[] array) {
        int max = findMax(array);
        for(int exp = 1; max / exp > 0; exp *= 10) {
            countingSort(array, exp);
            System.out.println("\nAfter sorting " + exp + "'s place: " + Arrays.toString(array));
        }
    }

    // The util method used to find the max value within the array
    private static int findMax(int[] array) {
        int max = array[0];
        for(int num : array) {
            if(num > max) {
                max = num;
            }
        } return max;
    }

    // Function to counting sort the array according to the number expressed by 'exp'
    private static void countingSort(int[] array, int exp) {
        int n = array.length;
        int[] output = new int[n]; // The output array
        int[] count = new int[10];
        Arrays.fill(count, 0);

        // Store the count of occurrences within 'count[]'
        for(int i = 0; i < n; i++) {
            count[(array[i] / exp) % 10]++;
        }

        // Alters count[i] so that it contains the actual position of the digit in 'output[]'
        for(int i = 1; i < 10; i ++) {
            count[i] += count[i - 1];
        }

        // Construct the output array
        for(int i = n - 1; i >= 0; i--) {
            int digit = (array[i] / exp) % 10;
            output[count[digit] - 1] = array[i];
            count[digit]--;
        }

        // Copy output[] to array[] so that array[] contains sorted numbers according to current digit
        System.arraycopy(output, 0, array, 0, n);
    }

    public static void main(String[] args) {
        // Example array
        int[] array = {783, 99, 472, 182, 264, 543, 356, 295, 692, 491, 94};

        // Print the original array
        System.out.println("Original Array: " + Arrays.toString(array));

        // Sort the array with Radix Sort
        radixSort(array);

        // Print the sorted array
        System.out.println("\nFinal Sorted Array: " + Arrays.toString(array));
    }

    // Util method for printing array
    private static void printArray(int[] array) {
        for(int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
