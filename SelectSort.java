package zidane.sort;

public class SelectSort extends Sort {
    public void doSort() {
        System.out.println("sort is started ");
        int max = 0;
        int maxPostion = 0;
        int temp;
        for (int i = size() - 1; i >= 0; i--) { // keep the last position to
                                                // save the MAX
            for (int j = 0; j <= i; j++) {
                if (getNumber(j) > max) {
                    max = getNumber(j); // keep as the Max if less than next
                    // one
                    maxPostion = j;
                }
            }
            temp = getNumber(i); // swap the value
            setNumber(max, i);
            setNumber(temp, maxPostion);
            max = 0;
            maxPostion = 0;
        }
        System.out.println("sort end ");
    }
}
