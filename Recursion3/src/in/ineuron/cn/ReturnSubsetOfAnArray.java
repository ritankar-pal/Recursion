package in.ineuron.cn;

public class ReturnSubsetOfAnArray {

	public static int[][] subsets(int[] input, int index){

		//base case:
		if(index == input.length){
			return new int[1][0];
		}

		int[][] child = subsets(input, index+1);

		if(index == input.length-1){
			child[0] = new int[1]; 
			child[0][0] = input[index];
			return child;
		}

		int[][] temp = child;	
		child = new int[temp.length * 2 + 1][];	

		int i = 0;
		for(; i < temp.length; i++){
			child[i] = new int[temp[i].length];
			for(int j = 0; j < temp[i].length; j++){
				child[i][j] = temp[i][j];
			}
		}

		int k = 0;
		for(; i < child.length-1; i++){

			child[i] = new int[temp[k].length + 1];
			child[i][0] = input[index];
			for(int j = 0; j < temp[k].length; j++){
				child[i][j+1] = temp[k][j];
			}
			k++;
		}
		//filling the last index with the inout[index]:
		child[child.length-1] = new int[1];
		child[child.length-1][0] = input[index];
		return child;
	}

	// Return a 2D array that contains all the subsets
	public static int[][] subsets(int input[]) {
		// Write your code here
		return subsets(input, 0);
	}
}
