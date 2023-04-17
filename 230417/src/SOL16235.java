import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class SOL16235 {
	
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
	public static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
	
	public int N, M, K;
	public int x, y, z;
	public int[][] A;
	
	public int[][] food;
	public PriorityQueue<Integer>[][] trees;
	
	public int[][] deadTreeValue;
	public int[][] growTrees;
	
	public void run() throws Exception {
		getInput();
		solution();
		print();
	}
	
	public void getInput() throws Exception {
		StringTokenizer stNMK = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stNMK.nextToken());
		M = Integer.parseInt(stNMK.nextToken());
		K = Integer.parseInt(stNMK.nextToken());
		
		A = new int[N+1][N+1];
		for (int i = 1; i <= N; i++) {
			StringTokenizer stA = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				A[i][j] = Integer.parseInt(stA.nextToken());
			}
		}
		
		// trees init
		trees = new PriorityQueue[N+1][N+1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				trees[i][j] = new PriorityQueue<Integer>();
			}
		}
		
		// get tree info
		for (int i = 1; i <= M; i++) {
			StringTokenizer stxyz = new StringTokenizer(br.readLine());
			x = Integer.parseInt(stxyz.nextToken());
			y = Integer.parseInt(stxyz.nextToken());
			z = Integer.parseInt(stxyz.nextToken());
			trees[x][y].offer(z);
		}
	}
	
	public void solution() {

		// 양분 초기화
		int FOODINIT = 5;
		food = new int[N+1][N+1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				food[i][j] = FOODINIT;
			}
		}
		
		
		for (int k = 0; k < K; k++) {
			
			// 죽은 나무와 번식 나무 배열 초기화
			deadTreeValue = new int[N+1][N+1];
			growTrees = new int[N+1][N+1];
			
			// 봄 : 자신의 나이만큼 양분을 먹고 나이 1 증가.
			trees = getOlder();
			
			// 여름 : 봄에 죽은 나무가 양분이 된다.
			addFood(deadTreeValue);
			
			// 가을 : 나무가 번식한다.
			breedTree();
			
			// 겨울 : 양분을 추가한다.
			addFood(A);
		}
	}
	
	public void print() {
		int ans = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				ans += trees[i][j].size();
			}
		}
		System.out.println(ans);
	}

	// 나이만큼 양분을 먹고 나이를 1 증가한다.
	public PriorityQueue<Integer>[][] getOlder() {

		// init new tree
		PriorityQueue<Integer>[][] newTrees = new PriorityQueue[N+1][N+1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				newTrees[i][j] = new PriorityQueue<Integer>();
			}
		}

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				
				while(!trees[i][j].isEmpty()) {
					
					int currTreeAge = trees[i][j].poll();
					
					if (food[i][j] < currTreeAge) {
						deadTreeValue[i][j] += currTreeAge/2;
					}
					else {
						food[i][j] -= currTreeAge;
						newTrees[i][j].offer(++currTreeAge);
						if (currTreeAge % 5 == 0) {
							for (int k = 0; k < 8; k++) {
								int nx = i + dx[k];
								int ny = j + dy[k];
								if (0 < nx && nx <= N && 0 < ny && ny <= N) {
									growTrees[nx][ny]++;
								}
							}
						}
					}
				}
			}
		}
		
		return newTrees;
	}

	// 나이가 5의 배수인 나무에 대해 번식한다.
	public void breedTree() {
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				for (int k = 0; k < growTrees[i][j]; k++) {
					trees[i][j].offer(1);
				}
			}
		}
	}
	
	// 양분을 추가한다.
	public void addFood(int[][] val) {
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				food[i][j] += val[i][j];
			}
		}
	}
}
