
public class BinaryHeapA<T extends Comparable<T>> implements BinaryHeap<T>
{
	// array to hold the heap 
	private Comparable[] heap;

	// keep track of the heap size (the number of heap elements stored within array--different from the capacity) 
	private int heapSize;

	public BinaryHeapA(Comparable<T>[] array)
	{
		// Initialize heap to be one element larger than given array 
		heap = new Comparable[array.length + 1];
		
		// Copy array into the heap, starting at index 1
		System.arraycopy(array, 0, heap, 1, array.length);
		
		// no. of heap elements equals array length
		heapSize = array.length;
	}
	

	/** Construct a max heap from the current heap array 
	 * 
	 */
	public void buildMaxHeap()
	{
		// get index to start max heapify
		int i = (int) Math.floor( (heapSize+1)/2 );
		
		// max heapify each subtree rooted at node indexed from i till 1
		for (int j = i; j > 0; j--)
		{
			maxHeapify(j);
		}		
	}

	/** Maintain max-heap property of the subtree rooted at index i
	 * @param index i marking root of subtree to be heapified
	 */
	public void maxHeapify(int i)
	{
		// Calculate indexes of its left and right nodes 
		int left = left(i);
		int right = right(i);

		// Index of the largest node 
		int largest;

		// if left index is valid, and left value is larger than value at index i
		if ( (left <= heapSize) && ( heap[left].compareTo(heap[i]) > 0) )
			largest = left;
		else 
			largest = i;

		// if right index is valid, and right value is larger than current largest value
		if ( (right <= heapSize) && ( heap[right].compareTo(heap[largest]) > 0) )
			largest = right;

		// If index of largest value now different from i
		if (largest != i)
		{
			// Swap values at i and largest
			Comparable<T> temp = heap[i];
			heap[i] = heap[largest];
			heap[largest] = temp;

			// Recursive call to maintain max-heap property of subtree rooted at largest
			maxHeapify(largest);
		}
	}
	
	/** Heap sort the current heap
	 * 
	 */
	public void heapSortA()
	{
		buildMaxHeap();
		
		int heapLength = heapSize;
		
		for (int i = heapLength; i > 1; i--)
		{
			// swap heap[i] and heap[1]
			Comparable<T> temp = heap[i];
			heap[i] = heap[1];
			heap[1] = temp;
			
			// leave out another sorted element
			heapSize = heapSize-1;
			
			// start to max-heapify at the first node
			maxHeapify(1);
		}
	}

	/** Return index of heap[i]'s left node
	 * @param i
	 * @return left i
	 */
	private int left(int i)
	{
		return 2*i;
	}

	/** Return index of heap[i]'s right node
	 * @param i
	 * @return right i
	 */
	private int right(int i)
	{
		return 2*i + 1;
	}


	/**
	 * @return the heap
	 */
	public Comparable[] getHeap() 
	{
		return heap;
	}

	/**
	 * @param newHeap: the heap to set
	 */
	public void setHeap(Comparable[] newHeap) 
	{
		this.heap = newHeap;
	}
	
}