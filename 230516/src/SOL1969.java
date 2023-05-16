import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.TreeMap;

class SOL1969 {
	
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public int N, M;
	public char[][] DNA;
	
	public char[] ans;
	public int ansDiff;
	
	public void run() throws Exception {
		getInput();
		solution();
		print();
	}
	
	public void getInput() throws Exception {
		StringTokenizer stNM = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stNM.nextToken());
		M = Integer.parseInt(stNM.nextToken());
		
		DNA = new char[N][M];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				DNA[i][j] = str.charAt(j);
			}
		}
	}
	
	public void solution() {
		
		ans = new char[M];
		
		// 가장 많이 나온 글자가 ans로 적용된다.
		for (int j = 0; j < M; j++) {
			TreeMap<Character, Integer> map = new TreeMap<>();
			
			for (int i = 0; i < N; i++) {
				char curr = DNA[i][j];
				if (map.containsKey(curr)) {
					map.replace(curr, map.get(curr) + 1);
				} else {
					map.put(curr, 1);
				}
			}
			
			ArrayList<Character> keySet = new ArrayList<>(map.keySet());
			keySet.sort((c1, c2) -> map.get(c2).compareTo(map.get(c1)));
			
			ans[j] = keySet.get(0);
		}
		
		// 최소 차이 구하기
		ansDiff = 0;
		for (int j = 0; j < M; j++) {
			for (int i = 0; i < N; i++) {
				if (ans[j] != DNA[i][j]) {
					ansDiff++;
				}
			}
		}
	}
	
	public void print() {
		StringBuilder sb = new StringBuilder();
		
		for (char c : ans) {
			sb.append(c);
		}
		sb.append('\n');
		sb.append(ansDiff);
		
		System.out.println(sb);
	}
}
