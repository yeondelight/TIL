import java.util.*;
import java.io.*;

public class Main {

	public void sol_11399() throws Exception{
		// scan
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		
		int[] times = new int[N];
		for(int i = 0; i < N; i++) {
			times[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(times);		// sort by times
		
		// cal min totalTime
		int totalSum = 0;
		for(int i = 0; i < N; i++) {
			int sum = 0;
			for(int j = 0; j <= i; j++) {
				sum += times[j];
			}
			totalSum += sum;
		}
		
		// show res
		System.out.println(totalSum);
	}
	
	public static void main(String[] args) throws Exception{
		new Main().sol_11399();
	}
}
