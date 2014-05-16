import java.util.*;
import java.io.*;

public class Heaps {
    private int size;
    private int[] heap;
    
    public Heaps() {
	heap = new int[7];
	size = 0;
    }
    
    public int size(){
    	return size;
    }

    public void add(int n) {
    	size++;
    	if(size>=heap.length){
	    grow();
	}
    	heap[size-1]=n;
    	pushUp(heap,size-1);
    }

    private void grow() {
    	int[] n = new int[size*2+1];
    	for(int i=0; i<heap.length; i++) {
    	    n[i] = heap[i];
    	}
    	heap = n;
    }

    public int removeMax() {
    	int r = heap[0];
    	size--;
    	heap[0] = heap[size];
    	pushDown(heap,0,size);
    	return r;
    }

    public int[] sorted() {
	int[] r = new int[size];
    	for(int i=0; i<r.length; i++) {
    	    r[r.length-1-i] = removeMax();
    	}
    	return r;
    }

    private static void swap(int[] a, int p, int q) {
	int temp = a[p];
	a[p] = a[q];
	a[q] = temp;
    }
                    
    public static int[] sort(int[] a) {
	for(int i=0; i<a.length; i++) {
	    pushUp(a,i);
	}
	for(int i=0; i<a.length; i++) {
	    swapMax(a,a.length-i);
	}
	return a;
    }

    private static void swapMax(int[] a, int len) {
	int r = a[0];
	a[0] = a[len-1];
	pushDown(a,0,len);
	a[len-1] = r;
    }

    private static void pushUp(int[] a, int i) {
	if(i==0) {return;}
	int above = (i+1)/2-1;
	if(a[above]<a[i]) {
	    swap(a,above,i);
	    pushUp(a,above);
	}
    }

    private static void pushDown(int[] a, int i, int len) {
	int left = (i+1)*2-1;
	int right = left+1;
	if(left>=len-1) {return;}
	if(right>=a.length || a[left] > a[right]) {
	    if(a[left] > a[i]) {
		swap(a,left,i);
		pushDown(a,left,len);
	    }
	} else {
	    if(a[right] > a[i]) {
		swap(a,right,i);
		pushDown(a,right,len);
	    }
	}
    }
            
}
