package in.ineuron.cn;

public class PrintKeypadString {

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
													//d  e 
	private static void printHelper(int input, String word){

		if(input == 0){
			System.out.println(word);  //ad, bd, cd, ae
			return;
		}

		int lastDigit = input % 10; //3 2

		String lastDigitString =  getCorrespondingString(lastDigit); //def abc

		for(int i = 0; i < lastDigitString.length(); i++){
			String newWord =  lastDigitString.charAt(i) + word; // d, ad, bd,cd, (e)
			printHelper(input/10, newWord);
		}

	}

	public static void printKeypad(int input){
		// Write your code here
		printHelper(input, "");
	}

}
