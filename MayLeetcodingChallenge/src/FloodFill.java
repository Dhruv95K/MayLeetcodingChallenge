import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
An image is represented by a 2-D array of integers, each integer representing the pixel value of the image 
(from 0 to 65535).
Given a coordinate (sr, sc) representing the starting pixel (row and column) of the flood fill, and 
a pixel value newColor, "flood fill" the image.

To perform a "flood fill", consider the starting pixel, plus any pixels connected 4-directionally to the 
starting pixel of the same color as the starting pixel, plus any pixels connected 4-directionally to those 
pixels (also with the same color as the starting pixel), and so on. Replace the color of all of the 
aforementioned pixels with the newColor.

At the end, return the modified image.

Example 1:
	Input: 
	image = [[1,1,1],[1,1,0],[1,0,1]]
	sr = 1, sc = 1, newColor = 2
	Output: [[2,2,2],[2,2,0],[2,0,1]]
Explanation: 
	From the center of the image (with position (sr, sc) = (1, 1)), all pixels connected 
	by a path of the same color as the starting pixel are colored with the new color.
	Note the bottom corner is not colored 2, because it is not 4-directionally connected
	to the starting pixel.
*/

public class FloodFill {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		
		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);
		
		int[][] arr = new int[n][m];
		
		for(int i = 0;i<n;i++) {
			input = br.readLine().split(" ");
			for(int j = 0;j<m;j++)
				arr[i][j] = Integer.parseInt(input[j]); 
		}
		
		int sr = Integer.parseInt(br.readLine());
		int sc = Integer.parseInt(br.readLine());
		int newColor = Integer.parseInt(br.readLine());
		
		System.out.println(Arrays.toString(floodFill(arr, sr, sc, newColor)));
		
	}
	
	static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    
    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int n = image.length;
        int m = image[0].length;
        int color = image[sr][sc];
        if(color == newColor)
            return image;
        
        image[sr][sc] = newColor;
        for(int i = 0;i<4;i++){
            int x = sr + dx[i];
            int y = sc + dy[i];
            
            if(x >= 0 && x < n && y >= 0 && y < m && image[x][y] == color){
                floodFill(image,x,y,newColor);
            }
        }
        
        return image;
    }

}
