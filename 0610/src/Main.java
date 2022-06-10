import java.io.BufferedReader;
import java.io.InputStreamReader;
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
	
	public static void main(String [] args) throws Exception{
		new Main().sol_1924();
	}
}
