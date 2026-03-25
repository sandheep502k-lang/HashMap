package Week1;

import java.util.*;

class DNSEntry {
    String ip;
    long expiry;

    DNSEntry(String ip, long ttl) {
        this.ip = ip;
        this.expiry = System.currentTimeMillis() + ttl;
    }
}

class DNSCache {

    private HashMap<String, DNSEntry> cache = new HashMap<>();

    public String resolve(String domain) {

        if (cache.containsKey(domain)) {
            DNSEntry e = cache.get(domain);
            if (System.currentTimeMillis() < e.expiry)
                return "HIT " + e.ip;
        }

        String ip = "172.217.0." + new Random().nextInt(255);
        cache.put(domain, new DNSEntry(ip, 3000));
        return "MISS " + ip;
    }

    public static void main(String[] args) {
        DNSCache d = new DNSCache();
        System.out.println(d.resolve("google.com"));
        System.out.println(d.resolve("google.com"));
    }
}