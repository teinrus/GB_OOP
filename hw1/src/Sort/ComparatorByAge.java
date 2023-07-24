package Sort;

import People.Human;

import java.util.Comparator;

public class ComparatorByAge implements Comparator<Human> {
    public int compare(Human o1, Human o2) {
        return Integer.compare(o1.getAge(), o2.getAge());
    }
}
