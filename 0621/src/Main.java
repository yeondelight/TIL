import java.io.*;
import java.util.*;

public class Main {
	
	public void sol_10610() throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		
		String N = br.readLine();
		Vector<Integer> nums = new Vector<Integer>();
		
		int sum = 0;
		for(int i = 0; i < N.length(); i++) {
			int num = Integer.parseInt(N.charAt(i)+"");
			nums.add(num);
			sum += num;
		}
		
		if (sum % 3 != 0 || !nums.contains(0))		sb.append(-1);
		else {
			Collections.sort(nums);
			Collections.reverse(nums);
			for(int i = 0; i < nums.size(); i++)	sb.append(nums.get(i));
		}
		
		System.out.println(sb);
		
	}
	
	class Score implements Comparable<Score>{
		String name;
		int korean;
		int english;
		int math;
		
		Score(String n, int k, int e, int m){
			this.name = n;
			this.korean = k;
			this.english = e;
			this.math = m;
		}
		
		@Override
		public int compareTo(Score s) {
			if (korean < s.korean)			return 1;
			else if (korean > s.korean)		return -1;
			else {
				if (english > s.english)		return 1;
				else if (english < s.english)	return -1;
				else {
					if (math < s.math)			return 1;
					else if (math > s.math)		return -1;
					else {
						int compare = name.compareTo(s.name);
						if (compare > 0)		return 1;
						else if (compare < 0)	return -1;
						else					return 0;
					}
				}
			}
		}
	}
	
	public void sol_10825() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		Vector<Score> score = new Vector<Score>();
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			int k = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			score.add(new Score(name, k, e, m));
		}
		
		Collections.sort(score);
		for(int i = 0; i < score.size(); i++) {
			Score s = score.get(i);
			sb.append(s.name).append('\n');
		}
		
		System.out.println(sb);
	}
	
	public void sol_11656() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String S = br.readLine();
		Vector<String> suffix = new Vector<String>();
		int lastIndex = S.length();
		for (int i = 0; i < S.length(); i++) {
			suffix.add(S.substring(i, lastIndex));
		}
		Collections.sort(suffix);
		
		for (int i = 0; i < suffix.size(); i++) {
			sb.append(suffix.get(i)).append('\n');
		}
		
		System.out.println(sb);
	}
	
	public void sol_11004() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		Vector<Integer> A = new Vector<>();
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++)	A.add(Integer.parseInt(st.nextToken()));
		Collections.sort(A);
		
		System.out.println(A.get(K - 1));
	}
	
	class Rank implements Comparable<Rank>{
		int document;
		int meeting;
		Rank(int d, int m){
			this.document = d;
			this.meeting = m;
		}
		
		@Override
		public int compareTo(Rank r) {
			if (document > r.document)		return 1;
			else if (document < r.document)	return -1;
			else							return 0;
		}
	}
	
	public void sol_1946() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			Vector<Rank> rank = new Vector<>();
			for (int j = 0; j < N; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int d = Integer.parseInt(st.nextToken());
				int m = Integer.parseInt(st.nextToken());
				rank.add(new Rank(d, m));
			}
			Collections.sort(rank);
			
			int count = 1;
			int minMeet = rank.get(0).meeting;
			for(int j = 1; j < rank.size(); j++) {
				int m = rank.get(j).meeting;
				if (minMeet > m) {
					minMeet = m;
					count++;
				}
			}
			sb.append(count).append('\n');
		}
		System.out.println(sb);
	}
	
	public void sol_11728() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Vector<Integer> arr = new Vector<>();
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr.add(Integer.parseInt(st.nextToken()));
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < M; i++) {
			arr.add(Integer.parseInt(st.nextToken()));
		}
		
		Collections.sort(arr);
		
		for(int i = 0; i < arr.size(); i++) {
			sb.append(arr.get(i)).append(' ');
		}
		
		System.out.println(sb);
	}
	
	public void sol_2470() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		Vector<Integer> nums = new Vector<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			nums.add(num);
		}
		Collections.sort(nums);
		
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		int abs = Integer.MAX_VALUE;
		int i = 0, j = nums.size() - 1;
		
		while (i < j) {
			int sum = nums.get(i) + nums.get(j);
			if (Math.abs(sum) < Math.abs(abs)) {
				min = nums.get(i);
				max = nums.get(j);
				abs = sum;
			}
			if (sum > 0)	j--;
			else 			i++;
		}
		
		sb.append(min).append(' ').append(max);
		System.out.println(sb);
	}
	
	public static void main(String[] args) throws Exception{
		new Main().sol_2470();
	}
}
