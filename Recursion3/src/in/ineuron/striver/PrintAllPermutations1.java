package in.ineuron.striver;

import java.util.ArrayList;
import java.util.List;

public class PrintAllPermutations1 {
	
	public List<List<Integer>> permute(int[] nums){
		
		List<List<Integer>> ans = new ArrayList<>();
		boolean[] check = new boolean[nums.length];
		
		permuteHelper(nums, ans, check, new ArrayList<>());
		
		return ans;
	}

	private void permuteHelper(int[] nums, List<List<Integer>> ans, boolean[] check, List<Integer> list) {
		
		if(list.size() == nums.length) {
			ans.add(new ArrayList<>(list));
			return;
		}
		
		for(int i = 0; i < nums.length; i++) {
			if(!check[i]) {
				list.add(nums[i]);
				check[i] = true;
				
				permuteHelper(nums, ans, check, list);
				
				list.remove(list.size()-1);
				check[i] = false;
			}
		}
		
	}
}
