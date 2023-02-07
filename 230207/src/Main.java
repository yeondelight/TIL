import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public int getGcd(int a, int b) {
		while (b != 0) {
			int r = a % b;
			a = b;
			b = r;
		}
		return a;
	}
	
	public int getLcd(int a, int b) {
		return a * b / getGcd(a, b);
	}
	
	public void sol_12871() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		String t = br.readLine();
		
		int lcd;
		if (s.length() < t.length())	lcd = getLcd(s.length(), t.length());
		else							lcd = getLcd(t.length(), s.length());
		
		int sLen = lcd / s.length();
		int tLen = lcd / t.length();
		
		String newS = "";
		String newT = "";
		
		for (int i = 0; i < sLen; i++)	newS += s;
		for (int i = 0; i < tLen; i++)	newT += t;
		
		if (newS.equals(newT))	System.out.println(1);
		else					System.out.println(0);
	}
	
	public void sol_14582() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[][] score = new int[9][2];
		
		for (int i = 0; i < 2; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				score[j][i] = Integer.parseInt(st.nextToken());
			}
		}
		
		int ullim = 0;
		int start = 0;
		boolean flag = false;
		for (int i = 0; i < 9; i++) {
			ullim += score[i][0];
			if (ullim > start) {
				flag = true;
				break;
			}
			start += score[i][1];
		}
		
		if (flag)	System.out.println("Yes");
		else		System.out.println("No");
	}
	
	public void sol_14912() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		
		int cnt = 0;
		
		for (int i = 1; i <= n; i++) {
			int curr = i;
			while (curr > 0) {
				int val = curr % 10;
				if (val == d) {
					cnt++;
				}
				curr /= 10;
			}
		}
		
		System.out.println(cnt);
	}
	
	public void sol_1051() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		char[][] map = new char[N][M];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		int maxSize = Math.min(N, M);
		int ansSize = 1;
		
		// size + 1만큼의 크기를 갖는 정사각형 판독
		for (int size = 1; size < maxSize; size++) {
			// 탐색 시작점은 (i, j)임
			SearchLoop:
			for (int i = 0; i < N - size; i++) {
				for (int j = 0; j < M - size; j++) {
					if (map[i][j] == map[i+size][j]
							&& map[i+size][j] == map[i][j+size]
							&& map[i][j+size] == map[i+size][j+size]) {
						ansSize = size+1;
						break SearchLoop;	// 시간 절약을 위해 break
					}
				}
			}
		}
		
		System.out.println(ansSize * ansSize);
	}
	
	public void sol_1205() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int taesu = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		
		if (N == 0) {		// 랭킹에 아무도 없으면 태수가 1등
			System.out.println(1);
			return;
		}
		
		
		// scan scores
		int[] score = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			score[i] = Integer.parseInt(st.nextToken());
		}	
		
		
		// check ranking
		if (N >= P) {		// 태수가 랭킹에 못들어가는 경우
			if (score[P-1] >= taesu) {
				System.out.println(-1);
				return;
			}
		}
		
		int fore = 1;		// 태수보다 점수가 높은 사람의 수
		for (int i = 0; i < N; i++) {
			if (score[i] > taesu) {
				fore++;
			} else {
				break;
			}
		}
		
		System.out.println(fore);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_1205();
	}
}
