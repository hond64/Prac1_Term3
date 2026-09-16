// Surname: Enter your surname
// Name: Enter your name
// Student no: Enter your student number
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
//Write Java functions that implement Algorithm 1 and Algorithm 2. 
        
    // Algorithm 1
    public static void algorithm1(int[] arr) {
        
        //Enter your code here
    }
  

    // Algorithm 2
    public static void algorithm2(int[] arr) {
        
        //Enter your code here
        
    }
    
    public static int[] generateRandomArray(int length, int min, int max) {
        // function to generate random array
        return ThreadLocalRandom.current().ints(length, min, max + 1).toArray();
    }
    
    
    
    public static void main(String[] args) {
        try {
            // Read input from a text file
            BufferedReader reader = new BufferedReader(new FileReader("Enter the path to input texts here: \\input1.txt"));
            String line = reader.readLine();
            reader.close();

            // Split the input string into an array of integers
            int[] arr = Arrays.stream(line.split(",")).mapToInt(Integer::parseInt).toArray();
            
            //Uncomment the line below to use the random array generator
            //int[] randomArray = generateRandomArray(400, -1000, 1000); 
            //change the first argument of the function call above to start from 400 and double progressively until it gets to 51200
                        
            //measure start time/end time of algorithm1 using "System.nanoTime()
            long startTime1 = System.nanoTime();
            
            algorithm1(arr);
            long endTime1 = System.nanoTime();
            long elapsedTime1 = endTime1 - startTime1;
            
          //measure start time/end time of algorithm2 using "System.nanoTime()
            long startTime2 = System.nanoTime();
            algorithm2(arr);
            long endTime2 = System.nanoTime();
            long elapsedTime2 = endTime2 - startTime2;

            // print the pairs found by both algorithms and their runtimes in nanoseconds and seconds
            System.out.println("Algorithm 1 Runtime in nano seconds: " + elapsedTime1);
            System.out.println("Algorithm 2 Runtime in nano seconds: " + elapsedTime2);
            System.out.println("Algorithm 1 Runtime in seconds: " + (elapsedTime1 / 1e9));
            System.out.println("Algorithm 2 Runtime in seconds: " + (elapsedTime2 / 1e9));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


