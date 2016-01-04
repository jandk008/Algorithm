package atcoder.beginner.contest18;
/*
* Here, I do two things, one is rewriting a reader class  to accept input from console instead of the default Scanner class
* the other one is first to accept three numbers from console and output the rank in the turn of input 
* example:  input : 25 12 89
*           output: 2 3 1
*/

import java.io.IOException;
import java.io.InputStream;
import java.util.Comparator;
import java.util.InputMismatchException;

public class Main {
	FastScanner in = new FastScanner(System.in);

	public static void main(String[] args) {
		Main m = new Main();
		m.a();
	}

	void a() {
	/*	int a = in.nextInt();
		int b = in.nextInt();
		int c = in.nextInt();
		Integer[] array = { a, b, c };
//		Arrays.sort(array, new MyComparator());
		Arrays.sort(array,Collections.reverseOrder());
		System.out.println(returnPos(array, a)+1);
		System.out.println(returnPos(array, b)+1);
		System.out.println(returnPos(array, c)+1);*/
		char[] array = in.next().toCharArray();
/*		Arrays.sort( new Comparator<Character>() {
			public int compare(Character a, Character b){
				return b-a;
			}
		});*/
//		Collections.sort(array,(Comparator<Character>)Collections.reverseOrder());
		System.out.println(array);
	}
	int returnPos(Integer[] a , int b ){
		for (int n= 0;n<a.length;n++){
			if (a[n] == b){
				return n;
			}
		}
		return -1;
	}
	class MyComparator implements Comparator<Integer>{
		public int compare(Integer a,Integer b){
			return b-a;
		}
	}

	class FastScanner {
		private InputStream stream;
		private byte[] buf = new byte[1024];
		private int curChar;
		private int numChars;

		public FastScanner(InputStream stream) {
			this.stream = stream;
			// stream = new FileInputStream(new File("dec.in"));

		}

		int read() {
			if (numChars == -1)
				throw new InputMismatchException();
			if (curChar >= numChars) {
				curChar = 0;
				try {
					numChars = stream.read(buf);
				} catch (IOException e) {
					throw new InputMismatchException();
				}
				if (numChars <= 0)
					return -1;
			}
			return buf[curChar++];
		}

		boolean isSpaceChar(int c) {
			return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
		}

		boolean isEndline(int c) {
			return c == '\n' || c == '\r' || c == -1;
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		int[] nextIntArray(int n) {
			int[] array = new int[n];
			for (int i = 0; i < n; i++)
				array[i] = nextInt();

			return array;
		}

		int[][] nextIntMap(int n, int m) {
			int[][] map = new int[n][m];
			for (int i = 0; i < n; i++) {
				map[i] = in.nextIntArray(m);
			}
			return map;
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		long[] nextLongArray(int n) {
			long[] array = new long[n];
			for (int i = 0; i < n; i++)
				array[i] = nextLong();

			return array;
		}

		long[][] nextLongMap(int n, int m) {
			long[][] map = new long[n][m];
			for (int i = 0; i < n; i++) {
				map[i] = in.nextLongArray(m);
			}
			return map;
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

		double[] nextDoubleArray(int n) {
			double[] array = new double[n];
			for (int i = 0; i < n; i++)
				array[i] = nextDouble();

			return array;
		}

		double[][] nextDoubleMap(int n, int m) {
			double[][] map = new double[n][m];
			for (int i = 0; i < n; i++) {
				map[i] = in.nextDoubleArray(m);
			}
			return map;
		}

		String next() {
			int c = read();
			while (isSpaceChar(c))
				c = read();
			StringBuilder res = new StringBuilder();
			do {
				res.appendCodePoint(c);
				c = read();
			} while (!isSpaceChar(c));
			return res.toString();
		}

		String[] nextStringArray(int n) {
			String[] array = new String[n];
			for (int i = 0; i < n; i++)
				array[i] = next();

			return array;
		}

		String nextLine() {
			int c = read();
			while (isEndline(c))
				c = read();
			StringBuilder res = new StringBuilder();
			do {
				res.appendCodePoint(c);
				c = read();
			} while (!isEndline(c));
			return res.toString();
		}
	}
}
