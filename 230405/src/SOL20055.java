import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;	

class SOL20055 {

	public int N, K;
	public int[] A;			// 내구도 저장
	public int[] isRobot;	// 로봇 수 저장
	
	public int step;

	public void getInput() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		A = new int[2*N+1];
		StringTokenizer stBelt = new StringTokenizer(br.readLine());
		for (int i = 1; i <= 2*N; i++) {
			A[i] = Integer.parseInt(stBelt.nextToken());
		}
	}
	
	public void solution() {
		
		isRobot = new int[2*N+1];	// 현 위치에 로봇이 있는지 파악
		
		for (step = 1; ; step++) {
			
			// 1. 벨트가 각 칸 위에 있는 로봇과 함께 한 칸 회전한다.
			rotateBelt();
			rotateRobot();
			
			// 2. 가장 먼저 벨트에 올라간 로봇부터 이동한다.
			moveRobot();
			
			// 3. 올리는 위치에 있는 칸의 내구도가 0이 아니라면 로봇을 올린다.
			if (A[1] > 0) {
				isRobot[1]++;
				A[1]--;			// 로봇을 올리면 내구도가 감소한다.
			}
			
			// 4. 내구도가 0인 칸의 개수가 K개 이상이라면 종료한다.
			if (howManyZero() >= K) {
				break;
			}
		}
	}
	
	public void print() {
		System.out.println(step);
	}
	
	public void run() throws Exception {
		getInput();
		solution();
		print();
	}

	// 회전 방향대로 벨트를 이동하는 함수
	public void rotateBelt() {
		int temp = A[2*N]; 
		for (int i = 2*N; i > 1; i--) {
			A[i] = A[i-1];
		}
		A[1] = temp;
	}

	// 회전 방향대로 로봇을 이동하는 함수
	public void rotateRobot() {
		int temp = isRobot[2*N];
		for (int i = 2*N; i > 1; i--) {
			isRobot[i] = isRobot[i-1];
		}
		isRobot[1] = temp;
		isRobot[N] = 0;		// N번 칸은 내리는 칸이다.
	}
	
	// 조건에 따라 로봇을 움직이는 함수
	public void moveRobot() {
		// 한바퀴만 돌아도 판단 가능함
		for (int i = 2*N; i > 1; i--) {
			if (isRobot[i] == 0 && isRobot[i-1] > 0) {	// 로봇 유무 확인
				if (A[i] > 0) {							// 내구도 확인
					isRobot[i]++;
					isRobot[i-1]--;
					A[i]--;
				}
			}
		}
		isRobot[N] = 0;		// N번 칸은 내리는 칸이다.
	}
	
	// 내구도가 0인 칸의 수를 세는 함수
	public int howManyZero() {
		int cnt = 0;
		for (int i = 1; i <= 2*N; i++) {	// 0번칸 제외
			if (A[i] == 0) {
				cnt++;
			}
		}
		return cnt;
	}
}