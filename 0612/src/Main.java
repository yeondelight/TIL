import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public void sol_2577() throws Exception {
		// ready
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// scan, cal
		int i, n, temp, mul = 1;
		int count[] = new int[10];
		
		for (i = 0; i < 10; i++) {
			count[i] = 0;
		}
		
		for (i = 0; i < 3; i++) {
			n = Integer.parseInt(br.readLine());
			mul *= n;
		}
		

		while (mul > 0) {
			temp = mul % 10;
			count[temp]++;
			mul /= 10;
		}
		
		for (i = 0; i < 10; i++) {
			sb.append(count[i]).append('\n');
		}
		
		//print
		System.out.println(sb);
	}
	
	public void sol_2657() throws Exception {
		// ready
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		// scan
		int n = Integer.parseInt(br.readLine());
		
		// cal
		char c;
		String str;
		int i, j, m, temp;
		
		for (i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			m = Integer.parseInt(st.nextToken());
			str = st.nextToken();
			for (j = 0; j < str.length(); j++) {
				temp = m;
				 c = str.charAt(j);
				 while (temp > 0) {
					 sb.append(c);
					 temp--;
				 }
			}
			sb.append('\n');
		}
		
		// print
		System.out.println(sb);
	}
	
	public void sol_11720() throws Exception {
		// ready
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// scan
		int n = Integer.parseInt(br.readLine());
		String m = br.readLine();
		
		// cal
		int i, temp, sum = 0;
		
		for (i = 0; i < n; i++) {
			temp = Integer.parseInt(m.charAt(i)+"");
			sum += temp;
		}
		
		// print
		System.out.println(sum);
	}
	
	public void sol_10818() throws Exception {
		// ready
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		// scan, cal
		int n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		int i, num, min = 0, max = 0;
		for (i = 0; i < n; i++) {
			num = Integer.parseInt(st.nextToken());
			if (i == 0) {
				min = num;
				max = num;
				continue;
			}
			if (min > num)	min = num;
			if (max < num)	max = num;
		}
		
		//print
		sb.append(min).append(" ").append(max).append('\n');
		System.out.println(sb);
	}
	
	public void sol_2884() throws Exception {
		// ready
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// scan, cal
		int h = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int resH, resM;
		int leftMin = 0;
		
		if (m >= 45) {
			resH = h;
			resM = m - 45;
		} else {
			resH = (h - 1) < 0 ? 24 + (h - 1) : h - 1;
			resM = m + 15;
		}
		
		//print
		sb.append(resH).append(' ').append(resM).append('\n');
		System.out.println(sb);
	}

	public void sol_8958() throws Exception {
		// ready
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// scan, cal
		int n = Integer.parseInt(br.readLine());

		int sum, combo = 0;
		char c;
		String str;
		for(int i = 0; i < n; i++) {
			sum = 0;
			combo = 0;
			str = br.readLine();
			for (int j = 0; j < str.length(); j++) {
				c = str.charAt(j);
				if (c == 'O') {	
					sum += (1 + combo);
					combo++;
				}
				else if (c == 'X') 	combo = 0;
			}
			sb.append(sum).append('\n');
		}
		
		//print
		System.out.println(sb);
	}

	public void sol_3052() throws Exception {
		// ready
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// scan, cal
		int num;
		List<Integer> remains = new ArrayList<Integer>();
		for(int i = 0; i < 10; i++) {
			num = Integer.parseInt(br.readLine()) % 42;
			if (!remains.contains(num)) {
				remains.add(num);
			}
		}
		
		//print
		System.out.println(remains.size());
	}
	
	public void sol_2920() throws Exception {
		// ready
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// scan, cal
		int[] num = new int[8];
		int[] increase = {1, 2, 3, 4, 5, 6, 7, 8};
		int[] decrease = {8, 7, 6, 5, 4, 3, 2, 1};
		
		boolean[] check = new boolean[3];
		
		for(int i = 0; i < 8; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		if (Arrays.equals(num, increase)) {
			System.out.println("ascending");
		} else if (Arrays.equals(num, decrease)) {
			System.out.println("descending");
		} else {
			System.out.println("mixed");
		}
	}
	
	public void sol_2908() throws Exception {
		// ready
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// scan
		String aStr = st.nextToken();
		String bStr = st.nextToken();
		
		// cal
		int a, b;
		int one, ten, hun;
		
		one = Integer.parseInt(aStr.charAt(0)+"");
		ten = Integer.parseInt(aStr.charAt(1)+"");
		hun = Integer.parseInt(aStr.charAt(2)+"");
		a =  one + ten * 10 + hun * 100;
		
		one = Integer.parseInt(bStr.charAt(0)+"");
		ten = Integer.parseInt(bStr.charAt(1)+"");
		hun = Integer.parseInt(bStr.charAt(2)+"");
		b =  one + ten * 10 + hun * 100;
		
		//print
		if (a > b) {
			System.out.println(a);
		} else {
			System.out.println(b);
		}
	}
	
	public static void main(String[] args) throws Exception{
		new Main().sol_2908();
	}
}
