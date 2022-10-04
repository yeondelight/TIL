import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Vector;

public class Main {
	
	public class Point {
		int x;
		int y;
		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static int[][] map;
	public static Vector<Point> points;
	
	public void printMap() {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public boolean checkRow(int x, int input) {
		for (int i = 0; i < 9; i++) {
			if (map[x][i] == input) {
				return false;
			}
		}
		return true;
	}
	
	public boolean checkCol(int y, int input) {
		for (int i = 0; i < 9; i++) {
			if (map[i][y] == input) {
				return false;
			}
		}
		return true;
	}
	
	public boolean checkSquare(int x, int y, int input) {
		int startX = (x / 3) * 3;
		int startY = (y / 3) * 3;
		for (int i = startX; i < startX + 3; i++) {
			for (int j = startY; j < startY + 3; j++) {
				if (map[i][j] == input) {
					return false;
				}
			}
		}
		return true;
	}
	
	public void backtracking(int idx) {
		if (idx == points.size()) {
			printMap();
			System.exit(0);
		}
		Point p = points.get(idx);
		for (int k = 1; k <= 9; k++) {
			boolean r = checkRow(p.x, k);
			boolean l = checkCol(p.y, k);
			boolean s = checkSquare(p.x, p.y, k);
			if (r && l && s) {
				map[p.x][p.y] = k;
				backtracking(idx + 1);
				map[p.x][p.y] = 0; 
			}
		}
	}
	
	public void sol_2580() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		map = new int[9][9];
		points = new Vector<Point>();
		for (int i = 0; i < 9; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 0) {
					points.add(new Point(i, j));
				}
			}
		}
		
		backtracking(0);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_2580();
	}
}
