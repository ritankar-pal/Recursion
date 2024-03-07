package in.ineuron.cn;

import java.util.List;

public class TestApp {

	public static void main(String[] args) {
		
		StringSubsequences subSeq = new StringSubsequences();
		
		String word = "abcd";
		List<String> listOfWords = subSeq.generateSubsequences(word);
		listOfWords.forEach(System.out::println);
		
//		System.out.println(word.substring(0,1));
	}

}
