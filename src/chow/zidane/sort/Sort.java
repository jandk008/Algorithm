package chow.zidane.sort;
/*
 Father class for sorting 
*/
public abstract class Sort {
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
