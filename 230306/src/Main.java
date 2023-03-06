import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	
	public int romeStr2num(String str) {
		// 로마숫자 HashMap
		HashMap<String, Integer> rome2num = new HashMap<>();
		rome2num.put("I", 1);
		rome2num.put("V", 5);
		rome2num.put("X", 10);
		rome2num.put("L", 50);
		rome2num.put("C", 100);
		rome2num.put("D", 500);
		rome2num.put("M", 1000);
		
		int num = 0;
		int i;
		for (i = 0; i < str.length() - 1; i++) {
			int v1 = rome2num.get(str.charAt(i)+"");
			int v2 = rome2num.get(str.charAt(i+1)+"");
			
			if (v1 < v2) {
				num += (v2 - v1);
				i++;
			} else {
				num += v1;
			}
		}
		
		if (i < str.length()) {
			num += rome2num.get(str.charAt(str.length()-1)+"");
		}
		
		return num;
	}
	
	public StringBuilder num2romeStr(int num) {
		StringBuilder sb = new StringBuilder();
		
		// M : 1000
		int m = num / 1000;
		num %= 1000;
		switch(m) {
			case 1:	sb.append("M");		break;
			case 2:	sb.append("MM");	break;
			case 3:	sb.append("MMM");	break;
		}

		// CD : 100
		int cd = num / 100;
		num %= 100;
		switch(cd) {
			case 1:	sb.append("C");		break;
			case 2:	sb.append("CC");	break;
			case 3:	sb.append("CCC");	break;
			case 4:	sb.append("CD");	break;
			case 5:	sb.append("D");		break;
			case 6:	sb.append("DC");	break;
			case 7:	sb.append("DCC");	break;
			case 8:	sb.append("DCCC");	break;
			case 9:	sb.append("CM");	break;
		}

		// XL : 10
		int xl = num / 10;
		num %= 10;
		switch(xl) {
			case 1:	sb.append("X");		break;
			case 2:	sb.append("XX");	break;
			case 3:	sb.append("XXX");	break;
			case 4:	sb.append("XL");	break;
			case 5:	sb.append("L");		break;
			case 6:	sb.append("LX");	break;
			case 7:	sb.append("LXX");	break;
			case 8:	sb.append("LXXX");	break;
			case 9:	sb.append("XC");	break;
		}
		
		// IV : 1
		switch(num) {
			case 1:	sb.append("I");		break;
			case 2:	sb.append("II");	break;
			case 3:	sb.append("III");	break;
			case 4:	sb.append("IV");	break;
			case 5:	sb.append("V");		break;
			case 6:	sb.append("VI");	break;
			case 7:	sb.append("VII");	break;
			case 8:	sb.append("VIII");	break;
			case 9:	sb.append("IX");	break;
		}
		
		return sb;
	}
	
	public void sol_2608() throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s1 = br.readLine();
		String s2 = br.readLine();
		
		int n1 = romeStr2num(s1);
		int n2 = romeStr2num(s2);
		
		int sum = n1 + n2;
		StringBuilder sumRome = num2romeStr(sum);
		
		System.out.println(sum);
		System.out.println(sumRome);
	}

	
	public void sol_2824() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BigInteger MAX = BigInteger.valueOf(1000000000);
		
		// N개의 수
		BigInteger numN = BigInteger.ONE;
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer stN = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			numN = numN.multiply(new BigInteger(stN.nextToken()));
		}
		

		// M개의 수
		BigInteger numM = BigInteger.ONE;
		int M = Integer.parseInt(br.readLine());
		
		StringTokenizer stM = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			numM = numM.multiply(new BigInteger(stM.nextToken()));
		}
		
		
		// 답 구하기
		BigInteger ans = numN.gcd(numM);
		if (ans.compareTo(MAX) >= 0) {
			ans = ans.mod(MAX);
			System.out.println(String.format("%09d", ans));
		} else {
			System.out.println(ans);
		}
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_2824();
	}
}
