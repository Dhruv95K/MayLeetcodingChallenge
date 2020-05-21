import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CountSquareSubmatricesWithAllOnes {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());

		String[] input;
		int[][] arr = new int[n][m];
		for (int i = 0; i < n; i++) {
			input = br.readLine().split(",");
			for (int j = 0; j < m; j++)
				arr[i][j] = Integer.parseInt(input[j]);
		}

		System.out.println(countSquares(arr));

	}

	public static int countSquares(int[][] matrix) {
		int sq = 0;
		int n = matrix.length;
		int m = matrix[0].length;

		if (n == 0)
			return 0;

		int[][] dp = new int[n][m];
		for (int i = 0; i < n; i++) {
			if (matrix[i][0] == 1) {
				dp[i][0] = 1;
				sq++;
			}
		}

		for (int i = 0; i < m; i++) {
			if (matrix[0][i] == 1) {
				dp[0][i] = 1;
				sq++;
			}
		}

		for (int i = 1; i < n; i++) {
			for (int j = 1; j < m; j++) {
				if (matrix[i][j] == 1)
					dp[i][j] = 1 + Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1]));

				sq += dp[i][j];
			}
		}

		return sq;
	}

}
