import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
Given a non-negative integer num represented as a string, remove k digits from the number so that the new number is the smallest possible.

Note:
	The length of num is less than 10002 and will be ≥ k.
	The given num does not contain any leading zero.

Example 1:
	Input: num = "1432219", k = 3
	Output: "1219"
	Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.

Example 2:
	Input: num = "10200", k = 1
	Output: "200"
	Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.

Example 3:
	Input: num = "10", k = 2
	Output: "0"
	Explanation: Remove all the digits from the number and it is left with nothing which is 0.
*/

public class RemoveKDigits {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String num = br.readLine();
		int k = Integer.parseInt(br.readLine());
		
		System.out.println(removeKdigits(num, k));		
	}
	
	public static String removeKdigits(String num, int k) {
        int n = num.length();
        if(n==k)
            return "0";
        
        StringBuilder sb = new StringBuilder(num);
        for(int i = 0;i<sb.length() - 1;i++){
            if((sb.charAt(i) - '0') > (sb.charAt(i + 1) - '0')){
                sb.deleteCharAt(i);
                i -= 2;
                if(i<0)
                    i = -1;
                k--;
            }
            if(k==0)
                break;
        }
        
     //   String ans = sb.toString();
        
        if(k > 0)
            sb = sb .delete(sb.length() - k,sb.length());
       //     ans = sb.substring(0,sb.length() - k);
        
        while(sb.charAt(0) == '0' && sb.length() != 1)
            sb.deleteCharAt(0);
        
        return sb.toString();
    }

}
