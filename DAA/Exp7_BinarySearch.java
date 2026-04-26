public class Exp7_BinarySearch {
    // Recursive function for Binary Search
    public static int binarySearch(int[] arr, int low, int high, int target) {
        if (low <= high) {
            int mid = low + (high - low) / 2;

            // Target found at mid
            if (arr[mid] == target)
                return mid;

            // Target is smaller than mid, search left sub-array
            if (arr[mid] > target)
                return binarySearch(arr, low, mid - 1, target);

            // Target is larger than mid, search right sub-array
            return binarySearch(arr, mid + 1, high, target);
        }

        // Target not found
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50};
        int target = 40;
        int result = binarySearch(arr, 0, arr.length - 1, target);
        
        if (result != -1)
            System.out.println("Element found at index: " + result);
        else
            System.out.println("Element not found.");
    }
}