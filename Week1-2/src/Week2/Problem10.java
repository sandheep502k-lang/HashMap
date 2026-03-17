package Week2;

import java.util.*;

class LRU<K,V> extends LinkedHashMap<K,V>{
    int cap;
    LRU(int c){super(c,0.75f,true); cap=c;}
    protected boolean removeEldestEntry(Map.Entry<K,V> e){
        return size()>cap;
    }
}

class CacheSystem {

    LRU<String,String> L1 = new LRU<>(10000);
    HashMap<String,String> L2 = new HashMap<>();

    public String get(String key){
        if(L1.containsKey(key)) return "L1";
        if(L2.containsKey(key)){
            L1.put(key, L2.get(key));
            return "L2";
        }
        L2.put(key, "data");
        return "DB";
    }
}