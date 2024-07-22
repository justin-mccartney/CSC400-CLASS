import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class TestRadixSort {
    @Test
    public void testRadixSort() {
        int[] array = {783, 99, 472, 182, 264, 543, 356, 295, 692, 491, 94};
        int[] expected = {94, 99, 182, 264, 295, 356, 472, 491, 543, 692, 783};

        RadixSort.radixSort(array);
        assertArrayEquals(expected, array);
    }

    @Test
    public void testEmptyArray() {
        int[] array = {};
        int[] expected = {};

        RadixSort.radixSort(array);
        assertArrayEquals(expected, array);
    }

    @Test
    public void singleElementArray() {
        int[] array = {5};
        int[] expected = {5};

        RadixSort.radixSort(array);
        assertArrayEquals(expected, array);
    }
}
