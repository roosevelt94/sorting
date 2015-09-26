
/**
 * @author nganhoang
 *
 */

public class ArraySorter 
{
	public ArraySorter()
	{

	}

	
	/** Heap sort
	 * @param array
	 * @return sorted array, starting at index 1
	 */
	public static Comparable[] heapSort(Comparable[] array)
	{
		// Initialize a binary heap
		BinaryHeapA binaryHeap = new BinaryHeapA(array);
		
		// Sort the heap using heapsort
		binaryHeap.heapSortA();
		
		return binaryHeap.getHeap();
	}
	
	/** Selection sort
	 * @param array
	 * @return sorted array
	 * 
	 */
	public static Comparable[] selectionSort(Comparable[] array)
	{
		int n = array.length;
		// iterate length-2 times
		for (int i = 0; i < n-1; i++)
		{
			// assume current index is min index
			int minIndex = i;
			// for elements after min index forwards
			for (int j = i+1; j < n; j++)
			{
				// if found a smaller number
				if ( array[j].compareTo( array[minIndex] ) < 0)
				{
					// update minimum index to be j
					minIndex = j;
				}
			}
			int temp = (Integer) array[i];
			array[i] = array[minIndex];
			array[minIndex] = temp;
		}
		return array;
	}

	/** Insertion sort
	 * @param array
	 * @return sorted array
	 * 
	 */
	public static Comparable[] insertionSort(Comparable[] array)
	{
		int n = array.length;
		// loop from the second to last element in array
		for (int i = 1; i < n; i++)
		{
			// temp value for current array value
			int value = (Integer)array[i];
			// index of previous element
			int index = i - 1;
			// while index is not out of bounds
			while (index >= 0)
			{
				// if the current value is smaller than the considered value
				if ( value < (Integer)array[index] )
				{
					// swap positions of two values
					array[index + 1] = array[index];
					array[index] = value;
					// decrement index by 1
					index --;
				}
				// best case: already sorted, break out of loop
				else
				{
					break;
				}
			}
		}
		return array;
	}

	/** Bubble sort
	 * @param array
	 * @return sorted array
	 * 
	 */
	public static Comparable[] bubbleSort(Comparable[] array)
	{
		int n = array.length;
		// run through the array n-1 times
		for (int j = 1; j < n; j++)
		{
			// for each pass through an array
			for (int i = 0; i < n-1; i++)
			{
				// if current value is larger than the next one
				if ( array[i].compareTo(array[i+1]) > 0)
				{
					// swap the two values
					int tempValue = (Integer)array[i];
					array[i] = array[i+1];
					array[i+1] = tempValue;
				}
			}
		}
		return array;
	}

	/** Merge sort
	 * @param array
	 * @return sorted array
	 * 
	 */
	public static Comparable[] mergeSort( Comparable[] array )
	{
		int n = array.length;
		// base case: if there's only one element in array
		if (n < 2)
		{
			// array is already sorted
			return array;
		}
		// find middle index
		int mid = (int)(n/2);
		
		// create left and right arrays
		Comparable[] left = new Comparable[mid];
		Comparable[] right = new Comparable[n-mid];
		
		for (int i = 0; i < mid; i++)
		{
			left[i] = array[i];
		}
		for (int i = mid; i < n; i++)
		{
			right[i - mid] = array[i];
		}
		// assign left and right arrays recursively
		left = mergeSort(left);
		right = mergeSort(right);
		return merge(left, right, array);
	}
	
	private static Comparable[] merge( Comparable[] left, Comparable[] right, Comparable[] arr )
	{
		int nLeft = left.length;
		int nRight = right.length;
		
		// index pointer to keep track of L
		int i = 0;
		// index pointer to keep track of R
		int j = 0;
		// index pointer to keep track of given array
		int k = 0;
		
		// while indices not out of bounds
		while ( (i < nLeft) && (j < nRight) )
		{
			// if ith element in left array is smaller than jth element in right array
			if ( left[i].compareTo(right[j]) < 0 )
			{
				// update main array 
				arr[k] = left[i];
				// increment k and i
				k ++;
				i ++;
			}
			// otherwise (if jth element in right is smaller)
			else 
			{
				arr[k] = right[j];
				k ++;
				j ++;
			}
		}
		// only one of the following while loops would be executed
		// if right array is exhausted first --> fill up arr with the rest of left
		while ( i < nLeft)
		{
			arr[k] = left[i];
			k ++;
			i ++;
		}
		// if left array is exhausted first --> fill up arr with the rest of right
		while ( j < nRight)
		{
			arr[k] = right[j];
			k ++;
			j ++;
		}
		return arr;
	}
}

