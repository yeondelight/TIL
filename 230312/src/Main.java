import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	class Point {
		
		int x;
		int y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		public int getDistance(Point p) {
			return (int) (Math.pow(this.x - p.x, 2) + Math.pow(this.y - p.y, 2)) ;
		}
	}
	
	public void sol_1004() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			StringTokenizer stPoint = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(stPoint.nextToken());
			int y1 = Integer.parseInt(stPoint.nextToken());
			int x2 = Integer.parseInt(stPoint.nextToken());
			int y2 = Integer.parseInt(stPoint.nextToken());
			Point start = new Point(x1, y1);
			Point end = new Point(x2, y2);
			
			int innerCircle = 0;
			
			int n = Integer.parseInt(br.readLine());
			for (int i = 0; i < n; i++) {
				StringTokenizer stCircle = new StringTokenizer(br.readLine());
				int cx = Integer.parseInt(stCircle.nextToken());
				int cy = Integer.parseInt(stCircle.nextToken());
				int r = (int) Math.pow(Integer.parseInt(stCircle.nextToken()), 2);
				Point c = new Point(cx, cy);
				
				int sDis = start.getDistance(c);
				int eDis = end.getDistance(c);
				
				if (sDis < r && eDis < r) {
					continue;
				}
				
				if (sDis < r)	innerCircle++;
				if (eDis < r)	innerCircle++;
			}
			
			sb.append(innerCircle).append('\n');
		}
		
		System.out.println(sb);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_1004();
	}
}
