import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


class Fireball {
	
	int m;
	int s;
	int d;
	
	public Fireball(int m, int s, int d) {
		this.m = m;
		this.s = s;
		this.d = d;
	}

}

class SOL20056 {
	
	public int N, M, K;
	public int[][] fireballCnt;
	public Queue<Fireball>[][] fireballs;
	
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	// 인접칸 정보. 북쪽부터 시계방향.
	public static int neighborCnt = 8;
	public static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
	public static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
	
	public void getInput() throws Exception {
		StringTokenizer stNMK = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stNMK.nextToken());
		M = Integer.parseInt(stNMK.nextToken());
		K = Integer.parseInt(stNMK.nextToken());
		
		// init fireballs
		fireballs = new LinkedList[N+1][N+1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				fireballs[i][j] = new LinkedList<>();
			}
		}
		
		// get fireballs
		fireballCnt = new int[N+1][N+1];
		for (int size = 0; size < M; size++) {
			StringTokenizer stFB = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(stFB.nextToken());
			int c = Integer.parseInt(stFB.nextToken());
			int m = Integer.parseInt(stFB.nextToken());
			int s = Integer.parseInt(stFB.nextToken());
			int d = Integer.parseInt(stFB.nextToken());
			
			fireballCnt[r][c]++;
			fireballs[r][c].offer(new Fireball(m, s, d));
		}
	}
	
	public void solution() {
		for (int k = 0; k < K; k++) {
			fireballCnt = moveFireball();			
			fireballCnt = mergeFireball();
		}
	}
	
	public void print() {
		int ans = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				while(!fireballs[i][j].isEmpty()) {
					Fireball fb = fireballs[i][j].poll();
					ans += fb.m;
				}
			}
		}
		System.out.println(ans);
	}
	
	public void run() throws Exception {
		getInput();
		solution();
		print();
	}

	// 파이어볼을 d방향으로 s만큼 이동한다.
	public int[][] moveFireball() {
		
		int[][] fireballCntMove = new int[N+1][N+1];	// 이동한 뒤 fireball의 개수를 저장
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				
				for (int k = 0; k < fireballCnt[i][j]; k++) {
					
					Fireball fb = fireballs[i][j].poll();
					
					int ny = (i + dy[fb.d] * fb.s) % N;
					int nx = (j + dx[fb.d] * fb.s) % N;
					if (ny <= 0)	ny += N;
					if (nx <= 0)	nx += N;

					fireballs[ny][nx].offer(fb);
					fireballCntMove[ny][nx]++;
				}
			}
		}
		
		return fireballCntMove;
	}

	// 2개 이상의 파이어볼을 합친다.
	public int[][] mergeFireball() {
		
		int[][] fireballCntMerge = new int[N+1][N+1];
		
		int[][] newDirection = {{0, 2, 4, 6}, {1, 3, 5, 7}};
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
			
				int valueSize = fireballs[i][j].size();
				
				if (valueSize < 2) {	// 2개 이상이어야 합칠 수 있다.
					fireballCntMerge[i][j] = fireballCnt[i][j];
					continue;
				}
				
				int mSum = 0;
				int sSum = 0;
				boolean[] isDEven = new boolean[valueSize];
				
				for (int k = 0; !fireballs[i][j].isEmpty(); k++) {
					Fireball fb = fireballs[i][j].poll();
					mSum += fb.m;
					sSum += fb.s;
					isDEven[k] = ( fb.d % 2 == 0 );
				}
				
				int directionFlag = 0;	// 0이면 모두 일치, 1이면 하나라도 다름
				for (int k = 0; k < valueSize-1; k++) {
					if (isDEven[k] != isDEven[k+1]) {
						directionFlag = 1;
						break;
					}
				}
				
				int mAvg = mSum / 5;
				int sAvg = sSum / valueSize;
				if (mAvg != 0) {
					for (int k = 0; k < 4; k++) {
						fireballs[i][j].offer(
							new Fireball(mAvg, sAvg, newDirection[directionFlag][k])
						);
						fireballCntMerge[i][j]++;
					}
				}
			}
		}
		
		return fireballCntMerge;
	}
}