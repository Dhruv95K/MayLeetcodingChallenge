import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/*
You're given strings J representing the types of stones that are jewels, and S representing the 
stones you have.  Each character in S is a type of stone you have.  You want to know how many of the 
stones you have are also jewels.

The letters in J are guaranteed distinct, and all characters in J and S are letters. Letters are case 
sensitive, so "a" is considered a different type of stone from "A".

Example 1:
	Input: J = "aA", S = "aAAbbbb"
	Output: 3

Example 2:
	Input: J = "z", S = "ZZ"
	Output: 0

Note:
	1. S and J will consist of letters and have length at most 50.
	2. The characters in J are distinct.
*/

public class JewelsAndStones {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String J = br.readLine();
		String S= br.readLine();
		
		System.out.println(numJewelsInStones(J, S));

	}

	public static int numJewelsInStones(String J, String S) {
        Set<Character> jewels = new HashSet<>();
        
        for(char c : J.toCharArray())
            jewels.add(c);
        
        int count = 0;
        for(char c : S.toCharArray())
            if(jewels.contains(c))
                count++;
        
        return count;
    }
}
