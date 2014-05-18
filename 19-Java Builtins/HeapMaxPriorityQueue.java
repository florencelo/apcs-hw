import java.util.*;
import java.io.*;
	
public class HeapMaxPriorityQueue<E extends Comparable<E>> implements MinPriorityQueue<E> {
  private ArrayList<E> heap;
  
  public HeapMaxPriorityQueue() {
    heap = new ArrayList<E>();
  }
  
  public E removeMax() {
    if (heap.size() <= 0)
      return null;
    else {
      E maxVal = heap.get(0);
      heap.set(0, heap.get(heap.size()-1)); 
      heap.remove(heap.size()-1);
      minHeapify(heap, 0);
      return maxVal;
    }
  }

  public void add (E x) {
    heap.add(x);        
    int loc = heap.size()-1;  

    while (loc > 0 && heap.get(loc).compareTo(heap.get(parent(loc))) < 0) {
      swap(heap, loc, parent(loc));
      loc = parent(loc);
    }
  }

  public boolean isEmpty() {
    return heap.size() == 0;
  }

  public E maximum() {
    if (heap.size() <= 0)
      return null;
    else
      return heap.get(heap.size() - 1);
  }

  private static <E extends Comparable<E>> void minHeapify(ArrayList<E> a, int i) {
    int left = leftChild(i);    
    int right = rightChild(i);  
    int largest;   
    if (right <= a.size()-1 && a.get(right).compareTo(a.get(i)) < 0)
      largest = right;   
    else
      largest = i;
    if (left <= a.size()-1 && a.get(left).compareTo(a.get(largest)) < 0)
      largest = left;
    if (largest != i) {
      swap(a, i, largest);
      minHeapify(a, largest);
    }
  } 

  private static <E> void swap(ArrayList<E> a, int i, int j) {
    E t = a.get(i);
    a.set(i, a.get(j));
    a.set(j, t);
  }

  private static int leftChild(int i) {
    return 2*i + 1;
  }

  private static int rightChild(int i) {
    return 2*i + 2;
  }

  private static int parent(int i) {
    return (i-1)/2;

}
}