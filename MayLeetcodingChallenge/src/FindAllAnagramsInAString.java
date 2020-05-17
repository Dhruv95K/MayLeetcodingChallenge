import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

Strings consists of lowercase English letters only and the length of both strings s and p will not be 
larger than 20,100.

The order of output does not matter.

Example 1:	
	Input:
	s: "cbaebabacd" p: "abc"
	
	Output:
	[0, 6]

Explanation:
	The substring with start index = 0 is "cba", which is an anagram of "abc".
	The substring with start index = 6 is "bac", which is an anagram of "abc".

Example 2:
	Input:
	s: "abab" p: "ab"
	
	Output:
	[0, 1, 2]

Explanation:
	The substring with start index = 0 is "ab", which is an anagram of "ab".
	The substring with start index = 1 is "ba", which is an anagram of "ab".
	The substring with start index = 2 is "ab", which is an anagram of "ab".
*/

public class FindAllAnagramsInAString {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String text = br.readLine();
		String pat = br.readLine();
		
		System.out.println(findAnagrams(text, pat));
		
	}
	
	static boolean compare(char arr1[], char arr2[]) { 
        for (int i = 0; i < 256; i++) 
            if (arr1[i] != arr2[i]) 
                return false; 
        return true; 
    } 
    
    public static List<Integer> findAnagrams(String txt, String pat) {
        List<Integer> ans = new ArrayList<>();
        int M = pat.length(); 
        int N = txt.length(); 
  
        if(M>N)
            return ans;
        
        char[] countP = new char[256]; 
        char[] countTW = new char[256]; 
        for (int i = 0; i < M; i++) 
        { 
            (countP[pat.charAt(i)])++; 
            (countTW[txt.charAt(i)])++; 
        } 
  
        
        for (int i = M; i < N; i++) 
        { 
            if (compare(countP, countTW)) 
                ans.add(i-M);
              
            (countTW[txt.charAt(i)])++; 
  
            countTW[txt.charAt(i-M)]--; 
        } 
  
        if (compare(countP, countTW)) 
            ans.add(N-M);
        
        return ans;
            
    }

}
