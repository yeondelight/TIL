import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	private static int R, C;

	public int getDistance(int direction, int diff) {

		int[] weight = {0, 0, R+C, R+C+R, R};
		
		if (direction == 2) {
			diff = R - diff;
		} else if (direction == 3) {
			diff = C - diff;
		}
		
		return weight[direction] + diff;
	}
	
	public void sol_2564() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		
		// N개의 상점
		int N = Integer.parseInt(br.readLine());
		int[] totalDis = new int[N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer stN = new StringTokenizer(br.readLine());
			int direction = Integer.parseInt(stN.nextToken());
			int diff = Integer.parseInt(stN.nextToken());
			
			totalDis[i] = getDistance(direction, diff);
		}
		
		
		// 동근
		StringTokenizer stDG = new StringTokenizer(br.readLine());
		int direction = Integer.parseInt(stDG.nextToken());
		int diff = Integer.parseInt(stDG.nextToken());

		int disDG = getDistance(direction, diff);
		
		
		// 총 길이
		int sum = 0;
		int round = (R + C) * 2;
		for (int i = 0; i < N; i++) {
			int disDiff = Math.abs(disDG - totalDis[i]);
			sum += Math.min(disDiff, round - disDiff);
		}
		
		
		// print
		System.out.println(sum);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_2564();
	}
}
