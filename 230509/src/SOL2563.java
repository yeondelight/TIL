import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class SOL2563 {

	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static int WHITESIZE = 100;
	public static int PAPERSIZE = 10;
	
	public int N;
	public boolean[][] paper;
	
	public int ans;
	
	public void run() throws Exception {
		addPaper();
		countArea();
		print();
	}
	
	public void addPaper() throws Exception {
		N = Integer.parseInt(br.readLine());
		paper = new boolean[WHITESIZE+1][WHITESIZE+1];
		for (int n = 0; n < N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			for (int i = x; i < x+PAPERSIZE; i++) {
				for (int j = y; j < y+PAPERSIZE; j++) {
					paper[i][j] = true;
				}
			}
		}
	}
	
	public void countArea() {
		ans = 0;
		for (int i = 0; i <= WHITESIZE; i++) {
			for (int j = 0; j <= WHITESIZE; j++) {
				if (paper[i][j]) {
					ans++;
				}
			}
		}
	}
	
	public void print() {
		System.out.println(ans);		
	}
}