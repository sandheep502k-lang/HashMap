package Week1;

import java.util.*;

class Analytics {

    HashMap<String, Integer> views = new HashMap<>();
    HashMap<String, Set<String>> users = new HashMap<>();
    HashMap<String, Integer> sources = new HashMap<>();

    public void process(String url, String user, String source) {
        views.put(url, views.getOrDefault(url, 0) + 1);
        users.computeIfAbsent(url, k -> new HashSet<>()).add(user);
        sources.put(source, sources.getOrDefault(source, 0) + 1);
    }

    public void dashboard() {
        views.entrySet().stream()
                .sorted((a,b)->b.getValue()-a.getValue())
                .limit(3)
                .forEach(e -> System.out.println(e.getKey()+" "+e.getValue()));
    }
}