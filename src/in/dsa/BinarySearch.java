package in.dsa;

public class BinarySearch {
	
	public static int binarySearch(int[] arr, int k, int start, int end) {
		
		if(start > end)
			return -1;
		
		int mid = (start + end)/2;
		
		if(arr[mid] == k) 
			return mid;
		else if(arr[mid] < k) {
			return binarySearch(arr, k, mid+1, end);
		}
		else {
			return binarySearch(arr, k, start, mid-1);
		}
		
	}
	
	public static void main(String... args) {
		
		int[] arr = {1,2,3,4,5,77,87,100};
				
		int target = 101;
		
		System.out.println(binarySearch(arr, target, 0, arr.length-1));
	}
	
}
