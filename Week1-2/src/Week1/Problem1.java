import java.util.*;

class UsernameChecker {

    private HashMap<String, Integer> users = new HashMap<>();
    private HashMap<String, Integer> attempts = new HashMap<>();

    public boolean checkAvailability(String username) {
        attempts.put(username, attempts.getOrDefault(username, 0) + 1);
        return !users.containsKey(username);
    }

    public void register(String username, int userId) {
        users.put(username, userId);
    }

    public List<String> suggest(String username) {
        List<String> res = new ArrayList<>();
        for (int i = 1; i <= 3; i++)
            res.add(username + i);
        res.add(username.replace("_", "."));
        return res;
    }

    public String getMostAttempted() {
        return attempts.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .get().getKey();
    }

    public static void main(String[] args) {
        UsernameChecker uc = new UsernameChecker();
        uc.register("john_doe", 1);

        System.out.println(uc.checkAvailability("john_doe"));
        System.out.println(uc.checkAvailability("jane_smith"));
        System.out.println(uc.suggest("john_doe"));
        System.out.println(uc.getMostAttempted());
    }
}