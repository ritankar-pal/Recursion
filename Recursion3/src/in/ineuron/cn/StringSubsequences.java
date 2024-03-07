package in.ineuron.cn;

import java.util.ArrayList;
import java.util.List;

public class StringSubsequences {
	
	public List<String> generateSubsequences(String word){
		
		String res = "";
		List<String> list = new ArrayList<>();
		
		subsequenceHelper(word, 0, res, list);
		
		return list;
	}

	private void subsequenceHelper(String word, int index, String res, List<String> list) {
		
		//base case:
		list.add(res);
		
		for(int i = index; i < word.length(); i++) {
			
			res = res + word.charAt(i); // "a"
			
			subsequenceHelper(word, i+1, res, list);
			
			if(res.length() == 1) res = ""; 
			else res = res.substring(0, res.length()-1);
			
		}
	}
}
