import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public void sol_1924() throws Exception {
		// ready
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// scan
		// int line = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int month = Integer.parseInt(st.nextToken());
		int day = Integer.parseInt(st.nextToken());
		
		// cal
		int months[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		
		int sum = 0;
		for (int i = 0; i < month - 1; sum += months[i], i++);
		sum += day;
		
		String weekday = "";
		switch (sum%7) {
		case 0:		weekday = "SUN";	break;
		case 1:		weekday = "MON";	break;
		case 2:		weekday = "TUE";	break;
		case 3:		weekday = "WED";	break;
		case 4:		weekday = "THU";	break;
		case 5:		weekday = "FRI";	break;
		case 6:		weekday = "SAT";	break;
		}
		
		// print
		sb.append(weekday).append('\n');
		System.out.println(sb);
		
		// end
		br.close();
	}
	
	public void sol_4673() throws Exception {
		StringBuilder sb = new StringBuilder();
		
		int i, num, sum;
		boolean check[] = new boolean[10001];
		
		for (i = 0; i < 10001; i++) {	
			check[i] = true;
		}
		
		for (i = 1; i < 10000; i++) {			
			sum = 0;
			num = i;
			sum += num;
			while (num > 0) {
				sum += num % 10;
				num /= 10;
			}
			
			if (sum <= 10000 && sum != i) {
				check[sum] = false;
			}
		}
		
		
		for (i = 1; i < 10000; i++) {
			if (check[i]) {
				sb.append(i).append('\n');
			}
		}
		System.out.println(sb);
	}
	
	public void sol_1978() throws Exception {
		// ready
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				
		// scan, cal;
		int nums = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		int i, j, count = 0;
		boolean check[] = new boolean[nums];
		for (i = 0; i < nums; i++) {
			check[i] = true;
		}
		
		for(i = 0; i < nums; i++) {
			int num = Integer.parseInt(st.nextToken()); 
			if (num == 1) {
				check[i] = false;
				continue;
			}
			
			int sqrtNum = (int) Math.sqrt(num);
			for (j = 2; j <= sqrtNum; j++) {
				if (num % j == 0)
					check[i] = false;
			}
		}
		
		for (i = 0; i < nums; i++) {
			if (check[i])	count++;
		}
		
		// print
		System.out.println(count);
	}
	
	public void sol_1316() throws Exception {
		// ready
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
		// scan
		int line = Integer.parseInt(br.readLine());

		// cal
		int i, j, count = 0;
		boolean[] check = new boolean[line];
		List word = new ArrayList<Character>();
		
		for (i = 0; i < line; i++) {
			word.clear();
			check[i] = true;
			String words = br.readLine();
			for (j = 0; j < words.length(); j++) {
				char old = words.charAt(j > 0 ? j - 1 : j);
				char now = words.charAt(j);
				if (word.contains(now) && (old != now))
					check[i] = false;
				else
					word.add(now);
			}
		}
		
		// print
		for (i = 0; i < line; i++) {
			if (check[i])
				count++;
		}
		System.out.println(count);
	}

	public void sol_2751() throws Exception {
		// ready
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// scan
		int line = Integer.parseInt(br.readLine());

		// cal
		int i;
		int[] nums = new int[line];
		
		for (i = 0; i < line; i++) {
			nums[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(nums);
		
		for (i = 0; i < line; i++) {
			sb.append(nums[i]).append('\n');
		}
		
		// print
		System.out.println(sb);
	}
	
	public static void main(String [] args) throws Exception{
		new Main().sol_2751();
	}
}
