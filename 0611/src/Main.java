import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public void sol_2581() throws Exception {
		// ready
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		// scan
		int m = Integer.parseInt(br.readLine());
		int n = Integer.parseInt(br.readLine());
		
		// cal
		boolean check;
		int i, j, sqrts;
		int sum = 0;
		List<Integer> primes = new ArrayList<Integer>();
		
		for(i = m; i <= n; i++) {
			check = true;
			sqrts = (int) Math.sqrt(i);
			for (j = 2; j <= sqrts; j++) {
				if (i % j == 0) {
					check = false;
					break;
				}
			}
			if (check && i != 1) {
				sum += i;
				primes.add(i);
			}
		}
		
		if (primes.size() == 0) {
			sb.append(-1).append('\n');
		}
		else {
			Collections.sort(primes);
			sb.append(sum).append('\n');
			sb.append(primes.get(0)).append('\n');
		}
			
		
		System.out.println(sb);
	}
	
	public void sol_10814() throws Exception {
		// ready
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		// scan
		int n = Integer.parseInt(br.readLine());
		
		// cal
		int i;
		int age;
		String name;
		People[] people = new People[n]; 
		
		for(i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			age = Integer.parseInt(st.nextToken());
			name = st.nextToken();
			people[i] = new People(age, name);
		}
		Arrays.sort(people);
		
		for(i = 0; i < n; i++) {
			sb.append(people[i].age).append(" ").append(people[i].name).append("\n");
		}
		
		System.out.println(sb);
	}
	
	class People implements Comparable<People> {
		public int age;
		public String name;
		
		People(int age, String name){
			this.age = age;
			this.name = name;
		}
		
		@Override
		public int compareTo(People p) {
			if (this.age == p.age)		return 0;
			else if (this.age < p.age)	return -1;
			else						return 1;
		}
	}
	
	public void sol_11653() throws Exception {
		// ready
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// scan
		int n = Integer.parseInt(br.readLine());
		
		// cal
		int i;
		List<Integer> nums = new ArrayList<Integer>();
		if (n != 1){
			for (i = 2; i <= n; i++) {
				while ( n % i == 0 ) {
					nums.add(i);
					n /= i;
				}
			}
		}
		
		for (i = 0; i < nums.size(); i++) {
			sb.append(nums.get(i)).append('\n');
		}
		
		// print
		System.out.println(sb);
	}
	
	public void sol_1001() throws Exception {
		// ready
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// scan
		// int line = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		sb.append(a-b).append('\n');
		
		// print
		System.out.println(sb);
		
		// end
		br.close();
	}

	public void sol_2475() throws Exception {
		// ready
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// scan
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// cal
		int i, num, cal = 0;
		for (i = 0; i < 5; i++) {
			num = Integer.parseInt(st.nextToken()) ;
			cal += num * num;
		}
		
		// print
		System.out.println(cal%10);
		
		// end
		br.close();
	}

	public void sol_1152() throws Exception {
		// ready
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// scan
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// cal
		int count = 0;
		while (st.hasMoreTokens()){
			st.nextToken() ;
			count++;
		}
		
		// print
		System.out.println(count);
		
		// end
		br.close();
	}
	
	public void sol_2562() throws Exception {
		// ready
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// scan,  cal
		int max = 0, maxIndex = 0, num;
		
		for (int i = 0; i < 9; i++) {
			num = Integer.parseInt(br.readLine());
			if (num > max) {
				maxIndex = i + 1;
				max = num;
			}
		}
		
		sb.append(max).append('\n');
		sb.append(maxIndex).append('\n');
		
		// print
		System.out.println(sb);

		
		// end
		br.close();

	}
	
	
	public static void main(String [] args) throws Exception{
		new Main().sol_2562();
	}
}
