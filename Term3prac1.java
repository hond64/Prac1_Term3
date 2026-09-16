// Surname: Wentzel
// Name: Miguel
// Student no: 4478677
// Course: CSC212
// Year: 2026
// Assignment: Practical 1 Term 3
// File: Term3Prac1.java

//import packages
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class Term3prac1 {

    // Algorithm 1
    public static void algorithm1(int[] arr) {
        int count = 0;

        // For each positive element, perform a sequential search for -x.
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                int x = arr[i];

                for (int j = 0; j < arr.length; j++) {
                    if (arr[j] == -x) {
                        System.out.println(x + " and " + (-x) + " are in the array");
                        count++;
                        break;
                    }
                }
            }
        }

        System.out.println("Number of pairs: " + count);
    }

    // Algorithm 2
    public static void algorithm2(int[] arr) {
        int i = 0;
        int j = arr.length - 1;
        int count = 0;

        while (i < j) {
            int sum = arr[i] + arr[j];

            if (sum == 0) {
                System.out.println(arr[j] + " and " + arr[i] + " are in the array");
                count++;
                i++;
                j--;
            } else if (sum > 0) {
                j--;
            } else {
                i++;
            }
        }

        System.out.println("Number of pairs: " + count);
    }

    public static int[] generateRandomArray(int length, int min, int max) {
        // function to generate random array
        return ThreadLocalRandom.current().ints(length, min, max + 1).toArray();
    }

    public static void main(String[] args) {
        try {
            // Read input from a text file
            BufferedReader reader = new BufferedReader(
                    new FileReader("input1.txt")
            );

            String line = reader.readLine();
            reader.close();

            // Split the input string into an array of integers
            int[] arr = Arrays.stream(line.split(","))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            // The practical states that the input array is sorted.
            // Sort here as a safeguard if the supplied text is not sorted.
            Arrays.sort(arr);

            System.out.println("Algorithm 1:");
            long startTime1 = System.nanoTime();
            algorithm1(arr);
            long endTime1 = System.nanoTime();
            long elapsedTime1 = endTime1 - startTime1;

            System.out.println();
            System.out.println("Algorithm 2:");
            long startTime2 = System.nanoTime();
            algorithm2(arr);
            long endTime2 = System.nanoTime();
            long elapsedTime2 = endTime2 - startTime2;

            System.out.println();
            System.out.println("Algorithm 1 Runtime in nano seconds: " + elapsedTime1);
            System.out.println("Algorithm 2 Runtime in nano seconds: " + elapsedTime2);
            System.out.println("Algorithm 1 Runtime in seconds: " + (elapsedTime1 / 1e9));
            System.out.println("Algorithm 2 Runtime in seconds: " + (elapsedTime2 / 1e9));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
