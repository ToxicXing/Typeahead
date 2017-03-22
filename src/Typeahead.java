import java.io.File;
import java.io.IOException;
import java.util.*;
/*
 * This project is a simple version of typeahead.
 * This version of typeahead is implemented by Trie.
 * Functionalities includes top k frequent keywords fetching, serialization and deserialization 
 * serialization and deserialization is used to store/recover trie into/from file and disk
 * trie itself is used to store in memory so that acquiring hottest keywords is fast.
 */
class TrieNode {
	TrieNode[] children;
	List<String> hotKeywords;
	public TrieNode() {
		children = new TrieNode[26];
		hotKeywords = new ArrayList<String>();
	}
}
public class Typeahead {
	private static final String FILE_NAME = "/Users/DaXing/Desktop/JavaCode/Typeahead/src/Keywords";
	private final TrieNode root = new TrieNode();
	private static final int TOP_K = 10;
	private final Map<String, Integer> keyword2Frequency = new HashMap<String, Integer>();

	public void buildTrie() throws IOException {
		File keywordsFile = new File(FILE_NAME);
		Scanner sc = new Scanner(keywordsFile);
		TrieNode curr = null;
		while (sc.hasNext()) {
			String keyword = sc.next();
			int frequency = sc.nextInt();
			addKeyword(keyword, frequency);
		}
	}
	/*
	 * Add a keyword to trie
	 * @return return false if trie already contains this word.
	 */
	public boolean addKeyword(String keyword, int frequency) {
		if (keyword2Frequency.containsKey(keyword)) {
			return false;
		}
		TrieNode curr = root;
		for (int i = 0; i < keyword.length(); i++) {
			char ch = keyword.charAt(i);
			int index = ch - 'a';
			if (curr.children[index] == null) {
				curr.children[index] = new TrieNode();
			}
			curr = curr.children[index];
			curr.hotKeywords.add(keyword);
			keyword2Frequency.put(keyword, frequency);
			// remove the least frequent keyword if the number of hot keywords exceeds max value
			if (curr.hotKeywords.size() > TOP_K) {
				int minFreq = Integer.MAX_VALUE;
				String minFreqKeyword = "";
				for (String str : curr.hotKeywords) {
					if (keyword2Frequency.get(str) < minFreq) {
						minFreq = keyword2Frequency.get(str);
						minFreqKeyword = str;
					}
				}
				curr.hotKeywords.remove(minFreqKeyword);
				keyword2Frequency.remove(minFreqKeyword);
			}
		}
		return true;
	}
	
	public List<String> search(String userInput) {
		TrieNode curr = root;
		List<String> res = null;
		for (int i = 0; i < userInput.length(); i++) {
			char ch = userInput.charAt(i);
			int index = ch - 'a';
			if (curr.children[index] != null) {
				curr = curr.children[index];
				res = curr.hotKeywords;
			} else {
				return res;
			}
		}
		return res;
	}
	
	public String serialize(TrieNode root) {
		StringBuilder sb = new StringBuilder();
		TrieNode curr = root;
		sb.append("<");
		for (int i = 0; i < 26; i++) {
			if (curr.children[i] != null) {
				char c = (char) ('a' + i);
				sb.append(c);
				sb.append(serialize(curr.children[i]));
			}
		}
        sb.append('>');
        return sb.toString();
	}
	
	public TrieNode deserialize(String data) {
		Stack<TrieNode> stack = new Stack<>();
        TrieNode top = new TrieNode(), curr = top;
        for (char c : data.toCharArray()) {
            if (c == '<') {
                stack.push(curr);
            } else if (c == '>') {
                stack.pop();
            } else {
                curr = new TrieNode();
                stack.peek().children[c - 'a'] = curr;
            }
        } 
        return root;
	}
}
