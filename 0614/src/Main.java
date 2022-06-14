import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	
	public void sol_1085() throws Exception {
		// ready
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// scan
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		
		// cal
		int[] res = new int[4];
		
		res[0] = w - x;
		res[1] = x;
		res[2] = h - y;
		res[3] = y;
		Arrays.sort(res);
		
		// print
		System.out.println(res[0]);
	}

	public void sol_2231() throws Exception {
		// ready
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				
		// scan
		int n = Integer.parseInt(br.readLine());
				
		// cal
		int res = 0, sum, temp;
				
		for (int i = 0; i < n; i++) {
			sum = 0;
			temp = i;
			sum += temp;
			while (temp > 0) {
				sum += temp % 10;
				temp /= 10;
			}
			if (sum == n) {
				res = i;
				break;
			}
		}
				
		// print
		System.out.println(res);
	}
	
	public void sol_2292() throws Exception {
		// ready
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
						
		// scan
		int n = Integer.parseInt(br.readLine());
						
		// cal
		int i = 0, sum = 1;
		do {
			sum += (i * 6);
			i++;
		} while (sum < n);
		
		// print
		System.out.println(i);
	}
	
	public void sol_15829() throws Exception {
		// ready
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
						
		// scan
		int n = Integer.parseInt(br.readLine());
		String str = br.readLine();
						
		// cal
		int c;
		BigInteger temp = BigInteger.ZERO;
		BigInteger hash = BigInteger.ZERO;
		BigInteger r = BigInteger.ONE;
		int mod = 1234567891;
		
		for(int i = 0; i < n; i++) {
			c = str.charAt(i) - 96;
			temp = r.multiply(BigInteger.valueOf(c));
			hash = hash.add(temp);
			r = r.multiply(BigInteger.valueOf(31));
		}
		hash  = hash.mod(BigInteger.valueOf(1234567891));
		
		// print
		System.out.println(hash);
	}	
	
	public void sol_10989() throws Exception {
		// ready
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		
		// scan
		int n = Integer.parseInt(br.readLine());
		int[] num = new int[n];
		
		// cal
		int i;
		for(i = 0; i < n; i++) {
			num[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(num);
		
		for (i = 0; i < n; i++) {
			sb.append(num[i]).append('\n');
		}
		
		// print
		System.out.println(sb);
	}	
	
	public void sol_2839() throws Exception {
		// ready
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// scan
		int n = Integer.parseInt(br.readLine());
		
		// cal
		int min = -1;
		int try3 = ( n % 3 == 0 ) ? n / 3 : n / 3 + 1;
		int try5 = ( n % 5 == 0 ) ? n / 5 : n / 5 + 1;
		int sum;
		
		for(int i = 0; i <= try5; i++) {
			for (int j = 0; j <= try3; j++) {
				sum = 5 * i + 3 * j;
				if (sum == n) {
					min = i + j;
				}
			}
		}
		
		// print
		System.out.println(min);
	}

	public void sol_4949() throws Exception {
		// ready
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// scan, cal
		String str;
		char c, temp;
		boolean check;
		while (!(str = br.readLine()).equals(".")) {
			check = true;
			Stack<Character> s = new Stack<Character>();
			for (int i = 0; i < str.length(); i++) {
				c = str.charAt(i);
				switch(c) {
				case '(':
				case '{':
				case '[':
					s.push(c);
					break;
				case ')':
					if (s.isEmpty())	check = false;
					else {
						temp = s.pop();
						if (temp != '(')	check = false;
					}
					break;
				case '}':
					if (s.isEmpty())	check = false;
					else {
						temp = s.pop();
						if (temp != '{')	check = false;
					}
					break;
				case ']':
					if (s.isEmpty())	check = false;
					else {
						temp = s.pop();
						if (temp != '[')	check = false;
					}
					break;
				}
			}
			if (check && s.isEmpty())	sb.append("yes\n");
			else						sb.append("no\n");
		}
		
		// print
		System.out.println(sb);
	}

	public void sol_10773() throws Exception {
		// ready
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// scan
		int k = Integer.parseInt(br.readLine());
		
		// cal
		int sum = 0, num;
		Stack<Integer> s = new Stack<Integer>();
		for(int i = 0; i < k; i++) {
			num = Integer.parseInt(br.readLine());
			if (num == 0) {
				sum -= s.pop();
			} else {
				s.push(num);
				sum += num;
			}
		}
		
		// print
		System.out.println(sum);
	}

	public void sol_1929() throws Exception {
		// ready
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// scan
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		// cal
		int sqrt;
		boolean check;
		for(int i = n; i <= m; i++) {
			check = true;
			sqrt = (int) Math.sqrt(i);
			for(int j = 2; j <= sqrt; j++) {
				if (i % j == 0) {
					check = false;
					break;
				}
			}
			if (check && i != 1)	sb.append(i).append('\n');
		}
		
		// print
		System.out.println(sb);
	}

	public void sol_1966() throws Exception {
		// ready
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		// scan
		int t = Integer.parseInt(br.readLine());
		
		// cal
		boolean check;
		int i, j, n, m;
		int count, index;
		List<Integer> q;
		for(i = 0; i < t; i++) {
			// scan document(n), wanna know(m)
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());

			// scan documents
			q = new ArrayList<Integer>();
			st = new StringTokenizer(br.readLine());
			while(st.hasMoreTokens()) {
				q.add(Integer.parseInt(st.nextToken()));
			}
			
			// cal
			count = 0;
			index = m;
			while (true) {
				check = false;
				for (j = 0; j < q.size(); j++) {
					if (q.get(0) < q.get(j)) {
						check = true;
						break;
					}
				}
				if (check) {	// 제일 뒤로 이동
					q.add(q.remove(0));
					if (index == 0)		index = q.size() - 1;
					else				index--;
				} else {		// 출력
					q.remove(0);
					if (index == 0)		break;
					else {
						count++;
						index--;
					}
				}
			}
			count++;
			sb.append(count).append('\n');
		}
		
		// print
		System.out.println(sb);
	}
	
	public void sol_2108() throws Exception {
		// ready
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// scan
		int n = Integer.parseInt(br.readLine());
		
		// cal
		int i;
		int[] nums = new int[n];
		int[] count = new int[8001];
		double sum = 0;
		
		for(i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(br.readLine()); 
			sum += nums[i];
			count[nums[i] + 4000]++;
		}
		Arrays.sort(nums);
		
		int many = 0, many_index = Integer.MAX_VALUE;
		boolean check = false;
		for (i = 0; i < 8001; i++) {
			if (many < count[i]) {
				many = count[i];
				many_index = i - 4000;
				check = true;
			} else if (many == count[i] && check) {
				many_index = i - 4000;
				check = false;
			}
		}
		
		sb.append((int) Math.floor(sum / n + 0.5)).append('\n');
		sb.append(nums[n/2]).append('\n');
		sb.append(many_index).append('\n');
		sb.append(nums[n-1] - nums[0]).append('\n');
		
		
		// print
		System.out.println(sb);
	}

	public static void main (String[] args) throws Exception {
		new Main().sol_2108();
	}
}
