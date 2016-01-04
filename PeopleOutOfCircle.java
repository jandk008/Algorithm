package zidane.array_strings;

/*
*Issue dicription: there are 50 people who call out numbers from 1 in loop 
*(after the 50th people said 50, the first peple say 51). The people will be out of the loop 
*if his number is 3 or times of 3. The output will be the last people.
*example input : 50  output: 11
*/
public class CircleOut {
	private  int[] array = new int[50];
	public CircleOut() {
		// TODO 自動生成されたコンストラクター・スタブ
		for (int i= 1;i<=array.length;i++){
			array[i-1]=i;
		}
	}
	public void execute(){
		int pos=0;
		int n=1;
		while(pos!=array.length-1){
			if(n%3==0){
				System.out.print(array[pos++]+" ");
			}else{
				rotation(pos);
			}
			n++;
		}
		System.out.println(array[pos]);
		System.out.println("最後の人が"+array[pos]+"ですが、"+(array[pos]-1)+"番に立ってます");
	}
	void rotation(int pos){
		int temp = array[pos];
		for(int i=pos;i<array.length-1;i++){
			array[i] = array[i+1];
		}
		array[array.length-1]=temp;
	}
	public static void main(String[] args){
		new CircleOut().execute();
	}
}
