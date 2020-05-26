import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/*Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.

Example 1:
	Input: [0,1]
	Output: 2
	Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.

Example 2:
	Input: [0,1,0]
	Output: 2
	Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
	Note: The length of the given binary array will not exceed 50,000.
*/
public class ContiguousArray {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		String[] input = br.readLine().split(" ");
		int[] arr = new int[n];
		for(int i = 0;i < n;i++)	
			arr[i] = Integer.parseInt(input[i]);
		
		System.out.println(findMaxLength(arr));
		
	}

	public static int findMaxLength(int[] nums) {
		int n = nums.length;
		for(int i = 0 ; i < n; i++)
			if(nums[i] == 0)
				nums[i] = -1;
		
		int ans = 0;
		int sum = 0;
		Map<Integer,Integer> map = new HashMap<>();
		
		for(int i = 0;i<n;i++) {
			sum += nums[i];
			
			if(sum == 0)
				ans = Math.max(ans, i+1);
			else{
				Integer c = map.get(sum);
				if(c != null) 
					ans = Math.max(ans,i - c);
				else
					map.put(sum, i);
			}
		}
		
		return ans;
	}

}
