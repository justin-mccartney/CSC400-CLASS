public class FindMissingNumber {
    public static void main(String[] args) {
        int[] array = {3, 6, 5, 1, 4};
        int n = array.length;

        int expectedSum = (n+ 1) * (n + 2) / 2;

        int actualSum = 0;
        for(int i = 0; i < n; i++) {
            actualSum += array[i];
        }

        int missingNumber = expectedSum - actualSum;
        System.out.println("The missing number is... " + missingNumber);
    }
}
