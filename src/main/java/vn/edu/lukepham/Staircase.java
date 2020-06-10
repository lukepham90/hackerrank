package vn.edu.lukepham;

import java.io.*;

/**
 * @author : Luke Pham
 * @since : 09/06/2020, Tue
 **/
public class Staircase {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("input/staircase.txt"));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("output/staircase.txt"));

        int n = Integer.valueOf(bufferedReader.readLine());

        staircase(bufferedWriter, n);

        bufferedReader.close();
        bufferedWriter.close();
    }

    private static void staircase(BufferedWriter bufferedWriter, int n) throws IOException {
        for (int i = 0; i < n; i++) {
            String stairs = "";
            for (int j = 0; j < n; j++) {
                if (j < n - i - 1) {
                    stairs = stairs.concat(" ");
                } else {
                    stairs = stairs.concat("#");
                }
            }
            bufferedWriter.write(stairs + "\n");
        }
    }
}
