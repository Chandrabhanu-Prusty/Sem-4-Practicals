import java.util.Arrays;
public class Exp2_MergeSort {

    // Merges two sorted halves: [left..mid] and [mid+1..right].
    static void merge(int[] arr, int[] temp, int left, int mid, int right) {
        int leftIndex = left;
        int rightIndex = mid + 1;
        int tempIndex = left;

        // Compare elements from both halves and write the smaller one to temp.
        while (leftIndex <= mid && rightIndex <= right) {
            if (arr[leftIndex] <= arr[rightIndex]) {
                temp[tempIndex++] = arr[leftIndex++];
            } else {
                temp[tempIndex++] = arr[rightIndex++];
            }
        }

        // Copy remaining elements from left half (if any).
        while (leftIndex <= mid) {
            temp[tempIndex++] = arr[leftIndex++];
        }

        // Copy remaining elements from right half (if any).
        while (rightIndex <= right) {
            temp[tempIndex++] = arr[rightIndex++];
        }
            
        // Copy merged segment back to original array.
        for (int i = left; i <= right; i++) {
            arr[i] = temp[i];
        }
    }

    // Divide array recursively, then merge sorted halves.
    static void mergeSort(int[] arr, int[] temp, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;

            mergeSort(arr, temp, left, mid);
            mergeSort(arr, temp, mid + 1, right);
            merge(arr, temp, left, mid, right);
        }
    }

    public static void main(String[] args) {
        int[] arr = {8, 3, 1, 7, 0, 10, 2};
        int[] temp = new int[arr.length];

        System.out.println("Start: " + Arrays.toString(arr));
        mergeSort(arr, temp, 0, arr.length - 1);
        System.out.println("End: " + Arrays.toString(arr));
    }
}
