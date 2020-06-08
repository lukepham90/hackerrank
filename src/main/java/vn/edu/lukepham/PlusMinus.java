package vn.edu.lukepham;

import java.io.*;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

/**
 * @author : Luke Pham
 * @since : 08/06/2020, Mon
 **/
public class PlusMinus {

    private static String[] plusMinus(int[] arr) {
        int positive = 0;
        int negative = 0;
        int zero = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                positive++;
            } else if (arr[i] < 0) {
                negative++;
            } else {
                zero++;
            }
        }

        String[] result = new String[3];
        DecimalFormat df = new DecimalFormat("0.000000");

        result[0] = df.format(BigDecimal.valueOf(positive).divide(BigDecimal.valueOf(arr.length), 6, RoundingMode.HALF_EVEN).doubleValue());
        result[1] = df.format(BigDecimal.valueOf(negative).divide(BigDecimal.valueOf(arr.length), 6, RoundingMode.HALF_EVEN).doubleValue());
        result[2] = df.format(BigDecimal.valueOf(zero).divide(BigDecimal.valueOf(arr.length), 6, RoundingMode.HALF_EVEN).doubleValue());
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("input/plus_minus.txt"));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("output/plus_minus.txt"));

        int n = Integer.valueOf(bufferedReader.readLine());
        String[] arrItems = bufferedReader.readLine().split(" ");

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.valueOf(arrItems[i]);
        }
        String[] result = plusMinus(arr);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(result[i] + "\n");
        }

        bufferedReader.close();
        bufferedWriter.close();
    }
}
