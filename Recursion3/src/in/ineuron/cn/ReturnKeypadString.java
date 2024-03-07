package in.ineuron.cn;

public class ReturnKeypadString {
	
	public static String getCorrespondingString(int digit){

		String res = "";

		switch(digit){
			case 2: 
				res = "abc"; break;
			case 3: 
				res = "def"; break;
			case 4:
				res = "ghi"; break;
			case 5: 
				res = "jkl"; break;
			case 6:
				res = "mno"; break;
			case 7:
				res = "pqrs"; break;
			case 8:
				res = "tuv"; break;
			case 9:
				res = "wxyz"; break;
			default:
				res = ""; break;
		}
		return res;
	}


	// Return a string array that contains all the possible strings
	public static String[] keypad(int n){ //23
		// Write your code here

		//base case: 
		if(n == 0 || n == 1) return new String[]{""};

		int lastDigit = n % 10;  //3 2

		String lastDigitString = getCorrespondingString(lastDigit);  //3: def, 2: abc

		String[] arr = keypad(n/10); // [""], ["a", "b", "c"]

		String[] output = new String[lastDigitString.length() * arr.length];

		int k = 0;

		for(int j = 0; j < arr.length; j++){

			for(int i = 0; i < lastDigitString.length(); i++){
				output[k] = arr[j] + lastDigitString.charAt(i);
				k++;
			}

		}

		return output;

	}
}
