import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class SortCharactersByFrequency {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();

		System.out.println(frequencySort(s));
	}

	static int MAX = 256;

	public static String frequencySort(String s) {
		Map<Character,Integer> map = new HashMap<>();
		
		TreeMap<Character,Integer> sortedMap = new TreeMap<>(new Comparator<Character>() {
			@Override
			public int compare(Character o1, Character o2) {
				if(map.get(o2) <= map.get(o1))
					return -1;
				
				return map.get(o2) - map.get(o1);
			}
		});
		
		for(char c : s.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}
		
		for(char c: map.keySet())
			sortedMap.put(c,map.get(c));
				
		StringBuilder sb = new StringBuilder();
		for(Character c : sortedMap.keySet())
			for(int i = 0 ; i<map.get(c);i++)
				sb.append(c);
		
		return sb.toString();
	}
}

