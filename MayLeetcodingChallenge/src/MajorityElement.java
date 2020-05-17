import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
Given an array of size n, find the majority element. 
The majority element is the element that appears more than ⌊ n/2 ⌋ times.
You may assume that the array is non-empty and the majority element always exist in the array.

Example 1:
	Input: [3,2,3]
	Output: 3

Example 2:	
	Input: [2,2,1,1,1,2,2]
	Output: 2
*/
public class MajorityElement {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		String[] input = br.readLine().split(" ");
		int[] arr = new int[n];
		for(int i = 0;i < n;i++)	
			arr[i] = Integer.parseInt(input[i]);
		
		System.out.print(majorityElement(arr));
	}
	
    public static int majorityElement(int[] nums) {
        int maj = nums[0];
        int cnt = 1;
        
        for(int i = 1;i<nums.length;i++){
            if(nums[i] == maj)
                cnt++;
            else{
                cnt--;
                if(cnt == 0){
                    cnt = 1;
                    maj = nums[i];
                }
            }
        }
        
        cnt = 0;
        
       
            return maj;
        
        
    }

}
