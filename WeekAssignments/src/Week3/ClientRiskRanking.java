import java.util.*;

class Client {
    String name;
    int riskScore;
    double balance;

    Client(String name, int riskScore, double balance) {
        this.name = name;
        this.riskScore = riskScore;
        this.balance = balance;
    }
}

public class ClientRiskRanking {

    static void bubbleSort(Client[] arr) {
        int n = arr.length, swaps = 0;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j].riskScore > arr[j + 1].riskScore) {
                    Client temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swaps++;
                }
            }
        }

        System.out.println("Bubble Sort (ASC):");
        for (Client c : arr)
            System.out.print(c.name + ":" + c.riskScore + " ");
        System.out.println("\nSwaps=" + swaps);
    }

    static void insertionSort(Client[] arr) {

        for (int i = 1; i < arr.length; i++) {
            Client key = arr[i];
            int j = i - 1;

            while (j >= 0 &&
                    (arr[j].riskScore < key.riskScore ||
                            (arr[j].riskScore == key.riskScore &&
                                    arr[j].balance < key.balance))) {

                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }

        System.out.println("Insertion Sort (DESC):");
        for (Client c : arr)
            System.out.print(c.name + ":" + c.riskScore + " ");
        System.out.println();
    }

    static void topRisk(Client[] arr, int k) {
        System.out.println("Top " + k + " risks:");
        for (int i = 0; i < Math.min(k, arr.length); i++)
            System.out.println(arr[i].name + "(" + arr[i].riskScore + ")");
    }

    public static void main(String[] args) {

        Client[] arr = {
                new Client("C", 80, 1000),
                new Client("A", 20, 2000),
                new Client("B", 50, 1500)
        };

        bubbleSort(arr);
        insertionSort(arr);
        topRisk(arr, 3);
    }
}