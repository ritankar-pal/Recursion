package in.dsa;

public class Factorial {
	
	public static int factoral(int num) {
		
		if(num <= 1)
			return 1;
		
		int fact = factoral(num-1);
		
		int multiply = num * fact;
		
		return multiply;
	}
	

	public static void main(String[] args) {
		
		System.out.println(factoral(0));;
	}

}
