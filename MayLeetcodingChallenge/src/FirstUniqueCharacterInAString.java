import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/*
Given a string, find the first non-repeating character in it and return it's index. If it 
doesn't exist, return -1.

Examples:
	s = "leetcode"
	return 0.

	s = "loveleetcode",
	return 2.
			
Note: You may assume the string contain only lowercase letters.
*/
public class FirstUniqueCharacterInAString {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		
		System.out.println(firstUniqChar(s));

	}
	
	public static int firstUniqChar(String s) {
        Map<Character,Integer> map = new HashMap<>();
        for(char c : s.toCharArray()){
            map.put(c,map.getOrDefault(c,0) + 1);
        }
        
        int i = 0;
        for(char c : s.toCharArray()){
            if(map.get(c) == 1)
                return i;
            
            i++;
        }
        
        return -1;
    }

}
