import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class IntervalListIntersections {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());

	}

	public int[][] intervalIntersection(int[][] A, int[][] B) {
		List<int[]> ans = new ArrayList();
	    int i = 0, j = 0;

	    while (i < A.length && j < B.length) {
	      // Let's check if A[i] intersects B[j].
	      // lo - the startpoint of the intersection
	      // hi - the endpoint of the intersection
	      int lo = Math.max(A[i][0], B[j][0]);
	      int hi = Math.min(A[i][1], B[j][1]);
	      if (lo <= hi)
	        ans.add(new int[]{lo, hi});

	      // Remove the interval with the smallest endpoint
	      if (A[i][1] < B[j][1])
	        i++;
	      else
	        j++;
	    }

	    return ans.toArray(new int[ans.size()][]);
	}

}
