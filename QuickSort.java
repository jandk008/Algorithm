package zidane.sort;
import java.lang.Math;

public class QuickSort extends Sort {

	@Override
	public void doSort() {
		quickSort(0, size()-1);
	}

	public void  quickSort(int low,int high){
		if(low < high){
			if(low+1 == high){
				if(getNumber(low)>=getNumber(high)){
					swap(low, high);
					return;
				}
			}
			int pivat = getNumber(low);
			int left = low+1;
			int right = high;

			while (left<right){
				while (left<right&&left<=high){
					if(getNumber(left)<=pivat)
						left++;
					else break;
				}
				while(left<=right&&right>low){
					if(getNumber(right)>=pivat)
						right--;
					else break;
				}
				if(left<right)
					swap(left, right);
			}
			swap(low, right);
			quickSort(low, right);
			quickSort(right+1,high);
		}
	}
	public void swap(int a, int b) {
		int temp = getNumber(b);
		setNumber(getNumber(a), b);
		setNumber(temp, a);
	}

}
/*
 Father class for sorting 
*/

abstract class Sort {
    //array as sorting data structure 
    private int[] array;
    final int  size = 5;

    public Sort() {
    }

    public void initial() {
        if (array == null) {
            array = new int[size];
        }
        for (int i = 0; i < size; i++) {
//            array[i] = getNumberRandom(System.currentTimeMillis());
        	array[i] = getNumberRandom(1);
        }
    }
    @SuppressWarnings("unused")
    private int getNumberRandom(double seed) {
        return new Long(Math.round(Math.random() * seed/3600 + 1)).intValue(); // make sure that result is not 0
    }

    @SuppressWarnings("unused")
	private int getNumberRandom(int seed){
    	return Integer.parseInt(String.valueOf(Math.round(Math.random() * seed + 1)));
    }

    public abstract void doSort();

    public void display() {
        System.out.println("---------display starts  -------------");
        for (int i = 0; i < size; i++) {
            System.out.println(array[i]);
        }
        System.out.println("---------display end -------------");
    }

    public int getNumber(int i) {
        return array[i];
    }

    public void setNumber(int i, int p) {
        array[p] = i;
    }

    public int size() {
        return size;

    }
}
