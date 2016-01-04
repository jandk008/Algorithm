package chow.zidane.graph;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public abstract class Graph {
  //use array[][] to store undirected graph, if E(u,v) exists, array[u][v] is 1, but 0
	protected int[][] array = new int[10][10];
	String path = "C:\\Users\\Zidane_Chow\\Desktop\\開発\\2.txt";
	BufferedReader in;
	 public Graph() {
		// TODO 自動生成されたコンストラクター・スタブ
		initial();
	}

	 void set(String a,String b){
		int i=Integer.parseInt(a);
		int j = Integer.parseInt(b);
		array[i][j] = 1;
	}
	
	 void set(int i,int j){
		array[i][j] = 1;
	}

// initial the graph 
	void initial() {
		for(int i=0;i<array.length;i++){
			set(i, i);
		}
    // read data from file 
    // if edge exits between two nodes, the node number is written  in the file
		try {
			in = new BufferedReader(new FileReader(new File(path)));
			String s;
			String[] pos;
			while((s=in.readLine())!=null){
				pos = s.split(" ");
				set(pos[0], pos[1]);
				set(pos[1], pos[0]);
			}

		} catch (Exception e) {
			// TODO: handle exception
			try {
				in.close();
			} catch (IOException e2) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
	
	 void display(){
			for(int n=0;n<array.length;n++){
				for(int j=0;j<array[0].length;j++){
					System.out.print(array[n][j]+" ");
				}
				System.out.println();
			}
		}

}
