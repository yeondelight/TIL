import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
	
	class Trie {
		
		class Node {
			private TreeMap<String, Node> child;
			private boolean isLeaf;
			
			public Node () {
				child = new TreeMap<String, Node>();
				isLeaf = false;
			}
		}
		
		private Node root;
		private StringBuilder sb;
		
		public Trie() {
			root = new Node();
			sb = new StringBuilder();
		}
		
		// getter
		public Node getRoot() {
			return root;
		}
		
		public StringBuilder getStringBuilder() {
			return sb;
		}
		
		// insert new nodes
		public void insert(String line) {
			StringTokenizer st = new StringTokenizer(line);
			int K = Integer.parseInt(st.nextToken());

			Node node = this.root;
			for (int i = 0; i < K; i++) {
				node = node.child.computeIfAbsent(st.nextToken(), key -> new Node());
			}
			node.isLeaf = true;
		}
		
		// inOrder
		public void inOrder(Node n, int depth) {
			for (Entry<String, Node> entry : n.child.entrySet()) {
				for (int i = 0; i < depth; i++)		sb.append("--");
				sb.append(entry.getKey()).append('\n');
				inOrder(entry.getValue(), depth+1);
			}
		}
	}
	
	public void sol_14725() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		Trie trie = new Trie();
		
		for (int i = 0; i < N; i++) {
			trie.insert(br.readLine());
		}
		
		trie.inOrder(trie.getRoot(), 0);
		System.out.println(trie.getStringBuilder());
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_14725();
	}
}
