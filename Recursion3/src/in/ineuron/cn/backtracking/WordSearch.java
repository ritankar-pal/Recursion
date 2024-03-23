package in.ineuron.cn.backtracking;

public class WordSearch {


	private static boolean search(char[][] board, String word, int n, int m, int[][] isVisited, int charIndex, int i, int j) {

		//		if(i == -1 || j == -1 || i == n || j == m) return false;
		//		if(isVisited[i][j] == 1) return false;


		if(charIndex == word.length()) return true;

		isVisited[i][j] = 1;

		//top:
		if(i - 1 >= 0 && isVisited[i-1][j] != 1 && board[i-1][j] == word.charAt(charIndex)) {
			if(search(board, word, n, m, isVisited, charIndex+1, i-1, j)) {
				return true;
			}
		}

		//right:
		if(j + 1 < m && isVisited[i][j + 1] != 1 && board[i][j + 1] == word.charAt(charIndex)) {
			if(search(board, word, n, m, isVisited, charIndex+1, i, j+1)) {
				return true;
			}
		}

		//bottom:
		if(i+1 < n && isVisited[i+1][j] != 1 && board[i+1][j] == word.charAt(charIndex)) {
			if(search(board, word, n, m, isVisited, charIndex+1, i+1, j)) {
				return true;
			}
		}

		//left:
		if(j-1 >=0 && isVisited[i][j-1] != 1 && board[i][j-1] == word.charAt(charIndex)) {
			if(search(board, word, n, m, isVisited, charIndex+1, i, j-1)) {
				return true;
			}
		}

		//reset:
		isVisited[i][j] = 0;

		return false;
	}

	public static boolean present(char [][]board, String word, int n, int m) {
		// Write your code here.
		int[][] isVisited = new int[n][m];

		for(int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {

				if(board[i][j] == word.charAt(0)) {
					int charIndex = 1;
					if(search(board, word, n, m, isVisited, charIndex, i, j)) {
						return true;
					}
				}
			}
		}

		return false;
	}

}
