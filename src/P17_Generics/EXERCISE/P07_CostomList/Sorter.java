package P17_Generics.EXERCISE.P07_CostomList;

public class Sorter {

    public static <T extends Comparable<T>> void sort (CustomList<T> data) {
        for (int i = 0; i < data.getSize(); i++) {
            T currentElement = data.get(i);

            for (int j = i + 1; j < data.getSize(); j++) {
                if (currentElement.compareTo(data.get(j)) > 0) {
                    data.swap(i, j);
                }
            }
        }
    }
}
