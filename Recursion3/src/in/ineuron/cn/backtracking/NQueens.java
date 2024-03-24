package in.ineuron.cn.backtracking;

import java.util.ArrayList;
import java.util.List;


public class NQueens {

	private static boolean isSafe(int[][] board, int n, int m, int row, int col) {

		//check upper diagonal:
		int dupRow = row;
		int dupCol = col;

		while(row >= 0 && col >= 0) {
			if(board[row][col] == 1) return false;
			row--;
			col--;
		}

		//check left side:
		row = dupRow;
		col = dupCol;

		while(col >= 0) {
			if(board[row][col] == 1) return false;
			col--;			
		}

		//check lower diagonal:
		row = dupRow;
		col = dupCol;

		while(row < n && col >= 0) {
			if(board[row][col] == 1) return false;
			row++;
			col--;
		}

		return true;
	}

	private static void placeNQueens(int[][] board, int N, int n, int m, int col, List<int[][]> list) {

		//baseCase:
		if(col == m) {
			list.add(board);
			return;
		}

		//checking each row of the given column where we can place the Queen as 1:
		for(int row = 0; row < n; row++) {
			if(isSafe(board, n, m, row, col)) {
				board[row][col] = 1;
				placeNQueens(board, N, n, m, col+1, list);
				
				//re-setting that row-col back to 0:
				board[row][col] = 0;
			}
		}
	}

	

	public static List<int[][]> solveNQueens(int[][] board, int N, int n, int m){

		List<int[][]> ansList = new ArrayList<>();

		int col = 0;
		placeNQueens(board, N, n, m, col, ansList);

		return ansList;
	}

}
