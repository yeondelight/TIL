import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public int getGCD (int a, int b) {
		if (b == 0)		return a;
		return getGCD (b,  a%b);
	}

	public void sol_9613() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
				
		while (t > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int[] num = new int[n];
			for (int i = 0; i < n; i++) {
				num[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(num);
			
			long sum = 0;
			for (int i = n-1; i > 0; i--) {
				for (int j = i-1; j >= 0; j--) {
					sum += getGCD(num[i], num[j]);
				}
			}
			
			sb.append(sum).append('\n');
			t--;
		}
		
		System.out.println(sb);
	}
	
	public void sol_10158() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer stWH = new StringTokenizer(br.readLine());
		int w = Integer.parseInt(stWH.nextToken());
		int h = Integer.parseInt(stWH.nextToken());
		
		StringTokenizer stPQ = new StringTokenizer(br.readLine());
		int p = Integer.parseInt(stPQ.nextToken());
		int q = Integer.parseInt(stPQ.nextToken());
		
		int t = Integer.parseInt(br.readLine());
		
		int x;
		int xDIV = (t - (w - p)) / w;
		int xMOD = (t - (w - p)) % w;
		if (t - (w - p) < 0)	x = p + t;
		else if (xDIV % 2 == 0)	x = w - xMOD;
		else					x = xMOD;

		int y;
		int yDIV = (t - (h - q)) / h;
		int yMOD = (t - (h - q)) % h;
		if (t - (h - q) < 0)	y = q + t;
		else if (yDIV % 2 == 0)	y = h - yMOD;
		else					y = yMOD;
		
		StringBuilder sb = new StringBuilder();
		sb.append(x).append(' ').append(y);
		System.out.println(sb);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_10158();
	}
}
