package P07_SETS_MAPS.LAB;

import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Stream;

public class T08_AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Double[]> students = new TreeMap<>();

        for (int i = 0; i < n; i++) {

            String name = scanner.nextLine();
            String[] gradesString = scanner.nextLine().split("\\s+");
            Double[] grades = new Double[gradesString.length];

            for (int j = 0; j < gradesString.length; j++) {
                grades[j] = Double.parseDouble(gradesString[j]);
            }

            students.putIfAbsent(name, grades);
        }


        for (Map.Entry<String, Double[]> entry : students.entrySet()) {
            double average = 0;
            double[] grades = Stream.of(entry.getValue())
                    .mapToDouble(Double::doubleValue)
                    .toArray();
            for (double grade : grades) {
                average += grade;
            }
            average = average / grades.length;

//            double average = Arrays.stream(entry.getValue())
//                    .mapToDouble(Double::doubleValue)
//                    .average()
//                    .orElse(0.0);

            DecimalFormat df = new DecimalFormat("#.############################################");
            System.out.printf("%s is graduated with %s%n", entry.getKey(), df.format(average));

        }
    }
}
