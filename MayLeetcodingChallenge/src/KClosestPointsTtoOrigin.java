import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
We have a list of points on the plane.  Find the K closest points to the origin (0, 0).
(Here, the distance between two points on a plane is the Euclidean distance.)
You may return the answer in any order.  The answer is guaranteed to be unique (except for the order that it is in.)

Example 1:
	Input: points = [[1,3],[-2,2]], K = 1
	Output: [[-2,2]]
	Explanation: 
	The distance between (1, 3) and the origin is sqrt(10).
	The distance between (-2, 2) and the origin is sqrt(8).
	Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
	We only want the closest K = 1 points from the origin, so the answer is just [[-2,2]].

Example 2:
	Input: points = [[3,3],[5,-1],[-2,4]], K = 2
	Output: [[3,3],[-2,4]]
	(The answer [[-2,4],[3,3]] would also be accepted.)
 

Note:
	1. 1 <= K <= points.length <= 10000
	2. -10000 < points[i][0] < 10000
	3. -10000 < points[i][1] < 10000
*/

public class KClosestPointsTtoOrigin {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int[][] points = new int[n][2];
		String[] input;
		for (int i = 0; i < n; i++) {
			input = br.readLine().split(",");
			points[i][0] = Integer.parseInt(input[0]);
			points[i][1] = Integer.parseInt(input[1]);
		}
		
		int K = Integer.parseInt(br.readLine());
		
		System.out.println(kClosest(points, K));
	}

	static class pair {
		int X, Y;

		pair(int x, int y) {
			X = x;
			Y = y;
		}
	}

	public static int[][] kClosest(int[][] a, int b) {
		int n = a.length;
		pair d[] = new pair[n];
		for (int i = 0; i < n; i++)
			d[i] = new pair(a[i][0], a[i][1]);
		Arrays.sort(d, (pair u, pair v) -> {
			long x = 1L * u.X * u.X + 1L * u.Y * u.Y;
			long y = 1L * v.X * v.X + 1L * v.Y * v.Y;
			if (x == y)
				return 0;
			return (x < y) ? -1 : 1;
		});
		int ans[][] = new int[b][2];
		for (int i = 0; i < b; i++) {
			ans[i][0] = d[i].X;
			ans[i][1] = d[i].Y;
		}
		return ans;
	}

}
