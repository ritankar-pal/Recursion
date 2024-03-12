package in.ineuron.cn;

public class StringPermutation {

	public static String[] stringPermutationHelper(String input, String res, boolean[] check, String[] arr){

		//base case;
		if(res.length() == input.length()){
			// System.out.println(res);
			String[] temp = arr;
			arr = new String[temp.length+1];
			for(int i = 0; i < temp.length; i++){
				arr[i] = temp[i];
			}
			arr[arr.length-1] = res;
			return arr;
		}

		for(int i = 0; i < input.length(); i++){
			if(!check[i]){
				res = res + input.charAt(i);
				check[i] = true;

				arr = stringPermutationHelper(input, res, check,  arr); 

				check[i] = false;
				res = res.substring(0, res.length()-1);
			}
		}

		return arr;

	}

	public static String[] permutationOfString(String input){
		// Write your code here
		String res = "";
		String[] arr = new String[0];
		boolean[] check = new boolean[input.length()];
		return stringPermutationHelper(input, res, check, arr);
	}
}
