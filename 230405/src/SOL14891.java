import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class SOL14891 {

	public static int wheelCnt = 4;
	public static int wheelStatusCnt = 8;
	public static int left = 2, right = 6;
	
	public static boolean[][] wheels;
	public static boolean[][] wheelsCopy;
	
	public static BufferedReader br;
	
	public void getInput() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		wheels = new boolean[wheelCnt+1][wheelStatusCnt];
		for (int i = 1; i <= wheelCnt; i++) {
			String str = br.readLine();
			for (int j = 0; j < wheelStatusCnt; j++) {
				// N = 0 = false
				// S = 1 = true
				wheels[i][j] = str.charAt(j) == '1' ? true : false;
			}
		}
	}
	
	public void solution() throws NumberFormatException, IOException {
		int K = Integer.parseInt(br.readLine());
		
		for (int k = 0; k < K; k++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int wheelNo = Integer.parseInt(st.nextToken());
			boolean rotate = Integer.parseInt(st.nextToken()) == 1 ? true : false;

			// 원본 손상 방지
			boolean tempRotate = rotate;
			wheelsCopy = copyArr(wheels);
			
			// 자기 자신 회전
			rotateWheel(wheelNo, rotate);
			
			// wheelNo의 왼쪽 검사
			tempRotate = rotate;
			for (int i = wheelNo; i > 1; i--) {
				if (wheels[i][right] != wheels[i-1][left]) {
					rotateWheel(i-1, !tempRotate);
					tempRotate = !tempRotate;			// 다음에 전달할 방향 틀어놓기
				} else {
					break;	// 연속성이 깨지면 바로 탈출
				}
			}
			
			// wheelNo의 오른쪽 검사
			tempRotate = rotate;
			for (int i = wheelNo; i < wheelCnt; i++) {
				if (wheels[i][left] != wheels[i+1][right]) {
					rotateWheel(i+1, !tempRotate);
					tempRotate = !tempRotate;			// 다음에 전달할 방향 틀어놓기
				} else {
					break;	// 연속성이 깨지면 바로 탈출
				}
			}
			
			wheels = copyArr(wheelsCopy);	// 회전 결과값 받아오기
		}
		
	}
	
	public void print() {
		int ans = 0;
		
		if (wheels[1][0])	ans += 1;
		if (wheels[2][0])	ans += 2;
		if (wheels[3][0])	ans += 4;
		if (wheels[4][0])	ans += 8;
		
		System.out.println(ans);
	}
	
	public void run() throws Exception {
		getInput();
		solution();
		print();
	}

	public boolean[][] copyArr(boolean[][] origin) {
		boolean[][] copy = new boolean[wheelCnt+1][wheelStatusCnt];
		for (int i = 0; i <= wheelCnt; i++) {
			for (int j = 0; j < wheelStatusCnt; j++) {
				copy[i][j] = origin[i][j];
			}
		}
		return copy;
	}
	
	public void rotateWheel(int wheelNo, boolean rotateFlag) {
		if (rotateFlag) {	// 시계방향 회전
			boolean temp = wheelsCopy[wheelNo][wheelStatusCnt-1];
			for (int i = wheelStatusCnt - 1; i > 0; i--) {
				wheelsCopy[wheelNo][i] = wheelsCopy[wheelNo][i-1]; 
			}
			wheelsCopy[wheelNo][0] = temp;
		}
		else {				// 반시계방향 회전
			boolean temp = wheelsCopy[wheelNo][0];
			for (int i = 0; i < wheelStatusCnt - 1; i++) {
				wheelsCopy[wheelNo][i] = wheelsCopy[wheelNo][i+1]; 
			}
			wheelsCopy[wheelNo][wheelStatusCnt-1] = temp;
			
		}
	}
}
