package P19_IteratorsAndComparators.EXERCISE.StrategyPattern;

import java.util.Comparator;

public class NameComparator implements Comparator<Person> {
    @Override
    public int compare(Person first, Person second) {

        int result = Integer.compare(first.getName().length(), second.getName().length());

        if (result == 0) {
            char firstNameFirstLetter = first.getName().toLowerCase().charAt(0);
            char secondNameFirstLetter = second.getName().toLowerCase().charAt(0);
            result = Character.compare(firstNameFirstLetter, secondNameFirstLetter);
        }
        return result;
    }
}
