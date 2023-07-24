package People;

import Sort.*;

import java.io.Serializable;
import java.util.ArrayList;

import java.util.Collections;
import java.util.Iterator;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;


public class FamilyTree implements Serializable, Iterable<Human> {

    ArrayList<Human> humanList;

    public FamilyTree() {
        humanList = new ArrayList<>();
    }

    public void add(Human human) {

        if (!humanList.contains(human)) {
            humanList.add(human);
        }
    }


    @Override
    public String toString() {

        StringBuilder strb = new StringBuilder();
        for (Human human : humanList) {
            strb.append(human);
        }
        return strb.toString();
    }


    @Override
    public Iterator<Human> iterator() {
        return humanList.iterator();
    }

    public void sortByAge() {
        humanList.sort(new ComparatorByAge());

    }

    public void sortByBirthdate() {
        humanList.sort(new ComparatorByBirthDate());
    }

    public void sortByName() {
        Collections.sort(humanList);
    }


}