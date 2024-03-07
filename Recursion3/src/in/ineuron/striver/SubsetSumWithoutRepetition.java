package in.ineuron.striver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetSumWithoutRepetition {
	
	private void findSubSets(int index, int[] nums, ArrayList<List<Integer>> ansList, List<Integer> list) {
		
		ansList.add(new ArrayList<>(list));
		
		for(int i = index; i < nums.length; i++) {
			if(i != index && nums[i] == nums[i-1]) continue;
			list.add(nums[i]);
			
			findSubSets(index+1, nums, ansList, list);
			list.remove(list.size()-1);
		}
		
	}
	
	public List<List<Integer>> subsWithoutDuplicates(int[] nums){
		
		Arrays.sort(nums);
		
		ArrayList<List<Integer>> ansList = new ArrayList<>();
		findSubSets(0, nums, ansList, new ArrayList<>());
		
		return null;
	}

}
