import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public void sol_16967() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());
		
		int[][] B = new int[H+X][W+Y];
		for (int i = 0; i < H+X; i++) {
			 StringTokenizer stB = new StringTokenizer(br.readLine());
			 for (int j = 0; j < W+Y; j++) {
				 B[i][j] = Integer.parseInt(stB.nextToken());
			 }
		}
		
		// get A
		int[][] A = new int[H][W];
		for (int i = 0; i < H+X; i++) {
			 for (int j = 0; j < W+Y; j++) {
				 // B의 고유영역인 경우 패스
				 if ( (i >= H && j < Y) || (i < X && j >= W) ) {
					 continue;
				 }
				 // 둘 다 포함
				 else if ((X <= i && i < H) && (Y <= j && j < W)) {
					 A[i][j] = Math.abs(A[i-X][j-Y] - B[i][j]);
				 }
				 // 둘 중 한 곳에만 포함
				 else {
					 int ai, aj;
					 if (i < H && j < W) {
						 ai = i;
						 aj = j;
					 } else {
						 ai = i-X;
						 aj = j-Y;
					 }
					 A[ai][aj] = B[i][j];
				 }
			 }
		}
		
		
		// print
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				sb.append(A[i][j]).append(' ');
			}
			sb.append('\n');
		}
		
		System.out.println(sb);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_16967();
	}
}
