package zidane.array_strings;

/*
* this function will create the permutation output for input using recursion 
* at first: we can solve this in recursion and think this as this way: if we have done permutation at n-1 item
* then we just add the n th item in front of the result 
* example: input abc 
*          output  abc acb bac bca cab cba 
*/

public class Permutation {
	public void permu(char[] c,int low, int high){
		if (low == high){
		  System.out.println(c);
			return;
		}
		for (int n = low;n<=high;n++){
		//iterate each item and swap it to the first, then execute the permutation at the rest 
			swap (c,low,n);
			permu(c, low+1, high);
			swap(c, low, n);
		}

	}
	public void swap (char[] c, int a , int b){
		char temp = c[a];
		c[a] = c[b];
		c[b]=temp;
	}
	public static void main (String[] args){
		String s = "abc";
		Permutation permutation = new Permutation();
		permutation.permu(s.toCharArray(), 0, s.length()-1);
	}
}

