package Week1;

import java.util.*;

class Plagiarism {

    HashMap<String, Set<String>> map = new HashMap<>();

    public void addDoc(String id, String text) {
        String[] w = text.split(" ");
        for (int i = 0; i < w.length - 2; i++) {
            String gram = w[i] + " " + w[i+1] + " " + w[i+2];
            map.computeIfAbsent(gram, k -> new HashSet<>()).add(id);
        }
    }

    public int compare(String doc1, String doc2, String text) {
        int match = 0;
        String[] w = text.split(" ");
        for (int i = 0; i < w.length - 2; i++) {
            String gram = w[i]+" "+w[i+1]+" "+w[i+2];
            if (map.containsKey(gram) && map.get(gram).contains(doc2))
                match++;
        }
        return match;
    }
}
