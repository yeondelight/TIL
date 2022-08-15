import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	class Point {
		double x;
		double y;
		Point(double x, double y){
			this.x = x;
			this.y = y;
		}
	}
	
	public void sol_2166() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Point[] p = new Point[N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			double x = Double.parseDouble(st.nextToken());
			double y = Double.parseDouble(st.nextToken());
			p[i] = new Point(x, y);
		}
		
		// Calculate
		double area = 0;
		for (int i = 1; i < N-1; i++) {
			Point a = new Point(p[i].x - p[0].x, p[i].y - p[0].y);
			Point b = new Point(p[i+1].x - p[0].x, p[i+1].y - p[0].y);
			area += (a.x*b.y - b.x*a.y) / 2.0;
		}
		
		System.out.println(String.format("%.1f", Math.abs(area)));
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_2166();
	}
}
