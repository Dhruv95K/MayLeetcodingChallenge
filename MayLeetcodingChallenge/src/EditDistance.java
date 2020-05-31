import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.

You have the following 3 operations permitted on a word:

Insert a character
Delete a character
Replace a character

Example 1:	
	Input: word1 = "horse", word2 = "ros"
	Output: 3
	Explanation: 
	horse -> rorse (replace 'h' with 'r')
	rorse -> rose (remove 'r')
	rose -> ros (remove 'e')

Example 2:
	Input: word1 = "intention", word2 = "execution"
	Output: 5
	Explanation: 
	intention -> inention (remove 't')
	inention -> enention (replace 'i' with 'e')
	enention -> exention (replace 'n' with 'x')
	exention -> exection (replace 'n' with 'c')
	exection -> execution (insert 'u')
*/

public class EditDistance {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String word1 = br.readLine();
		String word2 = br.readLine();
		
		System.out.println(minDistance(word1,word2));
	}

	public static int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        
        int[][] dp = new int[n+1][m+1];
        
        for(int i = 0;i<=n;i++) {
        	for(int j = 0;j<=m;j++) {
        		if(i==0) {
        			dp[i][j] = j;
        			continue;
        		}
        		
        		if(j==0) {
        			dp[i][j] = i;
        			continue;
        		}
        		
        		int match = dp[i-1][j-1];
        		int mismatch = dp[i-1][j-1] + 1;
        		int ins = dp[i][j-1] + 1;
        		int del = dp[i-1][j] + 1;
        		
        		if(word1.charAt(i - 1) == word2.charAt(j - 1))
        			dp[i][j] = Math.min(match, Math.min(ins, del));
        		else
        			dp[i][j] = Math.min(mismatch, Math.min(ins, del));
        	}
        }
        	
        return dp[n][m];
    }
}
