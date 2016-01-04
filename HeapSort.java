package chow.zidane.sort;


/**
 * <p>Implement the heap sort</p>
 * @author ziczhou
 *
 */
public class HeapSort {
	
	public static void main(String[] args){
		int[] a = {2,6,18,1,12,7,2};
		heapSort(a, 0, a.length - 1, true);
		for (int i = 0; i < a.length ; i ++)
		System.out.println(a[i]);
	}
	
	/**
	 * <p>Heap sort
	 * 1. initial the heap with the maximum or minimum at the first position
	 * 2. swap the first one and the last one.
	 * 3. after swap, the heap is broken, and modify the heap where the node 
	 * is the target according to the value of order.
	 * 4. loop once the array, do the same thing.</p> 
	 * @param a array to sort
	 * @param p the start index
	 * @param q the end index, array index
	 * @param order true for max heap, false for minimum heap
	 */
	public static void heapSort(int[] a, int p, int q, boolean order){
		// build the max heap
		buildHeap(a, 0, a.length - 1, order);
		
		for (int i = a.length - 1; i >= 0; i--){
			swap(a, 0, i);
			heapModify(a, i - 1, 0, order);
		}
	}
	
	/**
	 * <p>Loop each non-leaf node to assure the parent greater or less
	 * than two children according to the value of order.</p>
	 * @param a array to sort
	 * @param p the start index
	 * @param q the end index, array index
	 * @param order true for max heap, false for minimum heap
	 */
	public static void buildHeap(int[] a, int p, int q, boolean order){
		if (p >= q){
			return;
		} else {
			int startIndex = getParentIndex(q);
			for (int i = startIndex; i >= p; i--) {
			  heapModify(a, q, i, order);	
			}
		}
	}
	
	/**
	 * <p>Modify the heap with placing the maximum or minimum between parent 
	 * and children at the parent index.</p>
	 * @param a array to sort
	 * @param q heap size, the last index to sort
	 * @param i the parent index of where to be modified
	 * @param order true for max heap, false for minimum heap
	 */
	public static void heapModify(int[] a,int q, int i, boolean order){
		int leftChild = getLeftChildIndex(i);
		int rightChild = getRightChildIndex(i);
		// compare parent and two child
		int targetIndex = i;

		if (leftChild <= q && !((a[targetIndex] < a[leftChild]) ^ order)) {
			targetIndex = leftChild;
		} 
		if (rightChild <= q && !((a[targetIndex] < a[rightChild]) ^ order)) {
			targetIndex = rightChild;
		}
		if (targetIndex == i) {
			// do nothing
		} else {
			swap(a, targetIndex, i);
			heapModify(a, q, targetIndex, order);
		}
	}
	
	public static void swap(int[] a, int p, int q){
		int tmp = a[p];
		a[p] = a[q];
		a[q] = tmp;
	}
	public static int getParentIndex(int index){
		if (index <= 0){
			return 0;
		} else {
			return (index - 1)/2;
		}
	}
	
	public static int getLeftChildIndex(int index){
		return index * 2 + 1;
	}
	
	public static int getRightChildIndex(int index){
		return (index + 1) * 2;
	}
}
