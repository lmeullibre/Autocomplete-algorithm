import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

class Trie {
    private Nodie root = new Nodie();


    void insert(String str) {
        int index;
        Nodie current = root;
        char c;
        HashMap<Character, Nodie> children = new HashMap<>();
        for (int i = 0; i < str.length(); ++i) {
            if (!current.children.containsKey(str.charAt(i))) {
                current.children.put(str.charAt(i), new Nodie());
            }
            current = current.children.get(str.charAt(i));
        }
        current.isLeaf = true;

    }


    private void recursiveCall(Nodie nod, String str, String c, ArrayList<String> suggestions) {

        Nodie current = new Nodie();
        current = nod;
        if (nod.isLeaf) {
            suggestions.add(str + c);
            return;
        }
        Character[] chars = nod.children.keySet().toArray(new Character[0]);
        for (Character aChar : chars) {

            recursiveCall(current.children.get(aChar), str, c + aChar, suggestions);
        }
    }


    void getSuggestions(String str) {
        boolean noResults = false;
        Nodie current = root;
        ArrayList<String> suggestions = new ArrayList<>();

        for (int i = 0; i < str.length() && !noResults; ++i) {
            if (current.children.containsKey(str.charAt(i))) {
                current = current.children.get(str.charAt(i));
            } else noResults = true;

        }
        if (!noResults){
            recursiveCall(current, str, "", suggestions);
            Collections.sort(suggestions);
            boolean stop = false;
            for (int q = 0; q < suggestions.size() && !stop; ++q){
                System.out.println(suggestions.get(q));
                if (q == 3)stop = true;
            }

        }
    }
}