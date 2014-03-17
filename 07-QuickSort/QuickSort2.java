import java.util.*;
import java.io.*;

public class QuickSort2{

    private static Random random = new Random();

    private static void sort(int[] a) {
	if (a.length > 0)
	    sortInPlace(a, 0, a.length - 1);
    }

    private static void sortInPlace(int[] a, int l, int r) {

	if (l >= r)
	    return; 

	final int range = r - l + 1;
	int pivot = random.nextInt(range) + l;

	int newPivot = partition(a, l, r, pivot);

	sortInPlace(a, l, newPivot - 1);
	sortInPlace(a, newPivot + 1, r);

    }

    private static int partition(int[] a, int l, int r, int wall) {

	int pivotVal = a[wall];
	swapArrayVals(a, wall, r);

	int storeIndex = l;
	for (int i = l; i <= (r - 1); i++) {
	    if (a[i] < pivotVal) {
		swapArrayVals(a, i, storeIndex);
		storeIndex++;
	    }
	}

	swapArrayVals(a, storeIndex, r);

	return storeIndex;
    }

    private static void swapArrayVals(int[] a, int from, int to) {
	int fromVal = a[from];
	int toVal = a[to];
	a[from] = toVal;
	a[to] = fromVal;
    }

    public static void main(String[] args) {
	int n = Integer.parseInt(args[0]);

	Random rnd = new Random();
	int[] a = new int[n];
	for (int i=0;i<n;i++)
	    a[i]=rnd.nextInt(100);
	System.out.println(Arrays.toString(a));
	QuickSort2 q = new QuickSort2();
	q.sort(a);
	System.out.println(Arrays.toString(a));
    }
    
}    
