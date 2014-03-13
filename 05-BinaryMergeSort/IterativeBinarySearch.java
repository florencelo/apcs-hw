
public class IterativeBinarySearch {
	
	public int binarySearch(int[] a, int x) {
	      int low = 0;
	      int high = a.length - 1;
	      while (low <= high) {
	         int mid = (low + high)/2;
	         if (a[mid] == x) return mid;
	         else if (a[mid] < x) low = mid + 1;
	         else high = mid - 1;
	      }
	      return -1;
	   }

	   public static void main(String[] args) {
		   IterativeBinarySearch b = new IterativeBinarySearch();

	      int[] a ={2,45,234,567,876,900,976,999};
	      System.out.println("Found 1 at index " + b.binarySearch(a,1) +" ");
	      System.out.println("Found 45 at index " + b.binarySearch(a,45)+" ");
	      System.out.println("Found 876 at index " + b.binarySearch(a,876)+" ");
	      System.out.println("Found 999 at index " + b.binarySearch(a,999)+" ");
	   }
}
