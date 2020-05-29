import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary 
representation and return them as an array.

Example 1:

Input: 2
Output: [0,1,1]
Example 2:

Input: 5
Output: [0,1,1,2,1,2]
Follow up:

It is very easy to come up with a solution with run time O(n*sizeof(integer)). But can you do it in linear time O(n) /possibly in a single pass?
Space complexity should be O(n).
Can you do it like a boss? Do it without using any builtin function like __builtin_popcount in c++ or in any other language.
*/

public class CountingBits {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		System.out.println(countBits(n));
	}

	public static int[] countBits(int num) {
        if(num==0)
            return new int[]{0};
        int[] bits = new int[num+1];
        bits[0] = 0;
        bits[1] = 1;
        
        for(int i=2;i<=num;i++){
            if(i%2==0)
                bits[i] = bits[i/2];
            else
                bits[i] = bits[i-1]+1;
        }
        
        return bits;
        
    }
}
