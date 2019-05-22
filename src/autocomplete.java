import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class autocomplete {

    private static Trie fillBuffer() {
        Trie filledTrie = new Trie();
        try {
            Scanner scanner = new Scanner(new File("src/input.txt"));

            String temp;
            while (scanner.hasNextLine()) {
                temp = scanner.nextLine();
                String[] tokens = temp.split(",");
                for (String str : tokens) {
                    str = str.trim();
                    filledTrie.insert(str.toLowerCase());
                }

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("The program couldn't find the text file containing the list of keywords. You should change the path manually at the autocomplete class, line 10.");
        }
        return filledTrie;
    }

    public static void main(String[] argv) {
        Trie myTree;
        myTree = fillBuffer();
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce the words you would like to check");
        String temp;
        while (sc.hasNext()){
            temp = sc.nextLine();
            if (temp.trim().length() > 0) myTree.getSuggestions(temp.toLowerCase().trim());
        }

    }

}