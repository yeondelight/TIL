import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	
	public void sol_2941() throws Exception {
		// ready
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// cal
		char c;
		String str = br.readLine();
		String temp;
		Stack<String> s = new Stack<String>();

		for(int i = 0; i < str.length(); i++) {
			c = str.charAt(i);
			switch(c) {
			case '-':
				if ( !s.isEmpty() && (s.peek().equals("c") || s.peek().equals("d"))) {
					s.push(s.pop() + c);
				}
				break;
			case '=':
				if ( !s.isEmpty() && (s.peek().equals("c") || s.peek().equals("s") || s.peek().equals("z"))) {
					temp = s.pop();
					if ( !s.isEmpty() && temp.equals("z") && s.peek().equals("d")) {
						s.push(temp + s.pop() + c);
					} else {
						s.push(temp + c);
					}
				}
				break;
			case 'j':
				if ( !s.isEmpty() && (s.peek().equals("l") || s.peek().equals("n"))) {
					s.push(s.pop() + c);
				} else {
					s.push(c + "");
				}
				break;
			default:
				s.push(c + "");
			}
		}
		
		
		System.out.println(s.size());
	}

	public void sol_10815() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		// scan
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int[] sang = new int[N];
		for (int i = 0; i < N; i++) {
			sang[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(sang);
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int[] card = new int[M];
		for (int i = 0; i < M; i++) {
			card[i] = Integer.parseInt(st.nextToken());
		}
		
		// cal
		for (int i = 0; i < M; i++) {
			sb.append(binarySearchHigh(card[i], sang) - binarySearchLow(card[i], sang)).append(' ');
		}
		
		// print
		System.out.println(sb);
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
	
	public void sol_1476() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// scan
		int E = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		// cal
		int year = 0;
		int e = 0, s = 0, m = 0;
		while (true) {
			e = (e + 1) % 15 == 0 ? 15 : (e + 1) % 15;
			s = (s + 1) % 28 == 0 ? 28 : (s + 1) % 28;
			m = (m + 1) % 19 == 0 ? 19 : (m + 1) % 19;
			year++;
			if (e==E && s==S && m==M)	break;
		}
		
		// print
		System.out.println(year);
	}
	
	public void sol_1475() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// scan
		String str = br.readLine();
		
		// cal
		int num, max = 0;
		int[] count = new int[9];
		
		for (int i = 0; i < str.length(); i++) {
			num = Integer.parseInt(str.charAt(i)+"");
			if (num == 9) {
				count[6]++;
			} else {
				count[num]++;
			}
		}
		count[6] = count[6] % 2 == 0 ? count[6] / 2 : count[6] / 2 + 1;
		
		for (int i = 0; i < 9; i++) {
			if (count[i] > count[max])	max = i;
		}
		
		// print
		System.out.println(count[max]);
	}
	
	public void sol_1094() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// scan
		int X = Integer.parseInt(br.readLine());
		
		// cal
		int num = 64;
		List<Integer> lines = new ArrayList<Integer>();
		lines.add(64);
		while (num > X) {
			int temp = lines.remove(0);
			temp /= 2;
			if (num - temp < X)	lines.add(0, temp);
			lines.add(0, temp);
			
			num = 0;
			for(int i = 0; i < lines.size(); i++) {
				num += lines.get(i);
			}
		}
		
		System.out.println(lines.size());
	}

	public void sol_11723() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int M = Integer.parseInt(br.readLine());
		
		int num;
		String cmd;
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			cmd = st.nextToken();
			switch(cmd) {
			case "all":
				list.clear();
				for (int j = 1; j < 21; j++) list.add(j);
				break;
			case "empty":
				list.clear();
				break;
			case "add":
				num = Integer.parseInt(st.nextToken());
				if (!list.contains(num))	list.add(num);
				break;
			case "remove":
				num = Integer.parseInt(st.nextToken());
				if (list.contains(num))		list.remove(list.indexOf(num));
				break;
			case "check":
				num = Integer.parseInt(st.nextToken());
				if (list.contains(num))	sb.append(1).append('\n');
				else					sb.append(0).append('\n');
				break;
			case "toggle":
				num = Integer.parseInt(st.nextToken());
				if (list.contains(num))	list.remove(list.indexOf(num));
				else					list.add(num);
				break;
			}
		}
		
		// print
		System.out.println(sb);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_11723();
	}
}
