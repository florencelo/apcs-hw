import java.util.*;
import java.io.*;
	
public class HeapMinPriorityQueue<E extends Comparable<E>> implements MinPriorityQueue<E> {
  private ArrayList<E> heap;
  
  public HeapMinPriorityQueue() {
    heap = new ArrayList<E>();
  }
  
  public E removeMin() {
    if (heap.size() <= 0)
      return null;
    else {
      E minVal = heap.get(0);
      heap.set(0, heap.get(heap.size()-1)); 
      heap.remove(heap.size()-1);
      minHeapify(heap, 0);
      return minVal;
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

  public E minimum() {
    if (heap.size() <= 0)
      return null;
    else
      return heap.get(0);
  }

  private static <E extends Comparable<E>> void minHeapify(ArrayList<E> a, int i) {
    int left = leftChild(i);    
    int right = rightChild(i);  
    int smallest;   
    if (left <= a.size()-1 && a.get(left).compareTo(a.get(i)) < 0)
      smallest = left;   
    else
      smallest = i;
    if (right <= a.size()-1 && a.get(right).compareTo(a.get(smallest)) < 0)
      smallest = right;
    if (smallest != i) {
      swap(a, i, smallest);
      minHeapify(a, smallest);
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