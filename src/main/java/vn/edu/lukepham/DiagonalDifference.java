package vn.edu.lukepham;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author Toan Pham on 05/06/2020
 */
public class DiagonalDifference {
    public static void main(String[] args) throws IOException, IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("input/diagonal_difference.txt"));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("output/diagonal_difference.txt"));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> arr = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
            try {
                arr.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(Collectors.toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = diagonalDifference(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }

    public static int diagonalDifference(List<List<Integer>> arr) {
        int sizeOfDiagonal = arr.get(0).size();
        int sumPrimaryDiagonal = 0;
        int sumSecondaryDiagonal = 0;

        for (int i = 0; i < sizeOfDiagonal; i++) {
            sumPrimaryDiagonal += arr.get(i).get(i);
            sumSecondaryDiagonal += arr.get(i).get(sizeOfDiagonal - i - 1);
        }

        return Math.abs(sumPrimaryDiagonal - sumSecondaryDiagonal);

    }
}


