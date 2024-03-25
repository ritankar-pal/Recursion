package in.ineuron.cn.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PalindromePartitioning {
	
	public List<List<String>> partition(String s){
		
		List<List<String>> ansList = new ArrayList<>();
		
		int index = 0;
		partitionHelper(s, index, new ArrayList<>(), ansList);
		
		HashMap<Integer, Integer> hashMap = new HashMap<>();
		
//		hashMap.get(hashMap);
		
		return ansList;
	}

	private void partitionHelper(String s, int index, List<String> list, List<List<String>> ansList) {
		
		if(index == s.length()) {
			ansList.add(new ArrayList<>(list));
			return;
		}
		
		for (int i = index; i < s.length(); i++) {
			if(isPalindrome(s, index, i)) {
				list.add(s.substring(index, i+1));
				partitionHelper(s, i+1, list, ansList);
				list.remove(list.size()-1);
			}
		}
		
	}

	private boolean isPalindrome(String s, int start, int end) {
		
		while(start <= end) {
			if(s.charAt(start) != s.charAt(end)) return false;
			start++;
			end--;
		}
		
		return true;
	}
}
