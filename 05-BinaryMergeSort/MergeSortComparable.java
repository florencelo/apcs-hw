import java.util.*;

public class MergeSortComparable {

	public static void MergeSortComparable(Comparable[] a){
		Comparable[] b = new Comparable[a.length];
		MergeSortComparable(a, b, 0 , a.length-1);
	}

	public static void MergeSortComparable(Comparable[] a, Comparable[] b, int left, int right){
		if(left < right)
		{
			int avg = (left + right) / 2;
			MergeSortComparable(a, b, left, avg);
			MergeSortComparable(a, b, (avg + 1), right);
			merge(a, b, left, (avg + 1), right);
		}
	}

	public static void merge(Comparable[]a, Comparable[] b, int left, int right, int R){
		int L = right - 1;
		int k = left;
		int num = R - left + 1;

		while (left <= L && right <= R)
			if(a[left].compareTo(a[right]) <= 0)
				b[k++] = a[left++];
			else
				b[k++] = a[right++];

		while (left <= L)
			b[k++] = a[left++];

		while (right <= R)
			b[k++] = a[right++];

		for(int i = 0; i < num; i++, R--)
			a[R] = b[R];
	}


	public static void main(String[]args){
		Integer[] I = {12,345,547,7,35,45,34,4,66,865,45};
		String[] S = {"Optimus Prime" , "Wheeljack", "Bumblebee", "Cliffjumper", "Ratchet", "Wheelie"};
		MergeSortComparable(I);
		MergeSortComparable(S);
		System.out.println(Arrays.toString(I));
		System.out.println(Arrays.toString(S));
	}
}