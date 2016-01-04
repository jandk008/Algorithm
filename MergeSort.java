package chow.zidane.sort;

/**
 * <p>Implement the merge sort, whose time complexity is O(nlogn)</p>
 * @author ziczhou
 *
 */
public class MergeSort {

	public static void main(String[] args){
		int[] a = {45,4,11,44,22,5,78,4,25,12,32,78,434,1,324,546,567,324,46,13345,578,456,421};
		a = mergeSort(a, 0, a.length - 1, false);
		for (int i =0;i<a.length;i++){
			System.out.print(a[i] + " ");
		}
	}
	
	/**
	 * <p>Implement the merge sort recursively.
	 * 1. divide the whole array into half and half with extra storage.
	 * 2. execute merge sort recursively.
	 * @param a array to sort
	 * @param p start index  
	 * @param q end index 
	 * @param order true for natural order, false for counter-order descend 
	 * @return sorted array
	 */
	public static int[] mergeSort(int[] a, int p, int q, boolean order){
		if (p == q){
			return a;
		}
		int[] l = copyArray(a, 0, q/2);
		l = mergeSort(l, 0, l.length - 1, order);
		int[] r = copyArray(a, q/2 + 1, q);
		r = mergeSort(r, 0, r.length - 1, order);
		return merge(l, r, order);
	}
	
	public static int[] copyArray(int[] a, int p, int q){
		int[] c = new int[q-p+1];
		for (int i = 0; i<=q-p;i++){
			c[i] = a[i+p];
		}
		return c;
	}
	
	/**
	 * <p>Merge two array into one with the order provided by variable order</p>
	 * @param a one array to merge
	 * @param b the second one
	 * @param order true for asc or  false for desc
	 * @return sorted array
	 */
	public static int[] merge(int[] a, int[] b, boolean order){
		int[] c = new int[a.length + b.length];
		int i = 0;
		int j = 0;
		int index = 0;
		while (i <= a.length - 1 && j <= b.length - 1){
			if (!((a[i] < b[j]) ^ order)){
				c[index] = a[i];
				i++;
			} else {
				c[index] = b[j];
				j++;
			}
			index ++;
		}
		while(i <= a.length - 1){
			c[index] = a[i];
			index++;
			i++;
		}
		while(j <= b.length - 1){
			c[index] = b[j];
			index++;
			j++;
		}
		return c;
	}
}
