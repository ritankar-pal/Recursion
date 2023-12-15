package in.dsa;

public class ReverseNum {
	
	public static int reverse(int num, int sum) {
		
		if(num == 0)
			return sum;
		
		int res = sum * 10 + (num % 10);
		
		return reverse(num/10, res);
		
	}
	
	
	public static void main(String[] args) {
		
		System.out.println(reverse(5478, 0));
	}
}
