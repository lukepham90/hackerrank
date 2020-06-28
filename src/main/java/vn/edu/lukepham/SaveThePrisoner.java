package vn.edu.lukepham;

import java.io.*;

/**
 * @author : Luke Pham
 * @since : 27/06/2020, Sat
 **/
public class SaveThePrisoner {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("input/save_the_prisoner.txt"));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("output/save_the_prisoner.txt"));

        int n = Integer.valueOf(bufferedReader.readLine());
        for (int i = 0; i < n; i++) {
            String testCase = bufferedReader.readLine();
            String[] splitNumbers = testCase.split(" ");
            int prison = Integer.valueOf(splitNumbers[0]);
            int candies = Integer.valueOf(splitNumbers[1]);
            int startPassingOut = Integer.valueOf(splitNumbers[2]) - 1;
            saveThePrisoner(bufferedWriter, prison, candies, startPassingOut);
        }

        bufferedReader.close();
        bufferedWriter.close();
    }

    private static void saveThePrisoner(BufferedWriter bufferedWriter, int prison, int candies, int startPassingOut) throws IOException {
        int warnedPrison = (startPassingOut + candies - 1) % prison + 1;
        bufferedWriter.write(warnedPrison + "\n");
    }
}
