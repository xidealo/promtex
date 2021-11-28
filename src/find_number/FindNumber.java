package find_number;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class FindNumber {

    public int getSum(String path) {
        int sum = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }

            for (String numberLineString : sb.toString().replaceAll("\r", "").split("\n")) {
                sum += Arrays.stream(numberLineString.split("\\."))
                        .map(Integer::parseInt)
                        .sorted(Comparator.reverseOrder()).limit(2)
                        .skip(1)
                        .findFirst()
                        .orElseThrow(NoSuchElementException::new);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sum;
    }
}
