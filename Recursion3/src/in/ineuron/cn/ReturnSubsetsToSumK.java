package in.ineuron.cn;

public class ReturnSubsetsToSumK {

	private static int[][] copyToNew2DArray(int[][] output, int[] arr){

		int[][] temp = output;

		if(output.length < 1){
			output = new int[1][arr.length];

			//copying the one and only first element:
			for(int i = 0; i < arr.length; i++){
				output[0][i] = arr[i];
			}
		}
		else{
			output = new int[temp.length + 1][];

			for(int i = 0; i < temp.length; i++){
				output[i] = new int[temp[i].length];
				for(int j = 0; j < temp[i].length; j++){
					output[i][j] = temp[i][j];
				}
			}

			//copying the last element:
			output[output.length-1] = new int[arr.length];
				for(int i = 0; i < arr.length; i++){
					output[output.length-1][i] = arr[i];
			}
		}

		return output;
	}

	private static int[] addANewElement(int[] input, int index, int[] arr){

		int[] temp = arr;
		arr = new int[temp.length+1];
		
		if(temp.length > 0){
			for(int i = 0; i < temp.length; i++){
				arr[i] = temp[i];
			}
			arr[arr.length-1] = input[index];
		}
		else arr[0] = input[index];

		return arr;
	}

	private static int[] removeLastElement(int[] arr){

		int[] temp = arr;
		arr = new int[temp.length-1];

		if(temp.length > 1){
			for(int i = 0; i < arr.length; i++){
				arr[i] = temp[i];
			}
		}
		return arr;
	}

	private static int[][] subsetSumHelper(int[] input, int k, int[][] output, int index, int sum, int[] arr){
		
		//base case:
		if(index == input.length){
			if(sum == k){
				return copyToNew2DArray(output, arr);
			}
			return output;
		}

		//take:
		sum = sum + input[index];
		arr = addANewElement(input, index, arr);  //adding the arr[index] in the given arr:

		int[][] left = subsetSumHelper(input, k, output, index+1, sum, arr); 

		//not take:
		sum = sum - input[index];
		arr = removeLastElement(arr);
		
		return subsetSumHelper(input, k, left, index+1, sum, arr); 
	}


	// Return a 2D array that contains all the subsets which sum to k
	public static int[][] subsetsSumK(int input[], int k) {
		// Write your code here
		int[][] output = new int[0][];
		int[] arr = new int[0];
		return subsetSumHelper(input, k, output, 0, 0, arr);

	}
}
