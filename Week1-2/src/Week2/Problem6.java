package Week2;

import java.util.*;

class TokenBucket {
    int tokens;
    long last;

    TokenBucket(int t) {
        tokens = t;
        last = System.currentTimeMillis();
    }
}

class RateLimiter {

    HashMap<String, TokenBucket> map = new HashMap<>();
    int max = 1000;

    public boolean allow(String id) {
        map.putIfAbsent(id, new TokenBucket(max));
        TokenBucket tb = map.get(id);

        if (tb.tokens > 0) {
            tb.tokens--;
            return true;
        }
        return false;
    }
}