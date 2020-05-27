import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Given a set of N people (numbered 1, 2, ..., N), we would like to split everyone into two groups of any size.
Each person may dislike some other people, and they should not go into the same group. 
Formally, if dislikes[i] = [a, b], it means it is not allowed to put the people numbered a and b into the same group.
Return true if and only if it is possible to split everyone into two groups in this way.

Example 1:
	Input: N = 4, dislikes = [[1,2],[1,3],[2,4]]
	Output: true
	Explanation: group1 [1,4], group2 [2,3]
		
Example 2:
	Input: N = 3, dislikes = [[1,2],[1,3],[2,3]]
	Output: false

Example 3:
	Input: N = 5, dislikes = [[1,2],[2,3],[3,4],[4,5],[1,5]]
	Output: false
 
Note:
	1. 1 <= N <= 2000
	2. 0 <= dislikes.length <= 10000
	3. 1 <= dislikes[i][j] <= N
	4. dislikes[i][0] < dislikes[i][1]
	5. There does not exist i != j for which dislikes[i] == dislikes[j].
*/

public class PossibleBipartition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	Map<Integer,List<Integer>> map;
	Map<Integer,Integer> color;
	
	public boolean possibleBipartition(int N, int[][] dislikes) {
		 map = new HashMap<Integer, List<Integer>>();
		 
		 for(int[] edge : dislikes) {
			 if(map.get(edge[0]) == null)
				 map.put(edge[0], new ArrayList());
			 map.get(edge[0]).add(edge[1]);
			 
			 if(map.get(edge[1]) == null)
				 map.put(edge[1], new ArrayList());
			 map.get(edge[1]).add(edge[0]);
		 }
		 
		 color = new HashMap<Integer, Integer>();
		 
		 for(int node = 1;node<=N;node++)
			 if(!color.containsKey(node) && !dfs(node,0))
				 return false;
		 
		 return true;
	}

	private boolean dfs(int node, int c) {
		if(color.containsKey(node))
			return color.get(node) == c;
		
		color.put(node, c);
		
		if(map.get(node) == null)
            return true;
		
		for(int neighbour : map.get(node))
			if(!dfs(neighbour,c ^ 1))
				return false;
		
		return true;
	}

}
