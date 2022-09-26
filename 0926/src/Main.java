import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static int N;
	public static int max, min;
	public static int[] num, op;
	
	public void backtracking(int val, int numIdx) {
		if (numIdx == N) {
			max = Math.max(max, val);
			min = Math.min(min, val);
			return;
		}
		for (int i = 0; i < 4; i++) {
			if (op[i] > 0) {
				op[i]--;
				switch(i) {
				case 0:		// +
					backtracking(val + num[numIdx], numIdx+1);
					break;
				case 1:		// -
					backtracking(val - num[numIdx], numIdx+1);
					break;
				case 2:		// *
					backtracking(val * num[numIdx], numIdx+1);
					break;
				case 3:		// /
					backtracking(val / num[numIdx], numIdx+1);
					break;
				}
				op[i]++;
			}
		}
	}
	
	public void sol_14888() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		num = new int[N];
		op = new int[4];
		
		// get nums
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		// get ops : + - * /
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			op[i] = Integer.parseInt(st.nextToken());
		}
		
		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;
		
		backtracking(num[0], 1);
		
		System.out.println(max);
		System.out.println(min);
	
	}
	
	public static StringBuilder sb;
	
	public void printStar(int i, int j, int num) {
		if ( i / num % 3 == 1 && j / num % 3 == 1 ) {
			sb.append(' ');
		} else {
			if (num / 3 == 0)	sb.append('*');
			else				printStar(i, j, num/3);
		}
	}
	
	public void sol_2447() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				printStar(i, j, N);
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_2447();
	}
}
