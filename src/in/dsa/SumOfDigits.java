package in.dsa;

public class SumOfDigits {

	public static int sum(int num) {
		
		if(num == 0) 
			return 0;
		
		int lastDigit = num % 10; //6 3 1 
		
		int res = lastDigit + sum(num/10);
		
		return res;
	}
	
	public static void main(String[] args) {

		System.out.println(sum(136));
	}

}
