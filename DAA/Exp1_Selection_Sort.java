import java.util.Arrays;

public class Exp1_Selection_Sort{
    static void selection_sort(int[] arr){
        for(int i=0; i<arr.length; i++){
            //find the max iteam in the arr and swap with last index
            int last = arr.length - i - 1;
            int MaxIndex = getMaxIndex(arr, 0, last);
            swap(arr, MaxIndex, last);
        }
    }

    static void swap(int [] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    static int getMaxIndex(int [] arr, int start, int end){
        int max = start;
        for(int i=start; i<end; i++){
            if(arr[max]<arr[i]){
                max = i;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {8,5,21,9,6};
        selection_sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}