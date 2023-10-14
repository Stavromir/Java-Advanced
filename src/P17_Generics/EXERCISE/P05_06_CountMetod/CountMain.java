package P17_Generics.EXERCISE.P05_06_CountMetod;

import P17_Generics.EXERCISE.P01_02_GenericBox.GenericBox;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CountMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<GenericBox<Double>> list = new ArrayList<>();

        while (n-- > 0){
            double input = Double.parseDouble(scanner.nextLine());
            GenericBox<Double> box = new GenericBox<>(input);

            list.add(box);
        }

        GenericBox<Double> boxToCompare = new GenericBox<>(Double.parseDouble(scanner.nextLine()));
        int result = countGreaterElements(list, boxToCompare);

        System.out.println(result);
    }

    static <T extends Comparable<T>> int countGreaterElements (List<T> data, T element) {
        int count = 0;
        for (T current : data) {
            int result = current.compareTo(element);
            if (result > 0) {
                count++;
            }
        }
        return count;
    }
}
