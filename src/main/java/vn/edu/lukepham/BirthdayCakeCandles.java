package vn.edu.lukepham;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Toan Pham on 20/08/2020
 */
public class BirthdayCakeCandles {

    static int birthdayCakeCandles(int[] candlesHeight) {
        int count = 0;
        int maxHeight = Integer.MIN_VALUE;
        for (int i = 0; i < candlesHeight.length; i++) {
            if (candlesHeight[i] > maxHeight) {
                count = 1;
            } else if (candlesHeight[i] == maxHeight) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("input/birthday_cake_candles.txt"));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("output/birthday_cake_candles.txt"));

        int age = Integer.valueOf(bufferedReader.readLine());
        int[] candlesHeight =

        bufferedReader.close();
        bufferedWriter.close();
    }
}
