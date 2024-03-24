package in.ineuron.cn.backtracking;

public class Sudoku {
	public static boolean isItSudoku(int matrix[][]) {

		// Write your code here.
		for(int i = 0; i < matrix.length; i++){
			for(int j = 0; j < matrix[i].length; j++){
				//empty cell:
				if(matrix[i][j] == 0){

					for(int digit = 1; digit <=9; digit++){

						if(isValid(matrix, digit, i, j)){
							matrix[i][j] = digit;

							if(isItSudoku(matrix)){
								return true;
							}
							else{
								//re-setting and trying with the next digit:
								matrix[i][j] = 0;
							}
						}

					}
					//none of the digit can be placed:
					return false;
				}
			}
		}
		return true;
	}


	private static boolean isValid(int matrix[][], int digit, int row, int col){

		for (int i = 0; i < 9; i++) {
			//column wise check:
			if(matrix[row][i] == digit) return false;

			//row wise check:
			if(matrix[i][col] == digit) return false;

			//sub 3x3 matrix check:
			if(matrix[3 * (row/3) + i/3][3 * (col/3) + i%3] == digit) return false;

		}
		return true;
	}
}
