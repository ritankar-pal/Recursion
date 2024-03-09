package in.ineuron.cn;


public class PrintSubsequences {

	public void generateSubsequences(String word){
		String res = "";
		subsequenceHelper(word, 0, res);
	}

	private void subsequenceHelper(String word, int index, String res) {
		
		System.out.println(res);
		
		for(int i = index; i < word.length(); i++) {
			res = res + word.charAt(i);
	
			subsequenceHelper(word, i+1, res);
			
			if(res.length() == 1) res = "";
			else res = res.substring(0, res.length()-1);
		}
		
	}
}
