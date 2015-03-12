package zidane.array_strings;
/*
* Hannoi Tower 
* 1. implement the basic functon and output the procedure  
* 2. calculate the number of procedure  
*/

class HannoiTower{
	// hannoi tower
	public static int hannoi(int n, String left, String middle, String right) {
		if (n == 1) {
			System.out.println("put " + n + " from " + left + " to " + right);
			return 1;
		}
		int step1, step2;
		step1 = hannoi(n - 1, left, right, middle);
		System.out.println("put " + n + " from " + left + " to " + right);
		step2 = hannoi(n - 1, middle, left, right);
		return step1 + 1 + step2;
	}
	public static void main(String[] args){
	 System.out.println("steps is " + hannoi(4, "left", "middle", "right"));
	}

}
