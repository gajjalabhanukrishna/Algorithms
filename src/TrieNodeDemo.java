public class TrieNodeDemo {
    public static void main(String args[])
    {
        TrieNode t = new TrieNode();
        System.out.println("Children: " + t.children[0]); // will be null by default
        System.out.println("isEndWord: " + t.isEndWord);  // will be false by default

    }
}
