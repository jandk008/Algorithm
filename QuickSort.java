package zidane.sort;
import java.lang.Math;

public class QuickSort extends Sort {

	@Override
	public void doSort() {
		quickSort(0, size()-1);
	}

	public void  quickSort(int low,int high){
		if(low < high){
			// end condition , otherwise dead loop occurs 
			if(low+1 == high){ 
				//consider equal situation  
				if(getNumber(low)>=getNumber(high)){
					swap(low, high);
					return;
				}
			}
			int pivat = getNumber(low);
			int left = low+1;
			int right = high;

			while (left<right){
				//left pointer move until current number is larger than the pivat
				while (left<right&&left<=high){
					if(getNumber(left)<=pivat)
						left++;
					else break;
				}
				//right pointer move until current number is less than the pivat
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
	public static void main (String[] agrs){
		QuickSort sort = new QuickSort();
    	sort.initial();
        sort.display();
        sort.doSort();
        sort.display();
	}

}
