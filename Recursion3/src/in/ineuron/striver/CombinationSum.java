package in.ineuron.striver;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
	
	private void possibleSubSequences(int[] nums, int target, int index, List<List<Integer>> subSets, List<Integer> list) {
		
		if(target == 0) {
			subSets.add(new ArrayList<>(list));
			return;
		}
		
		for(int i = index; i < nums.length; i++) {
			if(i != index && nums[i] == nums[i-1]) continue;
			
			if(nums[i] > target) break;
			
			list.add(nums[i]);
			possibleSubSequences(nums, target - nums[i], index+1, subSets, list);
			list.remove(list.size()-1);
		}
		
	}
	
	public List<List<Integer>> possibleCombinaionSum(int[] nums, int target){
		
		List<List<Integer>> subSets = new ArrayList<>();
		
		possibleSubSequences(nums, target, 0, subSets, new ArrayList<>());
		
		return subSets;
	}

	
}
