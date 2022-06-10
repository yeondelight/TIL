import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	public void sol_1000() throws Exception {
		// ready
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// scan
		// int line = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		sb.append(a+b).append('\n');
		
		// print
		System.out.println(sb);
		
		// end
		br.close();
	}
	
	public void sol_1037() throws Exception {
		// ready
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// scan
		int line = Integer.parseInt(br.readLine());		// n의 진짜 약수 개수
		StringTokenizer st = new StringTokenizer(br.readLine());	// 약수가 적힌 lines
				
		int min = 0;
		int max = 0;
		for (int i = 0; i < line; i++) {
			int s = Integer.parseInt(st.nextToken());
			if (i == 0) {
				min = s;
				max = s;
			} else {
				if (s < min ) {
					min = s;
				}
				if ( s > max ) {
					max = s;
				}
			}
		}
		
		int realnum = min * max;
		
		sb.append(realnum).append('\n');
		
		// print
		System.out.println(sb);
		
		// end
		br.close();
	}
	
	public void sol_1110() throws Exception {
		// ready
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// scan
		int num = Integer.parseInt(br.readLine());
		
		// cal
		int count = 0;
		int newNum = num;
		int bigNum;
		int smallNum;
		do {
			count++;
			bigNum = newNum / 10;
			smallNum = newNum % 10;
			newNum = smallNum * 10 + ( smallNum + bigNum ) % 10;
		} while(num != newNum);
		
		// print
		System.out.println(count);
		
		// end
		br.close();
	}
	
	public void sol_1157() throws Exception {
		// ready
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// scan
		String word = br.readLine();
		word = word.toUpperCase();
		
		// cal
		Map alphaCount = new HashMap<Character, Integer>();
		for(int i = 0; i < word.length(); i++) {
			char chars = (Character) word.charAt(i);
			if (!alphaCount.containsKey(chars)) {
				alphaCount.put(chars, 1);
			}
			else {
				int val = (int) alphaCount.get(chars);
				val++;
				alphaCount.put(chars, val);
			}
		}
		
		List<Map.Entry<Character, Integer>> entryList = new LinkedList<>(alphaCount.entrySet());
		entryList.sort(new Comparator<Map.Entry<Character, Integer>>() {
			@Override
			public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
				return o2.getValue() - o1.getValue();
			}
		});
		
		int maxCount = entryList.get(0).getValue();
		int count = 0;
		char maxChar = ' ';
		for( Map.Entry<Character, Integer> entry : entryList ) {
			if (entry.getValue() == maxCount) {
				if (count < 1) {
					count++;
					maxChar = entry.getKey();
				}
				else {
					maxChar = '?';
					break;
				}
			}
		}
		
		// print
		System.out.println(maxChar);
		
		// end
		br.close();
	}
	
	public void sol_1193() throws Exception {
		// ready
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// scan
		int num = Integer.parseInt(br.readLine());
		
		// cal
		int numerator = 1;
		int denominator = 1;
		
		int index = 1;
		int sum = 0;
		do {
			sum += index;
			index++;
		} while (sum < num);	// i는 numerator + denominator


		// start Index
		int startIndex = 0;
		for (int i = 1; i < index - 1; i++) { startIndex += i; }
		startIndex++;
		
		int diff = num - startIndex;
		if ( index % 2 == 0 ) {
			denominator += diff;
			numerator = index - denominator;
			
		} else {
			numerator += diff;
			denominator = index - numerator;
		}
		
		// print
		sb.append(numerator).append("/").append(denominator);
		System.out.println(sb);
		
		// end
		br.close();
	}
	
	public void sol_1546() throws Exception {
		// ready
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// scan
		int n = Integer.parseInt(br.readLine());		// 과목 수
		StringTokenizer st = new StringTokenizer(br.readLine());	// 과목 점수가 적힌 lines
		
		// cal
		float score[] = new float[n];
		
		int s;
		int max = 0;
		float sum = 0;
		for (int i = 0; i < n; i++) {
			s = Integer.parseInt(st.nextToken());
			score[i] = s;
			if (max < s) {
				max = s;
			}
		}
		
		for (int i = 0; i < n; i++) {
			score[i] = score[i] / (float)max * 100;
			sum += score[i];
		}
		
		float avg = sum / (float)n;
		
		
		// print
		sb.append(avg).append('\n');
		System.out.println(sb);
		
		// end
		br.close();
	}
	
	public void sol_4344() throws Exception {
		// ready
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());		// 테스트케이스 수
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());	// testcase line
			int num = Integer.parseInt(st.nextToken());					// 학생 수
			
			int sum = 0;
			int score[] = new int[num];
			float avg;
			for (int j = 0; j < num; j++) {
				score[j] = Integer.parseInt(st.nextToken());
				sum += score[j];
			}
			avg = sum / (float)num;
			
			int count = 0;
			for (int j = 0; j < num; j++) {
				if ( score[j] > avg )
					count++;
			}
			
			avg = count / (float)num;
			double result = Math.round(avg*100000)/1000.0;
			sb.append(String.format("%.3f", result)).append('%').append('\n');
		}
		
		// print
		System.out.println(sb);
		
		// end
		br.close();
	}
	
	public void sol_2609() throws Exception {
		// ready
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// scan
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		int min = 0;
		int max = 0;
		
		int n1 = a;
		int n2 = b;
		do {
			min = n1 % n2;
			n1 = n2;
			n2 = min;
		} while(n2 != 0);
		min = n1;
		
		max = a * b / min;
		
		// print
		sb.append(min).append('\n');
		sb.append(max).append('\n');
		System.out.println(sb);
		
		// end
		br.close();
	}
	public static void main(String [] args) throws Exception{
		new Main().sol_2609();
	}
}
