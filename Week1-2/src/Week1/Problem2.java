import java.util.*;

class Inventory {

    private HashMap<String, Integer> stock = new HashMap<>();
    private HashMap<String, Queue<Integer>> waitlist = new HashMap<>();

    public Inventory() {
        stock.put("IPHONE15_256GB", 100);
        waitlist.put("IPHONE15_256GB", new LinkedList<>());
    }

    public synchronized String purchase(String product, int userId) {
        if (stock.get(product) > 0) {
            stock.put(product, stock.get(product) - 1);
            return "Success, remaining: " + stock.get(product);
        } else {
            waitlist.get(product).add(userId);
            return "Added to waitlist #" + waitlist.get(product).size();
        }
    }

    public int checkStock(String product) {
        return stock.getOrDefault(product, 0);
    }

    public static void main(String[] args) {
        Inventory inv = new Inventory();
        System.out.println(inv.checkStock("IPHONE15_256GB"));
        System.out.println(inv.purchase("IPHONE15_256GB", 1));
    }
}