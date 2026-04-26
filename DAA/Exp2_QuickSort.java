import java.util.Arrays;
public class Exp2_QuickSort {
    static int partition(int arr[], int low, int high) {
        int pivot = arr[low];
        int i = low + 1;
        int j = high;

        while (true) {
            while (i <= high && arr[i] <= pivot) i++;
            while (arr[j] > pivot) j--;

            if (i < j) {
                int t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
            } else break;
        }

        arr[low] = arr[j];
        arr[j] = pivot;

        // System.out.println(Arrays.toString(arr));
        return j;
    }

    static void quickSort(int arr[], int low, int high) {
        if (low < high) {
            int p = partition(arr, low, high);
            quickSort(arr, low, p - 1);
            quickSort(arr, p + 1, high);
        }
    }

    public static void main(String[] args) {
        int arr[] = {8,3,1,7,0,10,2};
        System.out.println("Start: " + Arrays.toString(arr));
        quickSort(arr, 0, arr.length - 1);
        System.out.println("End: " + Arrays.toString(arr));
    }
}