import java.io.BufferedReader;
import java.io.InputStreamReader;

class Point {
	int y;
	int x;
	public Point(int y, int x) {
		this.y = y;
		this.x = x;
	}
}

class SOL1331 {

	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public boolean[][] visited;
	public Point[] points;
	
	public boolean flag;
	
	public void run() throws Exception {
		getInput();
		solution();
		print();
	}
	
	public void getInput() throws Exception {
		points = new Point[36];
		for (int i = 0; i < 36; i++) {
			String currPoint = br.readLine();
			int y = currPoint.charAt(0) - 'A';
			int x = currPoint.charAt(1) - '1';
			points[i] = new Point(y, x);
		}
	}
	
	public void solution() {
		
		flag = true;
		visited = new boolean[6][6];
		
		for (int i = 0; i < 36; i++) {
			Point curr = points[i];
			Point next = points[(i+1) % 36];
			int diffY = Math.abs(next.y - curr.y);
			int diffX = Math.abs(next.x - curr.x);
			if ((diffY == 1 && diffX == 2) || (diffY == 2 && diffX == 1)) {
				if (!visited[next.y][next.x]) {
					visited[next.y][next.x] = true;
					continue;
				}
			}
			flag = false;
			break;
		}
	}
	
	public void print() {
		if (flag)	System.out.println("Valid");
		else		System.out.println("Invalid");
	}
}
