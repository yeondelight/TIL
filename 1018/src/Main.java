import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public void sol_1002() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int r1 = Integer.parseInt(st.nextToken());
			
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int r2 = Integer.parseInt(st.nextToken());
			
			int dist = (x2 - x1)*(x2 - x1) + (y2 - y1)*(y2 - y1);	// 조규현과 백승환의 거리^2
			int rSum = (r1 + r2)*(r1 + r2);
			int rDif = (r1 - r2)*(r1 - r2);
			
			if (dist == 0 && r1 == r2)				sb.append("-1");
			else if (dist > rSum || dist < rDif)	sb.append('0');
			else if (dist == rSum || dist == rDif)	sb.append('1');
			else									sb.append('2');
			
			sb.append('\n');
		}
		
		System.out.println(sb);
	}

	public static void main(String[] args) throws Exception {
		new Main().sol_1002();
	}
}
