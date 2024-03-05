package in.ineuron.striver;

import java.util.ArrayList;

public class SubSetSum1 {
	
	private void subsetSumHelper(int index, int sum, ArrayList<Integer> arr, ArrayList<Integer> subsetSum, int size) {
		
		if(index == size) {
			subsetSum.add(sum);
		}
		
		//take
		subsetSumHelper(index+1, sum + arr.get(index), arr, subsetSum, size);
		
		//not take:
		subsetSumHelper(index+1, sum, arr, subsetSum, size);
	}
	
	
	public ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N){
		
		ArrayList<Integer> subsetSum = new ArrayList<>();
		subsetSumHelper(0, 0, arr, subsetSum, N);
		
		subsetSum.sort((a, b) -> a-b); //sort in ascending order:
		
		return subsetSum;
	}

}
