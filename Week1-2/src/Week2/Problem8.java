package Week2;

class Parking {

    String[] table = new String[500];

    int hash(String s) {
        return Math.abs(s.hashCode()) % 500;
    }

    int park(String plate) {
        int i = hash(plate);
        while (table[i] != null) i = (i + 1) % 500;
        table[i] = plate;
        return i;
    }
}