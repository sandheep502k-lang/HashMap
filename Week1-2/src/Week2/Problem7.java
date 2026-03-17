package Week2;

import java.util.*;

class AutoComplete {

    HashMap<String, Integer> freq = new HashMap<>();

    public void add(String q) {
        freq.put(q, freq.getOrDefault(q, 0) + 1);
    }

    public List<String> search(String pre) {
        return freq.keySet().stream()
                .filter(s -> s.startsWith(pre))
                .sorted((a,b)->freq.get(b)-freq.get(a))
                .limit(5)
                .toList();
    }
}