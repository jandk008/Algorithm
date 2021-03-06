package chow.zidane.graph;

/*
 * This class extends Graph and implement a update() method to add new edge 
 * and return whether connectable for two nodes.
 * To implement this , use basic solution.
 * Next version will concentrate on improving the performance and checking connectable with weight
 */

import java.util.LinkedList;

public class PathFind extends Graph {
	public PathFind() {
		// TODO 自動生成されたコンストラクター・スタブ
		super();
	}

	// after adding new edge, update the connectable table for new graph
	void update() {
		boolean[] isUpdated = new boolean[array.length];
		LinkedList<Integer> path = new LinkedList<Integer>();
		for (int n = 0; n < array.length; n++) {
			path.addFirst(n);
			while (!path.isEmpty()) {
				int k = path.removeFirst();
				isUpdated[k] = true;
				for (int m = 0; m < array.length; m++) {
					if (array[k][m] == 1 && !isUpdated[m]) {
						isUpdated[m] = true;
						path.add(m);
						if (array[n][m] == 0) {
							set(n, m);
							set(m, n);
						}
					}
				}
			}
			for (int h = 0; h < isUpdated.length; h++) {
				isUpdated[h] = false;
			}
		}
	}

	void set(int i, int j) {
		super.set(i, j);
		update();
	}

	void set(String i, String j) {
		super.set(i, j);
		update();
	}

	boolean connectable(int i, int j) {
		return array[i][j] != 0;
	}

	@SuppressWarnings("unused")
	private static class Test {
		public static void main(String[] args) {
			PathFind pathFind = new PathFind();
			pathFind.display();
			System.out.println(pathFind.connectable(3, 8));

			pathFind.set(4, 5);
			pathFind.display();
			System.out.println(pathFind.connectable(8, 3));

		}
	}
}
