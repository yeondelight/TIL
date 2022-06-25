import java.io.*;
import java.util.*;

public class Main {
	
	class Point {
		int x;
		int y;
		Point(int x, int y){
			this.x = x;
			this.y = y;
		}
		
		@Override
		public boolean equals(Object o) {
			Point p = (Point) o;
			if ((x == p.x) && (y == p.y)) 	return true;
			else							return false;
		}
		
		@Override
	    public int hashCode() {
	        return Objects.hash(x, y);
	    }
		
		@Override
		public String toString() {
			return "(" + x + ", " + y + ")";
		}
	}
	
	class Graph {
		HashMap<Point, ArrayList<Point>> g;
		
		Graph (int size) {
			g = new HashMap<Point, ArrayList<Point>>();
		}
		
		public void addVertex(Point p) {
			g.put(p, new ArrayList<Point>());
		}
		
		public void addEdge(Point p1, Point p2) {
			if (g.containsKey(p1) && g.containsKey(p2)) {
				g.get(p1).add(p2);
				g.get(p2).add(p1);
			}
		}
		
		public int getBFS() {
			int count = 0;
			Vector<Point> visited = new Vector<>();
            for(Point key : g.keySet()){
                if (visited.size() == g.size())	break;
                if (!visited.contains(key)) {
                	count++;
        			Queue<Point> q = new LinkedList<>();
                	q.add(key);
                	visited.add(key);
                    while (!q.isEmpty()) {
                    	Point poll = q.poll();
                        ArrayList<Point> value = g.get(poll);
                    	for (Point pNode : value) {
                    		if (!visited.contains(pNode)) {
                    			q.add(pNode);
                    			visited.add(pNode);
                    		}
                    	}
                    }
                }
            }
			return count;
		}
	}
	
	public void sol_1012() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			Graph cabbage = new Graph( M > N ? M : N );
			for (int j = 0; j < K; j++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				Point p = new Point(x, y);
				cabbage.addVertex(p);
				if (x > 0)		cabbage.addEdge(p, new Point(x-1, y));
				if (x < M-1)	cabbage.addEdge(p, new Point(x+1, y));
				if (y > 0)		cabbage.addEdge(p, new Point(x, y-1));
				if (y < N-1)	cabbage.addEdge(p, new Point(x, y+1));
			}
			sb.append(cabbage.getBFS()).append('\n');
		}
		
		System.out.print(sb);
	}
	
	public static void main (String[] args) throws Exception {
		new Main().sol_1012();
	}
}
