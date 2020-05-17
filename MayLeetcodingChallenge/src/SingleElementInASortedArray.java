import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
You are given a sorted array consisting of only integers where every element appears exactly twice, except 
for one element which appears exactly once. Find this single element that appears only once.

Follow up: Your solution should run in O(log n) time and O(1) space.

Example 1:
	Input: nums = [1,1,2,3,3,4,4,8,8]
	Output: 2

Example 2:
	Input: nums = [3,3,7,7,10,11,11]
	Output: 10
 

Constraints:
	1. 1 <= nums.length <= 10^5
	2. 0 <= nums[i] <= 10^5
*/

public class SingleElementInASortedArray {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		String[] input = br.readLine().split(" ");
		int[] arr = new int[n];
		for(int i = 0;i < n;i++)	
			arr[i] = Integer.parseInt(input[i]);
		
		System.out.println(singleNonDuplicate(arr));
	}
	
	public static int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        int lo = 0,hi = n-1;
        
        while(lo <= hi){
            int mid = lo + (hi - lo)/2;
            
            if((mid == 0 || nums[mid-1] != nums[mid]) && (mid == n-1 || nums[mid] != nums[mid+1]))
                return nums[mid];
            
            if(mid % 2 == 0){
                if(nums[mid] == nums[mid+1])
                    lo = mid + 2;
                else 
                    hi = mid-1;
            }
            
            else if(mid % 2 == 1){
                if(nums[mid] == nums[mid-1])
                    lo = mid + 1;
                else 
                    hi = mid - 1;
            }
        }
        
        return -1;
    }

}
