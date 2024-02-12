package multi.threading.project.example;

public class TwoSum {

	
	public int[] twoSum(int[] nums, int target) {
		
		int[] index = new int[2];
		int len = nums.length;
		for(int i=0;i<len;i++) {
			for(int j=i+1;j<len;j++) {
				if(nums[i]+nums[j]==target) {
					index[0] = i;
					index[1] = j;
				}
			}
		}
		
		
		return index ;
	}
	
	public static void main(String[] args) {
		
		TwoSum two = new TwoSum();
	int [] arr	= two.twoSum(new int[] {1,2,3,4,5} ,9);
	for(int num : arr) {
		System.out.println(num);
	}
}
}
