import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Number implements Comparable {
	
	int id;
	int cnt;
	
	public Number(int id, int cnt) {
		this.id = id;
		this.cnt = cnt;
	}

	@Override
	public int compareTo(Object o) {
		Number n = (Number) o;
		if (this.cnt == n.cnt) {	// 1. cnt가 작은 순서대로
			return this.id - n.id;	// 2. id가 작은 순서대로
		}
		return this.cnt - n.cnt;
	}
}

class SOL17140 {
	
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static int MAX = 100;
	
	public int N = 3;
	public int[][] A;
	public int r, c, k;
	
	public int R, C;
	public int time;
	public boolean flag;

	public void getInput() throws Exception {
		StringTokenizer stRCK = new StringTokenizer(br.readLine());
		r = Integer.parseInt(stRCK.nextToken());
		c = Integer.parseInt(stRCK.nextToken());
		k = Integer.parseInt(stRCK.nextToken());
		
		A = new int[MAX+1][MAX+1];
		for (int i = 1; i <= N; i++) {
			StringTokenizer stA = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				A[i][j] = Integer.parseInt(stA.nextToken());
			}
		}
	}
	
	public void solution() throws Exception {
		R = C = N;
		for (time = 0; time <= MAX; time++) {
			
			if (A[r][c] == k) {
				flag = true;
				break;
			}
			
			if (R >= C) A = calR();
			else		A = calC();
		}
	}
	
	public void print() {
		if (flag)	System.out.println(time);
		else		System.out.println(-1);
	}
	
	public void run() throws Exception {
		getInput();
		solution();
		print();
	}

	// R 연산
	public int[][] calR() {
		int[][] mapCopy = new int[MAX+1][MAX+1];	// 결과를 저장할 map
		
		for (int i = 1; i <= R; i++) {			// 모든 행에 대해 연산한다.
			
			int[] countNumber = new int[MAX+1];	// 수의 개수를 저장할 배열
			for (int j = 1; j <= C; j++) {		// 해당 행의 모든 값에 대해 개수를 센다.
				countNumber[A[i][j]]++;
			}
			
			PriorityQueue<Number> pq = new PriorityQueue<>();
			for (int n = 1; n <= MAX; n++) {	// 0은 세면 안되니까
				if (countNumber[n] != 0) {		// 그 수가 나온 적 있으면 id와 cnt 저장
					pq.offer(new Number(n, countNumber[n]));
				}
			}
			
			C = Math.max(C, pq.size()*2);		// R 연산시 C 크기가 바뀐다. 큰 값으로 갱신
			
			// pq에 있는 모든 값을 mapCopy에 옮겨담는다.
			for (int n = 1; n <= MAX && !pq.isEmpty(); n+=2) {
				Number num = pq.poll();
				mapCopy[i][n] = num.id;
				mapCopy[i][n+1] = num.cnt;
			}
		}
		
		return mapCopy;
	}

	// C 연산
	public int[][] calC() {
		int[][] mapCopy = new int[MAX+1][MAX+1];	// 결과를 저장할 map
		
		for (int j = 1; j <= C; j++) {			// 모든 열에 대해 연산한다.
			
			int[] countNumber = new int[MAX+1];	// 수의 개수를 저장할 배열
			for (int i = 1; i <= R; i++) {		// 해당 열의 모든 값에 대해 개수를 센다.
				countNumber[A[i][j]]++;
			}
			
			PriorityQueue<Number> pq = new PriorityQueue<>();
			for (int n = 1; n <= MAX; n++) {	// 0은 세면 안되니까
				if (countNumber[n] != 0) {		// 그 수가 나온 적 있으면 id와 cnt 저장
					pq.offer(new Number(n, countNumber[n]));
				}
			}
			
			R = Math.max(R, pq.size()*2);		// C 연산시 R 크기가 바뀐다. 큰 값으로 갱신
			
			// pq에 있는 모든 값을 mapCopy에 옮겨담는다.
			for (int n = 1; n <= MAX && !pq.isEmpty(); n+=2) {
				Number num = pq.poll();
				mapCopy[n][j] = num.id;
				mapCopy[n+1][j] = num.cnt;
			}
		}
		
		return mapCopy;
	}
}