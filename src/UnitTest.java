import java.io.IOException;
import java.util.*;
public class UnitTest {
	public static void main(String[] args) {
		Typeahead tp = new Typeahead();
		try {
			tp.buildTrie();
		} catch (IOException e) {
			e.printStackTrace();
		}
		List<String> res = tp.search("a");
		System.out.println("result for searching a is " + res.toString());
		tp.addKeyword("abbcddee", 188);
		res = tp.search("a");
		System.out.println("result for searching a is " + res.toString());
	}
}
