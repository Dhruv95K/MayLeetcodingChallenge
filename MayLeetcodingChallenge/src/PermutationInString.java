import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PermutationInString {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s2 = br.readLine();
		String s1 = br.readLine();
		
		System.out.println(checkInclusion(s1, s2));

	}

	static boolean compare(char arr1[], char arr2[]) { 
        for (int i = 0; i < 256; i++) 
            if (arr1[i] != arr2[i]) 
                return false; 
        return true; 
    } 
    
    public static boolean checkInclusion(String s1, String s2) {
        int M = s1.length(); 
        int N = s2.length(); 
  
        if(M>N)
            return false;
        
        char[] count1 = new char[256]; 
        char[] count2 = new char[256]; 
        for (int i = 0; i < M; i++) 
        { 
            (count1[s1.charAt(i)])++; 
            (count2[s2.charAt(i)])++; 
        } 
  
        
        for (int i = M; i < N; i++) 
        { 
            if (compare(count1, count2)) 
                return true;
              
            (count2[s2.charAt(i)])++; 
  
            count2[s2.charAt(i-M)]--; 
        } 
  
        if (compare(count1, count2)) 
            return true;
        
        return false;
    }
}
