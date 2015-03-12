package zidane.array_strings;
/*
* This fuction implement the rotation of matrix in clockwise(90 degree to right side) 
* methods includes initial(),rotateMatrix(),displayMatrix()
*/

class RotationMatrix{
//initial the matrix 
	public static void intialMatrix(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				matrix[i][j] = j;
			}
		}
	}

// do the rotation of matrix 
	public static void rotateMatrix(int[][] matrix) {
		int n = matrix.length;
		//calculate the number of layer, and first rotate the outer and  inner later 
		for (int layer = 0; layer < n / 2; layer++) {
			int first = layer;
			int last = n - 1 - first;
			for (int i = first; i < last; i++) {
			  //keep the offset 
				int offset = i - first;
				int temp = matrix[first][i];
					//leftbottom to lefttop 
				matrix[first][i] = matrix[last - offset][first];
					//rightbottom to leftbottom 
				matrix[last - offset][first] = matrix[last][last - offset];
					//righttop ⇒  rightbottom 
				matrix[last][last - offset] = matrix[i][last];
					//lefttop ⇒  righttop 
				matrix[i][last] = temp;
			}
		}
	}

	public static void diplayMatrix(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println("");
		}
	}
}
