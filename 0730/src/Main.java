import java.io.*;
import java.util.*;

public class Main {
	
	public static int res;
	public static int N, M;
	public static boolean[] check = new boolean[13];
	
	public static Vector<Point> home, chicken;
	
	class Point{
		int x;
		int y;
		Point(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	public int getDist(Point p1, Point p2) {
		return (int) (Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y));
	}
	
	public void dfs_15686(int num, int count) {
		// M개의 치킨집을 선정한 경우
		if (count == M) {
			// 집과 치킨집 거리의 총 합을 구한다.
			int distSum = 0;
			for (Point h : home) {
				int dist = Integer.MAX_VALUE;
				for (int i = 0; i < chicken.size(); i++) {
					if (check[i]) {
						Point c = chicken.get(i);
						dist = Math.min(dist, getDist(h, c));
					}
				}
				distSum += dist;
			}
			res = Math.min(res, distSum);
			return;
		}
		
		// 치킨집 끝까지 선정한 경우 탈출
		if (num == chicken.size()) {
			return;
		}
		
		// 폐업시킬 치킨집 선정
		check[num] = true;
		dfs_15686(num + 1, count + 1);
		
		// 폐업시킬 치킨집 해제
		check[num] = false;
		dfs_15686(num + 1, count);
	}
	
	public void sol_15686() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		home = new Vector<>();
		chicken = new Vector<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int map = Integer.parseInt(st.nextToken());
				if (map == 1)	home.add(new Point(i, j));
				if (map == 2)	chicken.add(new Point(i, j));
			}
		}
		
		res = Integer.MAX_VALUE;
		dfs_15686(0, 0);
		System.out.println(res);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_15686();
	}

}