import java.util.HashMap;

public class Nodie {
    char c;
    HashMap<Character, Nodie> children = new HashMap<Character, Nodie>();
    boolean isLeaf;

    public Nodie() {

    }

    public Nodie(char c) {
        isLeaf = false;
        this.c = c;
    }
}