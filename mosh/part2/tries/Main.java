package part2.tries;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("car");
        trie.insert("card");
        trie.insert("care");
        trie.insert("careful");
        trie.insert("egg");
        // System.out.println(trie.hasWord(""));
        // trie.remove("book");
        // trie.traverse();
        // System.out.println(trie.hasWord("car"));
        // System.out.println(trie.hasWord("care"));
        List<String> words = trie.autoComplete("");
        System.out.println(words.toString());
        System.out.println("Done");
    }
}
