import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public void sol_11866() throws Exception {
		// ready
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// scan
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		// cal
		List<Integer> nums = new ArrayList<Integer>();
		
		int i;
		
		for (i = 0; i < n; i++) {
			nums.add(i + 1);
		}
		
		sb.append("<");
		
		while(nums.size() > 1) {
			i = ( i + ( k - 1 ) ) % nums.size();
			sb.append(nums.remove(i)).append(", ");
		};
		sb.append(nums.remove(0)).append(">\n");
		
		// print
		System.out.println(sb);
	}
	
	public void sol_11651() throws Exception {
		// ready
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		// scan
		int n = Integer.parseInt(br.readLine());
		
		// cal
		int i, x, y;
		List<Point> points = new ArrayList<Point>();
		
		for (i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			points.add(new Point(x, y));
		}
		
		Collections.sort(points, new Comparator<Point>() {
			public int compare (Point p1, Point p2) {
				if (p1.y > p2.y)		return 1;
				else if (p1.y < p2.y)	return -1;
				else {
					if (p1.x > p2.x)		return 1;
					else if (p1.x < p2.x)	return -1;
					else					return 0;
				}
			}
		});
		
		// print
		for (i = 0; i < points.size(); i++) {
			sb.append(points.get(i).x).append(' ').append(points.get(i).y).append('\n');
		}
		
		System.out.println(sb);
	}
	
	class Point {
		int x;
		int y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public void sol_1436() throws Exception {
		// ready
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// scan
		int n = Integer.parseInt(br.readLine());
		
		// cal
		int i, count = 0;
		
		for(i = 0; count != n; i++) {
			if (Integer.toString(i).contains("666"))	count++;
		}
		
		// print
		System.out.println(i - 1);
	}

	public void sol_10866() throws Exception {
		// ready
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		// scan
		int n = Integer.parseInt(br.readLine());
		
		// cal
		int i, num;
		String cmd;
		boolean successed;
		List<Integer> deque = new ArrayList<Integer>();
		
		for(i = 0; i < n; i++) {
			successed = false;
			st = new StringTokenizer(br.readLine());
			cmd = st.nextToken();
			switch(cmd) {
			case "size":
				successed = true;
				sb.append(deque.size()).append('\n');
				break;
			case "empty":
				successed = true;
				if (deque.isEmpty())	sb.append("1\n");
				else					sb.append("0\n");
				break;
			case "front":
				successed = true;
				if (deque.isEmpty())	sb.append("-1\n");
				else
					sb.append(deque.get(0)).append('\n');
				break;
			case "back":
				successed = true;
				if (deque.isEmpty())	sb.append("-1\n");
				else
					sb.append(deque.get(deque.size() - 1)).append('\n');
				break;
			case "pop_front":
				successed = true;
				if (deque.isEmpty())	sb.append("-1\n");	
				else
					sb.append(deque.remove(0)).append('\n');
				break;
			case "pop_back":
				successed = true;
				if (deque.isEmpty())	sb.append("-1\n");
				else
					sb.append(deque.remove(deque.size() - 1)).append('\n');
				break;
			}
			if (successed)	continue;
			else {
				num = Integer.parseInt(st.nextToken());
				switch(cmd) {
				case "push_front":
					deque.add(0, num);
					break;
				case "push_back":
					deque.add(num);
					break;
				}
			}
		}
		
		// print
		System.out.println(sb);
	}

	public void sol_10828() throws Exception {
		// ready
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		// scan
		int n = Integer.parseInt(br.readLine());
		
		// cal
		int i, num;
		String cmd;
		Stack<Integer> s = new Stack<Integer>();
		
		for(i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			cmd = st.nextToken();
			switch(cmd) {
			case "size":
				sb.append(s.size()).append('\n');
				break;
			case "empty":
				if (s.isEmpty())	sb.append("1\n");
				else				sb.append("0\n");
				break;
			case "top":
				if (s.isEmpty())	sb.append("-1\n");
				else				sb.append(s.lastElement()).append('\n');
				break;
			case "pop":
				if (s.isEmpty())	sb.append("-1\n");
				else				sb.append(s.pop()).append('\n');
				break;
			case "push":
				num = Integer.parseInt(st.nextToken());
				s.push(num);
				break;
			}
		}
		
		// print
		System.out.println(sb);
	}
	
	public void sol_10845() throws Exception {
		// ready
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		// scan
		int n = Integer.parseInt(br.readLine());
		
		// cal
		int i, num;
		String cmd;
		List<Integer> q = new ArrayList<Integer>();
		
		for(i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			cmd = st.nextToken();
			switch(cmd) {
			case "size":
				sb.append(q.size()).append('\n');
				break;
			case "empty":
				if (q.isEmpty())	sb.append("1\n");
				else				sb.append("0\n");
				break;
			case "front":
				if (q.isEmpty())	sb.append("-1\n");
				else				sb.append(q.get(0)).append('\n');
				break;
			case "back":
				if (q.isEmpty())	sb.append("-1\n");
				else
					sb.append(q.get(q.size() - 1)).append('\n');
				break;
			case "pop":
				if (q.isEmpty())	sb.append("-1\n");	
				else
					sb.append(q.remove(0)).append('\n');
				break;
			case "push":
				num = Integer.parseInt(st.nextToken());
				q.add(num);
				break;
			}
		}
		
		// print
		System.out.println(sb);
	}

	public void sol_10816() throws Exception {
		// ready
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		// scan, cal
		int i, num;
		
		// 상근
		int n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());

		int[] card = new int[n];
		for(i = 0; i < n; i++) {
			card[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(card);
		
		// 몇개 가짐?
		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(i = 0; i < m; i++) {
			num = Integer.parseInt(st.nextToken());
			sb.append(binarySearchHigh(num, card) - binarySearchLow(num, card)).append(' ');
		}
		
		// print
		System.out.println(sb);
	}
	
	public void sol_1920() throws Exception {
		// ready
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		// scan
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		
		int i, num;
		st = new StringTokenizer(br.readLine());
		for (i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (i = 0; i < m; i++) {
			num = Integer.parseInt(st.nextToken());
			if (binarySearch(num, arr) < 0)	sb.append(0).append('\n');
			else							sb.append(1).append('\n');
		}
		
		// print
		System.out.println(sb);
	}
	
	public static int binarySearch(int num, int[] arr) {
		int mid, low = 0;
		int high = arr.length - 1;
		
		while (low <= high) {
			mid = (low + high) / 2;
			
			if (num < arr[mid]) {
				high = mid - 1;
			} else if (num > arr[mid]) {
				low = mid + 1;
			} else {
				return mid;
			}
		}
		return -1;
	}
	
	public static int binarySearchLow(int num, int[] arr) {
		int mid, low = 0;
		int high = arr.length;
		
		while (low < high) {
			mid = (low + high) / 2;
			
			if (num <= arr[mid]) {
				high = mid;
			} else {
				low = mid + 1;
			}
		}
		return low;
	}
	
	public static int binarySearchHigh(int num, int[] arr) {
		int mid, low = 0;
		int high = arr.length;
		
		while (low < high) {
			mid = (low + high) / 2;
			
			if (num < arr[mid]) {
				high = mid;
			} else {
				low = mid + 1;
			}
		}
		return low;
	}
	
	public void sol_4153() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		String str;
		int[] lines = new int[3];
		
		while (true) {
			str = br.readLine();
			if (str.equals("0 0 0"))	break;
			
			st = new StringTokenizer(str);
			lines[0] = Integer.parseInt(st.nextToken());
			lines[1] = Integer.parseInt(st.nextToken());
			lines[2] = Integer.parseInt(st.nextToken());
			Arrays.sort(lines);
			if (lines[2] * lines[2] == lines[0] * lines[0] + lines[1] * lines[1])
				sb.append("right\n");
			else
				sb.append("wrong\n");
		}
		
		System.out.println(sb);
	}
	
	public void sol_10250() throws Exception {
		// ready
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		// scan
		int t = Integer.parseInt(br.readLine());
		
		// cal
		int i, h, w, n, y, x;
		
		for (i = 0; i < t; i++) {
			st = new StringTokenizer(br.readLine());
			h = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			
			y = ( n % h == 0 ) ? h : n % h;
			x = (n - 1) / h + 1;
			
			sb.append(y);
			if (x < 10)	sb.append(0);
			sb.append(x).append('\n');
		}
		
		
		// print
		System.out.println(sb);
	}

	public void sol_2798() throws Exception {
		// ready
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// scan
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] card = new int[n];
		
		// cal
		int max = 0;
		int i, j, k, sum;

		st = new StringTokenizer(br.readLine());
		for (i = 0; i < n; i++) {
			card[i] = Integer.parseInt(st.nextToken());
		}
		
		for (i = 0; i < n; i++) {
			for (j = i + 1; j < n; j++) {
				for (k = j + 1; k < n; k++) {
					sum = card[i] + card[j] + card[k];
					if (sum > max && sum <= m) {
						max = sum;
					}
				}
			}
		}
		
		
		// print
		System.out.println(max);
	}
	
	public void sol_1259() throws Exception {
		// ready
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringBuffer sf;
		
		// scan, cal
		String str, compare;
		
		while (!(str = br.readLine()).equals("0")) {
			sf = new StringBuffer(str);
			compare = sf.reverse().toString();
			if (str.equals(compare))	sb.append("yes\n");
			else						sb.append("no\n");
		}
		
		// print
		System.out.println(sb);
	}
	
	public void sol_11050() throws Exception {
		// ready
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// scan, cal
		int i, npec = 1, kpec = 1;
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int count = k;
		
		for ( i = 0; i < count; i++, n--, k--) {
			npec *= n;
			kpec *= k;
		}
		
		// print
		System.out.println(npec/kpec);
	}	
	
	public void sol_2164() throws Exception {
		// ready
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// scan
		int n = Integer.parseInt(br.readLine());
		
		// cal
		Queue<Integer> q = new LinkedList<Integer>();
		
		for (int i = 0; i < n; i++) {
			q.add(i+1);
		}
		
		if (n > 2) {
			do {
				q.poll();
				q.add(q.poll());
			} while (q.size() > 2);
			q.poll();
		} else if (n == 2) {
			q.poll();
		}
		
		// print
		System.out.println(q.poll());
	}

	public void sol_1018() throws Exception {
		// ready
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// scan
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		// cal
		int i, j;
		String str;
		char[][] map = new char[n][m];
		
		// map 등록
		for (i = 0; i < n; i++) {
			str = br.readLine();
			for (j = 0; j < m; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		char start;
		int a, b, index;
		int min = n * m;
		int count = 0, count1 = 0, count2 = 0;
		for (i = 0; i <= n - 8; i++) {
			for (j = 0; j <= m - 8; j++) {
				count1 = 0;
				count2 = 0;
				start = map[i][j];
				for (a = i; a < i + 8; a++) {
					for (b = j; b < j + 8; b++) {
						index = (a - i) + (b - j);
						if (index % 2 == 0) {
							if (map[a][b] != start)	count1++;
						} else {
							if (map[a][b] == start)	count1++;
						}
					}
					for (b = j; b < j + 8; b++) {
						index = (a - i) + (b - j);
						if (index % 2 == 0) {
							if (map[a][b] == start)	count2++;
						} else {
							if (map[a][b] != start)	count2++;
						}
					}
					count = (count1 > count2) ? count2 : count1;
				}
				if (min > count)	min = count;
			}
		}
		
		// print
		System.out.println(min);
	}
	
	public static void main(String[] args) throws Exception{
		new Main().sol_1018();
	}
}
