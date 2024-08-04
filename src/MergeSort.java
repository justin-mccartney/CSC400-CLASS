public class MergeSort {

    // Main method to sort an array using Merge Sort
    public static void mergeSort(int[] arr) {
        if (arr.length < 2) return; // If the array has less than 2 elements, it's already sorted

        int mid = arr.length / 2;
        int[] left = new int[mid];
        int[] right = new int[arr.length - mid];

        System.arraycopy(arr, 0, left, 0, mid);
        System.arraycopy(arr, mid, right, 0, arr.length - mid);

        mergeSort(left);
        mergeSort(right);

        merge(arr, left, right);
    }

    // Method to merge two sorted sub-arrays into a single sorted array
    private static void merge(int[] arr, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }
        while (i < left.length) {
            arr[k++] = left[i++];
        }
        while (j < right.length) {
            arr[k++] = right[j++];
        }
    }

    public static void main(String[] args) {
        // Example array
        // Example taken from a previous critical thinking assignment
        int[] arr = {783, 99, 472, 182, 264, 543, 356, 295, 692, 491, 94};

        System.out.println("Original array:");
        printArray(arr);

        // Sort array using Merge Sort
        mergeSort(arr);

        System.out.println("Sorted array:");
        printArray(arr);
    }

    // Utility method to print an array
    private static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
