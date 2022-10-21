import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	
	public void sol_2775() throws Exception{
		// ready
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// scan
		int t = Integer.parseInt(br.readLine());
		
		// cal
		int i, j, m;
		int k, n;
		int temp = 0, num[], now[];
		for (i = 0; i < t; i++) {
			k = Integer.parseInt(br.readLine());
			n = Integer.parseInt(br.readLine());
			num = new int[n + 1];
			now = new int[n + 1];
			for (j = 1; j <= n; j++)		// floor 0
				num[j] = j;
			for (j = 1; j <= k; j++) {		// floor 1 ~ k
				temp = 0;
				for (m = 1; m <= n; m++) {
					temp += num[m];
					now[m] = temp;
				}
				num = now;
			}
			sb.append(temp).append('\n');
		}
		
		// print
		System.out.println(sb);
	}
	
	public void sol_1654() throws Exception{
		// ready
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// scan
		int k = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		
		// cal
		int count;
		long mid, low = 0, high = 0;
		
		int[] lines = new int[k];
		for (int i = 0; i < k; i++) {
			lines[i] = Integer.parseInt(br.readLine());
			if (high < lines[i])	high = lines[i];
		}
		
		high++;
		while (low < high) {
			mid = (low + high) / 2;
			count = 0;
			for (int i = 0; i < k; i++) {
				count += (lines[i] / mid);
			}
			if (count < n) {
				high = mid;
			} else {
				low = mid + 1;
			}
		}
		
		// print
		System.out.println(high - 1);
	}
	
	public void sol_2805() throws Exception{
		// ready
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// scan
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		// cal
		long count;
		long mid, low = 0, high = 0;
		
		int[] lines = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			lines[i] = Integer.parseInt(st.nextToken());
			if (high < lines[i])	high = lines[i];
		}
		
		high++;
		while (low < high) {
			mid = (low + high) / 2;
			count = 0;
			for (int i = 0; i < n; i++) {
				if (lines[i] >= mid)
					count += lines[i] - mid;
			}
			if (count < m) {
				high = mid;
			} else {
				low = mid + 1;
			}
		}
		
		// print
		System.out.println(high - 1);
	}

	public void sol_18111() throws Exception{
		// ready
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// scan
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		// cal
		int i, j;
		int[][] map = new int[N][M];
		List<Integer> values = new ArrayList<Integer>();
		for(i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (!values.contains(map[i][j]))
					values.add(map[i][j]);
			}
		}
		Collections.sort(values);


		int minTime = Integer.MAX_VALUE;
		int maxHeight = -1;
		int min, point, bCount, tCount, diff;
		boolean check;
		for (min = values.get(0); min <= values.get(values.size()-1); min++) {
			check = true;
			bCount = B;
			tCount = 0;
			
			LoopN:
			for (i = 0; i < N; i++) {
				for (j = 0; j < M ; j++) {
					point = map[i][j];
					if (min < point) {
						diff = point - min;
						bCount += diff;
						tCount += 2 * diff;
					} else if (min > point) {
						if (min > 256) {
							check = false;
							break LoopN;
						} else {
							diff = min - point;
							bCount -= diff;
							tCount += diff;
						}
					}
				}
			}
			
			if (check && (minTime >= tCount) && (bCount >= 0)) {
				minTime = tCount;
				maxHeight = min;
			}
		}
		
		sb.append(minTime).append(' ').append(maxHeight);
		
		// print
		System.out.println(sb);
	}
	
	public void sol_1874() throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		
		// scan
		int n = Integer.parseInt(br.readLine());
		int[] num = new int[n];
		for (int i = 0; i < n; i++) {
			num[i] = Integer.parseInt(br.readLine());
		}
		
		// cal
		Stack<Integer> s = new Stack<Integer>();
		int count = 1, pushNum = 1;
		
		// first num
		for(int i = 1; i <= num[0]; i++) {
			s.push(i);
			pushNum++;
			sb.append('+').append('\n');
		}
		s.pop();
		sb.append('-').append('\n');
		
		// second num ~
		for(int i = 1; i < n; i++) {
			int diff = num[i-1] - num[i];
			if (diff > 0) {		// pop
				if (s.isEmpty() || s.peek() != num[i]) {
					System.out.println("NO");
					return;
				} else {
					while(!s.isEmpty()  && s.peek() == num[i]) {
						s.pop();
						count--;
						sb.append('-').append('\n');
					}
				}
			} else {			// push
				count = pushNum;
				while (count <= num[i]) {
					s.push(count);
					count++;
					pushNum++;
					sb.append('+').append('\n');
				}
				s.pop();
				sb.append('-').append('\n');
			}
		}
		
		// print
		System.out.println(sb);
	}
	
	public void sol_1010() throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int t = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < t; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			BigInteger mpec = BigInteger.ONE;
			BigInteger npec = BigInteger.ONE;
			for (int j = 0; j < n; j++) {
				mpec = mpec.multiply(BigInteger.valueOf(m).subtract(BigInteger.valueOf(j)));
				npec = npec.multiply(BigInteger.valueOf(n).subtract(BigInteger.valueOf(j)));
			}
			sb.append(mpec.divide(npec)).append('\n');
		}
		
		System.out.println(sb);
	}

	public void sol_1676() throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		BigInteger pec = BigInteger.ONE;
		
		for(int i = 2; i <= n; i++) {
			pec = pec.multiply(BigInteger.valueOf(i));
		}
		
		String str = pec.toString();
		BigInteger count = BigInteger.ZERO;
		for (int i = str.length() - 1; i > -1; i--) {
			if (str.charAt(i) == '0') {
				count = count.add(BigInteger.ONE);
			} else {
				break;
			}
		}
		
		System.out.println(count);
	}
	
	public static void main (String [] args) throws Exception{
		new Main().sol_1874();
	}

}
