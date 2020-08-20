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
public class MiniMaxSum {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("input/mini_max_sum.txt"));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("output/mini_max_sum.txt"));

        List<Integer> positiveNums = Arrays.asList(bufferedReader.readLine().split(" ")).stream().map(Integer::new).sorted().collect(Collectors.toList());
        Long sum = 0L;
        for (Integer num : positiveNums) {
            sum += Long.valueOf(num);
        }

        bufferedWriter.write(String.format("%d %d", (sum - positiveNums.get(4)) , (sum - positiveNums.get(0))));
        bufferedReader.close();
        bufferedWriter.close();
    }
}
