package P07_SETS_MAPS.LAB;

import java.util.*;

public class T05_AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfStudents = Integer.parseInt(scanner.nextLine());

        Map<String, List<Double>> studentMap = new TreeMap<>();

        for (int i = 0; i < numberOfStudents; i++) {
            String inputText = scanner.nextLine();
            String studentName = inputText.split("\\s+")[0];
            double studentGrade = Double.parseDouble(inputText.split("\\s+")[1]);

            studentMap.putIfAbsent(studentName, new ArrayList<>());
            studentMap.get(studentName).add(studentGrade);
        }

        for (Map.Entry<String, List<Double>> entry : studentMap.entrySet()) {
            System.out.print(entry.getKey() + " -> ");

            List<Double> grades = entry.getValue();

//            for (Double grade : grades) {
//                System.out.printf("%.2f ",grade);
//            }
//            double averageGrade = 0;
//            for (Double current : grades) {
//                averageGrade += current;
//            }
//            averageGrade = averageGrade / grades.size();


            double averageGrade = grades.stream()
                    .mapToDouble(Double::doubleValue)
                    .average()
                    .orElse(0.0);
            System.out.printf("(avg: %.2f)%n", averageGrade);
        }


//        for (Map.Entry<String, List<Double>> entry : studentMap.entrySet()) {
//            List<Double> grades = entry.getValue();
//            double averageGrade = 0;
//            for (Double current : grades) {
//                averageGrade += current;
//            }
//            averageGrade = averageGrade / grades.size();
//            studentMap.get(entry.getKey()).add(averageGrade);
//        }
    }
}
