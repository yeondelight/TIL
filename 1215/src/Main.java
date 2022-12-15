import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	class Point{
		int x;
		int y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public void sol_11785() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Point[] P = new Point[4];
		for (int i = 1; i < 4; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			P[i] = new Point(x, y);
		}
		
		long S = (P[2].x - P[1].x) * (P[3].y - P[1].y) - (P[2].y - P[1].y) * (P[3].x - P[1].x);
		
		int ans;
		if (S > 0)		ans = 1;
		else if (S < 0)	ans = -1;
		else 			ans = 0;
		
		System.out.println(ans);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_11785();
	}
}
