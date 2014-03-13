import java.util.*;

public class MergeSort {

    public static void mergeSort(int[] array) {
        if (array.length > 1) {
            int[] left = leftHalf(array);
            int[] right = rightHalf(array);
            
            mergeSort(left);
            mergeSort(right);
            
            merge(array, left, right);
        }
    }
    
    public static int[] leftHalf(int[] array) {
        int sizeL = array.length / 2;
        int[] left = new int[sizeL];
        for (int i = 0; i < sizeL; i++) {
            left[i] = array[i];
        }
        return left;
    }
    
    public static int[] rightHalf(int[] array) {
        int sizeL = array.length / 2;
        int sizeR = array.length - sizeL;
        int[] right = new int[sizeR];
        for (int i = 0; i < sizeR; i++) {
            right[i] = array[i + sizeL];
        }
        return right;
    }
    
    public static void merge(int[] result, 
                             int[] left,
                             int[] right) {
        int L = 0;   
        int R = 0;   
        
        for (int i = 0; i < result.length; i++) {
            if (R >= right.length || (L < left.length && 
				      left[L] <= right[R])) {
                result[i] = left[L];    
                L++;
            } else {
                result[i] = right[R];   
                R++;
            }
        }
    }

    public static void main(String[] args) {
        int[] list = {12,345,547,7,35,45,34,4,66,865,45};
        System.out.println("Before: " + Arrays.toString(list));
        mergeSort(list);
        System.out.println("After:  " + Arrays.toString(list));
    }
}
