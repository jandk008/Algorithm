package zidane.sort;

public class CompareSort extends Sort {
	public void doSort() {
		boolean isDone = false;
		while (!isDone) {
			isDone=true;
			for (int n = 0; n < size() - 1; n++) {
				int i = n;
				while ( i < size() - 1 && getNumber(i) > getNumber(i + 1) ) {
					int temp = getNumber(i);
					setNumber(getNumber(i + 1), i);
					setNumber(temp, i + 1);
					i++;
					isDone = false;
				}
			}
		}
	}

	
}
