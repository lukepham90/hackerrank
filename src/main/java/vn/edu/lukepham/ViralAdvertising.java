package vn.edu.lukepham;

import java.io.*;

/**
 * @author : Luke Pham
 * @since : 27/06/2020, Sat
 **/
public class ViralAdvertising {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("input/viral_advertising.txt"));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("output/viral_advertising.txt"));

        int n = Integer.valueOf(bufferedReader.readLine());

        viralAdvertising(bufferedWriter, n);

        bufferedReader.close();
        bufferedWriter.close();
    }

    private static void viralAdvertising(BufferedWriter bufferedWriter, int n) throws IOException {
        int shared = 5;
        int cumulative = 0;
        int liked;
        for (int i = 1; i <= n; i++) {
            liked = (int) Math.floor(shared / 2);
            shared = liked * 3;
            cumulative += liked;
        }
        bufferedWriter.write(cumulative + "\n");
    }


}
