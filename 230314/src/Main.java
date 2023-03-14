import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public int getGCD(int a, int b) {
        if ( b == 0 )	return a;
        if ( a < b )	return getGCD(b, a);
        return getGCD( b, a%b );
    }
    
    public void sol_2485() throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int N = Integer.parseInt(br.readLine());
    	
    	int[] num = new int[N];
    	for (int i = 0; i < N; i++) {
    		num[i] = Integer.parseInt(br.readLine());
    	}
    	
    	// 간격 계산
    	// 그 간격들끼리 최대공약수 구하기
    	int gcd = getGCD(num[1] - num[0], num[2] - num[1]);
    	for (int i = 3; i < N; i++) {
    		gcd = getGCD(gcd, num[i] - num[i-1]);
    	}
    	
    	// 없는 경우 cnt
    	int cnt = 0;
    	for (int i = 1; i < N; i++) {
    		int val = (num[i] - num[i-1]) / gcd - 1;
    		cnt += val;
    	}
    	
    	System.out.println(cnt);
    }

    class Str2Num implements Comparable {
    	
    	private int num;
    	private String str;

    	public String[] num2str = {
    			"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"
    	};
    	
    	public Str2Num (int num) {
    		this.num = num;
    		if (num < 10) {
    			this.str = num2str[num];
    		} else {
    			this.str = num2str[num/10] + " " + num2str[num%10];
    		}
    	}
    	
    	public int getNum() { return num; }
    	public String getStr() { return str; }

		@Override
		public int compareTo(Object o) {
			Str2Num s2n = (Str2Num) o;
			return this.str.compareTo(s2n.getStr());
		}
    }
    
    public void sol_1755() throws Exception {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	int M = Integer.parseInt(st.nextToken());
    	int N = Integer.parseInt(st.nextToken());
    	Str2Num[] str = new Str2Num[N-M+1];
    	
    	for (int i = M, j = 0; i <= N; i++, j++) {
    		str[j] = new Str2Num(i);
    	}
    	Arrays.sort(str);
    	
    	StringBuilder sb = new StringBuilder();
    	for (int i = 0; i < N-M+1; i++) {
    		sb.append(str[i].getNum()).append(' ');
    		if (i % 10 == 9) {
    			sb.append('\n');
    		}
    	}
    	System.out.println(sb);
    }
    
	public static void main(String[] args) throws Exception {
		new Main().sol_1755();
	}
}
