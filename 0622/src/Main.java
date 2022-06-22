import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class Main {

	public void sol_10867() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		Vector<Integer> nums = new Vector<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			if (!nums.contains(num))	nums.add(num);
		}
		Collections.sort(nums);
		
		for (int i = 0; i < nums.size(); i++) {
			sb.append(nums.get(i)).append(' ');
		}
		
		System.out.println(sb);
	}
	
	public void sol_11652() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		Map<Long, Integer> nums = new HashMap<Long, Integer>();
		for(int i = 0; i < N; i++) {
			int count = 0;
			long num = Long.parseLong(br.readLine());
			if (nums.containsKey(num))	count = nums.get(num) + 1;
			nums.put(num, count);
		}
		
		List<Entry<Long, Integer>> entryList = new ArrayList<>(nums.entrySet());
		Collections.sort(entryList, new Comparator<Entry<Long, Integer>>() {
			public int compare(Entry<Long, Integer> e1, Entry<Long, Integer> e2) {
				int compare = e2.getValue().compareTo(e1.getValue());
				if (compare == 0) {
					return e1.getKey().compareTo(e2.getKey());
				} else {
					return compare;
				}
			}
		});
		
		System.out.println(entryList.get(0).getKey());
	}
	
	public class TrieNode {
		Map<String, TrieNode> childNodes = new HashMap<>();
		boolean isLast;
	}
	
	public class Trie {
		TrieNode rootNode;
		
		Trie() {
			rootNode = new TrieNode();
		}
		
		public boolean insert(String str) {
			TrieNode thisNode = this.rootNode;
			for (int i = 0; i < str.length(); i++) {
				String s = str.charAt(i)+"";
				if (thisNode.childNodes.containsKey(s)) {
					if (thisNode.childNodes.get(s).isLast)	return false;
				}
				thisNode = thisNode.childNodes.computeIfAbsent(str.charAt(i)+"", key -> new TrieNode());
			}
			thisNode.isLast = true;
			return true;
		}
	}
	
	public void sol_5052() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		for(int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());
			String[] phones = new String[n];
			for (int j = 0; j < n; j++)	phones[j] = br.readLine();
			Arrays.sort(phones);
			
			boolean check = true;
			Trie trie = new Trie();
			for (int j = 0; j < n; j++) {
				if (!trie.insert(phones[j])) check = false;
			}
			if (check)	sb.append("YES").append('\n');
			else		sb.append("NO").append('\n');
		}
		
		System.out.println(sb);
	}
	
	public void sol_1302() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		Map<String, Integer> books = new HashMap<String, Integer>();
		for(int i = 0; i < N; i++) {
			int count = 0;
			String title = br.readLine();
			if (books.containsKey(title))	count = books.get(title) + 1;
			books.put(title, count);
		}
		
		List<Entry<String, Integer>> entryList = new ArrayList<>(books.entrySet());
		Collections.sort(entryList, new Comparator<Entry<String, Integer>>() {
			public int compare(Entry<String, Integer> e1, Entry<String, Integer> e2) {
				int compare = e2.getValue().compareTo(e1.getValue());
				if (compare == 0) {
					return e1.getKey().compareTo(e2.getKey());
				} else {
					return compare;
				}
			}
		});
		
		System.out.println(entryList.get(0).getKey());
	}
	
	class Jewel implements Comparable<Jewel>{
		int weight;
		int price;
		Jewel(int w, int p){
			this.weight = w;
			this.price = p;
		}
		
		@Override
		public int compareTo(Jewel j) {
			if (this.price < j.price)		return 1;
			else if (this.price > j.price)	return -1;
			else							return 0;
		}
	}
	
	public void sol_1202() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// scan N, K
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		// scan M, V
		Vector<Jewel> jewel = new Vector<>();
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int weight = Integer.parseInt(st.nextToken());
			int price = Integer.parseInt(st.nextToken());
			jewel.add(new Jewel(weight, price));
		}
		Collections.sort(jewel, new Comparator<Jewel>() {
			@Override
			public int compare(Jewel j1, Jewel j2) {
				if (j1.weight > j2.weight)		return 1;
				else if (j1.weight < j2.weight)	return -1;
				else							return 0;
			}
		});
		
		// scan C
		int[] bags = new int[K];
		for(int i = 0; i < K; i++) {
			bags[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(bags);
		
		// cal
		int j = 0;
		long maxPrice = 0;
		PriorityQueue<Jewel> getJewel = new PriorityQueue<>();
		for(int i = 0; i < K; i++) {
			int bagWeight = bags[i];
			for (; j < jewel.size(); j++) {
				if (jewel.get(j).weight > bags[i]) break;
				getJewel.add(jewel.get(j));
			}
			if (getJewel.size() > 0) {
				Jewel p = getJewel.poll();
				maxPrice += p.price;
			}
		}
		
		
		// print
		System.out.println(maxPrice);
	}
	
	public void sol_3273() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		Vector<Integer> nums = new Vector<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			nums.add(Integer.parseInt(st.nextToken()));
		}
		Collections.sort(nums);
		int x = Integer.parseInt(br.readLine());

		// cal
		int count = 0;
		int start = 0, end = nums.size() - 1;
		while (start < end) {
			int sum = nums.get(start) + nums.get(end);
			if (sum > x) {
				end--;
			} else if (sum < x) {
				start++;
			} else {
				count++;
				start++;
			}
		}
		
		System.out.println(count);
	}
	
	public static void main (String[] args) throws Exception {
		new Main().sol_3273();
	}
}
