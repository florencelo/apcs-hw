
public class QuickSelect1{

    public static int separate(int[] a, int low, int high)
    {
	int left = low;
	int pivotIndex = low + (high - low)/2;
	int pivot = a[pivotIndex];
	a[pivotIndex] = a[high];
	a[high] = pivot;
	pivotIndex = high;
	int partitionIdx = low;
	while (left < high)
	    {
	        if (a[left] < pivot) 
		    {
			int tmp = a[left];
			a[left] = a[partitionIdx];
			a[partitionIdx] = tmp;
			++partitionIdx;
		    }
	        ++left;
	    }
	a[pivotIndex] = a[partitionIdx];
	a[partitionIdx] = pivot;
	return partitionIdx;
    }

    public static int quickSelect(int[] a, int low, int high, int k)
    {
	if (low == high)
	    return a[low];
	int pivotIndex = separate(a, low, high);
	int sizeOfLeftSubArray = pivotIndex - low + 1;
	if (sizeOfLeftSubArray > k)
	    {
	        return quickSelect(a, low, pivotIndex-1, k);
	    }
	else if (sizeOfLeftSubArray < k)
	    {
	        return quickSelect(a, pivotIndex+1, high, k-sizeOfLeftSubArray);
	    }
	else
	    {
	        return a[pivotIndex];
	    }
    }
	
    public static void main (String [] args){
	int [] a = {2,345,45,56,43,54,654,43,6,5,4}; 
		
	System.out.println(quickSelect(a, 1, 5, 0));
	System.out.println(quickSelect(a, 0, 10, 3));
	System.out.println(quickSelect(a, 1, 10, 1));
	System.out.println(quickSelect(a, 2, 5, 0));
	System.out.println(quickSelect(a, 4, 5, 1));
	System.out.println(quickSelect(a, 1, 9, 4));
	System.out.println(quickSelect(a, 0, 10, 5));
	System.out.println(quickSelect(a, 0, 7, 3));
	System.out.println(quickSelect(a, 0, 10, 9));
	System.out.println(quickSelect(a, 1, 5, 3));
    }
}
