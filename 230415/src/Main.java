import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public static char getScore(int score) {
		if (score >= 90)	return 'A';
		if (score >= 80)	return 'B';
		if (score >= 70)	return 'C';
		if (score >= 60)	return 'D';
		return 'F';
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		System.out.println(getScore(N));
	}
}