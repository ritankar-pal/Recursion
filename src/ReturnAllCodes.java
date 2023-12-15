import java.util.List;
import java.util.ArrayList;

public class ReturnAllCodes {

	public static void generateCode(String remaining, String code, List<String> list){

		if(remaining.isEmpty()){
			list.add(code);
			return;
		}

		int firstDigit = Integer.parseInt(remaining.substring(0,1));
		char firstChar = (char)('a' + firstDigit - 1);

		generateCode(remaining.substring(1), code+firstChar, list);

		if(remaining.length() >= 2){
			int firstTwoDigit = Integer.parseInt(remaining.substring(0,2));
			if(firstTwoDigit >= 10 && firstTwoDigit <= 26){
				char firstTwoChar = (char)('a' + firstTwoDigit - 1);
				generateCode(remaining.substring(2), code+firstTwoChar, list);
			}
		}

	}
	
	public static  String[] getCode(String input){
		// Write your code here

		List<String> list = new ArrayList<>();

		generateCode(input, "", list);

		String[] output = new String[list.size()];

		for(int i = 0; i < list.size(); i++){
			output[i] = list.get(i);
		}

		return output;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
		String s = "123";
		
		String[] arr = getCode(s);
		
		for (String string : arr) {
			System.out.println(string);
		}
		
	}

}
