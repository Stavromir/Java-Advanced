package P17_Generics.EXERCISE.P03_04_GenericSwap;

import java.util.List;

public class Swap {

    public static <T> List<T> swapPositions (List<T> list, int firstIndex, int secondIndex) {
        T firstElement = list.get(firstIndex);
        T secondElement = list.get(secondIndex);

        list.set(firstIndex, secondElement);
        list.set(secondIndex, firstElement);
        return list;
    }


}
